public class Main{
    public static void main(String[] args){
        int x = Tools.random(1, 6);
        int y = 1;
        int dmg = x+y;

        log(x);
        Tools.delay(900);
        log(dmg);
    }


    public static void log(Object text){
        System.out.println(text);
    }
}