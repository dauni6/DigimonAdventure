package com.dontsu.digimonadventure.ui.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import com.dontsu.digimonadventure.R
import com.dontsu.digimonadventure.databinding.ActivityDetailBinding
import com.dontsu.digimonadventure.ui.base.BaseActivity
import com.dontsu.domain.model.Content
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

        const val DIGIMON_ID_KEY = "DIGIMON_ID_KEY"

        fun newInstance(context: Context, id: Int?): Intent {
            return Intent(context, DetailActivity::class.java).apply {
                putExtra(DIGIMON_ID_KEY, id)
            }
        }
    }

}
