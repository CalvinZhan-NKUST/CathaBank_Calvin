package com.test.cathabank.ui.theme.main

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.cathabank.R
import com.test.cathabank.data.model.StockInfo

class StockAdapter : ListAdapter<StockInfo, StockAdapter.StockViewHolder>(StockDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockViewHolder {
        val binding = LayoutInflater.from(parent.context).inflate(R.layout.stock_layout, parent, false)
        return StockViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StockViewHolder, position: Int) {
        val stockInfo = getItem(position)
        holder.bind(stockInfo)
    }

    class StockViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val tvStockCode: TextView = view.findViewById(R.id.tvStockCode)
        private val tvStockName: TextView = view.findViewById(R.id.tvStockName)
        private val tvOpenPrice: TextView = view.findViewById(R.id.tvOpenPrice)
        private val tvClosePrice: TextView = view.findViewById(R.id.tvClosePrice)
        private val tvHighPrice: TextView = view.findViewById(R.id.tvHighPrice)
        private val tvLowPrice: TextView = view.findViewById(R.id.tvLowPrice)
        private val tvPriceDifference: TextView = view.findViewById(R.id.tvPriceDifference)
        private val tvMonthlyAverage: TextView = view.findViewById(R.id.tvMonthlyAverage)
        private val tvTransactionCount: TextView = view.findViewById(R.id.tvTransactionCount)
        private val tvTransactionVolume: TextView = view.findViewById(R.id.tvTransactionVolume)
        private val tvTradeValue: TextView = view.findViewById(R.id.tvTradeValue)

        fun bind(stockInfo: StockInfo) {
            tvStockCode.text = stockInfo.Code
            tvStockName.text = stockInfo.Name
            tvOpenPrice.text = stockInfo.OpenPrice
            tvClosePrice.text = stockInfo.ClosePrice
            tvHighPrice.text = stockInfo.HighPrice
            tvLowPrice.text = stockInfo.LowPrice
            tvPriceDifference.text = stockInfo.PriceDifference
            tvMonthlyAverage.text = stockInfo.MonthlyAveragePrice
            tvTransactionCount.text = stockInfo.TransactionCount
            tvTransactionVolume.text = stockInfo.TransactionVolume
            tvTradeValue.text = stockInfo.TradeValue

            // 根據收盤價與月平均價變更顏色
            if (stockInfo.ClosePrice.toDoubleOrNull() ?: 0.0 > stockInfo.MonthlyAveragePrice.toDoubleOrNull() ?: 0.0) {
                tvClosePrice.setTextColor(view.context.getColor(R.color.red))  // 紅色
            } else {
                tvClosePrice.setTextColor(view.context.getColor(R.color.green))  // 綠色
            }

            // 根據漲跌價差變更顏色
            if (stockInfo.PriceDifference.toDoubleOrNull() ?: 0.0 > 0) {
                tvPriceDifference.setTextColor(view.context.getColor(R.color.red))  // 紅色
            } else {
                tvPriceDifference.setTextColor(view.context.getColor(R.color.green))  // 綠色
            }

            view.setOnClickListener {
                // 顯示 AlertDialog 顯示股市資訊
                val alertDialog = AlertDialog.Builder(view.context, R.style.CathayAlertDialog) // 使用自定義樣式
                    .setTitle("股票資訊: ${stockInfo.Name}")
                    .setMessage("""
                        本益比: ${stockInfo.PE}
                        殖利率: ${stockInfo.DividendYield}%
                        股價淨值比: ${stockInfo.PB}
                    """.trimIndent())
                    .setPositiveButton("確定") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .create()
                alertDialog.show()
            }
        }
    }

    class StockDiffCallback : DiffUtil.ItemCallback<StockInfo>() {
        override fun areItemsTheSame(oldItem: StockInfo, newItem: StockInfo): Boolean {
            return oldItem.Code == newItem.Code
        }

        override fun areContentsTheSame(oldItem: StockInfo, newItem: StockInfo): Boolean {
            return oldItem == newItem
        }
    }
}
