//sentence chain selector
//non-weighted natural language generator

import scala.collection.mutable.HashMap
import scala.collection.mutable.Queue

object main {
  //using hash map with sets
  def main():Unit = {
    val bank = new LanguageBank();
    //arrays of sentences
    bank.insertSentence("I love apples");
    bank.insertSentence("I hate apples rotten");
    bank.insertSentence("I love berries");
    bank.insertSentence("I hate blue berries");
    bank.insertSentence("I love apples too");
    bank.insertSentence("I don't like apples");
    bank.insertSentence("I don't love pees");
    bank.insertSentence("I can't love bees");
    bank.insertSentence("I never hate apples");
    1 to 20 foreach {_ => println(bank.genSentence(3))}
  }
}

object SetTools {
  //randomly selects element from a set
  def random[T](s: Set[T]): T = {
    val n = util.Random.nextInt(s.size)
    s.iterator.drop(n).next
  }
}

class LanguageBank() {
  var wordChain:HashMap[String, Set[String]] = HashMap();
  var startWords:Set[String] = Set();
  //method to insert sentences into the bank
  def insertSentence(sent:String):Unit = {
    val words = sent.split(" ")
    if(words.length != 0){
      startWords += words(0);
      for(i <- 0 until words.length-1){
        if(wordChain.contains(words(i))) {
          wordChain(words(i)) += words(i+1);
        }
        else wordChain(words(i)) = Set(words(i+1))
      }
    }
  }
  
  def genSentence(len:Int):String = {
    var sent:Queue[String] = new Queue();
    var curWord:String = SetTools.random(startWords);
    sent += curWord;
    for(_ <- 1 to len-1){
      curWord = SetTools.random(wordChain(curWord));
      sent += curWord
    }
    return sent.mkString(" ");
  }
}


main.main();
