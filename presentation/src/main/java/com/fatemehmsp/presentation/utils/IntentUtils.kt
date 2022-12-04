package com.fatemehmsp.presentation.utils

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.fatemehmsp.presentation.R

fun Fragment.openBrowser(context: Context, url: String) {
    try {
        context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    } catch (ex: ActivityNotFoundException) {
            Toast.makeText(
                context,
                context.getText(R.string.browser_not_founded),
                Toast.LENGTH_LONG
            ).show()
    }
}