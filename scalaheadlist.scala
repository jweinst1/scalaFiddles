//using head of scala List to return new longer lists via methods on a singleton


object Main {
  def main(args:Array[String]):Unit = {
    println(make.plusOne(List(1)));
    println(make.select('+', List(5)));
  }
}


//list manipulation methods
object make {
  def plusOne(lst:List[Int]):List[Int] = lst.head + 1 :: lst;
  def minusOne(lst:List[Int]):List[Int] = lst.head - 1 :: lst;
  def timesOne(lst:List[Int]):List[Int] = lst.head * 1 :: lst;
  //selects method with match statement
  def select(sym:Char, lst:List[Int]):List[Int] = sym match {
    case '+' => plusOne(lst);
    case '-' => minusOne(lst);
    case '*' => timesOne(lst);
    case _ => lst;
  }
}



Main.main(Array())
