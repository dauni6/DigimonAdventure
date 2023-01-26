package com.dontsu.presentation.ui.main.search

import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.viewModels
import com.dontsu.presentation.extensions.toGone
import com.dontsu.presentation.extensions.toVisible
import com.dontsu.presentation.ui.base.BaseFragment
import com.dontsu.presentation.ui.detail.DetailActivity
import com.dontsu.presentation.ui.main.DigimonAdapterItemDecoration
import com.dontsu.domain.model.UiState
import com.dontsu.presentation.R
import com.dontsu.presentation.databinding.FragmentDigimonSearchBinding
import com.dontsu.presentation.extensions.repeatOnStarted
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class DigimonSearchFragment : BaseFragment<FragmentDigimonSearchBinding, DigimonSearchViewModel>(FragmentDigimonSearchBinding::inflate) {

    override val viewModel: DigimonSearchViewModel by viewModels()

    private val digimonSearchListAdapter by lazy {
        DigimonSearchListAdapter { content ->
            startActivity(DetailActivity.newInstance(context = requireContext(), id = content.id))
        }
    }

    override fun initViews(): Unit = with(binding) {
        toolbar.apply {
            inflateMenu(R.menu.menu_search)
            setOnMenuItemClickListener {
                it.itemId == R.id.menu_item_refresh
            }
        }

        searchView.apply {
            setOnQueryTextListener(object: SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String): Boolean {
                    viewModel.searchDigimon(query.trim())
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean = false

            })
        }

        recyclerView.apply {
            adapter = digimonSearchListAdapter
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
                        digimonSearchListAdapter.submitList(list)
                    }
                    digimonSearchListAdapter.submitList(list)
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
        WindowCompat.getInsetsController(requireActivity().window, view).show(WindowInsetsCompat.Type.ime())
    }

    private fun dismissKeyboard(view: View) {
        WindowCompat.getInsetsController(requireActivity().window, view).hide(WindowInsetsCompat.Type.ime())
    }

}
