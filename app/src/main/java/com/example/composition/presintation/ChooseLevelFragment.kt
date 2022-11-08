package com.example.composition.presintation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.composition.R
import com.example.composition.databinding.FragmentCooseLevelBinding
import com.example.composition.domain.entity.Level


class ChooseLevelFragment : Fragment() {

    private var _binding: FragmentCooseLevelBinding? = null
    private val binding: FragmentCooseLevelBinding
        get() = _binding ?: throw RuntimeException("FragmentCooseLevelBinding equals null")


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCooseLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initButtons()
    }

    private fun initButtons() {
        with(binding) {
            buttonLevelTest.setOnClickListener {
                startFragment(Level.TEST)
            }
            buttonLevelEsy.setOnClickListener {
                startFragment(Level.EASY)
            }
            buttonLevelNormal.setOnClickListener {
                startFragment(Level.NORMAL)
            }
            buttonLevelHard.setOnClickListener {
                startFragment(Level.HARD)
            }
        }
    }

    private fun startFragment(level: Level) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, GameFragment.newInstance(level))
            .addToBackStack(GameFragment.NAME)
            .commitAllowingStateLoss()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val NAME = "ChooseLevelFragment"

        fun newInstance(): ChooseLevelFragment {
            return ChooseLevelFragment()
        }
    }
}