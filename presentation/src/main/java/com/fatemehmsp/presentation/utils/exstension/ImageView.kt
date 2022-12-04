package com.fatemehmsp.presentation.utils.exstension


import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.fatemehmsp.presentation.R

fun ImageView.load(context: Context, url: String?, roundedCorners: Int = 8) {
    Glide.with(context)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .apply(RequestOptions().error(R.drawable.ic_app_image))
        .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(roundedCorners)))
        .into(this)
}