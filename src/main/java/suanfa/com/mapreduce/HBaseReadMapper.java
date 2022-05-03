package suanfa.com.mapreduce;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapper;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.Text;

import java.io.IOException;

public class HBaseReadMapper extends TableMapper<Text, Put>{
    /**
     * @param key     rowKey
     * @param value   rowKey此行的数据 Result类型
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void map(ImmutableBytesWritable key, Result value, Context context) throws IOException, InterruptedException {
        // 获得rowKey的字节数组
        byte[] rowKeyBytes = key.get();
        String rowKeyStr = Bytes.toString(rowKeyBytes);
        Text text = new Text(rowKeyStr);

        Put put = new Put(rowKeyBytes);
        // 获取一行中所有的Cell对象
        Cell[] cells = value.rawCells();
        for (Cell cell : cells) {
            //列族
            byte[] familyBytes = CellUtil.cloneFamily(cell);
            String familyStr = Bytes.toString(familyBytes);
            //当前cell是否是info1
            if ("info1".equals(familyStr)) {
                //在判断是否是name | age
                byte[] qualifier_bytes = CellUtil.cloneQualifier(cell);
                String qualifierStr = Bytes.toString(qualifier_bytes);
                if ("name".equals(qualifierStr) || "age".equals(qualifierStr)) {
                    put.add(cell);
                }
            }
        }

        // 判断是否为空；不为空，才输出
        if (!put.isEmpty()) {
            context.write(text, put);
        }
    }

}
