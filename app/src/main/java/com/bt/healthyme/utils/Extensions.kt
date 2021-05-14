package com.bt.healthyme.utils

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import io.reactivex.disposables.CompositeDisposable

fun Activity.hideKeyBoard() {
    val view = this.currentFocus
    if (view != null) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm?.hideSoftInputFromWindow(view.windowToken, 0)
        view.clearFocus()
    }
}

fun CompositeDisposable.disposeWithCheck() {
    if (!this.isDisposed) {
        this.dispose()
    }
}