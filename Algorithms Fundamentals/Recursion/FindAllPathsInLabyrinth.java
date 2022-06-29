package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAllPathsInLabyrinth {

    static List<Character> path = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] labyrinth = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            labyrinth[i] = scanner.nextLine().toCharArray();
        }
        findPath(labyrinth, 0, 0, ' ');// ' ' tuk dobavqme edin char parametur,koito shte ni dava kakva posoka sme izbrali,zashtoto po uslovie trqbva da otpechatvame naude sme trugnali napr R za nadqsno L za nalqvo i t.n.
    }

    private static void findPath(char[][] labyrinth, int row, int col, char direction) {
        if (!isInBounds(labyrinth, row, col) || labyrinth[row][col] == 'V'
                || labyrinth[row][col] == '*') {
            return;//tuk kazvame,che,ako izleze ot ramkite na matricata shte trqbva da returne, t.e. spira i nqma kakvo da tursi natatuk!
        }
        path.add(direction);

        if (labyrinth[row][col] == 'e') {
            printPath();
            path.remove(path.size() - 1);
            return;//tuk imame return inache shte markira i izhoda i nikoga nqma da imame 'e' sled '-', zashtoto shte go setnem na prazna kletka
        }
        labyrinth[row][col] = 'V';//tuk markirame kato poseteno vseki hod

        findPath(labyrinth, row, col - 1, 'L');// s col - 1 hodim nalqvo ot kolonite
        findPath(labyrinth, row, col + 1, 'R');// s col + 1 hodim nadqsno ot kolonite
        findPath(labyrinth, row - 1, col, 'U');//(s row - 1 hodim nagore)tuk izvikvame rekursiqta,za vsqka sledvashta stupka se pravi s rekursiq(izvikvame q 4 puti,zashtoto iskame da probvame da hodim i v 4te posoki)rekursiqta shte dulbae,dokato ne sreshtne stena(nie si q opredelqme s proverki)sreshtne li shte spre da dulbae i shte ni returne(shte se vurne i zapochva na novo da probva v sledvashtata posoka)
        findPath(labyrinth, row + 1, col, 'D');//s row + 1 hodim nadolu

        labyrinth[row][col] = '-';//tuk izvikvame backtrackinga t.e. sled kato se vrushtame ot rekursiite markirame vsqka kletka,koqto sme uspqli da posetim purvo kato posetena s 'V' i sled tova kato posetena s '-'(t.e. otmarkirame vse edno poseshtenieto i q markirame kato svobodna '-')(tezi znaci sa ni po uslovie)

        path.remove(path.size() - 1);//vseki put kogato backtrackvame bez da sme namerili izhoda, premahvame poslednata posoka(posledniq index),po koqto sme bili trugnali
    }

    private static void printPath() {
        for (int i = 1; i < path.size(); i++) {
            System.out.print(path.get(i));
        }
        System.out.println();
    }

    private static boolean isInBounds(char[][] labyrinth, int row, int col) {
        return row < labyrinth.length && row >= 0 && col < labyrinth[row].length && col >= 0;
    }
}
