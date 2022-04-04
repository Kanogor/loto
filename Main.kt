import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    val bag = Baggie()
    val gamePlay = GamePlay()

    println(
        """Hello, World
           |Now we start our Game - LOTO!
           |In this game, the winner is the one who first crosses out all the numbers in one of the lines
           |Enter the name of Gamer 1:
       """.trimMargin()
    )
    val firstGamer = readLine().toString()

    println("Enter the name of Gamer 2:")
    val secondGamer = readLine().toString()

    println("Enter the number of Cards")
    val numOfCard = readLine()?.toIntOrNull() ?: return
    val x = checkNumberInt(numOfCard)
    if (x == null) println("Enter the correct number")

    val card1 = List(numOfCard) {
        GameCard()
    }

    val card2 = List(numOfCard) {
        GameCard()
    }

    runBlocking {
        launch {
            bag.getKeg().collect { i ->
                if (!gamePlay.checkProcess(card1)) {
                    println("$firstGamer is WIN")
                    cancel()
                }
                if (!gamePlay.checkProcess(card2)) {
                    println("$secondGamer is WIN")
                    cancel()
                } else {
                    delay(1000)
                    gamePlay.showKeg(card1, i, firstGamer)
                    gamePlay.showKeg(card2, i, secondGamer)
                }
            }
        }
    }

}

fun checkNumberInt(a: Int): Int? {
    if (a <= 0) return null
    return a
}




