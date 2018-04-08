import java.io.IOException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;

import org.apache.hadoop.hbase.TableName;

import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;

import org.apache.hadoop.hbase.util.Bytes;

public class TablePartC{

   public static void main(String[] args) throws IOException {
     
    HBaseConfiguration hconfig = new HBaseConfiguration(new Configuration());
    HTable powersTable = new HTable(hconfig, "powers"); 

    String fileName = "input.csv";  // assumed to be present in same directory
    String line = null;
    try {
      FileReader fileReader = new FileReader(fileName);
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      while((line = bufferedReader.readLine()) != null) {
        // System.out.println(line); used during testing
        String [] fields = line.split(",");
        
        // create a Put object for the line
        Put powersPut = new Put(Bytes.toBytes(fields[0]));  // key
        powersPut.add(Bytes.toBytes("personal"), Bytes.toBytes("hero"),Bytes.toBytes(fields[1]));
        powersPut.add(Bytes.toBytes("personal"), Bytes.toBytes("power"),Bytes.toBytes(fields[2]));
        powersPut.add(Bytes.toBytes("professional"), Bytes.toBytes("name"),Bytes.toBytes(fields[3]));
        powersPut.add(Bytes.toBytes("professional"), Bytes.toBytes("xp"),Bytes.toBytes(fields[4]));
        powersPut.add(Bytes.toBytes("custom"), Bytes.toBytes("color"),Bytes.toBytes(fields[5]));
        
        // put the data out to the table
        powersTable.put(powersPut);
        
        
      }   
      bufferedReader.close();         
    }
    catch(FileNotFoundException ex) {
      System.out.println("Unable to open file '" + fileName + "'");                
    }
    catch(IOException ex) {
      System.out.println("Error reading file '" + fileName + "'"); 
    }
    
    
    
    
   }
}

