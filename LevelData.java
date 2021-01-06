import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

public class LevelData {
    static String Lvl = "1";
   static String [][] Level = {{"NormalZombie","ConeHeadZombie"},{"NormalZombie","ConeHeadZombie", "BucketHeadZombie"}};
   static int [][][] LevelValue = {{{0, 49}, {50, 99}},{{0, 33},{34, 67}, {68, 99}}} ;
   public LevelData() {
       try {
           File f = new File("Level.vbhv");
           
           if(!f.exists()) {
               BufferedWriter bwr = new BufferedWriter(new FileWriter(f));
               bwr.write("1");
               bwr.close();
               Lvl = "1";
           } else {
               BufferedReader br = new BufferedReader(new FileReader(f));
               Lvl = br.readLine();
           }
       } catch (Exception ex) {
           
           
       }
   }
   public static void write(String lvl) {
       File f = new File("Level.vbhv");
        try {
            BufferedWriter bwr = new BufferedWriter(new FileWriter(f));
            bwr.write(lvl);
            bwr.close();
            Lvl = lvl;
        } catch (IOException ex) {
            Logger.getLogger(LevelData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
               
   }
}
