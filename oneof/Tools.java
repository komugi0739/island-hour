public class Tools{
    public Tools(){
        log("これが実行されることはないよぉ～～～～");
    }

    public static void log(Object text){
        System.out.println(text);
    }

    public static void delay(long ms) {try {
        Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public static int random(int min, int max){
        if(max < min){
            int kari = min;
            min = max;
            max = kari;
        }

        int ran = (int)(Math.random()*(max-min+1) +min);
        return ran;
    }
    
    public static int[] antirgb(String moto) {
        if(moto.startsWith("#")) moto = moto.substring(1);

        int r = Integer.parseInt(moto.substring(0, 2), 16);
        int g = Integer.parseInt(moto.substring(2, 4), 16);
        int b = Integer.parseInt(moto.substring(4, 6), 16);

        return new int[]{r, g, b};
    }
    public static String logCol(String mode, int r, int g, int b) {
        if(mode == "rgb"){
            String res = String.format("\u001b[38;2;%d;%d;%dm", r, g, b);
            return res;
        }
        return "";
    }
    public static String logCol(String mode, String code) {
        if(mode == "code"){
            int[] rgb = antirgb(code);
            String res = logCol("rgb", rgb[0], rgb[1], rgb[2]);
            return res; //ふぅぅ冗長大好きさ
        }
        return "";
    }
    public static String logCol(String mode) {
        if(mode == "reset") log("\u001b[0m" + "(色をリセットしました)");
        return "";
    }
}