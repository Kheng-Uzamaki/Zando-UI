package com.pheaktra.zando.viewmodel

import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.pheaktra.zando.MainActivity
import com.pheaktra.zando.themes.ThemeManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.Locale

class ThemeViewModel(application: Application) : AndroidViewModel(application) {
    private val themeManager = ThemeManager(application)
    private val sharedPreferences = application.getSharedPreferences("settings", Context.MODE_PRIVATE)

    private val _isDarkMode = MutableStateFlow(false)
    val isDarkMode: StateFlow<Boolean> = _isDarkMode

    private val _selectedLanguage = MutableStateFlow(sharedPreferences.getString("language", "en") ?: "en")
    val selectedLanguage: StateFlow<String> = _selectedLanguage

    init {
        viewModelScope.launch {
            themeManager.darkModeFlow.collect { isDark ->
                _isDarkMode.value = isDark
            }
        }
        setAppLocale(application, _selectedLanguage.value)
    }

    fun toggleDarkMode() {
        viewModelScope.launch {
            themeManager.setDarkMode(!_isDarkMode.value)
        }
    }

    fun setLanguage(language: String) {
        _selectedLanguage.value = language
        sharedPreferences.edit().putString("language", language).apply()
        Log.d("ThemeViewModel", "Language set to: $language") // Debugging log

        // Restart Activity instead of killing app
        val context = getApplication<Application>().applicationContext
        val intent = Intent(context, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        context.startActivity(intent)
    }

    private fun setAppLocale(context: Context, language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = Configuration(context.resources.configuration)
        config.setLocale(locale)
        context.resources.updateConfiguration(config, context.resources.displayMetrics)
    }
}