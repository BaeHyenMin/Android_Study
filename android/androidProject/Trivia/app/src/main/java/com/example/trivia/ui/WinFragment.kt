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
import com.example.trivia.databinding.FragmentWinBinding

class WinFragment : Fragment() {

    private var _binding: FragmentWinBinding?=null;
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWinBinding.inflate(inflater, container, false)
        return binding.root;
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.avatarText.observe(viewLifecycleOwner){
            binding.textViewWin.text = "$it"
        }
        binding.buttonReplay.setOnClickListener {
            findNavController().navigate(R.id.action_winFragment_to_avatarFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}