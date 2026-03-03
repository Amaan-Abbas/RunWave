package com.example.runWave.model

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Creating a preference file.
private val Context.dataStore by preferencesDataStore(name = "app_prefs")

object DataStoreManager {
    private val IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")
    private val USERNAME = stringPreferencesKey("username")

    suspend fun setLoggedIn(context: Context, value: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[IS_LOGGED_IN] = value
        }
    }

    suspend fun saveUsername(context: Context,  value: String) {
        context.dataStore.edit { prefs ->
            prefs[USERNAME] = value
        }
    }

    fun isLoggedIn(context: Context): Flow<Boolean> {
        return context.dataStore.data.map { prefs ->
            prefs[IS_LOGGED_IN] ?: false
        }
    }

    fun getUsername(context: Context): Flow<String> {
        return context.dataStore.data.map { prefs ->
            prefs[USERNAME] ?: ""
        }
    }
}