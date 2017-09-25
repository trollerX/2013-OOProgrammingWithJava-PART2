package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author TrollerX
 */
public class Dungeon {

    private final int length;
    private final int height;
    private final int vampires;
    private int moves;
    private final boolean vampiresMove;
    private List<Vampire> left;
    private Player player;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        this.left = new ArrayList<Vampire>();
    }

    public void run() {
        Scanner reader = new Scanner(System.in);
        populateDungeon();
        while (!isGameEnd()) {
            printMovesLeft();
            System.out.println("");
            printLocations();
            System.out.println("");
            printDungeon();
            System.out.println("");
            movingLogic(reader);
        }
    }

    public void populateDungeon() {
        this.player = new Player();
        Random r = new Random();

        while (left.size() < vampires) {
            Vampire newVampire = new Vampire(r.nextInt(length), r.nextInt(height));
            if (newVampire.locationEquals(player)) {
                continue;
            }
            if (left.contains(newVampire)) {
                continue;
            }
            left.add(newVampire);
        }
    }

    private void printMovesLeft() {
        System.out.println(moves);
        moves--;
    }

    private void printLocations() {
        System.out.println(player);
        for (Vampire vampire : left) {
            System.out.println(vampire);
        }
    }

    private void printDungeon() {
        //array of dots
        char[][] dungeon = new char[length][height];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < length; col++) {
                dungeon[col][row] = '.';
            }
        }
        //add locations of moveables
        dungeon[player.getRow()][player.getCol()] = '@';
        for (Vampire vampire : left) {
            dungeon[vampire.getRow()][vampire.getCol()] = 'v';
        }
        //print dungeon
        for (int i = 0; i < dungeon.length; i++) {
            for (int j = 0; j < dungeon[i].length; j++) {
                System.out.print(dungeon[i][j]);
            }
            System.out.println("\n");
        }
    }

    private void movingLogic(Scanner reader) {
//        System.out.print("Enter moves: ");
        String input = reader.nextLine();
        for (char c : input.toCharArray()) {
            if (player.isMoveLegal(height, length, c)) {
                player.move(c);
            }
            if (vampiresMove) {
                for (Vampire v : left) {
                    char move = "wsad".charAt(new Random().nextInt(4));
                    if (v.isMoveLegal(height, length, otherVampires(v), move)) {
                        v.move(move);
                    }
                }
            }

            for (int i = 0; i < left.size(); i++) {
                if (player.locationEquals(left.get(i))) {
                    left.remove(left.get(i));
                }
            }
        }
    }

    public boolean isGameEnd() {
        if (left.isEmpty()) {
            System.out.println("YOU WIN");
            return true;
        }
        if (moves == 0) {
            System.out.println("YOU LOSE");
            return true;
        }
        return false;
    }

    public List<Vampire> otherVampires(Vampire v) {
        List<Vampire> otherVampires = new ArrayList<Vampire>();
        for (Vampire vampire : left) {
            if (!vampire.locationEquals(v)) {
                otherVampires.add(vampire);
            }
        }
        return otherVampires;
    }
}
