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

import org.apache.hadoop.hbase.util.Bytes;

public class TablePartE{

   public static void main(String[] args) throws IOException {
     
    HBaseConfiguration hconfig = new HBaseConfiguration(new Configuration());
    HTable powersTable = new HTable(hconfig, "powers"); 
    
    Scan scan = new Scan();
    // just get all data, no need to populate scanner
    ResultScanner scanner = table.getScanner(scan);
    for (Result r: scanner) {
      System.out.println(r);  
    }
    
   }
}

