package com.example.assigment6

import android.content.Context
import android.content.Intent


class SharedPrefManager {

    private val SHARED_PREF_NAME = "volleyregisterlogin"
    private val KEY_USERNAME = "keyusername"
    private val KEY_EMAIL = "keyemail"
    private val KEY_GENDER = "keygender"
    private val KEY_ID = "keyid"
    private var mInstance: SharedPrefManager? = null
    private var ctx: Context? = null

    constructor(context: Context) {
        ctx = context
    }

    @Synchronized
    fun getInstance(context: Context?): SharedPrefManager? {
        if (mInstance == null) {
            mInstance = SharedPrefManager(context!!)
        }
        return mInstance
    }
    fun userLogin(user: User) {
        val sharedPreferences = ctx!!.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt(KEY_ID, user.getId())
        editor.putString(KEY_USERNAME, user.getName())
        editor.putString(KEY_EMAIL, user.getEmail())
        editor.putString(KEY_GENDER, user.getGender())
        editor.apply()
    }
    fun isLoggedIn(): Boolean {
        val sharedPreferences = ctx!!.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getString(KEY_USERNAME, null) != null
    }
    fun getUser(): User{
        val sharedPreferences = ctx!!.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        return User(
            sharedPreferences.getInt(KEY_ID, -1),
            sharedPreferences.getString(KEY_USERNAME, null)!!,
            sharedPreferences.getString(KEY_EMAIL, null)!!,
            sharedPreferences.getString(KEY_GENDER, null)!!
        )
    }

    fun logout() {
        val sharedPreferences = ctx!!.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
        ctx!!.startActivity(Intent(ctx, LoginActivity::class.java))
    }


}