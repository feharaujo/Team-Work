package com.felipearaujo.data.remote.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Onedrivebusiness(

        @field:JsonProperty("folder")
        val folder: String? = null,

        @field:JsonProperty("foldername")
        val foldername: String? = null,

        @field:JsonProperty("enabled")
        val enabled: Boolean? = null,

        @field:JsonProperty("account")
        val account: String? = null
)