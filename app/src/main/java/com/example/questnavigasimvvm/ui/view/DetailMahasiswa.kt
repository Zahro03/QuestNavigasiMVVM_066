package com.example.questnavigasimvvm.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.questnavigasimvvm.model.DataMahasiswa


@Composable
fun DetailMahasiswaView(
    modifier: Modifier = Modifier,
    uiStateMahasiswa: DataMahasiswa,
    onBackButton: () -> Unit
)
{
    val listDataMhs = listOf(
        Pair("Nama", uiStateMahasiswa.nama),
        Pair("Gender", uiStateMahasiswa.gender),
        Pair("Email", uiStateMahasiswa.email),
        Pair("Alamat", uiStateMahasiswa.alamat),
        Pair("NIM", uiStateMahasiswa.nim),
    )

    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ){

        listDataMhs.forEach { items ->
            CardSection(
                judulParam = items.first,
                isiParam = items.second
            )
        }

        ElevatedButton(
            onClick = { onBackButton() }
        ) {
            Text("Kembali")
        }

    }
}

@Composable
fun CardSection(judulParam:String, isiParam:String){
    Column (horizontalAlignment = Alignment.Start, modifier = Modifier.padding(8.dp)){

        Row (modifier = Modifier.fillMaxWidth().padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = judulParam, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.2f))
            Text(text = "$isiParam", modifier = Modifier.weight(2f))
        }
    }
}