package com.example.userdirectory.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.userdirectory.model.ProfileImage
import com.example.userdirectory.model.UserData
import com.example.userdirectory.model.UserLogin
import com.example.userdirectory.model.UserName

@Composable
fun UserCard(user: UserData) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(user.profileImage.imageURL)
                    .build(),
                contentDescription = user.userName.firstName + " " + user.userName.lastName,
                modifier = Modifier.padding(8.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(1.dp)
            ) {
                Text(
                    text = user.userName.firstName + " " + user.userName.lastName,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = user.email
                )
            }
        }

    }
}


@Preview
@Composable
fun UserCardPreview() {
    val testUser = UserData(
        UserName(firstName = "Test", lastName = "Name"),
        UserLogin("Test Login"),
        email = "Test Email",
        ProfileImage("Test URL")
    )
    UserCard(testUser)
}