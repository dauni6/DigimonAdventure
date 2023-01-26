package com.dontsu.presentation.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB: ViewBinding, VM: ViewModel>(
    private val inflate: Inflate<VB>
): Fragment() {

    private var _binding: VB? = null
    protected val binding get() = _binding!!

    abstract val viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initListeners()
        initObservers()
    }

    open fun initViews() = Unit

    open fun initListeners() = Unit

    /**
     * this method will be used for Observing StateFlow<T>.
     * it’s recommended to call this API in the fragment’s onviewCreated to avoid unexpected behaviors.
     * */
    open fun initObservers() = Unit

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
