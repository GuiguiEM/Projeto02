package br.senai.sp.jandira.projeto02.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.projeto02.R
import br.senai.sp.jandira.projeto02.model.Viagem
import java.time.LocalDate

class ViagemRepository {

        @Composable
        fun listarTodasAsViagens(): List<Viagem>{

            val londres = Viagem(
                id = 1,
                destino = "Londres",
                descricao = "Londres, capital da Inglaterra e do Reino Unido, é uma cidade do século 21 com uma história que remonta à era romana.",
                dataChegada = LocalDate.of(2019, 2 ,18),
                dataPartida = LocalDate.of(2019, 2 ,21),
                imagem = painterResource(id = R.drawable.londres)

            )

            val paris = Viagem(
                id = 2,
                destino = "Paris",
                descricao = "Paris, a capital da França, é uma importante cidade europeia e um centro mundial de arte, moda, gastronomia e cultura.",
                dataChegada = LocalDate.of(2014, 6 ,8),
                dataPartida = LocalDate.of(2014, 6 ,14),
                imagem = painterResource(id = R.drawable.paris)

            )

            val toquio = Viagem(
                id = 3,
                destino = "Tóquio",
                descricao = "Tóquio, a movimentada capital do Japão, combina o estilo ultramoderno com o tradicional, desde arranha-céus iluminados por neon a templos históricos.",
                dataChegada = LocalDate.of(2024, 4 ,14),
                dataPartida = LocalDate.of(2024, 4 ,24),
                imagem = painterResource(id = R.drawable.toquio)

            )

            val roma = Viagem(
                id = 4,
                destino = "Roma",
                descricao = "Roma, a capital da Itália, é uma cidade cosmopolita, enorme, com quase 3.000 anos de arte, arquitetura e cultura influentes no mundo todo e à mostra.",
                dataChegada = LocalDate.of(2022, 12,22),
                dataPartida = LocalDate.of(2023, 1,4),
                imagem = painterResource(id = R.drawable.roma)

            )

            val madri = Viagem(
                id = 5,
                destino = "Madri",
                descricao = "Madri, a capital da Espanha, situada no centro do país, é uma cidade de avenidas elegantes e parques grandes e bem cuidados, como o Buen Retiro.",
                dataChegada = LocalDate.of(2010, 9 ,1),
                dataPartida = LocalDate.of(2010, 9 ,7),
                imagem = painterResource(id = R.drawable.madri)

            )

            return listOf(londres, paris, toquio, roma, madri)
        }
}