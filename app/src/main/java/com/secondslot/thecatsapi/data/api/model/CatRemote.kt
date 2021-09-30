package com.secondslot.thecatsapi.data.api.model

import com.google.gson.annotations.SerializedName
import com.secondslot.thecatsapi.data.repository.model.Cat

data class CatRemote(
    @SerializedName("id") val id: String,
    @SerializedName("url") val url: String
)

fun CatRemote.toItem(): Cat = Cat(
    id = this.id,
    url = this.url
)
