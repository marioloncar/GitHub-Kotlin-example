package com.mario.github.mvp.util.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by mario on 09/07/18.
 */

internal fun ImageView.loadImage(url: String) {
    Glide.with(this.context)
            .load(url)
            .asBitmap()
            .centerCrop()
            .into(this)
}