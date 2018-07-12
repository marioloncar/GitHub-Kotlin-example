package com.mario.github.mvp.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.mario.github.mvp.R
import com.mario.github.mvp.data.network.model.Repo
import com.mario.github.mvp.util.extension.loadImage
import java.util.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var itemList: MutableList<Repo> = ArrayList()

    fun setItems(itemList: List<Repo>) {
        this.itemList.clear()
        this.itemList.addAll(itemList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false))
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: Repo = itemList[position]

        item.owner?.avatarUrl?.let { holder.imageViewThumb.loadImage(it) }
        holder.textViewRepoName.text = item.name
        holder.textViewAuthorName.text = item.owner?.login
        holder.textViewWatchers.text = item.watchersCount.toString()
        holder.textViewForks.text = item.forksCount.toString()
        holder.textViewIssues.text = item.openIssuesCount.toString()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewThumb = itemView.findViewById<ImageView>(R.id.imageview_thumb)
        val textViewRepoName = itemView.findViewById<TextView>(R.id.textview_repo_name)
        val textViewAuthorName = itemView.findViewById<TextView>(R.id.textview_author_name)
        val textViewWatchers = itemView.findViewById<TextView>(R.id.textview_watchers)
        val textViewForks = itemView.findViewById<TextView>(R.id.textview_forks)
        val textViewIssues = itemView.findViewById<TextView>(R.id.textview_issues)
    }
}