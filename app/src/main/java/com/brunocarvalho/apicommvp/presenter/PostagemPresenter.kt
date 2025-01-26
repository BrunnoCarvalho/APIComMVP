package com.brunocarvalho.apicommvp.presenter

import android.util.Log
import com.brunocarvalho.apicommvp.model.PostagemAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PostagemPresenter(private val view: IPostagemPresenter, private val postagemAPI: PostagemAPI) {
//O que vai ser exibido
    private val coroutine = CoroutineScope(Dispatchers.IO)

    fun recuperarPostagens(){
        view.carregando(true)
        coroutine.launch {
            val postagens = postagemAPI.recuperarPostagens()
            withContext(Dispatchers.Main){
                view.exibirPostagens(postagens)
                view.carregando(false)
            }
        }
    }

    fun onDestroy(){
        coroutine.cancel()
    }

}