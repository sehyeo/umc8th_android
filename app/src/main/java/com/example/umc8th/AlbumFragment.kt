package com.example.umc8th

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.umc8th.databinding.FragmentAlbumBinding

class AlbumFragment : Fragment() {

    lateinit var binding: FragmentAlbumBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val albumTitle = arguments?.getString("albumTitle") ?: "알 수 없음"

        binding.root.findViewById<TextView>(R.id.albumTitleTextView)?.text = albumTitle

        binding.btnArrowLeft.setOnClickListener {
            findNavController().navigate(R.id.action_albumFragment_to_navigation_home)
        }

        binding.switchMix.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.albumImage.setImageResource(R.drawable.woodz_album_mix)
            } else {
                binding.albumImage.setImageResource(R.drawable.woodz_album)
            }
        }
    }

}