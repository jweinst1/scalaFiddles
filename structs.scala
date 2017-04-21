//struct simulaton


object Main {
  def main(args:Array[String]):Unit = {
    println(new foo(4, 3));
    println(new doo(false));
    val f = new foo(4, 3);
    println(f.v);
    //4
  }
}

//structs
class foo(val v:Int, val c:Byte);
class doo(val f:Boolean);

//acts as external constructor
object cons {
  def newfoo(v:Int, c:Byte) = new foo(v, c);
}


Main.main(Array());
