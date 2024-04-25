package br.senai.sp.jandira.projeto02.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.projeto02.R
import br.senai.sp.jandira.projeto02.model.Categorias

class CategoriasRepository {

    @Composable
    fun listarTodasAsCategorias(): List<Categorias>{
        val montain = Categorias(
            id = 1,
            titulo = "Montains",
            imagem = painterResource(id = R.drawable.montanha)
        )

        val snow = Categorias(
            id = 2,
            titulo = "Snow",
            imagem = painterResource(id = R.drawable.floco_de_neve)
        )

        val beach = Categorias(
            id = 3,
            titulo = "Beach",
            imagem = painterResource(id = R.drawable.praia)
        )

        val city = Categorias(
            id = 4,
            titulo = "City",
            imagem = painterResource(id = R.drawable.cidade)
        )

        return listOf(montain, snow, beach, city)
    }
}