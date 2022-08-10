package edu.juniorperalta.diplomado.project.week9.model;

import edu.juniorperalta.diplomado.model.project.DemoResponse;
import edu.juniorperalta.diplomado.project.week9.command.Command;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommandDemo extends Command<DemoResponse> {

    private String id;
}
