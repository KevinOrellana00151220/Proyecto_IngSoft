package com.guanacobusiness.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.guanacobusiness.R
import com.guanacobusiness.model.job

class JobAdapter(private val jobs:List<job>) : RecyclerView.Adapter<JobViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return JobViewHolder(layoutInflater.inflate(R.layout.item_job, parent, false))
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val item = jobs[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return jobs.size
    }
}