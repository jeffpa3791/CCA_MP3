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

public class TablePartA{
  public static void main(String[] args) throws IOException
  {
    HTableDescriptor tPowers = new HTableDescriptor(“powers”); 
    tPowers.addFamily( new HColumnDescriptor(“personal”));
    tPowers.addFamily( new HColumnDescriptor(“professional”));
    tPowers.addFamily( new HColumnDescriptor(“custom”));

    HTableDescriptor tFood = new HTableDescriptor(“food”); 
    tFood.addFamily( new HColumnDescriptor(“nutrition”));
    tFood.addFamily( new HColumnDescriptor(“taste”));

    HBaseConfiguration hconfig = new HBaseConfiguration(new Configuration());
    HBaseAdmin hbase_admin = new HBaseAdmin( hconfig );

    hbase_admin.createTable( tPowers );
    System.out.println(“Created powers”);

    hbase_admin.createTable( tFood );
    System.out.println(“Created food”);
  }
}	
