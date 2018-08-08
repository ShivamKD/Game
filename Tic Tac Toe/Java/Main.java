
import java.util.Scanner;



/**
 *
 * @author shivamkd
 */
public class Main {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        Tic game = new Tic();
        System.out.println("Press 1 to have your first chance");
        int choice = ob.nextInt();
        if(choice != 1){
            choice  = 0;
        }
        
        
        int chances = 0;
        while(chances < 9){
            chances++;
            if((chances + choice) % 2 == 0){
                
                game.userMove();
                System.out.println("After User Move");
            }
            else{
                int f = game.computer();
                System.out.println("After Commputer Move");
                if(f == 1){
                    game.display();
                    System.out.println("Computer Won");
                    return ;
                }
            }
            game.display();
        }
        
        System.out.println("Draw");
    }
}
