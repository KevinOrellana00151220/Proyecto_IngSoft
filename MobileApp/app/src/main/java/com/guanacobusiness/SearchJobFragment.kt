package com.guanacobusiness

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.guanacobusiness.databinding.FragmentSearchJobBinding
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.guanacobusiness.adapter.JobAdapter
import com.guanacobusiness.model.job
import com.guanacobusiness.network.job.JobService
import com.guanacobusiness.network.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class SearchJobFragment : Fragment() {
    private lateinit var binding: FragmentSearchJobBinding
    private lateinit var adapter: JobAdapter
    private val allJobs = mutableListOf<job>()
    private val jobByFilter = mutableListOf<job>()
    private lateinit var bottomNav : BottomNavigationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.  fragment_search_job, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getAllJobs()
        initRecyclerView()
        //Selected the search button in bottom nav bar
        binding.bottomNavigation.selectedItemId = R.id.searchPage

        binding.searchJob.setOnQueryTextListener(object: androidx.appcompat.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(p0: String?): Boolean {
                filtersRecyclerView(p0!!.lowercase(Locale.getDefault()))

                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return true
            }

        })

        bottomNav = binding.bottomNavigation
        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.homePage -> {
                    Toast.makeText(binding.root.context, "Home Page", Toast.LENGTH_SHORT).show()
                    goToHomePage()
                    true
                }
                R.id.searchPage-> {
                    Toast.makeText(binding.root.context, "Search Page", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.profilePage -> {
                    Toast.makeText(binding.root.context, "Profile Page", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }

        }
        //SetOnClickListener for salary filter chip
        binding.salaryChip.setOnClickListener {
            binding.workTypeChip.isChecked = false
            binding.locationChip.isChecked = false
            binding.salaryChip.isChecked = true
                Toast.makeText(binding.root.context, "Salary", Toast.LENGTH_SHORT).show()
                searchSalaryDialog()
        }

        //SetOnClickListener for location filter chip
        binding.locationChip.setOnClickListener {
            binding.workTypeChip.isChecked = false
            binding.salaryChip.isChecked = false
            binding.locationChip.isChecked = true
                    Toast.makeText(binding.root.context, "Location", Toast.LENGTH_SHORT).show()
                    searchLocationDialog()
        }

        //SetOnClickListener for work type filter chip
        binding.workTypeChip.setOnClickListener {
            binding.salaryChip.isChecked = false
            binding.locationChip.isChecked = false
            binding.workTypeChip.isChecked = true
                Toast.makeText(binding.root.context, "Work Type", Toast.LENGTH_SHORT).show()
                searchWorkTypeDialog()
        }

    }

    private fun salaryRecyclerView(salary: String) {
        jobByFilter.clear()
        for (job in allJobs) {
            if (salary == getString(R.string.low_salary)) {
                if (job.salary.toInt() <= 500) {
                    jobByFilter.add(job)
                }
            } else if (salary == getString(R.string.medium_salary)) {
                if (job.salary.toInt() in 501..750) {
                    jobByFilter.add(job)
                }
            } else if (salary == getString(R.string.high_salary)) {
                if (job.salary.toInt() > 750) {
                    jobByFilter.add(job)
                }
            }
        }
        adapter = JobAdapter(jobByFilter)
        binding.rvJobs.layoutManager = LinearLayoutManager(binding.root.context)
        binding.rvJobs.adapter = adapter
    }
    private fun filtersRecyclerView(string: String) {
        jobByFilter.clear()
        allJobs.forEach(
            {
                if (it.department.toString().lowercase(Locale.getDefault()).contains(string.lowercase(
                        Locale.getDefault()
                    ))
                    || it.worktype.toString().lowercase(Locale.getDefault()).contains(string.lowercase(
                        Locale.getDefault()
                    )) ||
                        it.title.lowercase(Locale.getDefault()).contains(string.lowercase(Locale.getDefault()))
                        || it.description.lowercase(Locale.getDefault()).contains(string.lowercase(
                        Locale.getDefault()
                    ))) {
                    jobByFilter.add(it)
                }
            }
        )
        adapter = JobAdapter(jobByFilter)
        binding.rvJobs.layoutManager = LinearLayoutManager(binding.root.context)
        binding.rvJobs.adapter = adapter
    }


    private fun searchLocationDialog() {
        val singleItems = (resources.getStringArray(R.array.locations))
        val checkedItem = 1
        MaterialAlertDialogBuilder(binding.root.context)
            .setTitle(resources.getString(R.string.salary))
            // Single-choice items (initialized with checked item)
            .setNegativeButton(resources.getString(R.string.cancel)) { dialog, which ->
                // Respond to item chosen
                binding.locationChip.isChecked = false
                dialog.cancel()
            }
            .setSingleChoiceItems(singleItems, checkedItem) { dialog, which ->
                val selected = singleItems[which]
                filtersRecyclerView(selected)
                dialog.dismiss()
            }
            .show()

    }

    private fun searchSalaryDialog() {
        val singleItems = arrayOf("Salario Bajo", "Salario Medio", "Salario Alto")
        val checkedItem = 1
        MaterialAlertDialogBuilder(binding.root.context)
            .setTitle(resources.getString(R.string.salary))
            .setNegativeButton(resources.getString(R.string.cancel)) { dialog, which ->
                // Respond to item chosen
                binding.salaryChip.isChecked = false
                dialog.dismiss()
            }
            // Single-choice items (initialized with checked item)
            .setSingleChoiceItems(singleItems, checkedItem) { dialog, which ->
                val selected = singleItems[which]
                salaryRecyclerView(selected)
                dialog.dismiss()
            }
            .show()
    }

    private fun searchWorkTypeDialog() {
        val singleItems = (resources.getStringArray(R.array.professions))
        val checkedItem = 1
        MaterialAlertDialogBuilder(binding.root.context)
            .setTitle(resources.getString(R.string.work_type))
            .setNegativeButton(resources.getString(R.string.cancel)) { dialog, which ->
                // Respond to item chosen
                binding.workTypeChip.isChecked = false
                dialog.dismiss()
            }
            // Single-choice items (initialized with checked item)
            .setSingleChoiceItems(singleItems, checkedItem) { dialog, which ->
                val selected = singleItems[which]
                filtersRecyclerView(selected)
                dialog.dismiss()
            }
            .show()
    }

    private fun initRecyclerView() {
        adapter = JobAdapter(allJobs)
    }

    private fun getAllJobs(){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitInstance.retrofit.create(JobService::class.java).getJobs()
            val jobs = call.body()
            Log.d("jobs", jobs.toString())
            activity?.runOnUiThread {
                if(call.isSuccessful){
                    val job = jobs?.jobs ?: emptyList()
                    allJobs.clear()
                    allJobs.addAll(job)
                    adapter.notifyDataSetChanged()
                }
                else{
                    showError()
                }
            }
        }
    }


    private fun showError(){
        //show error
        Toast.makeText(binding.root.context, "Error", Toast.LENGTH_SHORT).show()
    }

    private fun goToHomePage(){
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_searchJobFragment_to_homeFragment)
    }


}