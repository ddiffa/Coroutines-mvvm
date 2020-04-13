package com.hellodiffa.coroutines_mvvm.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.hellodiffa.coroutines_mvvm.R
import com.hellodiffa.coroutines_mvvm.data.model.Article
import com.hellodiffa.coroutines_mvvm.remote.Resource
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val viewModel by inject<MainViewModel>()

    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
        setupObservers()
    }


    private fun setupObservers() {
        viewModel.getArticle().observe(this, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    rvArticle.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                    it.data?.let { articles -> retrieveList(articles) }
                }
                Resource.Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    rvArticle.visibility = View.GONE
                }
                Resource.Status.ERROR -> {
                    rvArticle.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun setupUI() {
        rvArticle.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf(), this::onRvClick)
        rvArticle.adapter = adapter
    }

    private fun onRvClick(article: Article) {
        Toast.makeText(this, "${article.title} clicked", Toast.LENGTH_SHORT).show()
    }

    private fun retrieveList(article: List<Article>) {
        adapter.apply {
            addArticle(article)
            notifyDataSetChanged()
        }
    }
}
