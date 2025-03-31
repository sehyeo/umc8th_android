package com.example.umc8th

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.umc8th.databinding.FragmentTracklistBinding

class TrackListFragment : Fragment() {

    private var _binding: FragmentTracklistBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTracklistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.switchMix.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.albumImage.setImageResource(R.drawable.woodz_album_mix)
            } else {
                binding.albumImage.setImageResource(R.drawable.woodz_album)
            }
        }
    }
}
