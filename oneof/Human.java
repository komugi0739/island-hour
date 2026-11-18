public class Human{
    String name;
    int star;
    int hp;
    int maxhp;
    int atk;
    int def;
    int spd; //速度。下限は1

    public Human(String name, int maxhp, int atk, int def, int spd){
        //代入
        this.name = name;
        this.star = 0; //最大3
        this.maxhp = maxhp;
         this.hp = maxhp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
    }

    public void call(){

    }
}