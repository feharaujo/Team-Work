package com.felipearaujo.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Company(

        @field:JsonProperty("is-owner")
        val isOwner: String? = null,

        @field:JsonProperty("name")
        val name: String? = null,

        @field:JsonProperty("id")
        val id: String? = null
)