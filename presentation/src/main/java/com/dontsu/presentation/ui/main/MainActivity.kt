package com.dontsu.presentation.ui.main

import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import com.dontsu.presentation.extensions.toGone
import com.dontsu.presentation.extensions.toVisible
import com.dontsu.presentation.ui.base.BaseActivity
import com.dontsu.presentation.ui.detail.DetailActivity
import com.dontsu.presentation.ui.main.search.DigimonSearchFragment
import com.dontsu.domain.model.UiState
import com.dontsu.domain.model.successOrNull
import com.dontsu.presentation.R
import com.dontsu.presentation.databinding.ActivityMainBinding
import com.dontsu.presentation.extensions.flowWithStarted
import com.dontsu.presentation.extensions.repeatOnStarted
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import timber.log.Timber

@ExperimentalCoroutinesApi
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
        // Note: we have to use `repeatOnLifecycle` to avoid wasting resources when the app is in the background.
        // because when we use a coroutine which is created in the `lifecycle.launch`, even if the app goes in the background,
        // a flow keeps collecting and it's not going to stop it.
        // So, `repeatOnLifecycle` automatically cancels the ongoing coroutine for us when the lifecycle falls below the state(e.g, Lifecycle.State.STARTED).
        // and then resume or recreate the coroutine for us.
        // and if you collect single flow, then you can use `flowWithLifecycle`.
        repeatOnStarted(flow = viewModel.listUiState) { state ->
            when(state) {
                is UiState.Uninitialized -> {
                    // do something before loading.
                    // but it's not used now.
                }
                is UiState.Loading -> {
                    binding.progressBar.toVisible()
                }
                is UiState.Success -> {
                    val list = state.successOrNull()?.content
                    list?.forEach {
                        Timber.d("view - ${it?.name}")
                    }
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

        // for digimon list refreshing
        flowWithStarted(flow = viewModel.refresh) { state ->
            when(state) {
                is UiState.Uninitialized -> Unit // nothing to do
                is UiState.Loading -> {
                    binding.swiperefresh.isRefreshing = true
                }
                is UiState.Success -> {
                    binding.swiperefresh.isRefreshing = false
                }
                is UiState.Error -> {
                    binding.swiperefresh.isRefreshing = false
                }
            }
        }
    }

    override fun initViews() {
        setSupportActionBar(binding.toolbar)

        binding.recyclerView.apply {
            adapter = digimonListAdapter
            addItemDecoration(DigimonAdapterItemDecoration())
        }
    }

    override fun initListeners() = with(binding) {
        swiperefresh.setOnRefreshListener {
            viewModel.refreshDigimonList()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_item_search -> {
                supportFragmentManager.beginTransaction().add(binding.fragmentContainer.id, DigimonSearchFragment()).commit()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
