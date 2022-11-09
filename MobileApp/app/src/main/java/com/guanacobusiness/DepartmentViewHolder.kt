package com.guanacobusiness

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.guanacobusiness.databinding.ItemDepartmentBinding
import com.guanacobusiness.model.department

class DepartmentViewHolder (view: View):RecyclerView.ViewHolder(view) {

    private val binding = ItemDepartmentBinding.bind(view)

    fun bind(department: String){
        binding.ivDepartment.text = department
    }

}
