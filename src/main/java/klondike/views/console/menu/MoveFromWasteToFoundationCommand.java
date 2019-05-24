package klondike.views.console.menu;

import klondike.controllers.Logic;
import klondike.models.Error;
import klondike.models.Suit;

public class MoveFromWasteToFoundationCommand extends Command {

    public MoveFromWasteToFoundationCommand(Logic logic) {
        super(CommandTitle.WASTE2FOUNDATION_COMMAND.getTitle(), logic);
    }

    @Override
    protected Error move() {
        Suit suit = SuitReader.read();
        return this.logic.moveFromWasteToFoundation(suit);
    }
}
