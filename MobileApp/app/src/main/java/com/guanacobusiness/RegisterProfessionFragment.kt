package com.guanacobusiness//package com.guanacobusiness

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.guanacobusiness.databinding.FragmentRegisterProfessionBinding
import com.guanacobusiness.getsetdata.GetSetJob
import com.guanacobusiness.getsetdata.GetSetUser
import com.guanacobusiness.model.user
import com.guanacobusiness.model.worktype
import com.guanacobusiness.network.RetrofitInstance
import com.guanacobusiness.network.department.DepartmentCall
import com.guanacobusiness.network.job.JobRequest
import com.guanacobusiness.network.job.JobService
import com.guanacobusiness.network.register.RegisterRequest
import com.guanacobusiness.network.register.RegisterService
import com.guanacobusiness.network.user.UserCall
import com.guanacobusiness.network.worktype.WorktypeCall
import com.guanacobusiness.ui.login.LoginActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import okhttp3.internal.wait

class RegisterProfessionFragment : Fragment() {
    private lateinit var binding: FragmentRegisterProfessionBinding
    private lateinit var worktypeinfo: List<worktype>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register_profession, container, false)
        return binding.root
    }


    private fun getAllWorks() {
        CoroutineScope(Dispatchers.IO).launch {
            worktypeinfo = WorktypeCall.getAllWorktypes()!!
        }
    }

    private fun getWorktypeId(){
            val worktype = binding.ProfessionDropdownContainer.editText?.text.toString()
            worktypeinfo?.forEach() { item ->
                if (item.worktype.contains(worktype)) {
                    GetSetUser.setProfession(item.id)
                }
            }
    }



    private fun goToLogin() {
        val intent = Intent(context, LoginActivity::class.java)
        startActivity(intent)
    }

    private fun postUser() {
        val username = GetSetUser.getUsername()
        val password = GetSetUser.getPassword()
        val email = GetSetUser.getEmail()
        val fullname = GetSetUser.getFullName()
        val imgUrl = GetSetUser.getImgurl()
        val profession = GetSetUser.getProfession()
        CoroutineScope(Dispatchers.IO).async {
            val call = RetrofitInstance.retrofit.create(RegisterService::class.java).register(
                user(
                    "$username",
                    "$email",
                    "$fullname",
                    "$password",
                    "$imgUrl",
                    "$profession",
                    null
                )
            )
            var response = call.body()
            activity?.runOnUiThread() {
                if (call.isSuccessful) {
                    Log.d("Mensaje:", "Se publico el Usuario")
                } else {
                    Log.d("error", "No se publico el Usuario")
                }
            }

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAllWorks()
        binding.registerUserButton.setOnClickListener {
            try {
                getWorktypeId()
                postUser()
            } catch (e: Exception) {
                Log.d("Error:", e.toString())
            }
            try {
                goToLogin()
            } catch (e: Exception) {
                Log.d("Error:", e.toString())
            }
        }
    }

}