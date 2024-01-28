package com.example.mywishlist.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mywishlist.R
import com.example.mywishlist.data.Priority
import com.example.mywishlist.ui.UiEvent
import com.example.mywishlist.ui.UiState
import com.example.mywishlist.ui.theme.MyWishListTheme

@ExperimentalMaterial3Api
@Composable
fun AddScreen(
    uiState: UiState,
    modifier: Modifier = Modifier,
    onEvent: (UiEvent) -> Unit,
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg2),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .alpha(.8f)
        )
//        Image(
//            painter = painterResource(id = R.drawable.moon1),
//            contentDescription = null,
//            modifier = Modifier
//                .fillMaxWidth()
//                .scale(1.2f),
//        )
        Column(
            modifier = Modifier
                .fillMaxSize(

                )
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary.copy(alpha = .18f)
                )
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()

                ) {
                    Text(
                        text = "Add Item to Wishlist",
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Bold,
                    )
                    FormField(
                        label = "Title",
                        value = uiState.title
                    ) {
                        onEvent(UiEvent.OnSetTitle(it))
                    }
                    Spacer(modifier = Modifier.padding(4.dp))

                    FormField(
                        label = "Website",
                        value = uiState.website,
                    ) {
                        onEvent(UiEvent.OnSetWebsite(it))
                    }

                    Spacer(modifier = Modifier.padding(4.dp))

                    FormField(
                        label = "Image",
                        value = uiState.img
                    ) {
                        onEvent(UiEvent.OnSetImage(it))
                    }
                    Spacer(modifier = Modifier.padding(4.dp))

                    Text(
                        text = "Priority",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimary,
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        PriorityCard(
                            text = "Low",
                            priority = Priority.Low,
                            color = Color.Yellow.copy(alpha = .8f),
                            uiState = uiState,
                            onEvent = onEvent
                        )
                        Spacer(modifier = Modifier.padding(8.dp))
                        PriorityCard(
                            text = "Medium",
                            priority = Priority.Medium,
                            color = Color.Cyan.copy(alpha = .8f),
                            uiState = uiState,
                            onEvent = onEvent
                        )
                        Spacer(modifier = Modifier.padding(8.dp))
                        PriorityCard(
                            text = "High",
                            priority = Priority.High,
                            color = Color.Green.copy(alpha = .8f),
                            uiState = uiState,
                            onEvent = onEvent
                        )
                    }
                    Spacer(modifier = Modifier.padding(16.dp))
                }
            }
            FloatingActionButton(
                onClick = { onEvent(UiEvent.OnSaveClicked) },
                shape = MaterialTheme.shapes.extraLarge,
                modifier = Modifier
                    .offset(y = (-45).dp)
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PriorityCard(
    text: String,
    priority: Priority,
    uiState: UiState,
    onEvent: (UiEvent) -> Unit,
    color: Color
) {
    Card(
        onClick = {
            onEvent(UiEvent.OnSetPriority(priority))
        },
        colors = CardDefaults.cardColors(
            containerColor = color
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = if (uiState.priority == priority) 8.dp else 0.dp
        ),
        border = if (uiState.priority == priority) BorderStroke(
            1.dp,
            Color.Gray
        ) else null,
    ) {
        Text(text = text, modifier = Modifier.padding(8.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormField(
    label: String,
    value: String = "",
    forEvent: (String) -> Unit
) {
    OutlinedTextField(
        label = { Text(text = label) },
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors
            (
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        shape = MaterialTheme.shapes.extraLarge,
        value = value,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = null,
                modifier = Modifier.padding(8.dp)
            )
        },
        onValueChange = forEvent
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun AddScreenPreview() {
    MyWishListTheme {
        AddScreen(uiState = UiState()) {}
    }
}