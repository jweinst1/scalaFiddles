//bytebuffer experiment
//shows how views of buffers can be combined for
//very effecient io

import java.nio.ByteBuffer
import java.nio.IntBuffer

object main {
  def main():Unit = {
    val g = ByteBuffer.allocate(8);
    //check position
    println(g.position())
    //0
    g.put(bytes._0);
    g.put(bytes._1);
    g.put(bytes._2);
    g.put(bytes._3);
    println(g.position())
    //4
    g.put(bytes.sample)
    g.position(4);
    val ints:IntBuffer = g.asIntBuffer();
    println(ints.get());
    //56
    println(ints.position())
    //rewrite in other buffer
    ints.position(0)
    ints.put(4);
    println(g.getInt());
    //4
  }
}

//static collection of pre-casted bytes
object bytes {
  val _0:Byte = 0
  val _1:Byte = 1
  val _2:Byte = 2
  val _3:Byte = 3
  val sample:Array[Byte] = Array(0, 0, 0, 56);
}



main.main()
