import javax.xml.soap.Node;
import java.util.Random;
import java.util.Scanner;

public class NumberGuess {

    private static class Player{
        int _count;
        String Id = null;
    }


    public static void main(String[] args) {
        runGame();
    }
    private static void runGame(){
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        LinkList myLink = new LinkList();
        myLink.initLink();
        int n = random.nextInt(10);
        String flag = new String("Y");
        while (flag.equalsIgnoreCase("Y")){
            Player player = new Player();
            player.Id = getId();
            System.out.println("输入你的猜测：");
            player._count = doGuess(n);
            System.out.println("所猜次数"+player._count);
            myLink.addlink(player.Id,player._count);

            System.out.println("是否继续？(Y/N)");
            flag = input.next();
        }
        myLink.sortLink();
        myLink.disPlay();
    }

    private static String getId(){
        Scanner input = new Scanner(System.in);
        String id = null;
        System.out.println("请输入你的ID：");
        id = input.next();
    return id;
    }
    private static int doGuess(int n){

        int guess;
        int count = 0;
        boolean isRight = false;
        Scanner input = new Scanner(System.in);
        while (!isRight)
        {
            count++;
            guess = input.nextInt();
            if(guess > n) System.out.println("太大了！");
            else if (guess < n) System.out.println("太小了！");
            else {
                System.out.println("正确！");
                break;
            }
        }
        return count;
    }
}
