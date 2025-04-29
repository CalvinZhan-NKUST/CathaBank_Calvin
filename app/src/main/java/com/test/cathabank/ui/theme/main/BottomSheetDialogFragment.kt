package com.test.cathabank.ui.theme.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.test.cathabank.databinding.FragmentSortMenuBinding

class SortMenuBottomSheetFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentSortMenuBinding? = null
    private val binding get() = _binding!!

    private lateinit var onSortSelectedListener: (sortOrder: String) -> Unit

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSortMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 設定按鈕的點擊事件
        binding.textViewSortDescending.setOnClickListener {
            onSortSelectedListener("ascending")
            dismiss() // 關閉底部選單
        }

        binding.textViewSortAscending.setOnClickListener {
            onSortSelectedListener("descending")
            dismiss() // 關閉底部選單
        }
    }

    fun setOnSortSelectedListener(listener: (sortOrder: String) -> Unit) {
        onSortSelectedListener = listener
    }
}
