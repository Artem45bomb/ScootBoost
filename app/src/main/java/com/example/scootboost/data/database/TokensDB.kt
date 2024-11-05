package com.example.scootboost.data.database

import android.content.Context
import android.content.Context.MODE_PRIVATE

import android.database.sqlite.SQLiteDatabase

class TokensDB(context:Context) {
    private val db:SQLiteDatabase = context.openOrCreateDatabase("app.db",MODE_PRIVATE,null)

    fun create(){
        db.execSQL("CREATE TABLE IF NOT EXISTS tokens (access_token TEXT,refresh_token TEXT)")
    }

    fun onClose(){
        db.close()
    }
}