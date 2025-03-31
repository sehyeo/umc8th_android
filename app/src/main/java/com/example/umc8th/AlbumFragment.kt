package com.example.umc8th

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.umc8th.databinding.FragmentAlbumBinding
import com.google.android.material.tabs.TabLayoutMediator
import androidx.lifecycle.ViewModelProvider


class AlbumFragment : Fragment() {

    lateinit var binding: FragmentAlbumBinding
    private lateinit var viewModel: AlbumViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAlbumBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = activity?.let {
            ViewModelProvider(it)[AlbumViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        viewModel.isMixOn.observe(viewLifecycleOwner) { isMix ->
            if (isMix) {
                binding.albumImage.setImageResource(R.drawable.woodz_album_mix)
            } else {
                binding.albumImage.setImageResource(R.drawable.woodz_album)
            }
        }

        val albumTitle = arguments?.getString("albumTitle") ?: "알 수 없음"
        binding.albumTitleTextView.text = albumTitle

        binding.btnArrowLeft.setOnClickListener {
            findNavController().navigate(R.id.action_albumFragment_to_navigation_home)
        }

        val pagerAdapter = AlbumPagerAdapter(this)
        binding.albumViewPager.adapter = pagerAdapter

        TabLayoutMediator(binding.albumTabLayout, binding.albumViewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "수록곡"
                1 -> "상세정보"
                2 -> "영상"
                else -> ""
            }
        }.attach()
    }
}
