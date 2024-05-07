package com.example.trivia.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.trivia.MainViewModel
import androidx.navigation.fragment.findNavController
import com.example.trivia.R
import com.example.trivia.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {

    private var _binding: FragmentQuestionBinding?=null;
    private val binding get() = _binding!!


    private val viewModel: MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestionBinding.inflate(inflater, container, false)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.avatarDrawable.observe(viewLifecycleOwner){
            binding.imageViewAvatar.setImageResource(it)
        }



        binding.buttonOne.setOnClickListener {
            findNavController().navigate(R.id.action_questionFragment_to_loseFragment)
        }
        binding.buttonTwo.setOnClickListener {
            findNavController().navigate(R.id.action_questionFragment_to_winFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}