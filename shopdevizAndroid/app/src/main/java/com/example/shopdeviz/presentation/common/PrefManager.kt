package com.example.shopdeviz.presentation.common

import android.content.Context
import android.content.SharedPreferences


class PrefManager(var _context: Context) {
    var pref: SharedPreferences
    var editor: SharedPreferences.Editor

    var PRIVATE_MODE = 0

    init {
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }

    var isFirstTimeLaunch: Boolean
        get() = pref.getBoolean(IS_FIRST_TIME_LAUNCH, true)
        set(isFirstTime) {
            editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime)
            editor.commit()
        }

    companion object {
        private const val PREF_NAME = "androidhive-welcome"
        private const val IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch"
    }
}