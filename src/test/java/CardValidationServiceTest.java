
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.SpringRestPactRunner;

import com.mastercard.samples.configuration.ApplicationConfig;
import com.mastercard.samples.controllers.CardValidationController;
import com.mastercard.samples.model.Card;
import com.mastercard.samples.services.CardValidationService;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.http.ResponseEntity.ok;

@RunWith(SpringRestPactRunner.class)
@PactBroker(host = "localhost", port = "8081")
@Provider("CardValidationService")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = { ApplicationConfig.class, CardValidationController.class })
@EnableAutoConfiguration
public class CardValidationServiceTest {

    private static final Card TEST_CARD = new Card("Batman", 5455031500000173L, true);

    @TestTarget
    public final Target target = new HttpTarget(8090);

    @MockBean
    private CardValidationService cardValidationService;

    @State("normal card")
    public void normalCard() {

        when(cardValidationService.getValidationResult(anyLong())).thenReturn(ok(TEST_CARD));
    }
}
