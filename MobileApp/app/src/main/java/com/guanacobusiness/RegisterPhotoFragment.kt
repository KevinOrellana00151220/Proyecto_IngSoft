package com.guanacobusiness//package com.guanacobusiness

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.guanacobusiness.databinding.FragmentRegisterPhotoBinding
import com.guanacobusiness.getsetdata.GetSetUser

class RegisterPhotoFragment : Fragment() {
    private lateinit var binding: FragmentRegisterPhotoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register_photo, container, false)
        return binding.root
    }

    private fun goToProfession() {
        setInfo()

        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_registerPhotoFragment_to_registerProfessionFragment)
    }

    private fun goWithoutPhoto(){
        setDefaultImage()

        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_registerPhotoFragment_to_registerProfessionFragment)
    }

    private fun setInfo() {
        GetSetUser.setImgurl("https://pbs.twimg.com/media/FXK9NsdWAAA99p-?format=png&name=small")
    }

    private fun setDefaultImage() {
        GetSetUser.setImgurl("https://st4.depositphotos.com/20923550/26743/v/450/depositphotos_267431104-stock-illustration-avatar-user-basic-abstract-circle.jpg")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonPhotoRegister.setOnClickListener {
            goToProfession()
        }
        binding.buttonSkipPhoto.setOnClickListener {
            goWithoutPhoto()
        }
    }
}