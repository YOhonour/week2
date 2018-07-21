import javax.xml.soap.Node;
import java.util.Random;
import java.util.Scanner;

public class NumberGuess {

    private static class Player{
        int _count;
        String Id = null;
    }


    public static void main(String[] args) {
        int seed = 1;
        String flag_ = new String("begin");
        LinkList myLink = new LinkList();
        Scanner input = new Scanner(System.in);
        myLink.initLink();
        System.out.println("所猜数字为0-20");
        while (flag_.equals("begin"))
        {
            System.out.println("输入begin开始，shutdown结束");
            flag_ = input.nextLine();
            if (flag_.equals("shutdown")) break;
            runGame(myLink,seed++);//进入此方法开始游戏，完毕就为系统层面
            myLink.sortLink();
            myLink.disPlay();
        }
    }

    private static void runGame(LinkList myLink,int seed)//进行一次猜测，传入链表对象，随机数种子避免猜测得数字相同
    {

        Random random = new Random(seed++);
        int n = random.nextInt(20);
        Player player = new Player();
        player.Id = getId();
        System.out.println("输入你的猜测：");
        player._count = doGuess(n);
        System.out.println("所猜次数"+player._count);
        myLink.addlink(player.Id,player._count);
    }

    private static String getId()
    {
        Scanner input = new Scanner(System.in);
        String id = null;
        System.out.println("请输入你的ID：");
        id = input.next();
    return id;
    }
    private static int doGuess(int n)//传入随机数，返回猜测次数
    {

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
