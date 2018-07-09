package com.mario.github.mvp.data.network

import com.google.gson.annotations.SerializedName

data class RepoResponse(@SerializedName("incomplete_results")
                        private var incompleteResults: Boolean? = false,

                        @SerializedName("items")
                        var repos: List<Repo>? = null,

                        @SerializedName("total_count")
                        private var totalCount: Int? = 0
)