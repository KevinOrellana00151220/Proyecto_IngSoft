package com.guanacobusiness

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.guanacobusiness.databinding.FragmentAddCurriculumBinding

class AddCurriculumFragment : Fragment() {
    private lateinit var binding: FragmentAddCurriculumBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_curriculum, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.exitBtn.setOnClickListener{
            goBack()
        }

        binding.AddCV.setOnClickListener{
            goToHome()
        }

    }

    private fun goBack() {
        val navController = NavHostFragment.findNavController(this)
        navController.popBackStack()
    }

    private fun goToHome() {
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_addCurriculumFragment_to_curriculumFragment)
    }
}