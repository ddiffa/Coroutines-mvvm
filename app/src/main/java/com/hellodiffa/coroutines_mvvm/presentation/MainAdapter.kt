package com.hellodiffa.coroutines_mvvm.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hellodiffa.coroutines_mvvm.R
import com.hellodiffa.coroutines_mvvm.data.model.Article
import kotlinx.android.synthetic.main.item_news.view.*

class MainAdapter(private val list: ArrayList<Article>, private val onClick: (Article) -> Unit) :
    RecyclerView.Adapter<MainAdapter.Holder>() {

    fun addArticle(article: List<Article>) {
        this.list.apply {
            clear()
            addAll(article)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_news, parent, false
        )
    )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(list[position]).setOnClickListener {
            onClick(list[position])
        }
    }


    inner class Holder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(article: Article) = view.apply {
            tvTitle.text = article.title
            Glide.with(context)
                .load(article.image)
                .into(imgBackground)
        }

    }
}