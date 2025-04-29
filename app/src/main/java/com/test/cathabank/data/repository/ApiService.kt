package com.test.cathabank.data.repository

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.test.cathabank.data.ApiConstants
import com.test.cathabank.data.model.BWIBBU
import com.test.cathabank.data.model.StockDay
import com.test.cathabank.data.model.StockDayAvg
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

class ApiService {

    private val client = OkHttpClient()
    private val gson = Gson()
    private val TAG = "ApiService"

    suspend fun fetchBWIBBU(): List<BWIBBU> = withContext(Dispatchers.IO) {
        val url = "${ApiConstants.BASE_URL}${ApiConstants.BWIBBU_ALL}"
        Log.d(TAG, "Fetching BWIBBU from: $url")

        val request = Request.Builder().url(url).build()
        val response = client.newCall(request).execute()
        val body = response.body?.string() ?: ""

        return@withContext try {
            val type = object : TypeToken<List<BWIBBU>>() {}.type
            val data: List<BWIBBU> = gson.fromJson(body, type)
            Log.d(TAG, "BWIBBU parsed successfully, size: ${data.size}")
            data
        } catch (e: Exception) {
            Log.e(TAG, "Failed to parse BWIBBU response", e)
            emptyList()
        }
    }

    suspend fun fetchStockDayAvg(): List<StockDayAvg> = withContext(Dispatchers.IO) {
        val url = "${ApiConstants.BASE_URL}${ApiConstants.STOCK_DAY_AVG_ALL}"
        Log.d(TAG, "Fetching StockDayAvg from: $url")

        val request = Request.Builder().url(url).build()
        val response = client.newCall(request).execute()
        val body = response.body?.string() ?: ""

        return@withContext try {
            val type = object : TypeToken<List<StockDayAvg>>() {}.type
            val data: List<StockDayAvg> = gson.fromJson(body, type)
            Log.d(TAG, "StockDayAvg parsed successfully, size: ${data.size}")
            data
        } catch (e: Exception) {
            Log.e(TAG, "Failed to parse StockDayAvg response", e)
            emptyList()
        }
    }

    suspend fun fetchStockDay(): List<StockDay> = withContext(Dispatchers.IO) {
        val url = "${ApiConstants.BASE_URL}${ApiConstants.STOCK_DAY_ALL}"
        Log.d(TAG, "Fetching StockDay from: $url")

        val request = Request.Builder().url(url).build()
        val response = client.newCall(request).execute()
        val body = response.body?.string() ?: ""

        return@withContext try {
            val type = object : TypeToken<List<StockDay>>() {}.type
            val data: List<StockDay> = gson.fromJson(body, type)
            Log.d(TAG, "StockDay parsed successfully, size: ${data.size}")
            data
        } catch (e: Exception) {
            Log.e(TAG, "Failed to parse StockDay response", e)
            emptyList()
        }
    }
}
