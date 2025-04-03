package com.example.userdirectory.model

import android.media.Image
import com.google.gson.annotations.SerializedName

data class UserDataResults(
    @SerializedName("results")
    val results: List<UserData>
)

data class UserName(
    @SerializedName("first")
    val firstName: String,
    @SerializedName("name")
    val lastName: String
)

data class UserLogin(
    @SerializedName("uuid")
    val id: String
)

data class ProfileImage(
    @SerializedName("large")
    val imageURL: String
)

data class UserData(
    @SerializedName("name")
    val userName: UserName,
    @SerializedName("login")
    val userLogin: UserLogin,
    @SerializedName("email")
    val email: String,
    @SerializedName("picture")
    val profileImage: ProfileImage
)