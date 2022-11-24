package com.guanacobusiness

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.navigation.NavigationView
import com.guanacobusiness.databinding.FragmentAddCurriculumBinding
import com.guanacobusiness.databinding.FragmentCurriculumBinding

class CurriculumFragment : Fragment() {
    private lateinit var binding: FragmentCurriculumBinding
    private lateinit var mainMenu : NavigationView
    private lateinit var navDrawer: DrawerLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_curriculum, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainMenu = binding.navView
        navDrawer = binding.drawerLayout

        binding.include.mainMenu.setOnClickListener { navDrawer.open() }
        mainMenu.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.allOffers -> {
                    goToHomePage()
                    true
                }
                R.id.aplicatedOffers -> {
                    goToAplicateOffers()
                    true
                }
                R.id.CV -> {
                    goToCVPage()
                    true
                }
                R.id.myOffers -> {
                    goToOffers()
                    true
                }
                else -> false
            }
        }

        binding.addCVActionButton.setOnClickListener{
            gotToAddCV()
        }

    }

    private fun goToHomePage(){
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_curriculumFragment_to_homeFragment)
    }

    private fun gotToAddCV() {
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_curriculumFragment_to_addCurriculumFragment)
    }

    private fun goToOffers() {
        val navController = NavHostFragment.findNavController(this)
        //navController.navigate(R.id.action_curriculumFragment_to_addCurriculumFragment)
    }

    private fun goToAplicateOffers() {
        val navController = NavHostFragment.findNavController(this)
        //navController.navigate(R.id.action_curriculumFragment_to_addCurriculumFragment)
    }

    private fun goToCVPage() {
        val navController = NavHostFragment.findNavController(this)
        //navController.navigate(R.id.action_curriculumFragment_to_addCurriculumFragment)
    }

}