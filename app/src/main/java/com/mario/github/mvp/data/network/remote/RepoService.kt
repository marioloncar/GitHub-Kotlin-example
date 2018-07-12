package com.mario.github.mvp.data.network.remote

import com.mario.github.mvp.data.network.ApiHelper
import com.mario.github.mvp.data.network.model.RepoResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

class RepoService {
    private val repoApi = ApiHelper.createService(RepoApi::class.java)

    fun searchRepositories(keyword: String, sortType: String?): Observable<RepoResponse> = repoApi.searchRepositories(keyword, sortType)

    interface RepoApi {
        @GET("search/repositories")
        fun searchRepositories(@Query("q") keyword: String,
                               @Query("sort") sortType: String?): Observable<RepoResponse>
    }
}