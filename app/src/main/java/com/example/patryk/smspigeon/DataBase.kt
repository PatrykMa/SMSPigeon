package com.example.patryk.smspigeon

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

const val DataBaseName="try"
const val version=1

const val tableName="name"
const val phoneNumber="phone"
const val content="content"

class BookDataBaseManager(var context: Context): SQLiteOpenHelper(context, DataBaseName,null, version) {
    lateinit var db: SQLiteDatabase
    override fun onOpen(db: SQLiteDatabase) {
        this.db=db
    }

    override fun onCreate(db: SQLiteDatabase?) {

        val CREATE_POSTS_TABLE = "CREATE TABLE " + tableName +
                "(" +
                phoneNumber + " INTEGER PRIMARY KEY," + // Define a primary key
                context + " TEXT " +
                ")"

        db?.execSQL(CREATE_POSTS_TABLE)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}