package chatbot;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Kibana {
    public static String searchByCID(String environment, String cid) {
        Logger log = LoggerFactory.getLogger(UnitTests.class);
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        String result = "";
        String urlKibanaSearch ="";
        switch (environment){
            case "stage":
                urlKibanaSearch = "esb-stage";
                break;
            case "test":
                urlKibanaSearch = "esb-test";
                break;
        }
        try {
            Date today = Calendar.getInstance().getTime();
            String newstring = new SimpleDateFormat("yyyy.MM.dd").format(today);
            String url = "http://elog.vsk.ru:9200/" + urlKibanaSearch + "-" + newstring + "/_search?q=%20message:%20%22" + cid + "%22%20&size=500";
            log.info("URL is : " + url);
            HttpGet request = new HttpGet(url);
            request.addHeader("content-type", "application/json");
            request.addHeader("Accept", "application/json");
            HttpResponse response = httpClient.execute(request);
            String responseBody = EntityUtils.toString(response.getEntity());
            result = responseBody;
            log.info("Response message : " + responseBody);
        } catch (Exception ex) {
            log.error("!!!!!!!!!!!!!!!!!!!!Something goes wrong!!!!!!!!!!!!!!!!!!!!");
        }
        return result;
    }
}
