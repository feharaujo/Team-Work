package com.felipearaujo.model

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Defaults(

        @field:JsonProperty("privacy")
        val privacy: String? = null
) : Parcelable