
import java.util.Scanner;



/**
 *
 * @author ShivamKD
 */
public class Tic {
    private int mat[][];
    private static final int USERVAL = 18;
    private static final int COMPUTERVAL = 50;
    char first,second;
    Tic(){
        int i,j;
        mat = new int[3][3];
        
        for(i = 0; i < 3; ++i){
            for(j = 0; j < 3; ++j){
                mat[i][j] = 2;
            }
        }
        firstDisplay();
    }
    
    
    final void firstDisplay(){
        int i,j;
        
        for(i = 0; i < 3; ++i){
            for(j = 0; j < 3; ++j){
                
                System.out.print((i+1) + ", " + (j + 1) + "\t");
                if(j!=2){
                    System.out.print("|\t");
                }
            }
            System.out.println("");
            System.out.println("___________________________________");
            System.out.println("");
        }
        System.out.println("______________________________________");
    }
    
    void display(){
        int i,j;
        char ch;
        for(i = 0; i < 3; ++i){
            for(j = 0; j < 3; ++j){
                switch (mat[i][j]) {
                    case 2:
                        ch = ' ';
                        break;
                    case 3:
                        ch = 'X';
                        break;
                    default:
                        ch = 'O';
                        break;
                }
                
                System.out.print(ch + "\t");
                if(j!=2){
                    System.out.print("|\t");
                }
            }
            System.out.println("");
            System.out.println("___________________________________");
            System.out.println("");
        }
        System.out.println("______________________________________");
    }
    
    
    
    void userMove(){
        int x,y;
        Scanner ob = new Scanner(System.in);
        System.out.println("User Move\n");
        
        System.out.print("Enter x co-ordinates : ");
        x = ob.nextInt();
        x--;
        System.out.print("Enter y co-ordinates : ");
        y = ob.nextInt();
        y--;
        
        if( x < 0 || x > 2 || y < 0 || y > 2){
            System.out.println("Invalid Coordiates");
            userMove();
            return ;
        }
        
        if(mat[x][y]!=2){
            System.out.println("Already Occupied!");
            userMove();
            return ;
        }
        
        mat[x][y] = 3;
    }
    
    void computerMove(Location ob){
        int x = ob.getX();
        int y = ob.getY();
        mat[x][y] = 5;
    }
    
    Location row(int val){
        for(int i = 0;i<3;i++){
            int s = mat[i][0] * mat[i][1] * mat[i][2];
            if(s == val){
                for(int j = 0;j<3;j++){
                    if(mat[i][j] == 2){
                        return new Location(i,j);
                    }
                }
            }
        }
        
        return null;
    }
    
    Location column(int val){
        for(int i = 0;i<3;i++){
            int s = mat[0][i] * mat[1][i] * mat[2][i];
            if(s == val){
                for(int j = 0;j<3;j++){
                    if(mat[j][i] == 2){
                        return new Location(j,i);
                    }
                }
            }
        }
        
        return null;
    }
    
    Location daigonal(int val){
        int s = mat[0][0] * mat[1][1] * mat[2][2];
        if(s == val){
            for(int i = 0;i<3;i++){
                if(mat[i][i] == 2){
                    return new Location(i,i);
                }
            }
        }
        
        s = mat[0][2] * mat[1][1] * mat[2][0];
        
        if(s == val){
            for(int i = 0;i<3;i++){
                if(mat[2-i][i] == 2){
                    return new Location(2-i,i);
                }
            }
        }
        
        return null;
    }
    
    
    Location checkUserWin(){
        Location move = row(USERVAL);
        
        if(move!=null){
            return move;
        }
        
        move = column(USERVAL);
        
        if(move!=null){
            return move;
        }
        
        move = daigonal(USERVAL);
        
        if(move!=null){
            return move;
        }
        
        return null;
    }
    
    
    Location freeSpace(){
        Location move,temp;
        move = null;
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3 ; j++){
                if(mat[i][j] == 2){
                    temp = new Location(i,j);
                    move = temp;
                    computerMove(temp);
                    temp = row(COMPUTERVAL);
                    if(temp!=null){
                        return move;
                    }
                    temp = column(COMPUTERVAL);
                    
                    if(temp!=null){
                        return move;
                    }
                    temp = daigonal(COMPUTERVAL);
                    
                    if(temp!=null){
                        return move;
                    }
                    move = new Location(i,j);
                    mat[i][j] = 2;
                }
            }
        }
        
        return move;
    }
    
    Location emptyMid(){
        if(mat[1][1] == 2){
            return new Location(1,1);
        }
        
        return null;
    }
    
    int computer(){
        
        Location move = emptyMid();
        
        if(move!=null){
            computerMove(move);
            return 0;
        }
        
        move = row(COMPUTERVAL);
        if(move!=null){
            computerMove(move);
            return 1;
        }
        
        move = column(COMPUTERVAL);
        
        if(move!=null){
            computerMove(move);
            return 1;
        }
        
        move = daigonal(COMPUTERVAL);
        
        if(move!=null){
            computerMove(move);
            return 1;
        }
        
        move = checkUserWin();
        
        if(move!=null){
            computerMove(move);
            return 0;
        }
        
        move = freeSpace();
        computerMove(move);
        return 0;
    }
    
    
    
}
