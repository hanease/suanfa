package suanfa.com.alidb.hitsdb;
import java.io.IOException;
import com.aliyun.hitsdb.client.TSDB;
import com.aliyun.hitsdb.client.TSDBClientFactory;
import com.aliyun.hitsdb.client.TSDBConfig;
import com.aliyun.hitsdb.client.value.request.Point;

public class TestWrite {
    public static void main(String[] args) throws InterruptedException, IOException {
        // 创建 TSDB 对象
        TSDBConfig config = TSDBConfig.address("example.hitsdb.com", 8242).config();
        TSDB tsdb = TSDBClientFactory.connect(config);
        // 构造数据并写入 TSDB
        for (int i = 0; i < 3600; i++) {
            Point point = Point.metric("test").tag("V", "1.0").value(System.currentTimeMillis(), 123.4567).build();
            Thread.sleep(1000);  // 1秒提交1次
            tsdb.put(point);
        }
        // 安全关闭客户端，以防数据丢失。
        System.out.println("关闭");
        tsdb.close();
    }
}
