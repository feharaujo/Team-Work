package com.felipearaujo.data.remote.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Response(

        @field:JsonProperty("STATUS")
        val status: String? = null,

        @field:JsonProperty("projects")
        val projects: List<ProjectsItem?>? = null
)