package com.guanacobusiness.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.guanacobusiness.databinding.ItemJobBinding
import com.guanacobusiness.model.job
import com.squareup.picasso.Picasso

class JobViewHolder(view:View):RecyclerView.ViewHolder(view) {

    val binding = ItemJobBinding.bind(view)

    fun render(jobs:job){
        //binding.companylogo.setImageResource(jobs.logoImg) // TODO: set image from url
        binding.jobTitle.text = jobs.title
        binding.jobSchedule.text = jobs.schedule
        binding.jobSalary.text = "$"+jobs.salary.toString()
        Picasso.get().load(jobs.imagen).into(binding.companylogo)
        Picasso.get().load(jobs.employer.imgurl).into(binding.employerlogo) // TODO: get employer from api
        binding.employerUser.text = jobs.employer.username
        binding.employerProfession.text = jobs.worktype.worktype
    }
}
