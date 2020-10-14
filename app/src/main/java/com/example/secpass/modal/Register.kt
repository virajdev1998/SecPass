package com.example.secpass.modal

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class registermodel {
    @SerializedName("email")
    @Expose
    var email: String? = null

    @SerializedName("user_id")
    @Expose
    var userId: Int? = null

    @SerializedName("token")
    @Expose
    var token: String? = null

    @SerializedName("profile_id")
    @Expose
    var profileId: Int? = null

    @SerializedName("profile_image")
    @Expose
    var profileImage: String? = null

}
