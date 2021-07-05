package subtask1

class Combinator {


    fun checkChooseFromArray(array: Array<Int>): Int? {
        val postersNum = array[0]
        val colorsNum = array[1]
        var combinations: Int? = null

        val triangle = pascalTriangle(colorsNum)

        for (index in triangle[colorsNum].indices){
            if (triangle[colorsNum][index] == postersNum){
                return index
            }
        }

        return combinations
    }

    private fun pascalTriangle(size: Int): Array<Array<Int>>{
        var triangle = mutableListOf<Array<Int>>()
        triangle.add(arrayOf(1))
        triangle.add(arrayOf(1,1))
        for (index in 2..size){
            triangle.add(x(triangle[index-1]) )
        }
        return triangle.toTypedArray()
    }

    private fun x(array: Array<Int>): Array<Int>{
        val list = mutableListOf<Int>()
        list.add(1)
        for (index in 1..array.lastIndex){
            val sum = array[index-1] + array[index]
            list.add(sum)
        }
        list.add(1)
        return list.toTypedArray()
    }
}
