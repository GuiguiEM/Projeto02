package br.senai.sp.jandira.projeto02.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.senai.sp.jandira.projeto02.model.Usuarios

@Dao
interface UsuarioDAO {

    @Insert
    fun salvar(usuarios: Usuarios): Long

    @Update
    fun atualizar(usuarios: Usuarios): Int

    @Delete
    fun excluir(usuarios: Usuarios): Int

    @Query("select * from tbl_usuarios order by name asc")
    fun listarTodosOsContatos(): List<Usuarios>

    @Query("SELECT * FROM tbl_usuarios WHERE email = :email AND password = :senha")
    fun logar(email: String, senha: String): Boolean

}
