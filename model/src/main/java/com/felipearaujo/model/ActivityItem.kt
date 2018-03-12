package com.felipearaujo.model

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonIgnoreProperties(ignoreUnknown = true)
data class ActivityItem(

        @field:JsonProperty("isprivate")
        val isprivate: String? = null,

        @field:JsonProperty("latestActivityType")
        val latestActivityType: String? = null,

        @field:JsonProperty("for-user-avatar-url")
        val forUserAvatarUrl: String? = null,

        @field:JsonProperty("fromusername")
        val fromusername: String? = null,

        @field:JsonProperty("forusername")
        val forusername: String? = null,

        @field:JsonProperty("lockdownId")
        val lockdownId: String? = null,

        @field:JsonProperty("link")
        val link: String? = null,

        @field:JsonProperty("description")
        val description: String? = null,

        @field:JsonProperty("type")
        val type: String? = null,

        @field:JsonProperty("activitytype")
        val activitytype: String? = null,

        @field:JsonProperty("userid")
        val userid: String? = null,

        @field:JsonProperty("extradescription")
        val extradescription: String? = null,

        @field:JsonProperty("itemid")
        val itemid: String? = null,

        @field:JsonProperty("datetime")
        val datetime: String? = null,

        @field:JsonProperty("due-date")
        val dueDate: String? = null,

        @field:JsonProperty("itemlink")
        val itemlink: String? = null,

        @field:JsonProperty("foruserid")
        val foruserid: String? = null,

        @field:JsonProperty("from-user-avatar-url")
        val fromUserAvatarUrl: String? = null,

        @field:JsonProperty("publicinfo")
        val publicinfo: String? = null,

        @field:JsonProperty("id")
        val id: String? = null,

        @field:JsonProperty("projectId")
        val projectId: String? = null,

        @field:JsonProperty("todo-list-name")
        val todoListName: String? = null
) : Parcelable