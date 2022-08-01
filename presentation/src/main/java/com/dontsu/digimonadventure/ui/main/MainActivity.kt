package com.dontsu.digimonadventure.ui.main

import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.dontsu.digimonadventure.R
import com.dontsu.digimonadventure.databinding.ActivityMainBinding
import com.dontsu.digimonadventure.extensions.toGone
import com.dontsu.digimonadventure.extensions.toVisible
import com.dontsu.digimonadventure.ui.base.BaseActivity
import com.dontsu.digimonadventure.ui.detail.DetailActivity
import com.dontsu.domain.model.UiState
import com.dontsu.domain.model.successOrNull
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val viewModel: MainViewModel by viewModels()

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    private val digimonListAdapter: DigimonListAdapter by lazy {
        DigimonListAdapter { content ->
            startActivity(DetailActivity.newInstance(context = this, id = content.id))
        }
    }

    override fun initObservers() {
        // for digimon list
        lifecycleScope.launch {
            // Note: we have to use `repeatOnLifecycle` to avoid wasting resources when the app is in the background.
            // because when we use a coroutine which is created in the `lifecycle.launch`, even if the app goes in the background,
            // a flow keeps collecting and it's not going to stop it.
            // So, `repeatOnLifecycle` automatically cancels the ongoing coroutine for us when the lifecycle falls below the state(e.g, Lifecycle.State.STARTED).
            // and then resume or recreate the coroutine for us.
            // and if you collect single flow, then you can use `flowWithLifecycle`.
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.listUiState.collect { state ->
                    when(state) {
                        is UiState.Uninitialized -> {
                            // do something before loading.
                            // but it's not used in this project.
                        }
                        is UiState.Loading -> {
                            binding.progressBar.toVisible()
                        }
                        is UiState.Success -> {
                            val list = state.successOrNull()?.content
                            if (!list.isNullOrEmpty()) {
                                digimonListAdapter.submitList(list)
                            }
                            binding.progressBar.toGone()
                        }
                        is UiState.Error -> {
                            Snackbar.make(binding.root, "error", Snackbar.LENGTH_SHORT).show()
                            binding.progressBar.toGone()
                        }
                    }
                }
            }
        }

        // for search digimon list
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.digimonUiState.collect { state ->
                    when(state) {
                        is UiState.Uninitialized -> {
                            // do something before loading.
                            // but it's not used in this project.
                        }
                        is UiState.Loading -> {
                            binding.progressBar.toVisible()
                        }
                        is UiState.Success -> {
                            val list = state.data.content
                            if (!list.isNullOrEmpty()) {
                                digimonListAdapter.submitList(list)
                            }
                            digimonListAdapter.submitList(list)
                            binding.progressBar.toGone()
                        }
                        is UiState.Error -> {
                            Snackbar.make(binding.root, "error", Snackbar.LENGTH_SHORT).show()
                            binding.progressBar.toGone()
                        }
                    }
                }
            }
        }

    }

    override fun initViews() {
        binding.recyclerView.apply {
            adapter = digimonListAdapter
            addItemDecoration(DigimonAdapterItemDecoration())
        }
    }

    override fun initListeners() {

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        val searchItem: MenuItem = menu.findItem(R.id.menu_item_search)
        val searchView = searchItem.actionView as SearchView

        searchView.apply {
            setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String): Boolean {
                    viewModel.searchDigimon(query.trim())
                    return true
                }

                override fun onQueryTextChange(query: String): Boolean {
                    return false
                }

            })
        }

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

}
