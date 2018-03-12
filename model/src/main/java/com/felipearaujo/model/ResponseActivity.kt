package com.felipearaujo.model

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonIgnoreProperties(ignoreUnknown = true)
data class ResponseActivity(

        @field:JsonProperty("STATUS")
        val sTATUS: String? = null,

        @field:JsonProperty("activity")
        val activity: List<ActivityItem?>? = null
): Parcelable