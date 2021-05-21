package com.example.sampleapplication.ui.saved_article

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleapplication.R
import com.example.sampleapplication.data.model.Article
import kotlinx.android.synthetic.main.item_saved_article.view.*

class SavedArticlesAdapter(
    private val articles: List<Article>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return SavedArticleViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_saved_article, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SavedArticleViewHolder -> holder.bindArticle(articles[position])
        }
    }

    override fun getItemId(position: Int) = articles[position].id.hashCode().toLong()
    override fun getItemCount() = articles.size

    private class SavedArticleViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bindArticle(article: Article) = view.run {
            title.text = article.name
            articleSaved.isChecked = article.onWishlist
        }
    }
}