package com.tinyit.contact

fun main(){
    println(inLove(4, 4))
    println(inLove(11, 3))
    println(inLove(22, 17))
}
fun inLove(flower1:Int, flower2:Int): Boolean{
    return flower1 % 2 !== flower2 % 2;
}

;l