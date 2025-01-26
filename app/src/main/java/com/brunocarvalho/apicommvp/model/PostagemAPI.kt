package com.brunocarvalho.apicommvp.model

import com.brunocarvalho.apicommvp.api.RetrofitService

class PostagemAPI {

    suspend fun recuperarPostagens(): List<Postagem> {

        val jsonPlace = RetrofitService.getJsonPlace()

        try {
            val retorno = jsonPlace.recuperarPostagens()
            if(retorno.isSuccessful){
                retorno.body()?.let { postagens ->
                    return postagens
                }
            }
        }catch (erroRecuperarPostagem: Exception){
            erroRecuperarPostagem.printStackTrace()
        }

        return emptyList()
    }

}