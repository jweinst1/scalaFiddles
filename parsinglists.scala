//works by turning a String to a List

object main {
  def main(args:Array[String]):Unit = {
    println(CharLst.strToLst("foo"))
    
    val test = CharLst.strToLst("1234");
    //can fuse chars together
    println(test.mkString);
    println(CharLst.getFirst(test));
    println(CharLst.restToStr(test));
  }
}

object CharLst {
  //turns str to lst of chars
  def strToLst(input:String):List[Char] = {
    var ls:List[Char] = List();
    for(i <- (0 to input.length-1).reverse) ls = input(i) :: ls;
    ls;
  }
  //gets char at head
  def getFirst(input:List[Char]):Char = input.head;
  //makes tail to string
  def restToStr(input:List[Char]):String = input.tail.mkString;
}

main.main(Array());
