package com.mario.github.mvp.util

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import androidx.core.graphics.drawable.toDrawable
import com.mario.github.mvp.R
import org.joda.time.DateTime
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by mario on 09/07/18.
 */

object CommonUtil {

    fun showLoadingDialog(context: Context?): ProgressDialog {
        val progressDialog = ProgressDialog(context)
        progressDialog.let {
            it.show()
            it.window?.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
            it.setContentView(R.layout.progress_dialog)
            it.isIndeterminate = true
            it.setCancelable(false)
            it.setCanceledOnTouchOutside(false)
            return it
        }
    }

    fun convertDate(date: String): String {
        val dateTime = DateTime(date)
        val formatter = SimpleDateFormat("dd/MM/yyyy")
        return formatter.format(Date(dateTime.millis))
    }

}