package com.felipearaujo.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Integrations(

        @field:JsonProperty("onedrivebusiness")
        val onedrivebusiness: Onedrivebusiness? = null,

        @field:JsonProperty("microsoftConnectors")
        val microsoftConnectors: MicrosoftConnectors? = null
)