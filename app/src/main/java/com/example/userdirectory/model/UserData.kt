package com.example.userdirectory.model

import com.google.gson.annotations.SerializedName

data class UserDataResults(
    @SerializedName("results")
    val results: List<UserData>
)

data class UserData(
    @SerializedName("name")
    val name: Any,
    @SerializedName("name.first")
    val firstName : String
)