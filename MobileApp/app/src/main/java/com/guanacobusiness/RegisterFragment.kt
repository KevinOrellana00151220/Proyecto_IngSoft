package com.guanacobusiness//package com.guanacobusiness

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.guanacobusiness.databinding.FragmentRegisterBinding
import com.guanacobusiness.getsetdata.GetSetUser
import com.guanacobusiness.ui.login.LoginActivity


class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        //Changing the host fragment to the RegisterFragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)
        return binding.root
    }

    private fun errorTermsAndConditions() {
        Toast.makeText(context, "Debes aceptar los terminos y condiciones para continuar", Toast.LENGTH_SHORT).show()
    }

    private fun errorTextFieldEmpty() {
        Toast.makeText(context, "Debes llenar los campos vacios para continuar", Toast.LENGTH_SHORT).show()
    }

    private fun goLogin() {
        val intent = Intent(context, LoginActivity::class.java)
        startActivity(intent)
    }

    private fun setInfo() {
        GetSetUser.setUsername(binding.usernameInput.text.toString())
        GetSetUser.setPassword(binding.passwordInput.text.toString())
        GetSetUser.setEmail(binding.emailInput.text.toString())
        GetSetUser.setFullName(binding.fullNameInput.text.toString())
    }

    private fun goToRegisterImg() {
        setInfo()

        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_registerFragment_to_registerPhotoFragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.topAppBarRegister.setOnClickListener {
            goLogin()
        }
        binding.continueRegisterButton.setOnClickListener {
            if(binding.termsAndConditionsCheckbox.isChecked){
                if (binding.fullNameInput.text.isNullOrEmpty() || binding.usernameInput.text.isNullOrEmpty() ||
                    binding.emailInput.text.isNullOrEmpty() || binding.passwordInput.text.isNullOrEmpty()){

                    errorTextFieldEmpty()
                } else {
                    goToRegisterImg()
                }
            } else {
                errorTermsAndConditions()
            }
        }
    }

}