package com.myapps.saple_game_api

import retrofit2.http.GET

interface ApiInterface {
    @GET("latestnews")
    fun getApiData():retrofit2.Call<game_data>

}