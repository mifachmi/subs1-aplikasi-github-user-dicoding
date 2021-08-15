package com.example.submissiongithubuser

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Users(
    var photoUser: Int = 0,
    var fullname: String = "",
    var username: String = "",
    var amountRepository: String = "",
    var amountFollowers: String = "",
    var amountFollowing: String = "",
    var company: String = "",
    var location: String = ""

) : Parcelable