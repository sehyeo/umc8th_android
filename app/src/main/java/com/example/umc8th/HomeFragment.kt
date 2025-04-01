package com.example.umc8th

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.umc8th.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

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
    }

}