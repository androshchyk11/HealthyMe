package com.bt.healthyme.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bt.healthyme.managers.SharedPreferencesManager

class SignInViewModel(
    private val sharedPreferencesManager: SharedPreferencesManager
) : ViewModel(){

    val nameLiveData  = MutableLiveData<String>("")
    val heightLiveData = MutableLiveData<String>("")
    val weightLiveData = MutableLiveData<String>("")
    val ageLiveData = MutableLiveData<String>("")
}