package chatbot;


import static chatbot.Kibana.searchByCID;

public class Template extends Requests {
    public static String testCase(String environment, String fileName) throws Exception {
        String CID = request(environment, fileName);

        pauseMethod(60000);
        String logs = searchByCID(environment, CID);
        System.out.println(logs);
        return logs;
    }
}
