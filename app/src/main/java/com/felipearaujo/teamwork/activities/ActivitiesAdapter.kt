package com.felipearaujo.teamwork.activities

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.felipearaujo.model.ActivityItem
import com.felipearaujo.teamwork.R
import com.squareup.picasso.Picasso
import javax.inject.Inject

/**
 * Created by felipearaujo on 11/03/18.
 */
class ActivitiesAdapter
@Inject constructor(val picasso: Picasso) : RecyclerView.Adapter<ActivitiesAdapter.ActivityViewHolder>() {

    private val list = ArrayList<ActivityItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_activity, parent, false)
        return ActivityViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun updateItems(items: List<ActivityItem>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }


    inner class ActivityViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        private val profileImage: ImageView? = itemView?.findViewById(R.id.profile_image)
        private val description: TextView? = itemView?.findViewById(R.id.tv_description)

        fun bind(item: ActivityItem) {
            val text = "${item.fromusername}: ${item.description}"
            description?.text = text

            picasso.load(item.fromUserAvatarUrl)
                    .into(profileImage)
        }

    }

}