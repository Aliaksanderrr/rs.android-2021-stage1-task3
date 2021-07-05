package subtask3


//fun main(args: Array<String>) {
//    val arr = TelephoneFinder().findAllNumbersFromGivenNumber("12")
//    println("ОТВЕТ:")
//    if (arr != null) {
//        for (str in arr){
//            println(str.toString())
//        }
//    }
//}

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        var result = mutableListOf<String>()

        for (num in number){
            try {
                Integer.parseInt(num.toString())
            } catch (ex: NumberFormatException){
                return  null
            }
        }

        for (index in number.indices){
            val neighbours = neighbour[number[index]]
            if (neighbours != null) {
                for (num in neighbours){
                    var newNumber = number.toCharArray()
                    newNumber[index] = num
                    result.add(String(newNumber))
                }
            }

        }
        return result.toTypedArray()

    }

    companion object{
        val neighbour: Map<Char, List<Char>> = mapOf(
            '1' to listOf('2', '4'),
            '2' to listOf('1', '3', '5'),
            '3' to listOf('2', '6'),
            '4' to listOf('1', '5', '7'),
            '5' to listOf('2', '4', '6', '8'),
            '6' to listOf('3', '5', '9'),
            '7' to listOf('4', '8'),
            '8' to listOf('5', '7', '9', '0'),
            '9' to listOf('6', '8'),
            '0' to listOf('8'))
    }


}
