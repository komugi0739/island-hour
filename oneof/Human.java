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
    public Human(String name){
        // player専用！代替
        this(name, 100, 20, 5, 50);
    }

    public void nanore(){
        Tools.log(String.format("俺の名前は%sだ！！ 体力は%s/%s、攻撃・防御は%s:%s！ 足の速さは%sだ！！", this.name, this.hp, this.maxhp, this.atk, this.def, this.spd));
    }
}