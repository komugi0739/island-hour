import java.util.Scanner;

public class Main{
    public static Object[] hs = new Object[0]; //要素数が0、を意味するらしい

    void main(String[] args){
        int x = Tools.random(1, 6);
        int y = 1;
        int dmg = x+y;

        log(x);
        Tools.delay(900);
        log(dmg);

        //human
        log("〈名前を入力してください〉");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
         scan.close();
        Human hero = new Human(name);
         hero.nanore();

        log(Tools.logCol("code", "#ffff80") + "黄色");
        log(Tools.logCol("code", "#f0f8ff") + "AliceBlue");
         Tools.logCol("reset");



    }

    public void log(Object text){
        System.out.println(text);
    }

    //RPGシステム、行きます
    public void encount(){encount(1);}
    public void encount(int num){
        log(String.format("敵を%s人呼びますね。", num));

        for(int i=0; i<num; i++){

        }
    }
}