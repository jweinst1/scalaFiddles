//trie int-index examples

object Main {
  def main(args:Array[String]):Unit = {
    println(-40 / 60);
  }
}

abstract class Trie;

class Arr extends Trie{
  val items:Array[Trie] = Array.fill(30){new None};
  
  def apply(index:Int):Trie = {
    val place = index / 30
    if(place == 0) items(index);
    else items(place) match {
      case Arr(lst) => lst.apply(index);
      case Value(v) => v;
      case None => new None;
    }
  }
}

class Value(val num:Int = 0) extends Trie;

//place holder for a nil value
class None extends Trie;


Main.main(Array());
