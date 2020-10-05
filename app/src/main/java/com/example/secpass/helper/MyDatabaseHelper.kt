package com.example.secpass.helper

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class MyDatabaseHelper(private val context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        //personal info
        val query = "CREATE TABLE  " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_FULLNAME + " TEXT, " +
                COLUMN_NICKNAME + " TEXT, " +
                COLUMN_DOB + " DATE," +
                COLUMN_GENDER + " TEXT," +
                //phonenumberquery
                COLUMN_TITLE + " TEXT, " +
                COLUMN_PHONENUMBER + " INTEGER, " +
                COLUMN_COUNTRY + " TEXT," +
                COLUMN_CATEGORY + " TEXT," +
                COLUMN_NOTE + " TEXT)"
        db.execSQL(query)

        //IDS
        val queryidproof =
            "CREATE TABLE  " + TABLE_IDPROOF +
                    " (" + COLUMN_IDDL + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TITLEIDS + " TEXT, " +
                    COLUMN_FULLNAMEIDS + " TEXT, " +
                    COLUMN_NUMBERIDS + " TEXT," +
                    //category Pancard & Election card
                    COLUMN_CATEGORYIDS + " TEXT," +
                    COLUMN_ISSUEDATEIDS + " TEXT," +
                    COLUMN_EXPIRATONDATEIDS + " TEXT," +
                    COLUMN_DATEOFBIRTHIDS + " TEXT," +
                    //passport issue place
                    COLUMN_PLACEOFISSUEIDS + " TEXT, " +
                    COLUMN_GENDERIDS + " TEXT," +
                    COLUMN_COUNTRYIDS + " TEXT," +
                    COLUMN_NOTEIDS + " TEXT)"
        db.execSQL(queryidproof)

        val query_socialmedia =
            "CREATE TABLE  " + TABLE_SOCIALMEDIASITES +
                    " (" + COLUMN_IDPASSWORD + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TITLPASSWORD + " TEXT, " +
                    COLUMN_EMAILUSERNAMEPASSWORD + " TEXT, " +
                    COLUMN_PASSWORDPASSWORD + " TEXT," +
                    COLUMN_CATEGORYPASSWORD + " TEXT," +
                    COLUMN_NOTESPASSWORD + " TEXT)"
        db.execSQL(query_socialmedia)


    }

    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_IDPROOF")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_SOCIALMEDIASITES")
        onCreate(db)
    }

    //personal info
    fun addName(

        fullname: String?,
        nickname: String?,
        dob: String,
        gender: String?,
        title: String?,
        phonenumber: String,
        country: String?,
        category: String?,
        note: String?
    ) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_FULLNAME, fullname)
        cv.put(COLUMN_NICKNAME, nickname)
        cv.put(COLUMN_DOB, dob)
        cv.put(COLUMN_GENDER, gender)
        cv.put(COLUMN_NOTE, note)
        cv.put(COLUMN_TITLE, title)
        cv.put(COLUMN_PHONENUMBER, phonenumber)
        cv.put(COLUMN_COUNTRY, country)
        cv.put(COLUMN_CATEGORY, category)
        val result = db.insert(TABLE_NAME, null, cv)
        if (result == -1L) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show()
        }
    }

    fun readAllData(): Cursor? {
        val query = "SELECT * FROM $TABLE_NAME"
        val db = this.readableDatabase
        var cursor: Cursor? = null
        if (db != null) {
            cursor = db.rawQuery(query, null)
        }
        return cursor
    }

    fun updateData(
        row_id: String,
        fullname: String?,
        nickname: String?,
        dob: String?,
        gender: String?,
        note: String?,
        title: String?,
        phonenumber: String,
        country: String?,
        category: String?
    ) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_FULLNAME, fullname)
        cv.put(COLUMN_NICKNAME, nickname)
        cv.put(COLUMN_DOB, dob)
        cv.put(COLUMN_GENDER, gender)
        cv.put(COLUMN_NOTE, note)
        cv.put(COLUMN_TITLE, title)
        cv.put(COLUMN_PHONENUMBER, phonenumber)
        cv.put(COLUMN_COUNTRY, country)
        cv.put(COLUMN_CATEGORY, category)
        val result = db.update(
            TABLE_NAME,
            cv,
            "_id=?",
            arrayOf(row_id)
        ).toLong()
        if (result == -1L) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteOneRow(row_id: String) {
        val db = this.writableDatabase
        val result = db.delete(
            TABLE_NAME,
            "_id=?",
            arrayOf(row_id)
        ).toLong()
        if (result == -1L) {
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteAllData() {
        val db = this.writableDatabase
        db.execSQL("DELETE FROM $TABLE_NAME")
        // db.execSQL("DELETE FROM " + TABLE_PHONENUMBER);
    }

    //DRIVING LICENSE
    fun addidproof(
        titledl: String?,
        fullnamdl: String?,
        number: String,
        issuedate: String,
        expiratondate: String,
        genderdll: String?,
        dateofbirth: String,
        contrydl: String?,
        notedll: String?,
        categorypc_ec: String?,
        placeofissue: String?
    ) {

        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_TITLEIDS, titledl )
        cv.put(COLUMN_FULLNAMEIDS, fullnamdl)
        cv.put(COLUMN_NUMBERIDS, number)
        cv.put(COLUMN_CATEGORYIDS, categorypc_ec)
        cv.put(COLUMN_ISSUEDATEIDS, issuedate)
        cv.put(COLUMN_EXPIRATONDATEIDS, expiratondate)
        cv.put(COLUMN_DATEOFBIRTHIDS, dateofbirth)
        cv.put(COLUMN_PLACEOFISSUEIDS, placeofissue)
        cv.put(COLUMN_GENDERIDS, genderdll)
        cv.put(COLUMN_COUNTRYIDS, contrydl)
        cv.put(COLUMN_NOTEIDS, notedll)
        val result =
            db.insert(TABLE_IDPROOF, null, cv)
        if (result == -1L) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show()
        }
    }

        fun readAlldrivinglincene(): Cursor? {
        val query =
            "SELECT * FROM $TABLE_IDPROOF"
        val db = this.readableDatabase
        var cursor: Cursor? = null
        if (db != null) {
            cursor = db.rawQuery(query, null)
        }
        return cursor
    }

    fun updateDrivinglincence(
        row_id: String,
        titledl: String?,
        fullnamedl: String?,
        number: Int,
        issuedate: Int,
        expiratondate: Int,
        genderdll: String?,
        dateofbirth: Int,
        contrydl: String?,
        notedll: String?,
        categorypc_ec: String?,
        placeofissue: String?

    ) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_TITLEIDS, titledl)
        cv.put(COLUMN_FULLNAMEIDS, fullnamedl)
        cv.put(COLUMN_NUMBERIDS, number)
        cv.put(COLUMN_ISSUEDATEIDS, issuedate)
        cv.put(COLUMN_EXPIRATONDATEIDS, expiratondate)
        cv.put(COLUMN_GENDERIDS, genderdll)
        cv.put(COLUMN_DATEOFBIRTHIDS, dateofbirth)
        cv.put(COLUMN_COUNTRYIDS, contrydl)
        cv.put(COLUMN_NOTEIDS, notedll)
        cv.put(COLUMN_CATEGORYIDS, categorypc_ec)
        cv.put(COLUMN_PLACEOFISSUEIDS, placeofissue)
        val result = db.update(
            TABLE_IDPROOF,
            cv,
            "_id=?",
            arrayOf(row_id)
        ).toLong()
        if (result == -1L) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteOneRowdrivinglincence(row_id: String) {
        val db = this.writableDatabase
        val result = db.delete(
            TABLE_IDPROOF,
            "_id=?",
            arrayOf(row_id)
        ).toLong()
        if (result == -1L) {
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteAllDatadrivinglincence() {
        val db = this.writableDatabase
        db.execSQL("DELETE FROM $TABLE_IDPROOF")
        // db.execSQL("DELETE FROM " + TABLE_PHONENUMBER);
    }

    //SOCIALMIDIASITE
        fun addsocialmediasites(
        titlesms: String?,
        emaiusername_devicename: String?,
        password: String?,
        categorysms: String?,
        notesms: String?
    ) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_TITLPASSWORD, titlesms)
        cv.put(COLUMN_EMAILUSERNAMEPASSWORD, emaiusername_devicename)
        cv.put(COLUMN_PASSWORDPASSWORD, password)
        cv.put(COLUMN_CATEGORYPASSWORD, categorysms)
        cv.put(COLUMN_NOTESPASSWORD, notesms)
        val result =
            db.insert(TABLE_SOCIALMEDIASITES, null, cv)
        if (result == -1L) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show()
        }
    }

    fun readAllsms(): Cursor? {
        val query =
            "SELECT * FROM $TABLE_SOCIALMEDIASITES"
        val db = this.readableDatabase
        var cursor: Cursor? = null
        if (db != null) {
            cursor = db.rawQuery(query, null)
        }
        return cursor
    }

    fun updatesms(
        row_id: String,
        titlesms: String?,
        emaiusername_devicename: String?,
        password: String?,
        categorysms: String?,
        notesms: String?
    ) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_TITLPASSWORD, titlesms)
        cv.put(COLUMN_EMAILUSERNAMEPASSWORD, emaiusername_devicename)
        cv.put(COLUMN_PASSWORDPASSWORD, password)
        cv.put(COLUMN_CATEGORYPASSWORD, categorysms)
        cv.put(COLUMN_NOTESPASSWORD, notesms)
        val result = db.update(
            TABLE_SOCIALMEDIASITES,
            cv,
            "_id=?",
            arrayOf(row_id)
        ).toLong()
        if (result == -1L) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteOneRowsms(row_id: String) {
        val db = this.writableDatabase
        val result = db.delete(
            TABLE_SOCIALMEDIASITES,
            "_id=?",
            arrayOf(row_id)
        ).toLong()
        if (result == -1L) {
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteAllDatasms() {
        val db = this.writableDatabase
        db.execSQL("DELETE FROM $TABLE_SOCIALMEDIASITES")
        // db.execSQL("DELETE FROM " + TABLE_PHONENUMBER);
    }


    companion object {
        private const val DATABASE_NAME = "SecPass1.db"
        private const val DATABASE_VERSION = 2
     //PERSONAL INFO
        //NAME
        private const val   TABLE_NAME = "personal_info"
        private const val COLUMN_ID = "_id"
        private const val COLUMN_FULLNAME = "fullname"
        private const val COLUMN_NICKNAME = "nickname"
        private const val COLUMN_DOB = "dob"
        private const val COLUMN_GENDER = "gender"


        private const val COLUMN_TITLE = "title"
        private const val COLUMN_PHONENUMBER = "phonenumber"
        private const val COLUMN_COUNTRY = "country"
        private const val COLUMN_CATEGORY = "categoty"
        private const val COLUMN_NOTE = "note"
       //ID'S
        //DRIVING LICENSE
        private const val TABLE_IDPROOF = "idproof"
        private const val COLUMN_IDDL = "_id"
        private const val COLUMN_TITLEIDS = "title"
        private const val COLUMN_FULLNAMEIDS = "fullname"
        private const val COLUMN_NUMBERIDS = "number"
        private const val COLUMN_ISSUEDATEIDS = "issuedate"
        private const val COLUMN_EXPIRATONDATEIDS = "expirationdate"
        private const val COLUMN_DATEOFBIRTHIDS = "dateofbirth"
       // private const val COLUMN_DATEOFBIRTH = "SecPass_dateofbirth"
        private const val COLUMN_COUNTRYIDS = "country"
        private const val COLUMN_NOTEIDS = "note"
        private const val COLUMN_CATEGORYIDS = "category"
        private const val COLUMN_PLACEOFISSUEIDS = "placeofissue"
        private const val COLUMN_GENDERIDS = "gender"


        //SOCIALMEDIASITES
        private const val TABLE_SOCIALMEDIASITES = "socialmediasites"
        private const val COLUMN_IDPASSWORD = "_id"
        private const val COLUMN_TITLPASSWORD = "title"
        private const val COLUMN_EMAILUSERNAMEPASSWORD = "emailusername"
        private const val COLUMN_PASSWORDPASSWORD = "password"
        private const val COLUMN_CATEGORYPASSWORD = "category"
        private const val COLUMN_NOTESPASSWORD = "notes"

    }

}