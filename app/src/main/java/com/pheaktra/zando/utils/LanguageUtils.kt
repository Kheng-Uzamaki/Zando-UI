package com.pheaktra.zando.utils

import android.content.Context
import android.content.res.Configuration
import android.util.Log
import java.util.Locale

object LanguageUtils {
    fun setAppLocale(context: Context, language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = Configuration(context.resources.configuration)
        config.setLocale(locale)
        context.resources.updateConfiguration(config, context.resources.displayMetrics)
        Log.d("LanguageUtils", "Locale updated to: $language")
    }
}


