package org.apache.fineract.commands.command;

import java.io.Serial;
import lombok.Getter;
import lombok.Setter;
import org.apache.fineract.command.core.Command;
import org.apache.fineract.commands.data.DeleteMakerCheckerRequest;

@Getter
@Setter
public class DeleteMakerCheckerCommand extends Command<DeleteMakerCheckerRequest> {

    @Serial
    private static final long serialVersionUID = 1L;
}
