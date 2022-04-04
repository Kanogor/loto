import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Baggie {

    private val baggie = (1..90).toMutableList()

    fun getKeg(): Flow<Int> = flow {
        baggie.shuffle()
        for (i in 0 until baggie.size) {
            val a = baggie.removeAt(0)
            emit(a)
        }
    }
}