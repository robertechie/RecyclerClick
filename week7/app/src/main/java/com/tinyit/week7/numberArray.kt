package com.tinyit.week7

fun rechanged(numb:Int):Int {
    var num2 = numb
    var reversed = 0
    while (num2 != 0 ) {
        val digit = num2 % 10
        reversed = reversed * 10 + digit
        num2 /= 10

    }

    return reversed
}


    fun main() {
        var numberArr = 348597
        print(rechanged(numberArr))

    }