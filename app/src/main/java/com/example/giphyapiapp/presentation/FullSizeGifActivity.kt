package com.example.giphyapiapp.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
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

    override fun onBackPressed() {
        val resultIntent = Intent()
        resultIntent.putExtra(MainActivity.GIF_NAME, intent.getStringExtra(MainActivity.GIF_NAME))
        setResult(RESULT_OK, resultIntent)
        finish()
        super.onBackPressed()
    }

    companion object{
        private const val URL = "url"

        fun newIntent(context: Context, url: String, name: String): Intent{
            return Intent(context, FullSizeGifActivity::class.java).let {
                it.putExtra(URL, url)
                it.putExtra(MainActivity.GIF_NAME, name)
            }
        }
    }
}