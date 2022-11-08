package com.example.composition.presintation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.composition.R
import com.example.composition.databinding.FragmentWelcomBinding

class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomBinding? = null
    private val binding: FragmentWelcomBinding
        get() = _binding ?: throw RuntimeException("FragmentWelcomBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonAnderstend.setOnClickListener {
            startFragment()
        }
    }

    private fun startFragment() {
        findNavController().navigate(R.id.action_welcomeFragment_to_chooseLevelFragment)
    }
}