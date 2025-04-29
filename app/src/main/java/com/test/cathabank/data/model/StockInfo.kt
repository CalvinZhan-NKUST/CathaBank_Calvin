package com.test.cathabank.data.model

data class StockInfo(
    val Code: String,
    val Name: String,
    val OpenPrice: String = "",
    val ClosePrice: String = "",
    val HighPrice: String = "",
    val LowPrice: String = "",
    val PriceDifference: String = "",
    val MonthlyAveragePrice: String = "",
    val TransactionCount: String = "",
    val TransactionVolume: String = "",
    val TradeValue: String = "",
    val PE: String = "",
    val DividendYield: String = "",
    val PB: String = ""
)