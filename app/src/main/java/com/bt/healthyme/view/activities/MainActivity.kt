package com.bt.healthyme.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bt.healthyme.R
import com.bt.healthyme.utils.hideKeyBoard
import kotlinx.android.synthetic.*

class MainActivity : BaseActivity() {

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.findFragmentById(R.id.signInFragment)

        setupNavController()
    }

    private fun setupNavController() {
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        hideKeyBoard()
        clearFindViewByIdCache()
        compositeDisposable?.dispose()
    }
}