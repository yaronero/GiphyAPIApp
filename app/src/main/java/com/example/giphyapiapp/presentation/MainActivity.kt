package com.example.giphyapiapp.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.giphyapiapp.R

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: GifAdapter

    private lateinit var viewModel: MainViewModel

    private lateinit var searchButton: ImageButton
    private lateinit var loadingBar: ProgressBar
    private lateinit var etGifName: EditText
    private lateinit var tvNoData: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setupViews()
        setupRecyclerView()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        loadingBar.visibility = View.VISIBLE

        when(requestCode){
            GIF_INPUT_NAME -> {
                if (resultCode == RESULT_OK) {
                    val response = data?.getStringExtra(GIF_NAME)
                    viewModel.gifInputName.value = response
                    viewModel.getGifsByName(response!!)
                    loadingBar.visibility = View.GONE
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun setupViews(){
        loadingBar = findViewById(R.id.loadingBar)
        etGifName = findViewById(R.id.etGifName)
        searchButton = findViewById(R.id.searchButton)
        tvNoData = findViewById(R.id.tvNoData)

        searchButton.setOnClickListener {
            loadingBar.visibility = View.VISIBLE
            viewModel.getGifsByName(etGifName.text.toString())
        }
    }

    private fun setupRecyclerView(){
        adapter = GifAdapter(this, listOf())

        val rvGifs = findViewById<RecyclerView>(R.id.rvGifs)
        rvGifs.adapter = adapter

        val gridLayout = GridLayoutManager(this, 2)
        rvGifs.layoutManager = gridLayout

        adapter.onGifClickListener = {
            val intent = FullSizeGifActivity.newIntent(this, it, viewModel.gifInputName.value.toString())
            startActivityForResult(intent, GIF_INPUT_NAME)
        }

        viewModel.gifDataList.observe(this) {
            adapter.setList(it)
            loadingBar.visibility = View.GONE
            adapter.notifyDataSetChanged()

            if (it.isEmpty()){
                tvNoData.text = getString(R.string.no_data)
            } else {
                tvNoData.text = ""
            }
        }
    }

    companion object{
        private const val GIF_INPUT_NAME = 101
        const val GIF_NAME = "gif_input_name"
    }
}