package com.example.secpass.webapi


import com.example.secpass.modal.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*


interface WebAPIService {

    @POST("account/register/")
    fun getSignup(
        @Query("email") email: String,
        @Query("password") password: String

    ): Call<register>
    @POST("account/login/")
    fun getSignin(
        @Query("email") email: String,
        @Query("password") password: String

    ): Call<Login>

    @POST("account/change-password/")
    fun getChangepassword(
        @Query("old_password") old_password: String,
        @Query("new_password") new_password: String

    ): Call<resetpassword>

}   