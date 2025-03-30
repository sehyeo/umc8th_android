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

        binding.homeAlbum.setOnClickListener {
            val bundle = Bundle().apply {
                putString("albumTitle", "WOODZ 5th Mini Album [OO-LI]")
            }
            findNavController().navigate(R.id.albumFragment, bundle)
        }
        val bannerImages = listOf(
            R.drawable.img_home_viewpager_exp,
            R.drawable.img_home_viewpager_exp2
        )

        val adapter = BannerAdapter(bannerImages)
        binding.bannerViewPager.adapter = adapter
    }
}