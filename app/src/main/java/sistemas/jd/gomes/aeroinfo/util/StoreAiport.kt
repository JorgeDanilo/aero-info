package sistemas.jd.gomes.aeroinfo.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

val Context.dataStore: DataStore<Preferences> by preferencesDataStore("airport")

class StoreAiport(context: Context) {

    companion object {
        val AIRPORT_KEY = stringPreferencesKey("airport_search")
    }

    private val dataStore = context.dataStore

    suspend fun saveAirport(icaoCode: String) {
        dataStore.edit { preferences ->
            preferences[AIRPORT_KEY] = icaoCode
        }
    }

    fun readSavedAirport(): Flow<String> {
        return dataStore.data.catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map { preferences ->
            val icaoCode = preferences[AIRPORT_KEY] ?: ""
            icaoCode
        }
    }
}