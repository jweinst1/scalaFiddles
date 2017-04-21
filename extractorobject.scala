//extractor objects

object main {
  def main(args:Array[String]):Unit = {
    val fn = new func('+', 5);
    println(fn(3));
    val ofn = new func('-', 2);
    println(ofn(fn(3)));
    /*8 6*/
  }
}

//customizable object that can be called
class func(op:Char, value:Int) {
  def apply(other:Int):Int = op match {
    case '+' => other + value;
    case '-' => other - value;
    case '*' => other * value;
    case '/' => other / value;
    case _ => other;
  }
}

main.main(Array())
