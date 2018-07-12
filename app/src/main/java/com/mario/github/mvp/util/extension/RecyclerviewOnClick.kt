package com.mario.github.mvp.util.extension

import android.support.v7.widget.RecyclerView
import android.view.View

interface OnItemClickListener {
    fun onItemClicked(position: Int, view: View)
}

internal fun RecyclerView.addOnItemClickListener(onClickListener: OnItemClickListener) {
    this.addOnChildAttachStateChangeListener(object: RecyclerView.OnChildAttachStateChangeListener {
        override fun onChildViewDetachedFromWindow(view: View?) {
            view?.setOnClickListener(null)
        }

        override fun onChildViewAttachedToWindow(view: View?) {
            view?.setOnClickListener {
                val holder = getChildViewHolder(view)
                onClickListener.onItemClicked(holder.adapterPosition, view)
            }
        }
    })
}