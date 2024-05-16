package br.senai.sp.jandira.projeto02.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_usuarios")
data class Usuarios(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,

    var name: String = "",
    var phone: String = "",
    var email: String = "",
    var password: String = "",

    @ColumnInfo(name = "is_over_18")
    var isOver18: Boolean = false
)