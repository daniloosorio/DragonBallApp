package org.example.drangonball.data.remote

import co.touchlab.kermit.Logger
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.parameters
import org.example.drangonball.data.remote.response.CharacterWrapperResponse

class ApiService(private val client: HttpClient) {
    suspend fun getAllCharacters(): CharacterWrapperResponse{
        return try {
            client.get("/api/characters"){
                parameter("limit",60)
            }.body()
        }
        catch (e: Exception){
            Logger.e("Error ApiService -> ${e.message}")
            return CharacterWrapperResponse(emptyList())
        }
    }
}