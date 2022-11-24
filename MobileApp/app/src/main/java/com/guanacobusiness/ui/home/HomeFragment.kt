package com.guanacobusiness.ui.Home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.guanacobusiness.R
import com.guanacobusiness.adapter.JobAdapter
import com.guanacobusiness.databinding.FragmentHomeBinding
import com.guanacobusiness.dto.Login.RetrofitInstanceLogin
import com.guanacobusiness.getsetdata.GetSetUser
import com.guanacobusiness.model.job
import com.guanacobusiness.model.user
import com.guanacobusiness.model.worktype
import com.guanacobusiness.network.job.JobService
import com.guanacobusiness.network.RetrofitInstance
import com.guanacobusiness.network.department.DepartmentCall
import com.guanacobusiness.network.user.UserCall
import com.guanacobusiness.network.user.UserRequest
import com.guanacobusiness.network.worktype.WorktypeCall
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: JobAdapter
    private lateinit var bottomNav : BottomNavigationView
    private lateinit var mainMenu : NavigationView
    private lateinit var navDrawer: DrawerLayout
    private val jobInfo = mutableListOf<job>()
    private lateinit var worktypeinfo: List<worktype>
    private lateinit var userinfo: List<UserRequest>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        binding = DataBindingUtil.inflate(inflater, R.layout.  fragment_home, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getAllJobs()
        initRecyclerView()
        mainMenu = binding.navView
        navDrawer = binding.drawerLayout
        binding.include.mainMenu.setOnClickListener { navDrawer.open() }
        binding.logOut.setOnClickListener {
            val navController = NavHostFragment.findNavController(this)
            navController.navigate(R.id.action_homeFragment_to_loginActivity)

        }
        bottomNav = binding.bottomNavigation

        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.homePage -> {
                    Toast.makeText(binding.root.context, "Home Page", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.searchPage-> {
                    Toast.makeText(binding.root.context, "Search Page", Toast.LENGTH_SHORT).show()
                    goToSearchPage()
                    true
                }
                R.id.profilePage -> {
                    Toast.makeText(binding.root.context, "Profile Page", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }

        }

        mainMenu.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.allOffers -> {
                    true
                }
                R.id.aplicatedOffers -> {
                    true
                }
                R.id.CV -> {
                    goToCVPage()
                    true
                }
                R.id.myOffers -> {
                    true
                }
                else -> false
            }
        }

        binding.addJobActionButton.setOnClickListener(){
            goToAddJobPage()
        }

    }

    private fun initRecyclerView() {
        adapter = JobAdapter(jobInfo)
        binding.rvJobs.layoutManager = LinearLayoutManager(binding.root.context)
        binding.rvJobs.adapter = adapter
    }

    private fun InflateTopbar() {
        CoroutineScope(Dispatchers.Main).async {

            userinfo.forEach() { item ->
                if (item.email == RetrofitInstanceLogin.getUser()) {
                    Picasso.get().load(item.imgurl).into(binding.include.userpfp)
                    binding.include.userNameBarApp.text = item.username
                }
            }
        }
    }


    private fun getAllJobs(){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitInstance.retrofit.create(JobService::class.java).getJobs()
            userinfo = UserCall.getAllUser()!!
            val jobs = call.body()
            Log.d("jobs", jobs.toString())
            activity?.runOnUiThread {
                if(call.isSuccessful) {
                    InflateTopbar()
                    val job = jobs?.jobs ?: emptyList()
                    jobInfo.clear()
                    jobInfo.addAll(job)
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

    private fun goToAddJobPage() {
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_homeFragment_to_addJobOfferFragment)
    }

    private fun goToSearchPage(){
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_homeFragment_to_searchJobFragment)
    }

    private fun goToCVPage(){
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_homeFragment_to_curriculumFragment)
    }
}