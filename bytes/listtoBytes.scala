//serialize Scala List to binary format

import java.nio.ByteBuffer

object main  {
  def main():Unit = {
    println(Lyte.makeBytes(List(1, true, 'f')).mkString(","));
  }
}

//functions to turn scala List to array of bytes
object Lyte {
  /**
    * Makes a List into Array[Bytes]
    * The ByteCode is as follows
    * 0 Boolean
    * 1 Byte
    * 2 Int
    * 3 Char
    * 4 Short
    * 5 Long
    * 6 Float
    * 7 Double
    */
  def makeBytes(lst:List[Any]):Array[Byte] = {
    var size = 1;
    for(e <- lst) e match {
      case _:Int => size += 5;
      case _:Boolean => size += 2;
      case _:Byte => size += 2;
      case _:Char => size += 3;
      case _:Short => size += 3;
      case _:Long => size += 9;
      case _:Float => size += 9;
      case _:Double => size += 9;
    }
    val bytes = ByteBuffer.allocate(size);
    bytes.put((44).toByte);
    
    for(n <- lst) n match {
      case a:Int => bytes.put((2).toByte); bytes.putInt(a);
      case a:Boolean => bytes.put((0).toByte); if(a) bytes.put((1).toByte) else bytes.put((0).toByte);
      case a:Byte => bytes.put((1).toByte); bytes.put(a);
      case a:Char => bytes.put((3).toByte); bytes.putChar(a);
      case a:Short => bytes.put((4).toByte); bytes.putShort(a);
      case a:Long => bytes.put((5).toByte); bytes.putLong(a);
      case a:Float => bytes.put((6).toByte); bytes.putFloat(a);
      case a:Double => bytes.put((7).toByte); bytes.putDouble(a);      
    }
    bytes.array();
  }
}

main.main();
