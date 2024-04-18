package br.senai.sp.jandira.projeto02.model

import androidx.compose.ui.graphics.painter.Painter

data class Categorias(
    var id: Int = 0,
    var titulo: String = "",
    var imagem: Painter? = null
)
