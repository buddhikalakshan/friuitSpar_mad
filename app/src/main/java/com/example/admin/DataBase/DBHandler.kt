package com.example.admin.DataBase


import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class DBHandler {

    class DBHandler(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
        override fun onCreate(db: SQLiteDatabase) {
            db.execSQL(SQL_CREATE_ENTRIES)
        }
        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            // This database is only a cache for online data, so its upgrade policy is
            // to simply to discard the data and start over
            db.execSQL(SQL_DELETE_ENTRIES)
            onCreate(db)
        }
        override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            onUpgrade(db, oldVersion, newVersion)
        }
        companion object {
            // If you change the database schema, you must increment the database version.
            const val DATABASE_VERSION = 1
            const val DATABASE_NAME = "Admin.db"
        }

        private val SQL_CREATE_ENTRIES =
            "CREATE TABLE ${DeliveryProfile.DeliveryDetails.TABLE_NAME} (" +
                    "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                    "${AdminProfile.AdminDetails.COLUMN_1} TEXT," +
                    "${AdminProfile.AdminDetails.COLUMN_2} TEXT," +
                    "${AdminProfile.AdminDetails.COLUMN_3} TEXT," +
                    "${AdminProfile.AdminDetails.COLUMN_4} TEXT)"

        private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${AdminProfile.AdminDetails.TABLE_NAME}"


    //insert
    fun addInfo(ItemId: String, ItemName: String, Itemprice: String, SupplierId: String): Long? {
        // Gets the data repository in write mode
        val db = writableDatabase

        // Create a new map of values, where column names are the keys
        val values = ContentValues().apply {
            put(AdminProfile.AdminDetails.COLUMN_1, ItemId)
            put(AdminProfile.AdminDetails.COLUMN_2, ItemName)
            put(AdminProfile.AdminDetails.COLUMN_3, Itemprice)
            put(AdminProfile.AdminDetails.COLUMN_4, SupplierId)
        }

        // Insert the new newRowId1, returning the primary key value of the new row
        val newRowId1 = db?.insert(AdminProfile.AdminDetails.TABLE_NAME, null, values)

        return newRowId1
        }
//update
        fun updateInfo(ItemId: String, ItemName: String, Itemprice: String, SupplierId: String){
            val db = writableDatabase

            // New value for one column
            val values = ContentValues().apply {
                put(AdminProfile.AdminDetails.COLUMN_2, ItemName)
                put(AdminProfile.AdminDetails.COLUMN_3, Itemprice)
                put(AdminProfile.AdminDetails.COLUMN_4, SupplierId)
            }

            // Which row to update, based on the title
            val selection = "${AdminProfile.AdminDetails.COLUMN_1} LIKE ?"
            val selectionArgs = arrayOf(ItemId)
            val count = db.update(
                AdminProfile.AdminDetails.TABLE_NAME,
                values,
                selection,
                selectionArgs)
            }
        fun deleteInfo(PNumber: String){
            val db = writableDatabase

            // Define 'where' part of query.
            val selection = "${AdminProfile.AdminDetails.COLUMN_1} LIKE ?"
            // Specify arguments in placeholder order.
            val selectionArgs = arrayOf(ItemId)
            // Issue SQL statement.
            val deletedRows = db.delete(AdminProfile.AdminDetails.TABLE_NAME, selection, selectionArgs)
            }
    }
