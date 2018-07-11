package com.mario.github.mvp.data.network.model

import com.google.gson.annotations.SerializedName

data class Repo(@SerializedName("watchers_count")
                var watchersCount: Int = 0,

                @SerializedName("fork")
                var fork: Boolean = false,

                @SerializedName("score")
                var score: Float = 0.toFloat(),

                @SerializedName("master_branch")
                var masterBranch: String? = null,

                @SerializedName("open_issues_count")
                var openIssuesCount: Int = 0,

                @SerializedName("homepage")
                var homepage: String? = null,

                @SerializedName("url")
                var url: String? = null,

                @SerializedName("size")
                var size: Int = 0,

                @SerializedName("node_id")
                var nodeId: String? = null,

                @SerializedName("private")
                var privateRepo: Boolean = false,

                @SerializedName("default_branch")
                var defaultBranch: String? = null,

                @SerializedName("id")
                var id: Int = 0,

                @SerializedName("html_url")
                var htmlUrl: String? = null,

                @SerializedName("updated_at")
                var updatedAt: String? = null,

                @SerializedName("description")
                var description: String? = null,

                @SerializedName("name")
                var name: String? = null,

                @SerializedName("owner")
                var owner: Owner? = null,

                @SerializedName("created_at")
                var createdAt: String? = null,

                @SerializedName("stargazers_count")
                var stargazersCount: Int = 0,

                @SerializedName("language")
                var language: String? = null,

                @SerializedName("forks_count")
                var forksCount: Int = 0,

                @SerializedName("pushed_at")
                var pushedAt: String? = null,

                @SerializedName("full_name")
                var fullName: String? = null,

                @SerializedName("archived")
                var archived: Boolean = false)