//Sentence Templating
//This example creates a system of sentence templating

object main {
  def main():Unit = {
    Ops.storeSentence("I love cats");
    Ops.storeSentence("I love dogs");
    Ops.storeSentence("I hate dogs");
    Ops.storeSentence("I like flowers");
    Ops.storeSentence("I love dogs");
    Ops.storeSentence("I have flowers");
    Ops.storeSentence("I love dogs");
    Ops.storeSentence("The dog sings");
    for(_ <- 1 to 10) println(Ops.genSentence());
  }
}


object Ops {
  //chops a sentence into templates and stores them.
  def storeSentence(sent:String):Unit = {
    var words:Array[String] = sent.split(" ")
    var hold:String = ""
    for(i <- 1 until words.length){
      Storage.words += words(i);
      hold = words(i);
      words(i) = "\0";
      Storage.templates += words.clone;
      words(i) = hold;
    }
  }
  
  //generates a sentence from templates
  def genSentence():String = {
    var pick:Array[String] = SetTools.random(Storage.templates);
    for(i <- 0 until pick.length) {
      if(pick(i) == "\0") pick(i) = SetTools.random(Storage.words);
    }
    pick.mkString(" ");
  }
}


object Storage {
  //storing the main set of all words
  //ignores start words for better quality
  var words:Set[String] = Set()
  
  //stores all templates
  //._1 => structure 
  var templates:Set[Array[String]] = Set()
}

object SetTools {
  //randomly selects element from a string set
  def random[T](s: Set[T]): T = {
    val n = util.Random.nextInt(s.size)
    s.iterator.drop(n).next
  }
}


main.main()
