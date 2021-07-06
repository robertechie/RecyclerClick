fun main(){
    var n:Int = 1
while(n<=100){
    when{
        n%3 == 0 && n%5 == 0 -> println("FizzBuzz")
        n%3 == 0 -> println("Fizz")
        n%5 == 0 -> println("Buzz")
        else -> println(n)
    }
    n++
}
    //print("Robert you are a good boy".reversed().toString()), the short form
   println(reverseString("Good food"))

}

fun reverseString(words:String):String{
    var theString =""
    var contentReverse: CharArray = words.toCharArray()
    var countn = contentReverse.count()-1

    while(countn>=0){
        theString+=contentReverse[countn]
        countn--
    }

    return theString
}