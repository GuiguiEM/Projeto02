package br.senai.sp.jandira.projeto02.repository

import android.content.Context
import androidx.compose.runtime.Composable
import br.senai.sp.jandira.projeto02.DAO.UsuarioDB
import br.senai.sp.jandira.projeto02.model.Usuarios

class UsuariosRepository(context: Context) {

    private val db = UsuarioDB.getBancoDeDados(context).usuarioDAO()

    fun salvar(usuarios: Usuarios): Long {
        return db.salvar(usuarios)
    }

    fun validaLogin(email:String, senha:String): Boolean {
        return db.logar(email, senha)
    }

    fun listarTodosOsUsuarios(): List<Usuarios>{
        return listarTodosOsUsuarios()
    }
}