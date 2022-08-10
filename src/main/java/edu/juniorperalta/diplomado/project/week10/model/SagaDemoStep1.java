package edu.juniorperalta.diplomado.project.week10.model;

import edu.juniorperalta.diplomado.model.project.DemoResponse;
import edu.juniorperalta.diplomado.project.week10.saga.model.SagaStep;
import edu.juniorperalta.diplomado.project.week10.saga.model.SagaStepCompensator;
import edu.juniorperalta.diplomado.project.week10.saga.model.SagaStepHandler;
import org.springframework.stereotype.Component;

@Component
public class SagaDemoStep1 implements SagaStep<DemoResponse> {

    @Override
    public String getName() {
        return "Saga Step 1";
    }

    @Override
    public SagaStepHandler<DemoResponse> getHandler() {
        return sagaPayload -> {
            // Create object or something
            System.out.println("Running Handler Step 1");
            sagaPayload.setResult(DemoResponse.builder().build());
        };
    }

    @Override
    public SagaStepCompensator<DemoResponse> getCompensator() {
        return sagaPayload -> {
            // delete objects created
            System.out.println("Running Compensator Step 1");
        };
    }
}
