package suanfa.com.alidb.hitsdb;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.alibaba.fastjson.JSON;

public class HttpWrite {

    private final static String HITSDB_IP = "192.168.11.17";  //实例地址
    private final static int HITSDB_PORT = 8242; //实例端口
    private final static int SYNC_TIMEOUT_MS = 60 * 1000;
    private Long startTime = System.currentTimeMillis();
    static String putUrl = "http://" + HITSDB_IP + ":" + HITSDB_PORT +
            "/api/put?sync_timeout=" + SYNC_TIMEOUT_MS;
    static String queryUrl = "http://" + HITSDB_IP + ":" + HITSDB_PORT +
            "/api/query";
    static class DataPoint {
        public String metric;
        public Long timestamp;
        public Double value;
        public Map<String, String> tags;
    }
    String buildData() {
        // 构造写入数据实体
        List<DataPoint> dataPoints = new ArrayList<DataPoint>();
        for (int i = 0; i < 3600; ++i) {
            DataPoint dataPoint = new DataPoint();
            dataPoint.metric = "sys.cpu";
            dataPoint.timestamp = startTime + i * 1000;
            dataPoint.value = 32.4;
            dataPoint.tags = new HashMap<String, String>();
            dataPoint.tags.put("host", "host1");
            dataPoint.tags.put("appName", "test1");
            dataPoints.add(dataPoint);
        }
        return JSON.toJSONString(dataPoints);
    }
    public void putDemo() throws ClientProtocolException, IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(putUrl);
        StringEntity eStringEntity = new StringEntity(buildData(), "utf-8");
        eStringEntity.setContentType("application/json");
        httpPost.setEntity(eStringEntity);
        HttpResponse response = httpClient.execute(httpPost);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200 || statusCode == 204) {
            System.out.println("write OK");
        }
        httpClient.close();
    }

}
