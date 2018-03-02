package com.felipearaujo.data.remote.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Category(

        @field:JsonProperty("color")
        val color: String? = null,

        @field:JsonProperty("name")
        val name: String? = null,

        @field:JsonProperty("id")
        val id: String? = null
)