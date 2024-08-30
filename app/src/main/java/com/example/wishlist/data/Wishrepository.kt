package com.example.wishlist.data

import kotlinx.coroutines.flow.Flow

class WishRepository(private val wishDao: WishDao) {
    suspend fun addAWish(wish:Wish){
        wishDao.addAWish(wish)
    }

    fun getAllWish() : Flow<List<Wish>> {
        return wishDao.getAllWishes()
    }

    fun getWishById(id:Long) : Flow<Wish> {
        return wishDao.getAWishById(id)
    }

    suspend fun deleteAWish(wish: Wish) {
        return wishDao.deleteAWish(wish)
    }

    suspend fun updateAWish(wish: Wish) {
        return wishDao.updateAWish(wish)
    }
}