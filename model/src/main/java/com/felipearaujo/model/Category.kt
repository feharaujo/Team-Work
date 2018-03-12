package com.felipearaujo.model

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonIgnoreProperties(ignoreUnknown = true)
data class Category(

        @field:JsonProperty("color")
        val color: String? = null,

        @field:JsonProperty("name")
        val name: String? = null,

        @field:JsonProperty("id")
        val id: String? = null
) : Parcelable