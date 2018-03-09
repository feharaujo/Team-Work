package com.felipearaujo.model

import com.fasterxml.jackson.annotation.JsonProperty

data class ResponseActivity(

        @field:JsonProperty("STATUS")
        val sTATUS: String? = null,

        @field:JsonProperty("activity")
        val activity: List<ActivityItem?>? = null
)