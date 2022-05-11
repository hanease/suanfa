package suanfa.com.mapreduce;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.mapreduce.Reducer;

import javax.xml.soap.Text;
import java.io.IOException;


public class HbaseReducer extends TableReducer<Text, Text, ImmutableBytesWritable> {

    /*@Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
　　　　String k = key.toString();
　　　　StringBuilder sb = new StringBuilder();
　　　　for (Text value : values) {
　　　　　　sb.append(value.toString()).append(",");
　　　　}
　　　　if (sb.length() > 0) {
　　　　　　sb.deleteCharAt(sb.length() - 1);
　　　　}
　　　　// rowkey
　　　　Put put = new Put(k.getBytes());
　　　　put.addColumn("cf1".getBytes(), "name".getBytes(), sb.toString().getBytes());
　　}*/

}
