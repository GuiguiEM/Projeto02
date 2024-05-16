package br.senai.sp.jandira.projeto02

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.projeto02.model.Usuarios
import br.senai.sp.jandira.projeto02.repository.UsuariosRepository
import br.senai.sp.jandira.projeto02.ui.theme.Projeto02Theme


@Composable
fun SignUpScreen(controleDeNavegacao: NavHostController) {

    val cr = UsuariosRepository(LocalContext.current)

    var userState = remember{
        mutableStateOf("")
    }

    var phoneState = remember{
        mutableStateOf("")
    }

    var emailState = remember{
        mutableStateOf("")
    }

    var passwordState = remember{
        mutableStateOf("")
    }

    var isOver18State = remember{
        mutableStateOf(false)
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Box(
                modifier = Modifier
                    .width(150.dp)
                    .height(50.dp)
                    .background(
                        color = (Color(0xFF7E24FF)),
                        shape = RoundedCornerShape(
                            bottomStart = 22.dp,
                        )
                    )
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 20.dp, start = 10.dp)
        ) {
            Column (
                modifier = Modifier
                    .padding(top = 50.dp)
            ){
                Text(
                    text = "Sign Up",
                    color = (Color(0xFF7E24FF)),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 36.sp,
                    modifier = Modifier

                )
                Text(
                    text = "Create a new account",
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
                Card (
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .size(height = 90.dp, width = 90.dp)
                        .align(alignment = Alignment.CenterHorizontally),
                    elevation = CardDefaults.cardElevation(10.dp),
                    shape = CircleShape,
                    border = BorderStroke(1.dp, Color(0xFF7E24FF))
                ){
                    Icon(
                        modifier = Modifier
                            .fillMaxSize(),
                        imageVector = Icons.Filled.Person,
                        contentDescription = "",
                        tint = Color(0xFF7E24FF)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp)
                    .offset(x = 0.dp, y = -30.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 18.dp)
                ) {
                    OutlinedTextField(
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.AccountCircle,
                                contentDescription = "",
                                tint = Color(0xFF6900FF)
                            )
                        },
                        modifier = Modifier
                            .padding(top = 50.dp)
                            .width(330.dp),
                        shape = RoundedCornerShape(12.dp),
                        value = userState.value,
                        onValueChange = {
                            userState.value = it
                            Log.i(
                                "SENAI",
                                "Valor: $it"
                            )
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF7E24FF),
                            unfocusedBorderColor = Color(0xFF7E24FF)
                        ),
                        label = {

                            Text(
                                text = "Username"
                            )
                        }
                    )
                    OutlinedTextField(
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Phone,
                                contentDescription = "",
                                tint = Color(0xFF6900FF)
                            )
                        },
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .width(330.dp),
                        shape = RoundedCornerShape(12.dp),
                        value = phoneState.value,
                        onValueChange = {
                            phoneState.value = it
                            Log.i(
                                "SENAI",
                                "Valor: $it"
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone
                        ),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF7E24FF),
                            unfocusedBorderColor = Color(0xFF7E24FF)
                        ),
                        label = {

                            Text(
                                text = "Phone"
                            )
                        }
                    )
                    OutlinedTextField(
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Email,
                                contentDescription = "",
                                tint = Color(0xFF6900FF)
                            )
                        },
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .width(330.dp),
                        shape = RoundedCornerShape(12.dp),
                        value = emailState.value,
                        onValueChange = {
                            emailState.value = it
                            Log.i(
                                "SENAI",
                                "Valor: $it"
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email
                        ),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF7E24FF),
                            unfocusedBorderColor = Color(0xFF7E24FF)
                        ),
                        label = {

                            Text(
                                text = "E-mail"
                            )
                        }
                    )
                    OutlinedTextField(
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Lock,
                                contentDescription = "",
                                tint = Color(0xFF6900FF)
                            )
                        },
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .width(330.dp),
                        shape = RoundedCornerShape(12.dp),
                        value = passwordState.value,
                        onValueChange = {
                            passwordState.value = it
                            Log.i(
                                "SENAI",
                                "Valor: $it"
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.NumberPassword
                        ),
                        visualTransformation = PasswordVisualTransformation(),

                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF7E24FF),
                            unfocusedBorderColor = Color(0xFF7E24FF)
                        ),
                        label = {

                            Text(
                                text = "Password"
                            )
                        }
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(x = -10.dp, y = 10.dp)
                    ) {
                        Checkbox(
                            checked = isOver18State.value,
                            onCheckedChange = {opcao ->
                                isOver18State.value = opcao
                            },
                            colors = CheckboxDefaults.colors(Color(0xFF7E24FF))
                        )
                        Text(
                            text = "Over 18?",
                            color = Color.DarkGray
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 35.dp),
                        horizontalAlignment = Alignment.End,
                    ) {
                        Button(
                            onClick = {
                                val usuarios = Usuarios(
                                    name = userState.value,
                                    phone = phoneState.value,
                                    email = emailState.value,
                                    password = passwordState.value,
                                    isOver18 = isOver18State.value
                                )
                                cr.salvar(usuarios)
                            },
                            colors = ButtonDefaults.buttonColors((Color(0xFF7E24FF))),
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .height(50.dp)
                                .width(330.dp)
                        ) {
                            Text(
                                text = "CREATE ACCOUNT",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 20.sp
                            )

                        }
                        Row(
                            modifier = Modifier
                                .padding(top = 30.dp)
                        ) {
                            Text(
                                text = "Already have an account?",
                                color = Color.Gray
                            )
                            Text(
                                modifier = Modifier.clickable { controleDeNavegacao.navigate("login") },
                                text = " Sign up",
                                color = (Color(0xFF7E24FF)),
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }

        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom
        ) {
            Box(
                modifier = Modifier
                    .width(150.dp)
                    .height(50.dp)
                    .background(
                        color = (Color(0xFF7E24FF)),
                        shape = RoundedCornerShape(
                            topEnd = 22.dp
                        )
                    )
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpScreenPreview() {
    Projeto02Theme {
        //HomeScreen()
    }
}