//vector and array example

object Main {
  def main(args:Array[String]):Unit = {
    //array usage
    var g = Array(1);
    println(g(0));
    g(0) = 4;
    println(g(0));
    //vector usage
    var d = Vector(8);
    d=d :+ 4;
    d = 4 +: d;
    println(d);
  }
}
/*1
4
Vector(4, 8, 4)*/



Main.main(Array());
