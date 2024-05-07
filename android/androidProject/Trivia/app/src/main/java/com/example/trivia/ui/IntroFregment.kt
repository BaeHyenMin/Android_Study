package com.example.trivia.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.trivia.R
import com.example.trivia.databinding.FragmentIntroFregmentBinding

class IntroFregment : Fragment() {

    private var _binding: FragmentIntroFregmentBinding?=null;
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentIntroFregmentBinding.inflate(inflater, container, false)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonStart.setOnClickListener {
            findNavController().navigate(R.id.action_introFregment_to_avatarFragment)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}