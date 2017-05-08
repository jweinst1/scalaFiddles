//experimenting with abstract classes

object main {
  def main():Unit = {
    val g:Jungle = JungleInt(7);
    g match {
      case JungleInt(int) => println(s"$int");
      //7
    }
  }
}

abstract class Jungle {
  
  val ref:Boolean;
  
  def isLeaf():Boolean;
  
}

case class JungleInt(val value:Int) extends Jungle {
  val ref:Boolean = false;
  def isLeaf():Boolean = ref && true;
}

main.main();
