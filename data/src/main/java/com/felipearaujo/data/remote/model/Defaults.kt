package com.felipearaujo.data.remote.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Defaults(

        @field:JsonProperty("privacy")
        val privacy: String? = null
)