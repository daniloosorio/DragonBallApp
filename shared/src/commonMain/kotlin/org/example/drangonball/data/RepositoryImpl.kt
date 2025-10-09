package org.example.drangonball.data

import org.example.drangonball.data.remote.ApiService
import org.example.drangonball.domain.Repository
import org.example.drangonball.domain.model.CharacterDetailModel
import org.example.drangonball.domain.model.CharacterModel

class RepositoryImpl(private val apiService: ApiService): Repository {
    override suspend fun getCharacters():List<CharacterModel> {
        return apiService.getAllCharacters().items.map { characterResponse ->
            characterResponse.toDomain()
        }
    }

    override suspend fun getSingleCharacter(id: Int): CharacterDetailModel? {
        return apiService.getDetailCharacter(id)?.toDetailDomain()
    }
}