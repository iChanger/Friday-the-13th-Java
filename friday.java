/*
ID: ichangs1
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.*;

class friday {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("friday.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer st = new StringTokenizer(f.readLine());
                          // Get line, break into tokens
    int i1 = Integer.parseInt(st.nextToken());    // first integer
    int year = 1900 + i1;
    int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int[] leapmonths = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int[] day13th = new int[]{0, 0, 0, 0, 0, 0, 0};
    int weekCount = 2; //The increment goes backwards. Monday starts at 0, Sunday starts at 1, Saturday starts at 2, ...
    //Order: 31, 28/29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    for( int i = 1900; i < year; i++){
        if (i % 100 == 0){
            if (i % 400 == 0){
                for(int minc = 0; minc < 12; minc++){
               int day = 1;
               for(int a = 0; a < (leapmonths[minc]); a++){
                   if( day == 13){
                       int weekday = weekCount % 7;
                       day13th[weekday] += 1;
                    }
                   day++;  
                   weekCount++;
                }
           }
            }
            else {
               for(int minc = 0; minc < 12; minc++){
               int day = 1;
               for(int a = 0; a < (months[minc]); a++){
                   if( day == 13){
                       int weekday = weekCount % 7;
                       day13th[weekday] += 1;
                    }
                   day++;  
                   weekCount++;
                }
            }
            }
        }
        else if (i % 4 == 0){
            for(int minc = 0; minc < 12; minc++){
               int day = 1;
               for(int a = 0; a < (leapmonths[minc]); a++){
                   if( day == 13){
                       int weekday = weekCount % 7;
                       day13th[weekday] += 1;
                    }
                   day++;  
                   weekCount++;
                }
           }
        }
           
        
        else {
            // 0 - Monday
           for(int minc = 0; minc < 12; minc++){
               int day = 1;
               for(int a = 0; a < (months[minc]); a++){
                   if( day == 13){
                       int weekday = weekCount % 7;
                       day13th[weekday] += 1;
                    }
                   day++;  
                   weekCount++;
                }
            }
        }
    
    }
    
    int e = 1;
    for (Integer line : day13th){
        if (e++ == day13th.length){
        out.print(line);
        out.format("%n"); // End in new line
        }
        
         else {
        out.print(line);
        out.print(" ");
        }
    }
    out.close();                                  // close the output file
}
 
    
}
