package com.example.wishlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wishlist.data.DummyWish
import com.example.wishlist.data.Wish

@Composable
fun HomeView(modifier: Modifier = Modifier, navController: NavController, viewModel: WishViewModel){
    Scaffold(
        topBar = { AppBarView(title = "WishList") },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Screen.AddScreen.route)

            },
                contentColor = Color.White,
                backgroundColor = Color.Black
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ) {
        LazyColumn(modifier = modifier
            .fillMaxSize()
            .padding(it)) {
            items(DummyWish.wishList){
                WishItem(wish = it) {
                    
                }
            }

        }
    }
}


@Composable
fun WishItem(wish: Wish, onClick :  () -> Unit ){
    Card(modifier = Modifier
        .fillMaxSize()
        .padding(top = 8.dp, start = 8.dp, end = 8.dp)
        .clickable {
            onClick()
        },
        elevation = 10.dp,
        backgroundColor = Color.White
    )
    {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = wish.title, fontWeight = FontWeight.ExtraBold)
        Text(text = wish.description)
    }
    }
}


//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun HomeViewPreview() {
//    HomeView()
//}