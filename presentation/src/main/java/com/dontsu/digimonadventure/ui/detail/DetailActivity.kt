package com.dontsu.digimonadventure.ui.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.dontsu.digimonadventure.R
import com.dontsu.digimonadventure.databinding.ActivityDetailBinding
import com.dontsu.digimonadventure.ui.base.BaseActivity
import timber.log.Timber

class DetailActivity : BaseActivity<ActivityDetailBinding, DetailViewModel>() {

    override val viewModel: DetailViewModel by viewModels()

    override fun getViewBinding(): ActivityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }

    override fun initListeners() = with(binding) {
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    companion object {
        fun newInstance(context: Context): Intent = Intent(context, DetailActivity::class.java)
    }

}
