package com.example.bitfit.data
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Insert

@Dao
interface FoodDao {
    @Query("SELECT * FROM foods")
    fun getAll(): LiveData<List<FoodEntity>>

    @Insert
    suspend fun insert(food: FoodEntity)

    @Query("DELETE FROM foods WHERE id = :id")
    suspend fun deleteById(id: Long)


    @Query("DELETE FROM foods")
    suspend fun deleteAll()
}


