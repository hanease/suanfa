package suanfa.com.mapreduce;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.io.Text;
import java.io.IOException;

public class HBaseWriteReducer extends TableReducer<Text, Put, ImmutableBytesWritable> {
    //将map传输过来的数据，写入到hbase表
    @Override
    protected void reduce(Text key, Iterable<Put> values, Context context) throws IOException, InterruptedException {
        //key 就是上边mapper阶段输出的rowkey
        ImmutableBytesWritable immutableBytesWritable = new ImmutableBytesWritable();
        immutableBytesWritable.set(key.toString().getBytes());

        //遍历put对象，并输出
        for(Put put: values) {
            context.write(immutableBytesWritable, put);
        }
    }
}
