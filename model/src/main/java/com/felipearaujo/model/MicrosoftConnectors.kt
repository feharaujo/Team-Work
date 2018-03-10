package com.felipearaujo.model

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MicrosoftConnectors(

        @field:JsonProperty("enabled")
        val enabled: Boolean? = null
) : Parcelable