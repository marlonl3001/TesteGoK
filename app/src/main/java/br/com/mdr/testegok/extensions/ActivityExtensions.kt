package br.com.mdr.testegok.extensions

import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import br.com.mdr.testegok.R
import com.google.android.material.snackbar.Snackbar

/**
 * @author Marlon D. Rocha
 * @since 21/08/20
 */

fun AppCompatActivity.showSnackMessage(snackMessage: String, view: View) {
    val snackBar = Snackbar.make(view, snackMessage, Snackbar.LENGTH_LONG)
    val textId = com.google.android.material.R.id.snackbar_text
    val snackView = snackBar.view
    val txtSnack = snackView.findViewById<TextView>(textId)
    txtSnack.maxLines = 5
    val params = snackView.layoutParams as FrameLayout.LayoutParams
    val sideMargin = 16
    params.setMargins(params.leftMargin + sideMargin,
        params.topMargin,
        params.rightMargin + sideMargin,
        params.bottomMargin + sideMargin)
    snackView.layoutParams = params
    val background = R.drawable.error_snack_corner
    snackView.setBackgroundResource(background)

    txtSnack.setTextColor(ContextCompat.getColor(this, R.color.white))
    snackBar.show()
}