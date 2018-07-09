package com.mario.github.mvp.data.network

import com.google.gson.annotations.SerializedName

data class LoginResponse(@SerializedName("scope")
                         var scope: String? = null,

                         @SerializedName("token_type")
                         var tokenType: String? = null,

                         @SerializedName("access_token")
                         var accessToken: String? = null)