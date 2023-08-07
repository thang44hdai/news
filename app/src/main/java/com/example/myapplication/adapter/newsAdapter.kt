package com.example.myapplication.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.model.New
import com.example.myapplication.model.news
import java.util.zip.Inflater

class newsAdapter(): RecyclerView.Adapter<newsAdapter.viewHolder>() {
    var ds: ArrayList<New> = ArrayList()
    inner class viewHolder(view: View): RecyclerView.ViewHolder(view){
        val author = itemView.findViewById<TextView>(R.id.tvAuthor)
        val description = itemView.findViewById<TextView>(R.id.tvDes)
        val title = itemView.findViewById<TextView>(R.id.tvTitle)
        val image = itemView.findViewById<ImageView>(R.id.imv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return ds.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val news = ds[position]
        holder.apply {
            author.text = news.author
            description.text = news.description
            title.text = news.title
            Glide.with(image).load(news.image).into(image)
        }
    }
    fun setNews(listNews: news){
        ds = listNews.news!!
    }
}