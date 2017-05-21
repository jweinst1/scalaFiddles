//CFG generator example
//uses a primitive recursive function grammar to generate language
//gen contains all levels of functions

import scala.util.Random

object main {
  def main():Unit = {
    for(_ <- 1 to 10) println(gen.nounPhrase())
  }
}

object sample {
  //gets random element from array
  def arr[T](items:Array[T]):T = {
    items(Random.nextInt(items.length))
  }
}

//lowest level word bank
object words {
  val nouns:Array[String] = Array("apple", "ball", "banana", "pear", "red")
  val dets:Array[String] = Array("the", "a", "this", "that")
}

object gen {
  //top level recursive function
  def nounPhrase():String = Random.nextInt(4) match {
    case 0 => detNoun();
    case 1 => noun();
    case 2 => nounNom();
    case 3 => detNom();
  }
  
  //generates det and noun
  def detNoun():String = s"${sample.arr(words.dets)} ${sample.arr(words.nouns)}";
  
  //generates noun
  def noun():String = sample.arr(words.nouns);
  
  //recursive generation of nominal nouns
  def nounNom():String = Random.nextInt(2) match {
    case 0 => noun();
    case 1 => s"${noun()} ${nounNom()}";
  }
  //generats a detnoun or detnoun - noun recrusively
  def detNom():String = Random.nextInt(2) match {
    case 0 => detNoun();
    case 1 => s"${sample.arr(words.dets)} ${nounNom()}";
  }
}



main.main()
