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
            max = min;
            min = kari;
        }

        int ran = (int)(Math.random()*(max-min+1) +min);
        return ran;
    }
}