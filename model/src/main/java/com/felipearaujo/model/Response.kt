package com.felipearaujo.model

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Response(

        @field:JsonProperty("STATUS")
        val status: String? = null,

        @field:JsonProperty("projects")
        val projects: List<ProjectsItem?>? = null
) : Parcelable