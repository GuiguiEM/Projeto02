package br.senai.sp.jandira.projeto02

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import br.senai.sp.jandira.projeto02.repository.UsuariosRepository
import br.senai.sp.jandira.projeto02.ui.theme.Projeto02Theme

@Composable
fun LoginScreen(controleDeNavegacao: NavHostController) {

    val cr = UsuariosRepository(LocalContext.current)

    var emailState = remember{
        mutableStateOf("")
    }

    var passwordState = remember{
        mutableStateOf("")
    }

    var mensagemErroState = remember {
        mutableStateOf("")
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
                .padding(top = 70.dp)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp)
                    .padding(top = 100.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 18.dp)
                ) {
                    Text(
                        text = "Login",
                        color = (Color(0xFF7E24FF)),
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 56.sp
                    )
                    Text(
                        text = "Please sign in to continue",
                        color = Color.Gray,
                        fontSize = 14.sp
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
                            .padding(top = 50.dp)
                            .width(330.dp),
                        value = emailState.value,
                        onValueChange = {
                            emailState.value = it
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
                                text = "E-mail",
                                modifier = Modifier
                                    .padding(start = 0.dp)
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
                        value = passwordState.value,
                        onValueChange = {
                            passwordState.value = it
                            Log.i(
                                "SENAI",
                                "Valor: $it"
                            )
                        },
                        visualTransformation = PasswordVisualTransformation(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF7E24FF),
                            unfocusedBorderColor = Color(0xFF7E24FF)
                        ),
                        label = {

                            Text(
                                text = "Password",
                                modifier = Modifier
                                    .padding(start = 0.dp)
                            )
                        }
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 50.dp),
                        horizontalAlignment = Alignment.End,
                    ) {
                        Button(
                            onClick = {
                                if (emailState.value == "" || passwordState.value == ""){
                                    mensagemErroState.value = "Email ou senhas incorretos"
                                } else {
                                    val usuario = cr.validaLogin(emailState.value, passwordState.value)

                                    if(usuario){
                                        controleDeNavegacao.navigate("home")
                                    }
                                }
                            },
                            colors = ButtonDefaults.buttonColors((Color(0xFF7E24FF))),
                            modifier = Modifier
                                .padding(top = 30.dp)
                                .height(60.dp)
                                .width(150.dp)
                        ) {
                            Text(
                                text = "SIGN IN",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 22.sp
                            )

                        }
                        Row(
                            modifier = Modifier
                                .padding(top = 30.dp)
                        ) {
                            Text(
                                text = "Don't have an account?",
                                color = Color.Gray
                            )
                            Text(
                                modifier = Modifier.clickable { controleDeNavegacao.navigate("SignUp") },
                                text = " Sign up",
                                color = (Color(0xFF7E24FF)),
                                fontWeight = FontWeight.Bold,
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
fun LoginScreenPreview() {
    Projeto02Theme {
        //LoginScreen(controleDeNavegacao = NavHostController)
    }
}