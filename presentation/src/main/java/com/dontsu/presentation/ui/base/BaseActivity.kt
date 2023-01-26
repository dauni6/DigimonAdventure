package com.dontsu.presentation.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding, VM : ViewModel>(
    private val inflate: Inflate<VB>
) : AppCompatActivity() {

    protected lateinit var binding: VB
    abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate.invoke(layoutInflater, null, false)
        setContentView(binding.root)
        initObservers()
        initViews()
        initListeners()
    }

    open fun initViews() = Unit

    open fun initListeners() = Unit

    /**
     * this method will be used for Observing StateFlow<T>.
     * it’s recommended to call this API in the activity’s onCreate to avoid unexpected behaviors.
     * */
    open fun initObservers() = Unit

}
