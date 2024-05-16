package br.senai.sp.jandira.projeto02.DAO

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.projeto02.model.Usuarios

@Database(entities = [Usuarios::class], version = 1)
abstract class UsuarioDB: RoomDatabase() {

    abstract fun usuarioDAO(): UsuarioDAO

    companion object{
        private lateinit var instancia: UsuarioDB

        fun getBancoDeDados(context: Context): UsuarioDB{
            instancia = Room
                    .databaseBuilder(
                context,
                UsuarioDB::class.java,
                "db_usuarios"
                    )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()

            return instancia
        }
    }

}