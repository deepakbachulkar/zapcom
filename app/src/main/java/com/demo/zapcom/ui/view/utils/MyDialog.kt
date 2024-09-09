package com.demo.zapcom.ui.view.utils

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.demo.zapcom.R

private var loadingDialog: AlertDialog? = null
fun showLoadingDialog(context: Context) {
    val builder: AlertDialog.Builder = AlertDialog.Builder(context)
    val inflater: LayoutInflater =(context as Activity).layoutInflater
    val dialogView: View = inflater.inflate(R.layout.loading_dialog, null)
    builder.setView(dialogView)
    builder.setCancelable(false) // Prevents the dialog from being dismissed by back button or outside touch

    loadingDialog = builder.create()
    loadingDialog?.show()
}

fun dismissLoadingDialog() {
    if (loadingDialog != null && loadingDialog?.isShowing()==true) {
        loadingDialog?.dismiss()
    }
}

