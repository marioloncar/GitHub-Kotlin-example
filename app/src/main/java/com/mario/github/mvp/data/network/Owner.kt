package com.mario.github.mvp.data.network

import com.google.gson.annotations.SerializedName

data class Owner(@SerializedName("id")
                 var id: Int = 0,

                 @SerializedName("received_events_url")
                 var receivedEventsUrl: String? = null,

                 @SerializedName("avatar_url")
                 var avatarUrl: String? = null,

                 @SerializedName("gravatar_id")
                 var gravatarId: String? = null,

                 @SerializedName("login")
                 var login: String? = null,

                 @SerializedName("type")
                 var type: String? = null,

                 @SerializedName("url")
                 var url: String? = null,

                 @SerializedName("node_id")
                 var nodeId: String? = null,

                 @SerializedName("html_url")
                 var htmlUrl: String? = null,

                 @SerializedName("site_admin")
                 var siteAdmin: Boolean = false
)