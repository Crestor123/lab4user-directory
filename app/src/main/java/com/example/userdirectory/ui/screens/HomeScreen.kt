package com.example.userdirectory.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.userdirectory.R
import com.example.userdirectory.model.UserData
import com.example.userdirectory.ui.theme.UserDirectoryTheme

@Composable
fun HomeScreen(
    directoryUiState: DirectoryUiState,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    when (directoryUiState) {
        is DirectoryUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is DirectoryUiState.Success -> ResultScreen(
            directoryUiState.userData, modifier = modifier.fillMaxWidth()
        )
        is DirectoryUiState.Error -> ErrorScreen(modifier = modifier.fillMaxSize())
    }
}

@Composable
fun ResultScreen(userData: List<UserData>, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Text(userData[0].userName.firstName)
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box (
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Loading")
    }
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Error")
    }
}