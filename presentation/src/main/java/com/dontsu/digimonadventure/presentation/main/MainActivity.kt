package com.dontsu.digimonadventure.presentation.main

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
import com.dontsu.digimonadventure.presentation.base.BaseActivity
import com.dontsu.domain.model.UiState
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val viewModel: MainViewModel by viewModels()

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun initObservers() {
        lifecycleScope.launch {
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
                            val list = state.data.content
                            if (!list.isNullOrEmpty()) {
                                list.forEach {
                                    Timber.d("id = ${it?.id} / name = ${it?.name} / href = ${it?.href}")
                                }
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

    }

    override fun initViews() {

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
                    Timber.d("onQueryTextSubmit = $query")
                    return true
                }

                override fun onQueryTextChange(query: String): Boolean {
                    Timber.d("onQueryTextChange = $query")
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
