package com.demo.zapcom.data.repository

import android.util.Log
import com.demo.zapcom.data.api.ApiService
import com.demo.zapcom.data.model.Item
import com.demo.zapcom.utils.Utils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import javax.inject.Inject
import javax.inject.Singleton


class ItemRepository @Inject constructor(private val apiService: ApiService) {


    suspend fun getItems(): List<Item> {
        return if(Utils.IS_DUMMY)
            Gson().fromJson(Utils.DATA_DUMMY, object : TypeToken<ArrayList<Item>>() {}.type)
        else
            apiService.getItems()
    }
}