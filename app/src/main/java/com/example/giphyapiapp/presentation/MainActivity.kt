package com.example.giphyapiapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.giphyapiapp.R

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: GifAdapter

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loadingBar = findViewById<ProgressBar>(R.id.loadingBar)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setupRecyclerView()
        viewModel.gifDataList.observe(this) {
            adapter.setList(it)
            loadingBar.visibility = View.GONE
            adapter.notifyDataSetChanged()
        }
    }

    private fun setupRecyclerView(){
        adapter = GifAdapter(this, listOf())

        val rvGifs = findViewById<RecyclerView>(R.id.rvGifs)
        rvGifs.adapter = adapter

        val gridLayout = GridLayoutManager(this, 2)
        rvGifs.layoutManager = gridLayout

        adapter.onGifClickListener = {
            val intent = FullSizeGifActivity.newIntent(this, it)
            startActivity(intent)
        }
    }
}