package com.bt.healthyme.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bt.healthyme.managers.SharedPreferencesManager
import io.reactivex.disposables.CompositeDisposable
import org.koin.android.ext.android.inject

abstract class BaseActivity: AppCompatActivity() {

    protected var compositeDisposable: CompositeDisposable? = null
    private val sharedPreferencesManager: SharedPreferencesManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        compositeDisposable = CompositeDisposable()
    }

}