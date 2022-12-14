package edu.juniorperalta.diplomado.project.week10;

import edu.juniorperalta.diplomado.model.project.Demo;
import edu.juniorperalta.diplomado.model.project.DemoResponse;
import edu.juniorperalta.diplomado.project.week10.saga.SagaFactory;
import edu.juniorperalta.diplomado.project.week10.saga.SagaOrchestrator;
import edu.juniorperalta.diplomado.project.week10.saga.model.Saga;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author aluis on 6/4/2022.
 */
@Service
@RequiredArgsConstructor
public class SagaDemoService {

    private static final int TIMEOUT = 60;

    private final SagaOrchestrator sagaOrchestrator;

    public String runDemo() {
        Demo demo = Demo.builder().id(UUID.randomUUID().toString()).build();
        Saga<DemoResponse> saga = SagaFactory.createDemoSaga("RandomID to identify saga", demo);
        DemoResponse demoResponse = sagaOrchestrator.orchestrate(saga, TIMEOUT);
        return demoResponse.getResult();
    }
}
