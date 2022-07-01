package com.example.giphyapiapp.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.example.giphyapiapp.R

class FullSizeGifActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_size_gif)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val imgView = findViewById<ImageView>(R.id.gifFullSizeView)

        Glide.with(this)
            .load(intent.getStringExtra(URL))
            .into(imgView)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    companion object{
        private const val URL = "url"

        fun newIntent(context: Context, url: String): Intent{
            return Intent(context, FullSizeGifActivity::class.java).let {
                it.putExtra(URL, url)
            }
        }
    }
}