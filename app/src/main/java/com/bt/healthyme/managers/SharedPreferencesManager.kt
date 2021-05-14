package com.bt.healthyme.managers

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.bt.healthyme.model.StatisticModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


@SuppressLint("CommitPrefEdits")
class SharedPreferencesManager constructor(private val context: Context) {
    private val prefFileName = "healthyMe.spref"

    private val TYPE_OF_TRAINING = "TYPE_OF_TRAINING"
    private val STATISTICS = "STATISTICS"
    private val IS_FIRST_ENTER = "IS_FIRST_ENTER"

    private val sharedPreferences: SharedPreferences
    private val editor: SharedPreferences.Editor

    init {
        this.sharedPreferences =
            context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

        this.editor = sharedPreferences.edit()
    }

    var isFirstEnter :Boolean
        get() {
            return sharedPreferences.getBoolean(IS_FIRST_ENTER, true)
        }
        set(isFirstEnter) {
            editor.putBoolean(IS_FIRST_ENTER, isFirstEnter)
            editor.apply()
        }

    var typeOfTraining: Int
        get() {
            return sharedPreferences.getInt(TYPE_OF_TRAINING, 1)
        }
        set(typeOfTraining) {
            editor.putInt(TYPE_OF_TRAINING, typeOfTraining)
            editor.apply()
        }

    var statistics: ArrayList<StatisticModel>?
        get() {
            val gson = Gson()
            val json: String? = sharedPreferences.getString(STATISTICS, "")
            val type: Type = object : TypeToken<List<StatisticModel?>?>() {}.type
            val arrayList: ArrayList<StatisticModel>? =
                gson.fromJson<List<StatisticModel>>(json, type) as ArrayList<StatisticModel>?
            return arrayList
        }
        set(statistics) {
            val gson = Gson()

            val json = gson.toJson(statistics)

            editor.putString(STATISTICS, json)
            editor.apply()
        }
}