//String parsing with lists
//function approach
object main {
  def main():Unit = {
    val a = CharCat();
    a('c')
    a('8')
    println(a);
    println(Split.untilChar('d', "hlldoo".toList))
    //StrPair(llh,List(o, o))
  }
}

//class to allow char concatenation
case class CharCat(){
  var clst:List[Char] = List();
  
  
  def apply(c:Char):Unit = {
    clst = c :: clst;
  }
  
  override def toString: String = clst.mkString;
}

case class StrPair(val data:String, val other:List[Char]); 

object Convert {
  //creates a reversed list of chars
  def toRevList(input:String):List[Char] = {
    var ls:List[Char] = List();
    for( i <- 0 to input.length-1) ls = input(i) :: ls;
    ls;
  }
}

//functions to split char lists
object Split {
  def untilChar(c:Char, clst:List[Char]):StrPair = {
    val cat = CharCat();
    var pnt:List[Char] = clst;
    while(pnt != Nil){
      if(pnt.head == c) return StrPair(cat.toString, pnt.tail);
      else {
        cat(pnt.head);
        pnt = pnt.tail;
      }
    }
    return StrPair(cat.toString, List());
  }
}


main.main();
