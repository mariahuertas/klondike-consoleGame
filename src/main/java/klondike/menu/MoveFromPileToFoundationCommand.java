package klondike.menu;

import klondike.Error;
import klondike.Game;
import klondike.Pile;
import klondike.Suit;

public class MoveFromPileToFoundationCommand extends Command {

    public MoveFromPileToFoundationCommand(Game game) {
        super(CommandTitle.PILE2FOUNDATION_COMMAND.getTitle(), game);
    }

    @Override
    protected Error move() {
        int pileIndex = Pile.readIndex(true);
        Suit suit = Suit.read();
        return this.game.moveFromPileToFoundation(pileIndex, suit);
    }
}