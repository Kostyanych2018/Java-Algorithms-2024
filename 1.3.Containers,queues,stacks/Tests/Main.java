import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };

        int temp;
        int len = arr.length;
        for (int i = 0; i < len / 2; i++) {
            temp = arr[i];
            arr[i] = arr[len - i - 1];
            arr[len - i - 1] = temp;
        }
        StringBuilder sb = new StringBuilder("Инвертированный массив:");
        for (int x : arr) {
            sb.append(x).append(" ");
        }
        LOGGER.info(sb.toString());
    }
}
