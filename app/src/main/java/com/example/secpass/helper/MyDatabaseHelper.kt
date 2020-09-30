package com.example.secpass.helper

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class MyDatabaseHelper(private val context: Context?) : SQLiteOpenHelper(
    context,
    DATABASE_NAME,
    null,
    DATABASE_VERSION
) {
    override fun onCreate(db: SQLiteDatabase) {
        val query = "CREATE TABLE  " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_FULLNAME + " TEXT, " +
                COLUMN_NICKNAME + " TEXT, " +
                COLUMN_DOB + " INTEGER," +
                COLUMN_GENDER + " TEXT," +
                COLUMN_NOTE + " TEXT)"
        db.execSQL(query)
        val queryphonenumber =
            "CREATE TABLE  " + TABLE_PHONENO +
                    " (" + COLUMN_IDP + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TITLE + " TEXT, " +
                    COLUMN_PHONENUMBER + " INTEGER, " +
                    COLUMN_COUNTRY + " TEXT," +
                    COLUMN_CATEGORY + " TEXT," +
                    COLUMN_NOTEP + " TEXT)"
        db.execSQL(queryphonenumber)
        val querydrivinglicense =
            "CREATE TABLE  " + TABLE_DRIVINGLICENSE +
                    " (" + COLUMN_IDDL + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TITLEDL + " TEXT, " +
                    COLUMN_FULLNAMEDL + " TEXT, " +
                    COLUMN_NUMBER + " INTEGER," +
                    COLUMN_ISSUEDATE + " INTEGER," +
                    COLUMN_EXPIRATONDATE + " INTEGER," +
                    COLUMN_GENDERDLL + " TEXT," +
                    COLUMN_DATEOFBIRTH + " TEXT," +
                    COLUMN_COUNTRYDL + " TEXT," +
                    COLUMN_NOTEDLL + " TEXT)"
        db.execSQL(querydrivinglicense)
        val querypancard =
            "CREATE TABLE  " + TABLE_PANCARD +
                    " (" + COLUMN_IDPC + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TITLEPC + " TEXT, " +
                    COLUMN_FULLNAMEPC + " TEXT," +
                    COLUMN_PANNUMBERPC + " INTEGER," +
                    COLUMN_CATEGORYPC + " TEXT," +
                    COLUMN_NOTEPC + " TEXT)"
        db.execSQL(querypancard)
        val querypassport =
            "CREATE TABLE " + TABLE_PASSPORT +
                    "(" + COLUMN_IDPP + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TITLEPP + " TEXT, " +
                    COLUMN_FULLNAMEPP + " TEXT, " +
                    COLUMN_NUMBERPP + " INTEGER, " +
                    COLUMN_ISSUEDATEPP + " INTEGER, " +
                    COLUMN_EXPIRATONDATEPP + " INTEGER, " +
                    COLUMN_PLACEOFISSUE + " TEXT, " +
                    COLUMN_GENDERPP + " TEXT, " +
                    COLUMN_DATEOFBIRTHPP + " INTEGER, " +
                    COLUMN_COUNTRYPP + " TEXT, " +
                    COLUMN_NOTEPP + " TEXT)"
        db.execSQL(querypassport)
        val queryelectioncard =
            "CREATE TABLE  " + TABLE_ELECTIONCARD +
                    " (" + COLUMN_IDEC + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TITLEC + " TEXT, " +
                    COLUMN_FULLNAMEEC + " TEXT," +
                    COLUMN_ELECTIONCARDNUMBER + " INTEGER," +
                    COLUMN_CATEGORYEC + " TEXT," +
                    COLUMN_NOTESEC + " TEXT)"
        db.execSQL(queryelectioncard)
        val querysocialmediasites =
            "CREATE TABLE  " + TABLE_SOCIALMEDIASITES +
                    " (" + COLUMN_IDSMS + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TITLSMS + " TEXT, " +
                    COLUMN_EMAILUSERNAME + " TEXT," +
                    COLUMN_PASSWORD + " TEXT," +
                    COLUMN_CATEGORYSMS + " TEXT," +
                    COLUMN_NOTESSMS + " TEXT)"
        db.execSQL(querysocialmediasites)
        val queryecommercesites =
            "CREATE TABLE  " + TABLE_ECOMMERCESITES +
                    " (" + COLUMN_IDECS + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TITLECS + " TEXT, " +
                    COLUMN_EMAILUSERNAMEECS + " TEXT," +
                    COLUMN_PASSWORDECS + " TEXT," +
                    COLUMN_CATEGORYECS + " TEXT," +
                    COLUMN_NOTESECS + " TEXT)"
        db.execSQL(queryecommercesites)
        val querywifi = "CREATE TABLE  " + TABLE_WIFI +
                " (" + COLUMN_IDWIFI + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLEWIFI + " TEXT, " +
                COLUMN_DEVICENAMEWIFI + " TEXT," +
                COLUMN_PASSWORDWIFI + " TEXT," +
                COLUMN_CATEGORYWIFI + " TEXT," +
                COLUMN_NOTEWIFI + " TEXT)"
        db.execSQL(querywifi)
    }

    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_PHONENO")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_DRIVINGLICENSE")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_PANCARD")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_PASSPORT")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_ELECTIONCARD")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_SOCIALMEDIASITES")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_ECOMMERCESITES")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_WIFI")
        onCreate(db)
    }

    //Name
    fun addName(
        fullname: String?,
        nickname: String?,
        dob: Int,
        gender: String?,
        note: String?
    ) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_FULLNAME, fullname)
        cv.put(COLUMN_NICKNAME, nickname)
        cv.put(COLUMN_DOB, dob)
        cv.put(COLUMN_GENDER, gender)
        cv.put(COLUMN_NOTE, note)
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
        note: String?
    ) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_FULLNAME, fullname)
        cv.put(COLUMN_NICKNAME, nickname)
        cv.put(COLUMN_DOB, dob)
        cv.put(COLUMN_GENDER, gender)
        cv.put(COLUMN_NOTE, note)
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

    //PHONE NUMBER
    fun addPhoneno(
        title: String?,
        phonenumber: Int,
        country: String?,
        category: String?,
        notep: String?
    ) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_TITLE, title)
        cv.put(COLUMN_PHONENUMBER, phonenumber)
        cv.put(COLUMN_COUNTRY, country)
        cv.put(COLUMN_CATEGORY, category)
        cv.put(COLUMN_NOTEP, notep)
        val result = db.insert(TABLE_PHONENO, null, cv)
        if (result == -1L) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show()
        }
    }

    fun readAllPhonedata(): Cursor? {
        val query = "SELECT * FROM $TABLE_PHONENO"
        val db = this.readableDatabase
        var cursor: Cursor? = null
        if (db != null) {
            cursor = db.rawQuery(query, null)
        }
        return cursor
    }

    fun updatePHONENO(
        row_id: String,
        title: String?,
        phonenumber: Int,
        country: String?,
        category: String?,
        notep: String?
    ) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_TITLE, title)
        cv.put(COLUMN_PHONENUMBER, phonenumber)
        cv.put(COLUMN_COUNTRY, country)
        cv.put(COLUMN_CATEGORY, category)
        cv.put(COLUMN_NOTEP, notep)
        val result = db.update(
            TABLE_PHONENO,
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

    fun deleteOneRowphone(row_id: String) {
        val db = this.writableDatabase
        val result = db.delete(
            TABLE_PHONENO,
            "_id=?",
            arrayOf(row_id)
        ).toLong()
        if (result == -1L) {
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteAllDataphone() {
        val db = this.writableDatabase
        db.execSQL("DELETE FROM $TABLE_PHONENO")
        // db.execSQL("DELETE FROM " + TABLE_PHONENUMBER);
    }

    //DRIVING LICENSE
    fun adddrivinglicense(
        titledl: String?,
        fullnamdl: String?,
        number: Int,
        issuedate: Int,
        expiratondate: Int,
        genderdll: String?,
        dateofbirth: Int,
        contrydl: String?,
        notedll: String?
    ) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_TITLEDL, titledl)
        cv.put(COLUMN_FULLNAMEDL, fullnamdl)
        cv.put(COLUMN_NUMBER, number)
        cv.put(COLUMN_ISSUEDATE, issuedate)
        cv.put(COLUMN_EXPIRATONDATE, expiratondate)
        cv.put(COLUMN_GENDERDLL, genderdll)
        cv.put(COLUMN_DATEOFBIRTH, dateofbirth)
        cv.put(COLUMN_COUNTRYDL, contrydl)
        cv.put(COLUMN_NOTEDLL, notedll)
        val result =
            db.insert(TABLE_DRIVINGLICENSE, null, cv)
        if (result == -1L) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show()
        }
    }

    fun readAlldrivinglincene(): Cursor? {
        val query =
            "SELECT * FROM $TABLE_DRIVINGLICENSE"
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
        fullnamdl: String?,
        number: Int,
        issuedate: Int,
        expiratondate: Int,
        genderdll: String?,
        dateofbirth: Int,
        contrydl: String?,
        notedll: String?
    ) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_TITLEDL, titledl)
        cv.put(COLUMN_FULLNAMEDL, fullnamdl)
        cv.put(COLUMN_NUMBER, number)
        cv.put(COLUMN_ISSUEDATE, issuedate)
        cv.put(COLUMN_EXPIRATONDATE, expiratondate)
        cv.put(COLUMN_GENDERDLL, genderdll)
        cv.put(COLUMN_DATEOFBIRTH, dateofbirth)
        cv.put(COLUMN_COUNTRYDL, contrydl)
        cv.put(COLUMN_NOTEDLL, notedll)
        val result = db.update(
            TABLE_DRIVINGLICENSE,
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
            TABLE_DRIVINGLICENSE,
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
        db.execSQL("DELETE FROM $TABLE_DRIVINGLICENSE")
        // db.execSQL("DELETE FROM " + TABLE_PHONENUMBER);
    }

    //PANCARD
    fun adddpancard(
        titlepc: String?,
        fullnampc: String?,
        numberpc: Int,
        categorypc: String?,
        notepc: String?
    ) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_TITLEPC, titlepc)
        cv.put(COLUMN_FULLNAMEPC, fullnampc)
        cv.put(COLUMN_PANNUMBERPC, numberpc)
        cv.put(COLUMN_CATEGORYPC, categorypc)
        cv.put(COLUMN_NOTEPC, notepc)
        val result = db.insert(TABLE_PANCARD, null, cv)
        if (result == -1L) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show()
        }
    }

    fun readAllpc(): Cursor? {
        val query = "SELECT * FROM $TABLE_PANCARD"
        val db = this.readableDatabase
        var cursor: Cursor? = null
        if (db != null) {
            cursor = db.rawQuery(query, null)
        }
        return cursor
    }

    fun updatepc(
        row_id: String,
        titlepc: String?,
        fullnampc: String?,
        numberpc: Int,
        categorypc: String?,
        notepc: String?
    ) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_TITLEPC, titlepc)
        cv.put(COLUMN_FULLNAMEPC, fullnampc)
        cv.put(COLUMN_PANNUMBERPC, numberpc)
        cv.put(COLUMN_CATEGORYPC, categorypc)
        cv.put(COLUMN_NOTEPC, notepc)
        val result = db.update(
            TABLE_PANCARD,
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

    fun deleteOneRowpc(row_id: String) {
        val db = this.writableDatabase
        val result = db.delete(
            TABLE_PANCARD,
            "_id=?",
            arrayOf(row_id)
        ).toLong()
        if (result == -1L) {
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteAllDatapc() {
        val db = this.writableDatabase
        db.execSQL("DELETE FROM $TABLE_PANCARD")
        // db.execSQL("DELETE FROM " + TABLE_PHONENUMBER);
    }

    //PASSPORT
    fun addpaport(
        titlepp: String?,
        fullnampp: String?,
        numberpp: Int,
        issuedatepp: Int,
        expiratondatepp: Int,
        placeofissue: String?,
        genderpp: String?,
        dateofbirthpp: Int,
        countrypp: String?,
        notepp: String?
    ) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_TITLEPP, titlepp)
        cv.put(COLUMN_FULLNAMEPP, fullnampp)
        cv.put(COLUMN_NUMBERPP, numberpp)
        cv.put(COLUMN_ISSUEDATEPP, issuedatepp)
        cv.put(COLUMN_EXPIRATONDATEPP, expiratondatepp)
        cv.put(COLUMN_PLACEOFISSUE, placeofissue)
        cv.put(COLUMN_GENDERPP, genderpp)
        cv.put(COLUMN_DATEOFBIRTHPP, dateofbirthpp)
        cv.put(COLUMN_COUNTRYPP, countrypp)
        cv.put(COLUMN_NOTEPP, notepp)
        val result = db.insert(TABLE_PASSPORT, null, cv)
        if (result == -1L) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show()
        }
    }

    fun readAllpp(): Cursor? {
        val query = "SELECT * FROM $TABLE_PASSPORT"
        val db = this.readableDatabase
        var cursor: Cursor? = null
        if (db != null) {
            cursor = db.rawQuery(query, null)
        }
        return cursor
    }

    fun updatepp(
        row_id: String,
        titlepp: String?,
        fullnampp: String?,
        numberpp: Int,
        issuedatepp: Int,
        expiratondatepp: Int,
        placeofissue: String?,
        genderpp: String?,
        dateofbirthpp: Int,
        countrypp: String?,
        notepp: String?
    ) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_TITLEPP, titlepp)
        cv.put(COLUMN_FULLNAMEPP, fullnampp)
        cv.put(COLUMN_NUMBERPP, numberpp)
        cv.put(COLUMN_ISSUEDATEPP, issuedatepp)
        cv.put(COLUMN_EXPIRATONDATEPP, expiratondatepp)
        cv.put(COLUMN_PLACEOFISSUE, placeofissue)
        cv.put(COLUMN_GENDERPP, genderpp)
        cv.put(COLUMN_DATEOFBIRTHPP, dateofbirthpp)
        cv.put(COLUMN_COUNTRYPP, countrypp)
        cv.put(COLUMN_NOTEPP, notepp)
        val result = db.update(
            TABLE_PASSPORT,
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

    fun deleteOneRowpp(row_id: String) {
        val db = this.writableDatabase
        val result = db.delete(
            TABLE_PASSPORT,
            "_id=?",
            arrayOf(row_id)
        ).toLong()
        if (result == -1L) {
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteAllDatapp() {
        val db = this.writableDatabase
        db.execSQL("DELETE FROM $TABLE_PASSPORT")
        // db.execSQL("DELETE FROM " + TABLE_PHONENUMBER);
    }

    //ELECTIONCARD
    fun adddelectioncard(
        titleec: String?,
        fullnamec: String?,
        electioncardnumber: Int,
        categoryec: String?,
        noteec: String?
    ) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_TITLEC, titleec)
        cv.put(COLUMN_FULLNAMEEC, fullnamec)
        cv.put(COLUMN_ELECTIONCARDNUMBER, electioncardnumber)
        cv.put(COLUMN_CATEGORYEC, categoryec)
        cv.put(COLUMN_NOTESEC, noteec)
        val result = db.insert(TABLE_ELECTIONCARD, null, cv)
        if (result == -1L) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show()
        }
    }

    fun readAllec(): Cursor? {
        val query = "SELECT * FROM $TABLE_ELECTIONCARD"
        val db = this.readableDatabase
        var cursor: Cursor? = null
        if (db != null) {
            cursor = db.rawQuery(query, null)
        }
        return cursor
    }

    fun updateec(
        row_id: String,
        titleec: String?,
        fullnamec: String?,
        electioncardnumber: Int,
        categoryec: String?,
        noteec: String?
    ) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_TITLEC, titleec)
        cv.put(COLUMN_FULLNAMEEC, fullnamec)
        cv.put(COLUMN_ELECTIONCARDNUMBER, electioncardnumber)
        cv.put(COLUMN_CATEGORYEC, categoryec)
        cv.put(COLUMN_NOTESEC, noteec)
        val result = db.update(
            TABLE_ELECTIONCARD,
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

    fun deleteOneRowec(row_id: String) {
        val db = this.writableDatabase
        val result = db.delete(
            TABLE_ELECTIONCARD,
            "_id=?",
            arrayOf(row_id)
        ).toLong()
        if (result == -1L) {
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteAllDataec() {
        val db = this.writableDatabase
        db.execSQL("DELETE FROM $TABLE_ELECTIONCARD")
        // db.execSQL("DELETE FROM " + TABLE_PHONENUMBER);
    }

    //SOCIALMIDIASITE
    fun addsocialmediasites(
        titlesms: String?,
        emaiusername: String?,
        password: String?,
        categorysms: String?,
        notesms: String?
    ) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_TITLSMS, titlesms)
        cv.put(COLUMN_EMAILUSERNAME, emaiusername)
        cv.put(COLUMN_PASSWORD, password)
        cv.put(COLUMN_CATEGORYSMS, categorysms)
        cv.put(COLUMN_NOTESSMS, notesms)
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
        emaiusername: String?,
        password: String?,
        categorysms: String?,
        notesms: String?
    ) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_TITLSMS, titlesms)
        cv.put(COLUMN_EMAILUSERNAME, emaiusername)
        cv.put(COLUMN_PASSWORD, password)
        cv.put(COLUMN_CATEGORYSMS, categorysms)
        cv.put(COLUMN_NOTESSMS, notesms)
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

    //ECOMMERCESITES
    fun addecommercesites(
        titleecs: String?,
        emaiusernameecs: String?,
        passwordecs: String?,
        categoryecs: String?,
        noteecs: String?
    ) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_TITLECS, titleecs)
        cv.put(COLUMN_EMAILUSERNAMEECS, emaiusernameecs)
        cv.put(COLUMN_PASSWORDECS, passwordecs)
        cv.put(COLUMN_CATEGORYECS, categoryecs)
        cv.put(COLUMN_NOTESECS, noteecs)
        val result =
            db.insert(TABLE_ECOMMERCESITES, null, cv)
        if (result == -1L) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show()
        }
    }

    fun readAllecs(): Cursor? {
        val query =
            "SELECT * FROM $TABLE_ECOMMERCESITES"
        val db = this.readableDatabase
        var cursor: Cursor? = null
        if (db != null) {
            cursor = db.rawQuery(query, null)
        }
        return cursor
    }

    fun updateecs(
        row_id: String,
        titleecs: String?,
        emaiusernameecs: String?,
        passwordecs: String?,
        categoryecs: String?,
        noteecs: String?
    ) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_TITLECS, titleecs)
        cv.put(COLUMN_EMAILUSERNAMEECS, emaiusernameecs)
        cv.put(COLUMN_PASSWORDECS, passwordecs)
        cv.put(COLUMN_CATEGORYECS, categoryecs)
        cv.put(COLUMN_NOTESECS, noteecs)
        val result = db.update(
            TABLE_ECOMMERCESITES,
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

    fun deleteOneRowecs(row_id: String) {
        val db = this.writableDatabase
        val result = db.delete(
            TABLE_ECOMMERCESITES,
            "_id=?",
            arrayOf(row_id)
        ).toLong()
        if (result == -1L) {
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteAllDataecs() {
        val db = this.writableDatabase
        db.execSQL("DELETE FROM $TABLE_ECOMMERCESITES")
        // db.execSQL("DELETE FROM " + TABLE_PHONENUMBER);
    }

    //WIFI
    fun addwifi(
        titlewifi: String?,
        devicenamewifi: String?,
        passwordwifi: String?,
        categoryewifi: String?,
        notewifi: String?
    ) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_TITLEWIFI, titlewifi)
        cv.put(COLUMN_DEVICENAMEWIFI, devicenamewifi)
        cv.put(COLUMN_PASSWORDWIFI, passwordwifi)
        cv.put(COLUMN_CATEGORYWIFI, categoryewifi)
        cv.put(COLUMN_NOTEWIFI, notewifi)
        val result = db.insert(TABLE_WIFI, null, cv)
        if (result == -1L) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show()
        }
    }

    fun readAllwifi(): Cursor? {
        val query = "SELECT * FROM $TABLE_WIFI"
        val db = this.readableDatabase
        var cursor: Cursor? = null
        if (db != null) {
            cursor = db.rawQuery(query, null)
        }
        return cursor
    }

    fun updatewifi(
        row_id: String,
        titlewifi: String?,
        devicenamewifi: String?,
        passwordwifi: String?,
        categoryewifi: String?,
        notewifi: String?
    ) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_TITLEWIFI, titlewifi)
        cv.put(COLUMN_DEVICENAMEWIFI, devicenamewifi)
        cv.put(COLUMN_PASSWORDWIFI, passwordwifi)
        cv.put(COLUMN_CATEGORYWIFI, categoryewifi)
        cv.put(COLUMN_NOTEWIFI, notewifi)
        val result = db.update(
            TABLE_WIFI,
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

    fun deleteOneRowwifi(row_id: String) {
        val db = this.writableDatabase
        val result = db.delete(
            TABLE_WIFI,
            "_id=?",
            arrayOf(row_id)
        ).toLong()
        if (result == -1L) {
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteAllDatawifi() {
        val db = this.writableDatabase
        db.execSQL("DELETE FROM $TABLE_WIFI")
        // db.execSQL("DELETE FROM " + TABLE_PHONENUMBER);
    }

    companion object {
        private const val DATABASE_NAME = "SecPass.db"
        private const val DATABASE_VERSION = 1

        //NAME
        private const val TABLE_NAME = "my_SecPass"
        private const val COLUMN_ID = "_id"
        private const val COLUMN_FULLNAME = "SecPass_fullname"
        private const val COLUMN_NICKNAME = "SecPass_nickname"
        private const val COLUMN_DOB = "SecPass_dob"
        private const val COLUMN_GENDER = "SecPass_gender"
        private const val COLUMN_NOTE = "SecPass_note"

        //PHONENUMBER
        private const val TABLE_PHONENO = "my_SecPassPhonenumber"
        private const val COLUMN_IDP = "_idp"
        private const val COLUMN_TITLE = "SecPass_title"
        private const val COLUMN_PHONENUMBER = "SecPass_phonenumber"
        private const val COLUMN_COUNTRY = "SecPass_country"
        private const val COLUMN_CATEGORY = "SecPass_categoty"
        private const val COLUMN_NOTEP = "SecPass_notep"

        //DRIVING LICENSE
        private const val TABLE_DRIVINGLICENSE = "my_SecPassdrivinglicense"
        private const val COLUMN_IDDL = "_iddl"
        private const val COLUMN_TITLEDL = "SecPass_titledl"
        private const val COLUMN_FULLNAMEDL = "SecPass_fullnamedl"
        private const val COLUMN_NUMBER = "SecPass_number"
        private const val COLUMN_ISSUEDATE = "SecPass_issuedate"
        private const val COLUMN_EXPIRATONDATE = "SecPass_expirationdate"
        private const val COLUMN_GENDERDLL = "SecPass_genderdll"
        private const val COLUMN_DATEOFBIRTH = "SecPass_dateofbirth"
        private const val COLUMN_COUNTRYDL = "SecPass_countrydl"
        private const val COLUMN_NOTEDLL = "SecPass_notedll"

        //PANCARD
        private const val TABLE_PANCARD = "my_SecPassPancard"
        private const val COLUMN_IDPC = "_idpc"
        private const val COLUMN_TITLEPC = "SecPass_titlepc"
        private const val COLUMN_FULLNAMEPC = "SecPass_fullnamepc"
        private const val COLUMN_PANNUMBERPC = "SecPass_pannumberpc"
        private const val COLUMN_CATEGORYPC = "SecPass_categorypc"
        private const val COLUMN_NOTEPC = "SecPass_notepc"

        //PASSPORT
        private const val TABLE_PASSPORT = "my_SecPasspassport"
        private const val COLUMN_IDPP = "_idpp"
        private const val COLUMN_TITLEPP = "SecPass_titlepp"
        private const val COLUMN_FULLNAMEPP = "SecPass_fullnamepp"
        private const val COLUMN_NUMBERPP = "SecPass_numberpp"
        private const val COLUMN_ISSUEDATEPP = "SecPass_issuedatepp"
        private const val COLUMN_EXPIRATONDATEPP = "SecPass_expirationdatepp"
        private const val COLUMN_PLACEOFISSUE = "SecPass_placeofissue"
        private const val COLUMN_GENDERPP = "SecPass_genderpp"
        private const val COLUMN_DATEOFBIRTHPP = "SecPass_dateofbirthpp"
        private const val COLUMN_COUNTRYPP = "SecPass_countrypp"
        private const val COLUMN_NOTEPP = "SecPass_notepp"

        //ELECTIONCARD
        private const val TABLE_ELECTIONCARD = "my_SecPasselectioncard"
        private const val COLUMN_IDEC = "_idec"
        private const val COLUMN_TITLEC = "SecPass_titleec"
        private const val COLUMN_FULLNAMEEC = "SecPass_fullnameec"
        private const val COLUMN_ELECTIONCARDNUMBER = "SecPass_electioncardnumber"
        private const val COLUMN_CATEGORYEC = "SecPass_categoryec"
        private const val COLUMN_NOTESEC = "SecPass_notesec"

        //SOCIALMEDIASITES
        private const val TABLE_SOCIALMEDIASITES = "my_SecPasssocialmediasites"
        private const val COLUMN_IDSMS = "_idsms"
        private const val COLUMN_TITLSMS = "SecPass_titlesms"
        private const val COLUMN_EMAILUSERNAME = "SecPass_emailusername"
        private const val COLUMN_PASSWORD = "SecPass_password"
        private const val COLUMN_CATEGORYSMS = "SecPass_categorysms"
        private const val COLUMN_NOTESSMS = "SecPass_notessms"

        //ECOMMERCESITES
        private const val TABLE_ECOMMERCESITES = "my_SecPassecommercesites"
        private const val COLUMN_IDECS = "_idecs"
        private const val COLUMN_TITLECS = "SecPass_titleecs"
        private const val COLUMN_EMAILUSERNAMEECS = "SecPass_emailusernameecs"
        private const val COLUMN_PASSWORDECS = "SecPass_passwordecs"
        private const val COLUMN_CATEGORYECS = "SecPass_categoryecs"
        private const val COLUMN_NOTESECS = "SecPass_notesecs"

        //WIFI
        private const val TABLE_WIFI = "my_SecPasswifi"
        private const val COLUMN_IDWIFI = "_idwifi"
        private const val COLUMN_TITLEWIFI = "SecPass_titlewifi"
        private const val COLUMN_DEVICENAMEWIFI = "SecPass_devicenamewifi"
        private const val COLUMN_PASSWORDWIFI = "SecPass_passwordwifi"
        private const val COLUMN_CATEGORYWIFI = "SecPass_categorywifi"
        private const val COLUMN_NOTEWIFI = "SecPass_notewifi"
    }

}