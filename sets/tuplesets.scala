//tuple set example

object main {
  def main():Unit = {
    //example with sets of string tuples
    val f = Set(("The", "Apple"), ("The", "Pear"), ("Red", "Apple"));
    println(StrPair.filterFirst("The", f));
  }
}

object StrPair {
  //yields new set of strings
  def filterFirst(tag:String, items:Set[(String, String)]):Set[String] = {
    for(elem <- items if elem._1 == tag) yield elem._2
  }
}



main.main()
