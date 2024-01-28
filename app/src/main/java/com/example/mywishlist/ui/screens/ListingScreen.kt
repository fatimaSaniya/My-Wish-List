package com.example.mywishlist.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.mywishlist.data.FakeRepository
import com.example.mywishlist.data.Item
import com.example.mywishlist.data.Priority
import com.example.mywishlist.ui.UiState

@Composable
fun ListingScreen(
    onItemSelected: (Item) -> Unit,
    uiState: UiState,
) {
    val wishList = FakeRepository().getItems()
    Column(modifier = Modifier.background( color = Color.White)) {
        LazyColumn(
            modifier = Modifier
                .padding(16.dp)
                .background(Color.White),
               verticalArrangement = Arrangement.spacedBy(16.dp)
        )
        {
            item {
                Text(
                    text = "My WishList",
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.Black
                )
            }
            items(uiState.items) { item ->
                ItemCard(item = item, onClick = { onItemSelected(item)}
                )

            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ItemCard(item: Item, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        colors = CardDefaults.cardColors(
            containerColor = when (item.priority) {
                Priority.High -> Color.Red.copy(alpha = 0.2f)
                Priority.Medium -> Color.Green.copy(alpha = 0.2f)
                Priority.Low -> Color.Blue.copy(alpha = 0.2f)
            }
        ),
        modifier = Modifier.padding(bottom = 16.dp)
    ) {
        GlideImage(
            model = item.img,
            contentDescription = item.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(250.dp).padding(16.dp),

        )
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = item.title, color = Color.Black)
            Text(text = item.website, style = MaterialTheme.typography.bodySmall, color = Color.Black)
        }
    }
}