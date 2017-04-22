//list of pairs
//overloads toString

object main {
  def main(args:Array[String]):Unit ={
    var foo = new PairList();
    foo.addPair('c', 4);
    foo.addPair('g', 3);
    println(foo);
    //[(g, 3)(c, 4)]
  }
}

case class Pair(val key:Char, val value:Int);

class PairList {
  var lst:List[Pair] = List()
  override def toString: String = {
    var str = "[";
    for(elem <- lst) str += s"(${elem.key}, ${elem.value})";
    return str + "]";
  }
  //adds one pair
  def addPair(k:Char, i:Int) = lst = Pair(k, i) :: lst;
  
}

main.main(Array());
