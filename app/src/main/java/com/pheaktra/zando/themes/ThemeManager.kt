package com.pheaktra.zando.themes

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "settings")

class ThemeManager(private val context: Context) {

    private val DARK_MODE_KEY = booleanPreferencesKey("dark_mode")

    val darkModeFlow: Flow<Boolean> = context.dataStore.data
        .map { preferences -> preferences[DARK_MODE_KEY] ?: false }

    suspend fun setDarkMode(enabled: Boolean) {
        context.dataStore.edit { settings ->
            settings[DARK_MODE_KEY] = enabled
        }
    }
}