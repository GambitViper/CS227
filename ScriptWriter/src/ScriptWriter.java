import java.io.*;
import java.util.*;
public class ScriptWriter{
  public static final int BITS = 65536;
  public static void main(String args[]) throws IOException{
    BufferedWriter writer = new BufferedWriter(new FileWriter("test_script.txt"));
    int[] posWays = {1,2,4};
    for(int w = 0; w < 3; w++){
    int ways = posWays[w];
      for(int offset_bits = 2; offset_bits <= 9; offset_bits++){
    	for(int index_bits = 1; index_bits <= 14; index_bits++) {
            	String wastr = "wa"; //(wa == 0) ? "wa" : "wna";
            	if(Math.log(ways)/Math.log(2) + index_bits + offset_bits == 16) {
            		writer.write( ways + "\n" + index_bits + "\n" + offset_bits + "\n"+ wastr + "\n" + "wb\n\n");
            	}
    	}
//    	System.out.printf("blockSize: %d, ways: %d\n", blockSize, ways);
//        long index_bits = (long)(Math.log(BITS/(blockSize*ways))/Math.log(2));
//        long offset_bits = (long)(Math.log(blockSize)/Math.log(2));
        
      }
    }
    writer.close();
  }
}
