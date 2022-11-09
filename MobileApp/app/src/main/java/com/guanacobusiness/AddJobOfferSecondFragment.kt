package com.guanacobusiness

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.guanacobusiness.databinding.FragmentAddJobOfferSecondBinding
import com.guanacobusiness.dto.Login.RetrofitInstanceLogin
import com.guanacobusiness.getsetdata.GetSetJob
import com.guanacobusiness.getsetdata.GetSetUser
import com.guanacobusiness.model.department
import com.guanacobusiness.model.user
import com.guanacobusiness.model.worktype
import com.guanacobusiness.network.RetrofitInstance
import com.guanacobusiness.network.department.DepartmentCall
import com.guanacobusiness.network.job.JobRequest
import com.guanacobusiness.network.job.JobService
import com.guanacobusiness.network.user.UserCall
import com.guanacobusiness.network.user.UserRequest
import com.guanacobusiness.network.worktype.WorktypeCall
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddJobOfferSecondFragment : Fragment() {
    private lateinit var binding: FragmentAddJobOfferSecondBinding
    private lateinit var worktypeinfo: List<worktype>
    private lateinit var departmentinfo: List<department>
    private lateinit var userinfo: List<UserRequest>



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_job_offer_second, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getAllDepartments()
        getAllWorksTypes()
        getAllUsers()
        binding.topAppBarAddJob2.setOnClickListener {
            goBack()
        }

        binding.AddJobFinishButton.setOnClickListener{
            val departmentId = getDepartmentId()
            val worktypeId = getWorktypeId()
            val userId = getUserId()
            postJob(departmentId, worktypeId, userId)
            goToHome()
        }

    }

    private fun goBack() {
        val navController = NavHostFragment.findNavController(this)
        navController.popBackStack()
    }

    private fun goToHome() {
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.homeFragment)
    }


    private fun getAllWorksTypes() {
        CoroutineScope(Dispatchers.IO).launch {
            worktypeinfo = WorktypeCall.getAllWorktypes()!!
        }
    }

    private fun getAllDepartments() {
        CoroutineScope(Dispatchers.IO).launch {
            departmentinfo = DepartmentCall.getAllDeparment()!!
        }
    }


    private fun getAllUsers() {
        CoroutineScope(Dispatchers.IO).launch {
            userinfo = UserCall.getAllUser()!!
        }
    }
    private fun getWorktypeId() : String{
        var worktypeid = ""
        val worktype = binding.ProfessionDropdownContainer.editText?.text.toString()
        worktypeinfo?.forEach() { item ->
            if (item.worktype.contains(worktype)) {
                worktypeid = item.id
            }
        }
        return worktypeid
    }

    private fun getDepartmentId() : String{
        var departmentid = ""
        val department = binding.DepartmentDropdownContainer.editText?.text.toString()
        departmentinfo?.forEach() { item ->
            if (item.department.contains(department)) {
                departmentid = item.id
            }
        }
        return departmentid
    }

    private fun getUserId() : String{
        var userid = ""
        val user = RetrofitInstanceLogin.getUser()!!
        userinfo?.forEach() { item ->
            if (item.email.contains(user)) {
                userid = item.id
            }
        }
        return userid
    }

    private fun postJob(departmentid: String, worktypeid: String, userid: String) {
        val title = GetSetJob.getjobTitle()
        val description = GetSetJob.getjobDescription()
        val schedule = GetSetJob.getjobSchedule()
        val salary = GetSetJob.getsalary()
        var company = binding.jobCompanyAddJobEditText.text.toString()
        var requisites = binding.jobRequisitesAddJobEditText.text.toString()
        CoroutineScope(Dispatchers.IO).launch {

            val call = RetrofitInstance.retrofit.create(JobService::class.java).postJob(
                JobRequest(
                    "$title",
                    "https://png.pngtree.com/element_our/20190602/ourlarge/pngtree-brown-office-briefcase-image_1422563.jpg",
                    "$description",
                    "$schedule",
                    salary.toFloat(),
                    "$worktypeid",
                    "$departmentid",
                    "$company",
                    "$userid",
                    "$requisites"
                )
            )
            var response = call.body()
            activity?.runOnUiThread() {
                if (call.isSuccessful) {

                    Log.d("Mensaje:", "Se publico el trabajo")
                } else {
                    Log.d("error", "nose mano")
                }
            }

        }
    }

}