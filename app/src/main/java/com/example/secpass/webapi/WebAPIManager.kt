package com.example.secpass.webapi


import com.example.secpass.modal.*
import retrofit2.Call


class WebAPIManager private constructor() {

    private val mApiService: WebAPIService = WebAPIServiceFactory.newInstance().makeServiceFactory()

    companion object {

        private var INSTANCE: WebAPIManager? = null

        val instance: WebAPIManager
            get() {
                if (INSTANCE == null) {
                    INSTANCE = WebAPIManager()
                }
                return INSTANCE as WebAPIManager
            }
    }

    fun getSignup(email: String, password: String): Call<register> {
        return mApiService.getSignup(email,password)
    }
    fun getSignin(email: String, password: String): Call<Login> {
        return mApiService.getSignin(email,password)
    }
    fun getChangepassword(old_password: String, new_password: String): Call<resetpassword> {
        return mApiService.getChangepassword(old_password,new_password)
    }




}
