package com.felipearaujo.teamwork.projects

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.felipearaujo.model.ProjectsItem
import com.felipearaujo.teamwork.R

/**
 * Created by felipearaujo on 07/03/18.
 */
class ProjectsAdapter : RecyclerView.Adapter<ProjectsAdapter.ProjectViewHolder>() {

    val list = ArrayList<ProjectsItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_project, parent, false)
        return ProjectViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun updateItems(items: List<ProjectsItem>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    inner class ProjectViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        var tvProjectName: TextView? = null

        init {
            tvProjectName = itemView?.findViewById(R.id.tv_project_name)
        }

        fun bind(projectItem: ProjectsItem) {
            tvProjectName?.text = projectItem.name
        }

    }

}