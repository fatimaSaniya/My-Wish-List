package com.example.mywishlist.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mywishlist.R
import com.example.mywishlist.ui.UiEvent
import com.example.mywishlist.ui.theme.MyWishListTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onEvent: (UiEvent) -> Unit = {},
) {
    val cardPadding = 24.dp
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.inversePrimary
                    )
                )
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg1),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .alpha(.8f)
                .fillMaxSize()
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Card(
                    onClick = { onEvent(UiEvent.OnSearchCardClicked) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(cardPadding)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.padding(8.dp))
                        Text(
                            text = "Search Wishlist",
                            style = MaterialTheme.typography.headlineSmall,
                        )
                    }
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {

                Card(
                    onClick = { onEvent(UiEvent.OnViewCardClicked) },
                    modifier = Modifier.weight(3f)
                ) {
                    Text(
                        text = "View Wishlist",
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.padding(cardPadding)
                    )
                }
                Spacer(modifier = Modifier.padding(8.dp))
                Card(
                    onClick = { onEvent(UiEvent.OnAddCardClicked) },
                    modifier = Modifier.weight(2f)) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(cardPadding)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.padding(8.dp))
                        Text(
                            text = "Add",
                            style = MaterialTheme.typography.headlineSmall,
                        )
                    }
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MyWishListTheme {
        HomeScreen()
    }
}