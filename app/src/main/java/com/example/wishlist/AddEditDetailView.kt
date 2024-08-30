package com.example.wishlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun addEditViewDetailView(
    id: Long = 0L,
    viewModel : WishViewModel = WishViewModel(),
    navController: NavController = rememberNavController()
){

    Scaffold(
        topBar = { AppBarView(title =
        if (id != 0L) stringResource(id = R.string.update_wish)
            else stringResource(id = R.string.add_wish)
        ){
            navController.navigateUp()
        }

        }
    ) {
        Column(modifier = Modifier
            .padding(it)
            .wrapContentSize()
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Spacer(modifier = Modifier
                .height(10.dp)
                .fillMaxWidth())
            OutlinedTextField(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp) ,value = viewModel.wishTitleState, onValueChange = { newVal->
                viewModel.wishTitleState = newVal
            },
                label = { Text(text = "Title")}
            )
            OutlinedTextField(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp) ,value = viewModel.wishDescriptionState, onValueChange = { newVal->
                viewModel.wishDescriptionState = newVal
            },
                label = { Text(text = "Description")}
            )

            Button(onClick = {
                if(viewModel.wishTitleState.isNotEmpty() && viewModel.wishTitleState.isNotEmpty()){
                    // update
                }
                else{

                }

            },
                modifier = Modifier
                    .padding(16.dp)
                    ,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.teal_200),
                    contentColor = Color.White
                ),
                elevation = ButtonDefaults.elevation(8.dp), // Adds elevation for a shadow effect
                ) {


                Text(text = stringResource(id = if (id!=0L) R.string.update_wish else R.string.add_wish))

                
            }
        }
    }



}


@Preview
@Composable
fun WishTextFieldPreview(){
    addEditViewDetailView()
}



