package com.example.wishlist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wishlist.data.Wish
import com.example.wishlist.data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(
    private val wishRepository: WishRepository = Graph.wishRepository
)

    : ViewModel() {

    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")


    fun onWishTitleChanged(newString : String){
        wishTitleState = newString
    }

    fun WishDescriptionChanged(newString: String){
        wishDescriptionState = newString
    }

    lateinit var getAllWishes : Flow<List<Wish>>

    init {
        viewModelScope.launch {
            getAllWishes = wishRepository.getAllWish()
        }
    }

    fun addWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.addAWish(wish)
        }
    }

    fun updateWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.updateAWish(wish)
        }
    }

    fun getAWishById(id:Long) : Flow<Wish> {
            return wishRepository.getWishById(id)
    }

    fun deleteWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.deleteAWish(wish)

        }
    }

}