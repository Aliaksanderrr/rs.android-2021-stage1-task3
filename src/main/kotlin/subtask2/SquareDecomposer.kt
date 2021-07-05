package subtask2

import kotlin.math.sqrt

//fun main(args: Array<String>) {
//    val arr = SquareDecomposer().decomposeNumber(50)
//    println("ОТВЕТ:")
//    if (arr != null) {
//        for (str in arr){
//            println(str.toString())
//        }
//    }
//}

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        if (number <= 1) return null

        for (num in number-1 downTo 1 ){
            var result = mutableSetOf<Int>()

            val rest = number*number - num*num
            result.add(num)
            result.addAll( decompose(rest))

            if (check(number*number, result.toTypedArray())){
                return result.sorted().toTypedArray()
            }
        }
        return null
    }

    private fun decompose(number: Int): Array<Int>{

        var int = sqrt(number.toDouble()).toInt()


        for (num in int downTo 1) {
            var result = mutableSetOf<Int>()
            result.add(num)
            val rest = number - num*num

            if (rest == 1) {
                result.add(1)
            } else if (rest != 0){
                result.addAll(decompose(rest))
            }
            if (check(number, result.toTypedArray())) return result.toTypedArray()
        }
        return mutableSetOf<Int>().toTypedArray()

    }

    private fun check(expected: Int, arr: Array<Int>): Boolean{
        var sum = 0
        for (num in arr){
            sum += num*num
        }
        return expected == sum
    }
}
