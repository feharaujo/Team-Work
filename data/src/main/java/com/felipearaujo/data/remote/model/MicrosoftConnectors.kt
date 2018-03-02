package com.felipearaujo.data.remote.model

import com.fasterxml.jackson.annotation.JsonProperty

data class MicrosoftConnectors(

        @field:JsonProperty("enabled")
        val enabled: Boolean? = null
)