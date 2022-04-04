class GameCard {
    private val cardHeight = 3
    private val num = (1..90).toMutableList()
    val card = List(cardHeight) {
        randomList()
    }

    fun cardScheme() {
        println("_____________________________________")
        card.forEach { row ->
            print("|")
            row.forEachIndexed { _, i ->
                if (i == null) print(" _ |")
                else if (i <= 9 && i != 0)
                    print(" $i |")
                else if (i == 0)
                    print(" X |")
                else
                    print(" $i|")
            }
            println()
            println("-------------------------------------")
        }
    }

    private fun randomList(): MutableList<Int?> {
        val a = mutableListOf<Int?>(null, null, null, null)
        num.shuffle()
        repeat(5) {
            a.add(num.first())
            num.removeAt(0)
        }
        a.shuffle()
        return a
    }
}
