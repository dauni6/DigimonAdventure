package com.dontsu.presentation.ui.detail

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.NestedScrollView
import com.dontsu.presentation.ui.base.BaseActivity
import com.dontsu.domain.model.Digimon
import com.dontsu.domain.model.Field
import com.dontsu.domain.model.UiState
import com.dontsu.domain.model.successOrNull
import com.dontsu.presentation.R
import com.dontsu.presentation.databinding.ActivityDetailBinding
import com.dontsu.presentation.extensions.*
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class DetailActivity : BaseActivity<ActivityDetailBinding, DetailViewModel>(ActivityDetailBinding::inflate) {

    override val viewModel: DetailViewModel by viewModels()

    override fun initObservers() {

        flowWithStarted(flow = viewModel.uiState) {
                state ->
            when(state) {
                is UiState.Uninitialized -> {
                    // do something before loading.
                    // but it's not used now.
                }
                is UiState.Loading -> {
                    binding.progressBar.toVisible()
                }
                is UiState.Success -> {
                    val digimon =  state.successOrNull()
                    if (digimon != null) {
                        setDigimon(digimon = digimon)
                    }
                    binding.progressBar.toGone()
                }
                is UiState.Error -> {
                    Snackbar.make(binding.root, state.error.toString(), Snackbar.LENGTH_SHORT).show()
                    binding.progressBar.toGone()
                }
            }
        }

        flowWithStarted(flow = viewModel.isFavorite) { isFavorite ->
            if (isFavorite) {
                binding.fabLike.setColorFilter(ResourcesCompat.getColor(resources, R.color.red, null))
            } else {
                binding.fabLike.setColorFilter(ResourcesCompat.getColor(resources, R.color.white, null))
            }
        }

    }

    override fun initListeners() = with(binding) {
        toolbar.setNavigationOnClickListener {
            finish()
        }

        toolbar.setOnMenuItemClickListener { item ->
            when(item.itemId) {
                R.id.menu_detail_item_share -> {
                    // todo : createShareIntent()

                    true
                }
                else -> false
            }
        }

        var isToolbarShown = false

        // scroll change listener begins at Y = 0 when image is fully collapsed
        detailScrollView.setOnScrollChangeListener(
            NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, _ ->
                // User scrolled past image to height of toolbar and the title text is
                // underneath the toolbar, so the toolbar should be shown.
                val shouldShowToolbar = scrollY > toolbar.height

                // The new state of the toolbar differs from the previous state; update
                // appbar and toolbar attributes.
                if (isToolbarShown != shouldShowToolbar) {
                    isToolbarShown = shouldShowToolbar

                    // Use shadow animator to add elevation if toolbar is shown
                    appbar.isActivated = shouldShowToolbar

                    // Show the plant name if toolbar is shown
                    collapsingToolbarLayout.isTitleEnabled = shouldShowToolbar
                }
        })

        fabLike.setOnClickListener {
            if (viewModel.isFavorite.value) {
                viewModel.deleteFavorite()
            } else {
                viewModel.addFavorite()
            }
        }
    }

    private fun createShareIntent() {
        // do something...
    }

    @SuppressLint("SetTextI18n")
    private fun setDigimon(digimon: Digimon) = with(binding) {
        digimonImageView.loadWithUrl(digimon.image?.first()?.href)
        digimonIdTextView.text = "Digicode : ${digimon.id.toString().ifEmpty { DIGIMON_UNKNOWN }}"
        collapsingToolbarLayout.title = digimon.name.toString().ifEmpty { DIGIMON_UNKNOWN }
        digimonNameTextView.text = digimon.name.toString().ifEmpty { DIGIMON_UNKNOWN }
        digimon.level?.let {
            levelValueTextView.text = if(it.isEmpty()) {
                DIGIMON_UNKNOWN
            } else {
                it.first()?.level.toString()
            }
        }
        digimon.attribute?.let {
            attributeValueTextView.text = if (it.isEmpty()) {
                DIGIMON_UNKNOWN
            } else {
                it.first()?.attribute.toString()
            }
        }
        digimon.type?.let {
            typeValueTextview.text = if (it.isEmpty()) {
                DIGIMON_UNKNOWN
            } else {
                it.first()?.type.toString()
            }
        }

        digimon.field?.let { fields: List<Field?> ->
            if (fields.isNotEmpty()) {
                val layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
                ).apply {
                    weight = 1f
                }

                fields.forEach { fieldOrNull ->
                    com.dontsu.presentation.util.findResOrNull(fieldOrNull?.id)?.let { res ->
                        val fieldImageView = AppCompatImageView(this@DetailActivity)
                        fieldImageView.layoutParams = layoutParams
                        fieldImageView.loadWithRes(res)
                        binding.fieldLinearLayout.addView(fieldImageView)
                    }
                }
            } else {
                binding.noFieldTextView.toVisible()
            }
        }

        digimon.description?.let {
            val description = it.find { description ->
                description?.language == "en_us"
            }
            descriptionTextView.text = if (description == null) {
                DIGIMON_NO_DESCRIPTION
            } else {
                description.description
            }
        }
    }

    companion object {

        const val DIGIMON_ID_KEY = "DIGIMON_ID_KEY"
        const val DIGIMON_UNKNOWN = "Unknown"
        const val DIGIMON_NO_DESCRIPTION = "There is no description for this Digimon."

        fun newInstance(context: Context, id: Int?): Intent {
            return Intent(context, DetailActivity::class.java).apply {
                putExtra(DIGIMON_ID_KEY, id)
            }
        }
    }

}
