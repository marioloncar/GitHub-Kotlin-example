package com.mario.github.mvp.data.network

import com.google.gson.annotations.SerializedName

data class User(@SerializedName("id")
                var id: Int = 0,

                @SerializedName("avatar_url")
                var avatarUrl: String? = null,

                @SerializedName("login")
                var login: String? = null,

                @SerializedName("name")
                var name: String? = null,

                @SerializedName("location")
                var location: String? = null,

                @SerializedName("email")
                var email: String? = null,

                @SerializedName("bio")
                var bio: String? = null,

                @SerializedName("public_repos")
                var publicRepos: Int = 0,

                @SerializedName("followers")
                var followers: Int = 0,

                @SerializedName("created_at")
                var createdAt: String? = null)