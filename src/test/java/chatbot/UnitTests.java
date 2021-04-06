package chatbot;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

public class UnitTests extends Template {

    @BeforeEach
    public void executedBeforeEach(TestInfo testInfo) {
        log.info("Starting test: "+ testInfo.getDisplayName());
    }

    @AfterEach
    public void executedAfterEach() {
        log.info("End test\n");
    }



    @Test
    public void CreateNewApplication() throws Exception {
        String logs = testCase(environment, "createAplication.json");
       assertThat(logs, containsString("Inbound Message"));
       assertThat(logs, containsString("FrontClaimsSettlementLossMobileService: 'CreateNewApplication' REST calling"));//еще запрос в xml
       assertThat(logs, containsString("AdapterOISUU: 'CreateNewApplication' calling 'OISUU'"));
       assertThat(logs, containsString("{operationName=CreateNewApplication}"));
       assertThat(logs, containsString("AdapterOISUU: 'CreateNewApplication' response 'OISUU'"));
       assertThat(logs, containsString("AdapterOISUU: response after 'CreateNewApplication' is"));
    }

    @Test
    public void UpdateApplication() throws Exception {
        String logs = testCase(environment, "updateApplication.json");
        assertThat(logs, containsString("Inbound Message"));
        assertThat(logs, containsString("FrontClaimsSettlementLossMobileService: 'UpdateApplication' REST calling"));
        assertThat(logs, containsString("AdapterOISUU: call 'OISUU' service operation 'UpdateApplication'"));//еще запрос в xml
        assertThat(logs, containsString("AdapterOISUU: 'UpdateApplication' calling 'OISUU'"));
        assertThat(logs, containsString("{operationName=UpdateApplication}"));
        assertThat(logs, containsString("AdapterOISUU: 'UpdateApplication' response 'OISUU'"));
        assertThat(logs, containsString("AdapterOISUU: response after 'UpdateApplication' is"));
        assertThat(logs, containsString("FrontClaimsSettlementLossMobileService: 'UpdateApplication' REST operation complete"));
    }

    @Test
    public void GetClaimAsynchron() throws Exception {
        String logs = testCase(environment, "getClaimAsynchron.json");
        assertThat(logs, containsString("Inbound Message"));
        assertThat(logs, containsString("FrontClaimsSettlementLossMobileService: 'GetClaimAsynchron' REST calling"));
        assertThat(logs, containsString("AdapterOISUU: call 'OISUU' service operation 'GetClaimAsynchron'"));//еще запрос в xml
        assertThat(logs, containsString("AdapterOISUU: 'GetClaimAsynchron' calling 'OISUU'"));
        assertThat(logs, containsString("{operationName=GetClaimAsynchron}"));
        assertThat(logs, containsString("AdapterOISUU: 'GetClaimAsynchron' response 'OISUU'"));
        assertThat(logs, containsString("AdapterOISUU: response after 'GetClaimAsynchron' is"));
        assertThat(logs, containsString("FrontClaimsSettlementLossMobileService: 'GetClaimAsynchron' REST operation complete"));
    }

    @Test
    public void FindPoint() throws Exception {
        String logs = testCase(environment, "findPoint.json");
        assertThat(logs, containsString("Inbound Message"));
        assertThat(logs, containsString("FrontClaimsSettlementLossMobileService: 'FindPoint' REST calling"));
        assertThat(logs, containsString("AdapterOISUU: call 'OISUU' service operation 'FindPoint'"));//еще запрос в xml
        assertThat(logs, containsString("AdapterOISUU: 'FindPoint' calling 'OISUU'"));
        assertThat(logs, containsString("{operationName=FindPoint}"));
        assertThat(logs, containsString("AdapterOISUU: 'FindPoint' response 'OISUU'"));
        assertThat(logs, containsString("AdapterOISUU: response after 'FindPoint' is"));
        assertThat(logs, containsString("FrontClaimsSettlementLossMobileService: 'FindPoint' REST operation complete"));
    }

    @Test
    public void ChangeServiceStation() throws Exception {
        String logs = testCase(environment, "changeServiceStation.json");
        assertThat(logs, containsString("Inbound Message"));
        assertThat(logs, containsString("FrontClaimsSettlementLossMobileService: 'ChangeServiceStation' REST calling"));
        assertThat(logs, containsString("AdapterOISUU: call 'OISUU' service operation 'ChangeServiceStation'"));//еще запрос в xml
        assertThat(logs, containsString("AdapterOISUU: 'ChangeServiceStation' calling 'OISUU'"));
        assertThat(logs, containsString("{operationName=ChangeServiceStation}"));
        assertThat(logs, containsString("AdapterOISUU: 'ChangeServiceStation' response 'OISUU'"));
        assertThat(logs, containsString("AdapterOISUU: response after 'ChangeServiceStation' is"));
        assertThat(logs, containsString("FrontClaimsSettlementLossMobileService: 'ChangeServiceStation' REST operation complete"));
    }


}
