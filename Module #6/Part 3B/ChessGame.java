import java.util.Scanner;

public class ChessGame {
   private static char[][] board = new char[8][8];
   private static boolean isWhiteTurn = true;

   public static void main(String[] args) {
       initializeBoard();
       Scanner scanner = new Scanner(System.in);

       System.out.println("=== Simple Console Chess ===");
       System.out.println("Input format example: e2 e4 (move from e2 to e4)");
       printBoard();

       while (true) {
           String currentPlayer = isWhiteTurn ? "White" : "Black";
           System.out.print(currentPlayer + "'s move: ");
           String input = scanner.nextLine().trim();

           if (input.equals("exit")) {
               System.out.println("Game ended!");
               break;
           }

           String[] moves = input.split(" ");
           if (moves.length != 2) {
               System.out.println("Invalid input! Use format like: e2 e4");
               continue;
           }

           int startX = moves[0].charAt(0) - 'a';
           int startY = Character.getNumericValue(moves[0].charAt(1)) - 1;
           int endX = moves[1].charAt(0) - 'a';
           int endY = Character.getNumericValue(moves[1].charAt(1)) - 1;

           if (isValidMove(startX, startY, endX, endY)) {
               board[endY][endX] = board[startY][startX];
               board[startY][startX] = '.';
               isWhiteTurn = !isWhiteTurn;
               printBoard();
           } else {
               System.out.println("Illegal move! Try again.");
           }
       }
       scanner.close();
   }

   private static void initializeBoard() {
       for (int i = 0; i < 8; i++) {
           for (int j = 0; j < 8; j++) {
               board[i][j] = '.';
           }
       }

       char[] pieces = {'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'};
       for (int i = 0; i < 8; i++) {
           board[0][i] = pieces[i];
           board[1][i] = 'p';
           board[6][i] = 'P';
           board[7][i] = Character.toUpperCase(pieces[i]);
       }
   }

   private static void printBoard() {
       System.out.println("\n  a b c d e f g h");
       for (int i = 0; i < 8; i++) {
           System.out.print((i + 1) + " ");
           for (int j = 0; j < 8; j++) {
               System.out.print(board[i][j] + " ");
           }
           System.out.println();
       }
   }

   private static boolean isValidMove(int startX, int startY, int endX, int endY) {
       char piece = board[startY][startX];
       if (piece == '.' || 
           (isWhiteTurn && Character.isLowerCase(piece)) || 
           (!isWhiteTurn && Character.isUpperCase(piece))) {
           return false;
       }

       if (Character.toLowerCase(piece) == 'p') {
           int direction = isWhiteTurn ? -1 : 1;
           return (endX == startX) && (endY == startY + direction);
       }

       return true;
   }
} 
