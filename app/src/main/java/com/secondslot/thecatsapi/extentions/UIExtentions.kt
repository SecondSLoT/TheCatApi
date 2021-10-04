package com.secondslot.seloustev.extentions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(
    imageUri: String,
) {

    Glide.with(context)
        .load(imageUri)
        .into(this)
}
