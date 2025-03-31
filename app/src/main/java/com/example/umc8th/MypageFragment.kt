package com.example.umc8th

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc8th.databinding.FragmentMypageBinding
import com.google.android.material.tabs.TabLayoutMediator

class MypageFragment : Fragment() {

    lateinit var binding: FragmentMypageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMypageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabTitles = listOf("저장한 곡", "음악파일")
        val adapter = MypagePagerAdapter(this)
        binding.mypageViewPager.adapter = adapter

        TabLayoutMediator(binding.mypageTabLayout, binding.mypageViewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }
}