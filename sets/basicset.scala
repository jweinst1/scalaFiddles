//Sets
//basic set examples


object Main {
  def main(args:Array[String]):Unit = {
    var f = Set("foo", "goo");
    f += "doo";
    val d = f;
    println(f("doo"));
    println(d + "soo");
    println(d ++ Set("dd "));
  }
}
/*true
Set(foo, goo, doo, soo)
Set(foo, goo, doo, dd )*/


Main.main(Array());
