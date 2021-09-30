package com.secondslot.seloustev.extentions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(
    imageUri: String,
//    requestListener: RequestListener<Drawable>
) {

    Glide.with(context)
        .load(imageUri)
//        .listener(requestListener)
        .into(this)
}
