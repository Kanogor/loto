class GamePlay {

    private fun doX(card: List<GameCard>, b: Int) {
        card.forEach { cards ->
            cards.card.forEach { row ->
                val iterate = row.listIterator()
                while (iterate.hasNext()) {
                    val oldValue = iterate.next()
                    if (oldValue == b) iterate.set(0)
                }
            }
        }
    }

    fun showKeg(
        card: List<GameCard>,
        i: Int,
        name: String,
    ) {
        println("There is keg number $i")
        when (i) {
            7 -> println("Оп, топорик")
            21 -> println("ОЧКОО!!!")
            22 -> println("ГУСИ ЛЕБЕДИ!!11!!")
            30 -> println("Тридцать лет, а ума нет)")
            38 -> println("Тридцать восемь попугаев")
            66 -> println("Ваааленки")
            69 -> println(";)")
            77 -> println("ДВА ТОПОРА, Семён Семеныч....")
        }
        Thread.sleep(2000)
        doX(card, i)
        println("$name's cards now look like this:")
        card.forEach { cards ->
            cards.cardScheme()
        }
    }

    fun checkProcess(card: List<GameCard>): Boolean {
        var a = true
        card.forEach { cards ->
            val iterate = cards.card.listIterator()
            while (iterate.hasNext()) {
                val result = iterate.next()
                    .filterNotNull()
                    .reduce { total, next ->
                        total + next
                    }
                if (result == 0) a = false
            }
        }
        return a
    }
}