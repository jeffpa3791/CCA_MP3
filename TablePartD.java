import java.io.IOException;

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
import org.apache.hadoop.hbase.client.Get;


import org.apache.hadoop.hbase.util.Bytes;

public class TablePartD{

   public static void main(String[] args) throws IOException {
     
    HBaseConfiguration hconfig = new HBaseConfiguration(new Configuration());
    HTable powersTable = new HTable(hconfig, "powers"); 
    
    // for row 1, want all fields
    Get row1Get = new Get(Bytes.toBytes("row1"));
    // for row 19, we only want two fields
    Get row19Get = new Get(Bytes.toBytes("row19"));
    row19Get.addColumn(Bytes.toBytes("personal"),Bytes.toBytes("hero"));
    row19Get.addColumn(Bytes.toBytes("custom"),Bytes.toBytes("color"));
    
    Result row1Result = powersTable.get(row1Get);  
    Result row19Result = powersTable.get(row19Get);
    
    String row1Hero = Bytes.toString(row1Result.getValue(Bytes.toBytes("personal"),Bytes.toBytes("hero")));
    String row1Power = Bytes.toString(row1Result.getValue(Bytes.toBytes("personal"),Bytes.toBytes("power")));
    String row1Name = Bytes.toString(row1Result.getValue(Bytes.toBytes("professional"),Bytes.toBytes("name")));
    String row1XP = Bytes.toString(row1Result.getValue(Bytes.toBytes("professional"),Bytes.toBytes("xp")));
    String row1Color = Bytes.toString(row1Result.getValue(Bytes.toBytes("custom"),Bytes.toBytes("color")));

    String row19Hero = Bytes.toString(row19Result.getValue(Bytes.toBytes("personal"),Bytes.toBytes("hero")));
    String row19Color = Bytes.toString(row19Result.getValue(Bytes.toBytes("custom"),Bytes.toBytes("color")));

    System.out.println("hero:" + row1Hero);
    
    System.out.println("hero: " + row19Hero + ", color: " + row19Color);
    
    
    
    
   }
}

