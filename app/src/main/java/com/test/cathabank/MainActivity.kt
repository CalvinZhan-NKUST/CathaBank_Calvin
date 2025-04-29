package com.test.cathabank

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.cathabank.data.repository.ApiService
import com.test.cathabank.databinding.ActivityMainBinding
import com.test.cathabank.ui.theme.main.MainViewModel
import com.test.cathabank.ui.theme.main.MainViewModelFactory
import com.test.cathabank.ui.theme.main.SortMenuBottomSheetFragment
import com.test.cathabank.ui.theme.main.StockAdapter

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(ApiService())
    }
    private lateinit var menuButton: ImageButton
    private lateinit var stockInfoAdapter: StockAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        // 初始化 binding 和視圖
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        menuButton = findViewById(R.id.menuButton)
        recyclerView = findViewById(R.id.recyclerView)
        stockInfoAdapter = StockAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = stockInfoAdapter

        // 訂閱 ViewModel 資料，並在資料變更時更新 Adapter
        viewModel.getStockInfoList().observe(this) { stockInfoList ->
            stockInfoAdapter.submitList(stockInfoList)
        }

        // 設置按鈕的點擊事件
        menuButton.setOnClickListener { view ->
            // 顯示底部選單
            val sortMenuFragment = SortMenuBottomSheetFragment()
            sortMenuFragment.setOnSortSelectedListener { sortOrder ->
                sortStockData(sortOrder)
            }
            sortMenuFragment.show(supportFragmentManager, sortMenuFragment.tag)
            recyclerView.scrollToPosition(0)
        }
    }

    private fun sortStockData(sortOrder: String) {
        val sortedList = if (sortOrder == "ascending") {
            stockInfoAdapter.currentList.sortedBy { it.Code }
        } else {
            stockInfoAdapter.currentList.sortedByDescending { it.Code }
        }
        stockInfoAdapter.submitList(sortedList)
    }
}


