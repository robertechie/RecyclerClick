package com.tinyit.recyclerclick

fun Vowels(words: String): String {
    var output = ""
    for (ch in words) {
        if (ch != 'A' && ch != 'a'
            && ch != 'E' && ch != 'e'
            && ch != 'I' && ch != 'i'
            && ch != 'O' && ch != 'o'
            && ch != 'U' && ch != 'u') {
            output +=ch
        }
    }
    return output.toString()
}

fun main() {
    println(Vowels("Good girl turn bad"))
}