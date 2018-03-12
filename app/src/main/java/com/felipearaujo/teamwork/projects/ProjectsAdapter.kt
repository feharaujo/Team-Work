package com.felipearaujo.teamwork.projects

import android.os.Build
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.felipearaujo.model.ProjectsItem
import com.felipearaujo.model.TagsItem
import com.felipearaujo.teamwork.R
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by felipearaujo on 07/03/18.
 */
class ProjectsAdapter(val activityView: ProjectsActivity) : RecyclerView.Adapter<ProjectsAdapter.ProjectViewHolder>() {

    private val list = ArrayList<ProjectsItem>()

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

        private val tvProjectName: TextView? = itemView?.findViewById(R.id.tv_project_name)
        private val tvCompanyName: TextView? = itemView?.findViewById(R.id.tv_company_name)
        private val tvTags: TextView? = itemView?.findViewById(R.id.tv_tags)
        private val tvRangeDate: TextView? = itemView?.findViewById(R.id.tv_range_date)
        private val tvDescription: TextView? = itemView?.findViewById(R.id.tv_description)
        private val cardContainer: View? = itemView?.findViewById(R.id.card_container)

        fun bind(projectItem: ProjectsItem) {
            tvTags?.text = fromHtml(createTag(projectItem.tags))

            tvProjectName?.text = projectItem.name
            tvCompanyName?.text = projectItem.company?.name
            tvDescription?.text = projectItem.description

            tvRangeDate?.text = "${createDateSimple(projectItem.startDate)} - ${createDateSimple(projectItem.endDate)}"

            cardContainer?.setOnClickListener {
                activityView.showActivities(adapterPosition)
            }
        }

        private fun createTag(tags: List<TagsItem?>?): String {
            val builder = StringBuilder()
            val SPACE = "&#160;&#160;"
            val HASH_TAG = "#"

            tags?.forEach {
                val word= "<font color=\"${it?.color}\">$HASH_TAG${it?.name}</font>"
                builder.append(word)
                builder.append(SPACE)
            }

            return builder.toString()
        }

        private fun fromHtml(html: String): Spanned {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
            } else {
                Html.fromHtml(html)
            }
        }
    }

    private fun createDateSimple(dateString: String?): String {
        val cal = Calendar.getInstance()
        cal.add(Calendar.DATE, 1)

        val format = SimpleDateFormat("yyyyMMdd", Locale.getDefault())
        val date = format.parse(dateString)

        val format2 = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

        return format2.format(date)
    }

}