package chatbot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseClass {
    static String stageUrl = "http://esb-stage.vsk.ru:8501/cxf/rest/partners/insurance/v1/claims/settlementlossmobile/";
    static String testUrl = "http://esb-test01.vsk.ru:8181/cxf/rest/partners/insurance/v1/claims/settlementlossmobile/";
    public static final String paths = "src/test/java/chatbot/Examples/";
    public static Logger log = LoggerFactory.getLogger(UnitTests.class);
    private String arg = System.getProperty("arg", "stage");
    public String environment = arg;

    public static void pauseMethod(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
