package com.guanacobusiness

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.guanacobusiness.model.department

class DepartmentAdapter(val departments:List<department>) : RecyclerView.Adapter<DepartmentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepartmentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DepartmentViewHolder(layoutInflater.inflate(R.layout.item_department, parent, false))
    }

    override fun onBindViewHolder(holder: DepartmentViewHolder, position: Int) {
        val item = departments[position]
        holder.bind(item.department)
    }

    override fun getItemCount(): Int = departments.size


}