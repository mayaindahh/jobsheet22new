package com.example.maya_22

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class Session  (context: Context){

    private val USERNAME_KEY = "key_username"
    private val NAMA_LENGKAP_KEY = "key_nama_lengkap"

    private var preferences: SharedPreferences = context.getSharedPreferences("Login App" , Context.MODE_PRIVATE )

    fun getUser(): String? {
        return preferences.getString(NAMA_LENGKAP_KEY , null)
    }

    fun setSession(username: String?, nama_lengkap: String?){
        preferences.edit().putString(USERNAME_KEY, username)
            .apply()

        preferences.edit().putString(NAMA_LENGKAP_KEY, username)
            .apply()

    }

    fun isloggedIn(): Boolean {
        val username = preferences.getString(USERNAME_KEY, null)
        return username != null
    }

    fun validate(username: String?, password: String): Boolean {
        val namalengkap = "Maya Indah Lestari."
        if (username == "admin" && password == "admin123") {
            setSession(username, namalengkap)
            return true
        }else if (username == "Radiva" && password == "Radiva123") {
            setSession(username, namalengkap)
            return true
        }else if (username == "3009" && password == "3009") {
            setSession(username,namalengkap)
            return true
        }
        return true
    }
    fun logout() {
        preferences.edit().remove(USERNAME_KEY)
            .remove(NAMA_LENGKAP_KEY)
            .apply()
    }
}