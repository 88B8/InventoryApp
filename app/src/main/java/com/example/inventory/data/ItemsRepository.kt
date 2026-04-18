import com.example.inventory.data.Item
import kotlinx.coroutines.flow.Flow

/**
 * Репозиторий для работы с Item
 */
interface ItemsRepository {
    /**
     * Получить список всех Item
     */
    fun getAllItemsStream(): Flow<List<Item>>

    /**
     * Получить Item по id
     */
    fun getItemStream(id: Int): Flow<Item?>

    /**
     * Добавить Item
     */
    suspend fun insertItem(item: Item)

    /**
     * Удалить Item
     */
    suspend fun deleteItem(item: Item)

    /**
     * Редактировать Item
     */
    suspend fun updateItem(item: Item)
}