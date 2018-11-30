import java.io.*;
import java.util.*;
public class ScriptWriter{
  public static final int BITS = 65536;
  public static void main(String args[]) throws IOException{
    BufferedWriter writer = new BufferedWriter(new FileWriter("test_script.txt"));
    int[] posWays = {1,2,4};
    for(int w = 0; w < 3; w++){
    int ways = posWays[w];
      for(int blockSize = 2; blockSize <= BITS; blockSize = blockSize*blockSize){
        int index_bits = (int)(Math.log(BITS/(blockSize*ways))/Math.log(2));
        int offset_bits = (int)(Math.log(blockSize)/Math.log(2));
        for(int wa = 0; wa < 2; wa++){
            writer.write( ways + "\n" + index_bits + "\n" + offset_bits + "\n"+ wa + "\n" + "wt\n\n");
        }
      }
    }
    writer.close();
  }
}
