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
    fun salvar(contato: Usuarios): Long

    @Update
    fun atualizar(contato: Usuarios): Int

    @Delete
    fun excluir(contato: Usuarios): Int

    @Query("select * from tbl_usuarios order by name asc")
    fun listarTodosOsContatos(): List<Usuarios>

    @Query("select * from tbl_usuarios where id = :id")
    fun buscarContatoPeloID(id: Long): Usuarios
}