package klondike;

import klondike.utils.IO;

public class Klondike {

    private Game game;

    private Klondike() {
        game = new Game();
    }

    public static void main(String[] args) {
        new Klondike().play();
    }

    public void play() {
        boolean finished;
        do {
            game.writeln();
            this.move();
            finished = game.isFinished();
        } while (!finished);
    }

    private void move() {
        int chosenMove = this.readMove();
        Suit suit;
        int pileIndex;
        switch (chosenMove) {
            case 1:
                this.game.moveFromStockToWaste();
                break;
            case 2:
                this.game.moveFromWasteToStock();
                break;
            case 3:
                suit = readSuit();
                this.game.moveFromWasteToFoundation(suit);
                break;
            case 4:
                pileIndex = readPileIndex(false);
                this.game.moveFromWasteToPile(pileIndex);
                break;
            case 5:
                suit = readSuit();
                pileIndex = readPileIndex(false);
                this.game.moveFromFoundationToPile(suit, pileIndex);
                break;
            case 6:
                pileIndex = readPileIndex(true);
                suit = readSuit();
                this.game.moveFromPileToFoundation(pileIndex, suit);
                break;
            case 7:
                int originIndex = readPileIndex(true);
                int destinationIndex = readPileIndex(false);
                int numberOfCards = readNumberOfCards();
                this.game.moveFromPileToPile(originIndex, destinationIndex, numberOfCards);
                break;
            default:
                break;
        }
    }

    private int readMove() {
        IO.writeln("1. klondike.Stock to klondike.Waste");
        IO.writeln("2. klondike.Waste to klondike.Stock");
        IO.writeln("3. klondike.Waste to klondike.Foundation");
        IO.writeln("4. klondike.Waste to klondike.Pile");
        IO.writeln("5. klondike.Foundation to klondike.Pile");
        IO.writeln("6. klondike.Pile to klondike.Foundation");
        IO.writeln("7. klondike.Pile to klondike.Pile");
        return IO.readPositiveInt("Choose an option: ");
    }

    private int readNumberOfCards() {
        return IO.readPositiveInt("How many cards do you want to move?: ");
    }

    private int readPileIndex(boolean isOrigin) {
        String pileTitle = isOrigin ? "origin" : "destination";
        return IO.readPositiveInt("Choose the " + pileTitle + " pile number(1-7): ", 7) - 1;
    }

    private Suit readSuit() {
        char suitInitial = IO.readChar("Choose a suit (H/D/C/P): ", new char[]{'H', 'D', 'C', 'P'});
        switch (suitInitial) {
            case 'H':
                return Suit.HEARTS;
            case 'D':
                return Suit.DIAMONDS;
            case 'C':
                return Suit.CLOVERS;
            case 'P':
                return Suit.PIKES;
        }
        return null;
    }

}