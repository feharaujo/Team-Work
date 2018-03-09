package com.felipearaujo.model

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Company(

        @field:JsonProperty("is-owner")
        val isOwner: String? = null,

        @field:JsonProperty("name")
        val name: String? = null,

        @field:JsonProperty("id")
        val id: String? = null
) : Parcelable