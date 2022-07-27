package com.dontsu.digimonadventure.ui.detail

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.dontsu.digimonadventure.R
import com.dontsu.digimonadventure.databinding.ActivityDetailBinding
import com.dontsu.digimonadventure.extensions.loadWithUrl
import com.dontsu.digimonadventure.extensions.toGone
import com.dontsu.digimonadventure.extensions.toVisible
import com.dontsu.digimonadventure.ui.base.BaseActivity
import com.dontsu.domain.model.Digimon
import com.dontsu.domain.model.UiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class DetailActivity : BaseActivity<ActivityDetailBinding, DetailViewModel>() {

    override val viewModel: DetailViewModel by viewModels()

    override fun getViewBinding(): ActivityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)

    override fun initObservers() {
        lifecycleScope.launch {
            viewModel.uiState.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED).collect { state ->
                when(state) {
                    is UiState.Uninitialized -> {
                        // do something before loading.
                        // but it's not used in this project.
                    }
                    is UiState.Loading -> {
                        binding.progressBar.toVisible()
                    }
                    is UiState.Success -> {
                        val digimon = state.data
                        Timber.d("digimon check = $digimon")
                        setDigimon(digimon = digimon)
                        binding.progressBar.toGone()
                    }
                    is UiState.Error -> {
                        binding.progressBar.toGone()
                    }
                }
            }
        }

    }

    override fun initListeners() = with(binding) {
        toolbar.setNavigationOnClickListener { view ->
            Timber.d("백버튼 클릭")
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
    }

    private fun createShareIntent() {
        // do something...
    }

    @SuppressLint("SetTextI18n")
    private fun setDigimon(digimon: Digimon) = with(binding) {
        digimonImageView.loadWithUrl(digimon.image?.first()?.href)
        digimonIdTextView.text = "Digicode : ${digimon.id.toString().ifEmpty { "not found" }}"
        digimonNameTextView.text = digimon.name.toString().ifEmpty { "not found" }
        levelValueTextView.text = digimon.level?.first()?.level.toString().ifEmpty { "not found" }
        attributeValueTextView.text = digimon.attribute?.first()?.attribute.toString().ifEmpty { "not found" } // todo : attribute might be empty.
        typeValueTextview.text = digimon.type?.first()?.type.toString().ifEmpty { "not found" }
        // fields
//        descriptionTextView.text = digimon.description?.takeIf { }
    }

    companion object {

        const val DIGIMON_ID_KEY = "DIGIMON_ID_KEY"

        fun newInstance(context: Context, id: Int?): Intent {
            return Intent(context, DetailActivity::class.java).apply {
                putExtra(DIGIMON_ID_KEY, id)
            }
        }
    }

}
