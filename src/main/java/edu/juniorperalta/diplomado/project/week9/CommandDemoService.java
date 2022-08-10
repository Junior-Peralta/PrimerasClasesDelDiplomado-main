package edu.juniorperalta.diplomado.project.week9;

import edu.juniorperalta.diplomado.model.project.DemoResponse;
import edu.juniorperalta.diplomado.project.week9.command.CommandBus;
import edu.juniorperalta.diplomado.project.week9.model.CommandDemo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author aluis on 6/4/2022.
 */
@Service
@RequiredArgsConstructor
public class CommandDemoService {

    private final CommandBus commandBus;

    public String runDemo() {
        DemoResponse demoResponse = commandBus.sendCommand(new CommandDemo());
        return demoResponse.getResult();
    }
}
