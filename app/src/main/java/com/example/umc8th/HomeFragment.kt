package com.example.umc8th

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.umc8th.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private lateinit var slideHandler: Handler
    private lateinit var slideRunnable: Runnable

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 기존 앨범 클릭 이동
        binding.homeAlbum.setOnClickListener {
            val bundle = Bundle().apply {
                putString("albumTitle", "WOODZ 5th Mini Album [OO-LI]")
            }
            findNavController().navigate(R.id.albumFragment, bundle)
        }

        // 패널 데이터
        val panels = listOf(
            PanelData("포근하게 덮어주는 꿈의\n목소리", R.drawable.bg_mint),
            PanelData("기분 좋은 바람이\n부는 여행지에서", R.drawable.bg_skyblue)
        )

        val panelAdapter = PanelAdapter(panels)
        binding.homePanelViewPager.adapter = panelAdapter

        binding.homePanelIndicator.setViewPager(binding.homePanelViewPager)

        val bannerImages = listOf(
            R.drawable.img_home_viewpager_exp,
            R.drawable.img_home_viewpager_exp2
        )
        val bannerAdapter = BannerAdapter(bannerImages)
        binding.bannerViewPager.adapter = bannerAdapter

        slideHandler = Handler(Looper.getMainLooper())
        slideRunnable = object : Runnable {
            override fun run() {
                val currentItem = binding.homePanelViewPager.currentItem
                val itemCount = panelAdapter.itemCount
                val nextItem = if (currentItem == itemCount - 1) 0 else currentItem + 1
                binding.homePanelViewPager.setCurrentItem(nextItem, true)
                slideHandler.postDelayed(this, 3000) // 3초마다 반복
            }
        }
        slideHandler.postDelayed(slideRunnable, 3000)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        slideHandler.removeCallbacks(slideRunnable)
    }

}