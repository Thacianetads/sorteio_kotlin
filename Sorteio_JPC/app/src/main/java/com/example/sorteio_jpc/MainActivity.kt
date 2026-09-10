package com.example.sorteio_jpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Home()
        }
    }
}

@Composable
fun Home(){
    val lista = listOf(
        "Thaciane", "Gabi", "Isa", "Arthur", "Isaque", "Paulo", "Fabio", "Wesley"
    )

    var vencedores by remember { mutableStateOf<List<String>>(emptyList())}
    fun sorteio(){
        val sorteio = lista.shuffled().take(4)
        vencedores = sorteio
    }
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Aplicativo de sorteio",
            color = Color(0xFF1A237E),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(50.dp)
        )
        Button(
            onClick = {
                sorteio()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6200EE)
            ),
            modifier = Modifier.padding(start = 0.dp, top=0.dp, end=0.dp, bottom=20.dp)
        ){
            Text(
                text = "Sortear",
                color = Color.White,
                fontSize = 18.sp
            )
        }
        if(vencedores.isNotEmpty()){
            vencedores.forEachIndexed{ index, vencedor ->
                Text(
                    text = "Vencedor ${index + 1}: ${vencedor}",
                    fontSize = 18.sp,
                    color = Color(0xFF009688),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview
@Composable
private fun HomePreview(){
    Home()
}