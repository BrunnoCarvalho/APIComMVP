package com.brunocarvalho.apicommvp.presenter

import com.brunocarvalho.apicommvp.model.Postagem

interface IPostagemPresenter {

    fun exibirPostagens(lista: List<Postagem>)
    fun carregando( exibirCarregando: Boolean)

}