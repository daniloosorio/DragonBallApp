package org.example.drangonball.data.remote.response

import kotlinx.serialization.Serializable
import org.example.drangonball.domain.model.TransformationModel

@Serializable
data class TransformationResponse (
    val name:String,
    val image:String,
    val ki:String,
){
    fun toDomain(): TransformationModel {
       return TransformationModel(
            name = name,
            image = image,
            ki = ki
        )
    }
}