package org.example.drangonball.data.remote.response

import kotlinx.serialization.Serializable
import org.example.drangonball.domain.model.CharacterDetailModel
import org.example.drangonball.domain.model.CharacterModel
import org.example.drangonball.domain.model.OriginPlanetModel
import org.example.drangonball.domain.model.TransformationModel

@Serializable
data class CharacterResponse (
    val id: Int,
    val name:String,
    val ki: String,
    val race: String,
    val gender: String,
    val description: String,
    val image: String,
    val originPlanet: OriginResponse?= null,
    val transformations: List<TransformationResponse> = emptyList()
){
    fun toDomain(): CharacterModel {
        return CharacterModel(
            id = id,
            name = name,
            ki = ki,
            race = race,
            gender = gender,
            description = description,
            image = image
        )
    }

    fun toDetailDomain(): CharacterDetailModel? {
        if (originPlanet == null) return  null
        return CharacterDetailModel(
            characterModel = CharacterModel(
                id = id,
                name = name,
                ki = ki,
                race = race,
                gender = gender,
                description = description,
                image = image
            ),
            originPlanet = OriginPlanetModel(
                name = originPlanet.name,
                isDestroyed = originPlanet.isDestroyed,
                description = originPlanet.description,
                image = originPlanet.image
            ),
            transformations = transformations.map { transformationResponse ->
                transformationResponse.toDomain()
            }

        )
    }

}


