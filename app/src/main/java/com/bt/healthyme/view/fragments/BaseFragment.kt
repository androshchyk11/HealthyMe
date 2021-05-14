package com.bt.healthyme.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bt.healthyme.utils.disposeWithCheck
import com.bt.healthyme.utils.hideKeyBoard
import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment : Fragment() {

    lateinit var compositeDisposable: CompositeDisposable
    var lockBackStack = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        compositeDisposable = CompositeDisposable()
        activity?.hideKeyBoard()
        setupClicks()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        compositeDisposable.disposeWithCheck()
    }

    abstract fun setupClicks()
}