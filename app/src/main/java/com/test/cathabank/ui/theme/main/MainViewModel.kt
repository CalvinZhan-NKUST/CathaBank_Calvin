package com.test.cathabank.ui.theme.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.test.cathabank.data.model.StockInfo
import com.test.cathabank.data.repository.ApiService
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val apiService: ApiService) : ViewModel() {
    // 取得所有股票資料
    fun getStockInfoList() = liveData(Dispatchers.IO) {
        try {
            val bwibbuList = apiService.fetchBWIBBU()
            val stockDayList = apiService.fetchStockDay()
            val stockDayAvgList = apiService.fetchStockDayAvg()

            val stockInfoMap = mutableMapOf<String, StockInfo>()

            // Merge BWIBBU 資料
            bwibbuList.forEach { bwibbu ->
                stockInfoMap[bwibbu.Code] = StockInfo(
                    Code = bwibbu.Code,
                    Name = bwibbu.Name,
                    PE = bwibbu.PEratio,
                    DividendYield = bwibbu.DividendYield,
                    PB = bwibbu.PBratio
                    // 其他欄位將在後續合併
                )
            }

            // Merge StockDay 資料
            stockDayList.forEach { stockDay ->
                val stockInfo = stockInfoMap[stockDay.Code]
                if (stockInfo != null) {
                    stockInfoMap[stockDay.Code] = stockInfo.copy(
                        OpenPrice = stockDay.OpeningPrice,
                        ClosePrice = stockDay.ClosingPrice,
                        HighPrice = stockDay.HighestPrice,
                        LowPrice = stockDay.LowestPrice,
                        PriceDifference = stockDay.Change,
                        TransactionCount = stockDay.Transaction,
                        TransactionVolume = stockDay.TradeVolume,
                        TradeValue = stockDay.TradeValue
                    )
                }
            }

            // Merge StockDayAvg 資料
            stockDayAvgList.forEach { stockDayAvg ->
                val stockInfo = stockInfoMap[stockDayAvg.Code]
                if (stockInfo != null) {
                    stockInfoMap[stockDayAvg.Code] = stockInfo.copy(
                        MonthlyAveragePrice = stockDayAvg.MonthlyAveragePrice
                    )
                }
            }

            // 送出合併後的資料
            emit(stockInfoMap.values.toList())
        } catch (e: Exception) {
            emit(emptyList<StockInfo>())
        }
    }
}
