package com.mario.github.mvp.data.network.remote

import com.mario.github.mvp.data.network.ApiHelper
import com.mario.github.mvp.data.network.model.RepoResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

class RepoService {
    private val repoApi = ApiHelper.createService(RepoApi::class.java)

    // TODO 11/07/18 Sort type will later be changed
    fun searchRepositories(keyword: String): Observable<RepoResponse> = repoApi.searchRepositories(keyword, "best match")

    interface RepoApi {
        @GET("search/repositories")
        fun searchRepositories(@Query("q") keyword: String,
                               @Query("sort") sortType: String?): Observable<RepoResponse>
    }
}