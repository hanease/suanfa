package suanfa.com.mapreduce;
import com.wenbronk.hbase.mapreduce.ReducerClass;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;

import java.io.IOException;

public class JobTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration config = new Configuration();
        config.set("fs.defaultFS", "hdfs://192.168.208.106:8020");
        config.set("yarn.resourcemanager.hostname", "192.168.208.106");
        config.set("mapred.job.tracker", "192.168.208.106:9001");
        config.set("ha.zookeeper.quorum", "192.168.208.106,192.168.208.107,192.168.208.108");

        Job job = new Job(config, "Hbase");
        job.setJarByClass(JobTest.class);

        FileSystem fileSystem = FileSystem.get(config);
        Path inPath = new Path("/usr/test/test.txt");
        job.setInputFormatClass(TextInputFormat.class);

        job.setMapperClass(HbaseMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        TableMapReduceUtil.initTableReducerJob("t_user", ReducerClass.class, job, null, null, null, null, false);

        boolean b = job.waitForCompletion(true);
        if (b) {
            System.out.println("mapreduce 执行成功");
        }


    }
}
}
