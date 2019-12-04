package com.example.triplan.api.model.Json

import com.squareup.moshi.Json

data class ImagePathJson(
    @Json(name = "image_type")
    val imageType: Int,
    @Json(name = "image_path")
    val imagePath: String
)