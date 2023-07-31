package com.dontsu.presentation.ui.search

import android.content.Context
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.dontsu.presentation.extensions.toGone
import com.dontsu.presentation.extensions.toVisible
import com.dontsu.presentation.ui.detail.DetailActivity
import com.dontsu.presentation.ui.main.DigimonAdapterItemDecoration
import com.dontsu.domain.model.UiState
import com.dontsu.presentation.R
import com.dontsu.presentation.databinding.ActivitySearchBinding
import com.dontsu.presentation.extensions.repeatOnStarted
import com.dontsu.presentation.extensions.setNavigationIconColor
import com.dontsu.presentation.ui.base.BaseActivity
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class SearchActivity : BaseActivity<ActivitySearchBinding, SearchViewModel>(ActivitySearchBinding::inflate) {

    override val viewModel: SearchViewModel by viewModels()

    private val searchListAdapter by lazy {
        SearchListAdapter { content ->
            startActivity(DetailActivity.newInstance(context = this, id = content.id))
        }
    }

    override fun initViews(): Unit = with(binding) {
        setSupportActionBar(binding.toolbar)
        toolbar.apply {
            setNavigationIconColor(ResourcesCompat.getColor(resources, R.color.white, null))
            setNavigationOnClickListener {
                finish()
            }
        }

        searchView.apply {
            setIconifiedByDefault(false)
            setOnQueryTextListener(object: SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String): Boolean {
                    viewModel.searchDigimon(query.trim())
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean = false

            })
        }

        recyclerView.apply {
            adapter = searchListAdapter
            addItemDecoration(DigimonAdapterItemDecoration())
        }
    }

    override fun initObservers() {
        // for search digimon list
        // Note: we have to use `repeatOnLifecycle` to avoid wasting resources when the app is in the background.
        // because when we use a coroutine which is created in the `lifecycle.launch`, even if the app goes in the background,
        // a flow keeps collecting and it's not going to stop it.
        // So, `repeatOnLifecycle` automatically cancels the ongoing coroutine for us when the lifecycle falls below the state(e.g, Lifecycle.State.STARTED).
        // and then resume or recreate the coroutine for us.
        // and if you collect single flow, then you can use `flowWithLifecycle`.
        repeatOnStarted(flow = viewModel.digimonUiState) { state ->
            when (state) {
                is UiState.Uninitialized -> binding.progressBar.toGone()
                is UiState.Loading -> binding.progressBar.toVisible()
                is UiState.Success -> {
                    val list = state.data.content
                    if (!list.isNullOrEmpty()) {
                        searchListAdapter.submitList(list)
                    }
                    searchListAdapter.submitList(list)
                    binding.progressBar.toGone()
                }
                is UiState.Error -> {
                    Snackbar.make(binding.root, "error", Snackbar.LENGTH_SHORT).show()
                    binding.progressBar.toGone()
                }
            }
        }
    }

    override fun onPause() {
        dismissKeyboard(binding.searchView)
        super.onPause()
    }

    private fun showKeyboard(view: View) {
        WindowCompat.getInsetsController(window, view).show(WindowInsetsCompat.Type.ime())
    }

    private fun dismissKeyboard(view: View) {
        WindowCompat.getInsetsController(window, view).hide(WindowInsetsCompat.Type.ime())
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_item_search -> {
               binding.searchView.performClick()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {

        fun newInstance(context: Context): Intent {
            return Intent(context, SearchActivity::class.java)
        }

    }

}
