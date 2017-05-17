//scala example of dealinhg with file channels

import java.nio.{ByteBuffer, LongBuffer, MappedByteBuffer}
import java.nio.channels.FileChannel
import java.io.RandomAccessFile


object main extends App {
  println("This is the Corplet System");
  val path = readLine("Corp> ");
  val file:FileChannel = new RandomAccessFile(path, "rwd").getChannel();
  val buf = ByteBuffer.allocate(243);
  //write byte and long section to file
  for(_ <- 1 to 8) buf.put((0).toByte);
  for(_<- 1 to 8) buf.putLong((0).toLong);
  file.write(buf);
  file.force(false);

  //create MappedByteBuffer for file chunk
  file.position((0).toLong);
  val mbuf:MappedByteBuffer = file.map(FileChannel.MapMode.READ_WRITE, 0, file.size());
  println(s"The file channel position is now ${file.position()}");
  for(_ <- 1 to 8) mbuf.put((6).toByte);
  //makes long buff view into mapped buffer
  val lbuf:LongBuffer = mbuf.asLongBuffer();
  for(_ <- 1 to 8) lbuf.put((5).toLong);
  mbuf.force();
  println("Mapped!");

  //re-read changed content
  buf.position(0);
  file.read(buf);
  //need to reset position after reading
  buf.position(0);
  for(_ <- 1 to 8) println(buf.get());
  for(_<- 1 to 8) println(buf.getLong());
  //close file
  file.close();
}
