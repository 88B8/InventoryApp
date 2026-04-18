package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * Сервис CRUD операций над Item
 */
@Dao
interface ItemDao {
    /**
     * Получить список всех Item
     */
    @Query("SELECT * from items ORDER BY name ASC")
    fun getAllItems(): Flow<List<Item>>

    /**
     * Получить список Item по id
     */
    @Query("SELECT * from items WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    /**
     * Добавить Item
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    /**
     * Редактировать Item
     */
    @Update
    suspend fun update(item: Item)

    /**
     * Удалить Item
     */
    @Delete
    suspend fun delete(item: Item)
}