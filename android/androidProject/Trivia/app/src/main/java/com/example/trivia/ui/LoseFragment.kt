package com.example.trivia.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.trivia.R
import com.example.trivia.databinding.FragmentLoseBinding

class LoseFragment : Fragment() {

    private var _binding: FragmentLoseBinding?=null;
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoseBinding.inflate(inflater, container, false)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonReplay.setOnClickListener {
            findNavController().navigate(R.id.action_loseFragment_to_avatarFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}