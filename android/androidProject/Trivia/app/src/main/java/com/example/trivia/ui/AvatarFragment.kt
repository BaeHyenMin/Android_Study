package com.example.trivia.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.trivia.MainViewModel
import com.example.trivia.R
import com.example.trivia.databinding.FragmentAvatarBinding

class AvatarFragment : Fragment() {

    private var _binding:FragmentAvatarBinding?=null;
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()
    private val imageId = mapOf(
        R.id.buttonM1 to R.drawable.m1,
        R.id.buttonM2 to R.drawable.m2,
        R.id.buttonM3 to R.drawable.m3,
        R.id.buttonW1 to R.drawable.m4,
        R.id.buttonW2 to R.drawable.m5,
        R.id.buttonW3 to R.drawable.m6
    )

    private fun onAvatarImage(v:View){
        viewModel.avatarDrawable.value=imageId[v.id]
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAvatarBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonM1.setOnClickListener(::onAvatarImage)
        binding.buttonM2.setOnClickListener(::onAvatarImage)
        binding.buttonM3.setOnClickListener(::onAvatarImage)
        binding.buttonW1.setOnClickListener(::onAvatarImage)
        binding.buttonW2.setOnClickListener(::onAvatarImage)
        binding.buttonW3.setOnClickListener(::onAvatarImage)

        binding.buttonNext.setOnClickListener {
            if(binding.editTextText.text.isNotEmpty()){
                viewModel.avatarText.value = binding.editTextText.text.toString()
            }
            findNavController().navigate(R.id.action_avatarFragment_to_questionFragment)
        }



    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}