//sentence chain selector
//non-weighted natural language generator

import scala.collection.mutable.HashMap

object main {
  //using hash map with sets
  def main():Unit = {
    var test:HashMap[String, Set[String]] = HashMap();
    test("a") = Set("fair", "street");
    println(test("a")("fair"))
  }
}


main.main();
