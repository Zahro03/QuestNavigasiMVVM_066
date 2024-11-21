package com.example.questnavigasimvvm

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.questnavigasimvvm.model.DataJK
import com.example.questnavigasimvvm.ui.ViewModel.MahasiswaViewModel
import com.example.questnavigasimvvm.ui.view.DetailMahasiswaView
import com.example.questnavigasimvvm.ui.view.FormMahasiswaView

enum class Halaman{
    Formulir,
    Detail
}

@Composable
fun PengelolaHalaman(
    modifier: Modifier = Modifier,
    viewModel: MahasiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController()

){
    val uiState by viewModel.uiState.collectAsState()

    NavHost(navController = navHost, startDestination =
    Halaman.Formulir.name ) {
        composable(route = Halaman.Formulir.name)
        {
            val konteks = LocalContext.current
            FormMahasiswaView (
                listJK = DataJK.listJK.map {
                        id -> konteks.resources.getString(id)
                },
                onSubmitClicked = {
                    viewModel.saveDataMahasiswa(it)
                    navHost.navigate(Halaman.Detail.name)
                }
            )
        }
        composable(route = Halaman.Detail.name){
            DetailMahasiswaView(
                uiStateMahasiswa = uiState,
                onBackButton = {
                    navHost.popBackStack()
                }
            )
        }
    }
}