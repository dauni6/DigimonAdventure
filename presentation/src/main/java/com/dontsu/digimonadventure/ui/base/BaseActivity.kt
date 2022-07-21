package com.dontsu.digimonadventure.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding, VM : ViewModel> : AppCompatActivity() {

    protected lateinit var binding: VB
    abstract val viewModel: VM

    abstract fun getViewBinding(): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
        viewModel
        initObservers()
        initViews()
        initListeners()
    }

    open fun initViews() = Unit

    open fun initListeners() = Unit

    open fun initObservers() = Unit

}
