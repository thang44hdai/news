package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.newsAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.viewmodel.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rcvList.layoutManager = LinearLayoutManager(this)
        val viewModel = ViewModelProvider(this).get(viewModel::class.java)
        val adapter = newsAdapter()
        viewModel.get_data().observe(this){
            adapter.setNews(it)
            binding.rcvList.adapter = adapter
            adapter.notifyDataSetChanged()
        }
    }
}