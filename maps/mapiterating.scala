//example of maps being looped and updated

object Main {
  def main(args:Array[String]):Unit = {
    val strs = Array("a", "b", "c");
    for (elem <- strs){
      cont.addPair(elem, "World");
    }
    for (key <- cont.map.keys){
      println(s"${key} -> ${cont.map(key)}");
    }
  }
}

object cont {
  var map = Map("hello" -> "world");
  def addPair(k:String, v:String) = map += (k -> v);
}



Main.main(Array());
