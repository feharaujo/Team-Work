package com.felipearaujo.model

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Onedrivebusiness(

        @field:JsonProperty("folder")
        val folder: String? = null,

        @field:JsonProperty("foldername")
        val foldername: String? = null,

        @field:JsonProperty("enabled")
        val enabled: Boolean? = null,

        @field:JsonProperty("account")
        val account: String? = null
): Parcelable