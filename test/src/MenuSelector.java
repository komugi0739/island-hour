import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.NonBlockingReader;

public class MenuSelector {
    public static void main(String[] args) {
        try (Terminal terminal = TerminalBuilder.builder().system(true).build()) {
            // 画面の入力を1文字ずつうけとる設定にするよ
            terminal.enterRawMode();
            NonBlockingReader reader = terminal.reader();

            String[] items = {"お茶をのむ", "お昼寝する", "お仕事をする"};
            int currentIndex = 0;

            // 最初の一覧を出すよ
            drawMenu(terminal, items, currentIndex);

            while (true) {
                int c = reader.read();

                // 矢印キー（エスケープシーケンス）の判定
                if (c == 27) { // ESC
                    int next1 = reader.read();
                    int next2 = reader.read();
                    if (next1 == 91) { // '['
                        if (next2 == 65) { // 上矢印
                            currentIndex = (currentIndex > 0) ? currentIndex - 1 : items.length - 1;
                        } else if (next2 == 66) { // 下矢印
                            currentIndex = (currentIndex < items.length - 1) ? currentIndex + 1 : 0;
                        }
                    }
                } else if (c == 13 || c == 10) { // Enterキー
                    System.out.println("\nきまりました：「" + items[currentIndex] + "」ですね。");
                    break;
                }

                // 画面を書きなおすよ
                drawMenu(terminal, items, currentIndex);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void drawMenu(Terminal terminal, String[] items, int currentIndex) {
        // カーソルを上に戻して書き直す処理（簡易的だよ）
        for (int i = 0; i < items.length; i++) {
            if (i == currentIndex) {
                terminal.writer().println(" > [x] " + items[i]);
            } else {
                terminal.writer().println("   [ ] " + items[i]);
            }
        }
        terminal.writer().flush();
        // 次の描画のためにカーソルを戻すエスケープを送る
        terminal.writer().print("\033[" + items.length + "A");
    }
}