package com.felipearaujo.model

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonIgnoreProperties(value = ["boardData", "projectAdmin"])
data class ProjectsItem(

        @field:JsonProperty("replyByEmailEnabled")
        val replyByEmailEnabled: Boolean? = null,

        @field:JsonProperty("endDate")
        val endDate: String? = null,

        @field:JsonProperty("created-on")
        val createdOn: String? = null,

        @field:JsonProperty("announcementHTML")
        val announcementHTML: String? = null,

        @field:JsonProperty("description")
        val description: String? = null,

        @field:JsonProperty("overview-start-page")
        val overviewStartPage: String? = null,

        @field:JsonProperty("starred")
        val starred: Boolean? = null,

        @field:JsonProperty("logo")
        val logo: String? = null,

        @field:JsonProperty("company")
        val company: Company? = null,

        @field:JsonProperty("id")
        val id: String? = null,

        @field:JsonProperty("announcement")
        val announcement: String? = null,

        @field:JsonProperty("tasks-start-page")
        val tasksStartPage: String? = null,

        @field:JsonProperty("start-page")
        val startPage: String? = null,

        @field:JsonProperty("notifyeveryone")
        val notifyeveryone: Boolean? = null,

        @field:JsonProperty("filesAutoNewVersion")
        val filesAutoNewVersion: Boolean? = null,

        @field:JsonProperty("subStatus")
        val subStatus: String? = null,

        @field:JsonProperty("tags")
        val tags: List<TagsItem?>? = null,

        @field:JsonProperty("privacyEnabled")
        val privacyEnabled: Boolean? = null,

        @field:JsonProperty("isProjectAdmin")
        val isProjectAdmin: Boolean? = null,

        @field:JsonProperty("defaultPrivacy")
        val defaultPrivacy: String? = null,

        @field:JsonProperty("last-changed-on")
        val lastChangedOn: String? = null,

        @field:JsonProperty("defaults")
        val defaults: Defaults? = null,

        @field:JsonProperty("name")
        val name: String? = null,

        @field:JsonProperty("show-announcement")
        val showAnnouncement: Boolean? = null,

        @field:JsonProperty("harvest-timers-enabled")
        val harvestTimersEnabled: Boolean? = null,

        @field:JsonProperty("category")
        val category: Category? = null,

        @field:JsonProperty("integrations")
        val integrations: Integrations? = null,

        @field:JsonProperty("startDate")
        val startDate: String? = null,

        @field:JsonProperty("status")
        val status: String? = null,

        val activity: List<ActivityItem?>? = null
) : Parcelable