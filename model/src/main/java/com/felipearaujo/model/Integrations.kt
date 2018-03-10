package com.felipearaujo.model

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Integrations(

        @field:JsonProperty("onedrivebusiness")
        val onedrivebusiness: Onedrivebusiness? = null,

        @field:JsonProperty("microsoftConnectors")
        val microsoftConnectors: MicrosoftConnectors? = null
) : Parcelable