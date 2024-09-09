package com.demo.zapcom.data.api

import com.demo.zapcom.data.model.Item
import retrofit2.http.GET

public interface ApiService {
    @GET("/b/5BEJ")
    suspend fun getItems(): List<Item>
}
