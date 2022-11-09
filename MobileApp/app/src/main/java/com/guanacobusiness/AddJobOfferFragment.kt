package com.guanacobusiness

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.guanacobusiness.databinding.FragmentAddJobOfferBinding
import com.guanacobusiness.getsetdata.GetSetJob

class AddJobOfferFragment : Fragment() {
    private lateinit var binding: FragmentAddJobOfferBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_job_offer, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.AddJobContinueButton.setOnClickListener {
            goToSecondPart()
        }

        binding.topAppBarAddJob.setOnClickListener{
            goBack()
        }

    }

    private fun goBack() {
        val navController = NavHostFragment.findNavController(this)
        navController.popBackStack()
    }

    private fun goToSecondPart() {

        setInfo()

        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_addJobOfferFragment_to_addJobOfferSecondFragment)
    }

    private fun setInfo() {
        GetSetJob.setJobImage(binding.jobImageAddJobEditText.text.toString())
        GetSetJob.setjobTitle(binding.jobTitleAddJobEditText.text.toString())
        GetSetJob.setjobDescription(binding.jobDescAddJobEditText.text.toString())
        GetSetJob.setjobSchedule(binding.jobsScheduleAddJobEditText.text.toString())
        GetSetJob.setsalary(binding.jobSalaryAddJobEditText.text.toString())
    }

}