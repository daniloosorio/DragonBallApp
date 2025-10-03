package org.example.drangonball.domain

import org.example.drangonball.domain.model.CharacterModel

interface Repository {
    suspend fun getCharacters(): List<CharacterModel>
}