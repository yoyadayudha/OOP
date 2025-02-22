import java.util.Scanner;

public class Tictactoe{
    public static boolean gameEnd = false;

    public static Scanner scanner = new Scanner(System.in);


    public static char board[] = {
        '_', '_', '_',
        '_', '_', '_',
        '_', '_', '_'
    };

    public static int winningMoves[][] = {
        {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // horizontal
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // vertical
        {0, 4, 8}, {2, 4, 6} // diagonal
    };

    public static int turn = 0; // 0 player 1 (O), 1 player 2 (X)
    public static void main(String[] agrs){
        startGame();
    }

    public static void printBoard(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(board[i * 3 + j] + " ");
            }
            System.out.println("");
        }
    }

    public static char getPlayerSign(){
        return turn == 0 ? 'O' : 'X';
    }

    public static boolean checkWin(char playerSign){
        boolean win = false;
        for(int i = 0; i < 8; i++){
            boolean valid = true;
            for(int j = 0; j < 3; j++){
                if(board[ winningMoves[i][j] ] != playerSign){
                    valid = false;
                }
            }
            if(valid == true){
                win = true;
                break;
            }
            
        }

        return win;
    }

    public static boolean placeMove(int x, int y){
        if(x < 0 || x > 2 || y < 0 || y > 2){
            return false;
        }

        if(board[y * 3 + x] != '_'){
            return false;
        }

        board[y * 3 + x] = getPlayerSign();
        return true;
    }

    public static boolean isTie(){ 
        int length = 9;
        for(int i = 0; i < 9; i++){
            if(board[i] == '_'){
                length--;
            }
        }
        if(length <= 0 && !checkWin('X') && !checkWin('O') && !checkWin('_'))
            return true;

            return false;
    }

    public static void play(){
        int x;
        int y;
        boolean validMove;
        do{
            System.out.print((turn == 0 ? "Player 1 (O) turn" : "Player 2 (X) turn") + "move :");
    
            x = scanner.nextInt();
            y = scanner.nextInt();

            validMove = placeMove(x, y);
            if(validMove == false){
                System.out.println("Invalid move, try again");
            }
            
        }while(validMove == false);
        
        //check win
        if(checkWin(getPlayerSign())){
            System.out.println((turn == 0 ? "Player 1 (O)" : "Player 2 (X)") + " wins!");
            printBoard();
            gameEnd = true;
            return;
        }

        

        if(isTie()){
            System.out.println("It's a tie!");
            gameEnd = true;
            return;
        }

        // System.out.println("x : " + x + " y : " + y);
        printBoard();

        if(turn == 0) turn = 1;
        else turn = 0;
    }

    public static void startGame(){
        System.err.println("Welcome to Tictactoe!");

        while(!gameEnd){
            play();
        }

    }
}