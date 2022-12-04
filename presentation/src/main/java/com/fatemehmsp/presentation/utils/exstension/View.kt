package com.fatemehmsp.presentation.utils.exstension

import android.view.View

fun View.visibleOrGone(visible :Boolean){
    if (visible)
        this.visibility = View.VISIBLE
    else
        this.visibility = View.GONE
}

fun View.gone(){
    this.visibility = View.GONE
}

fun View.visible(){
    this.visibility = View.VISIBLE
}