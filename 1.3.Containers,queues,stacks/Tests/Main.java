public class Main {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };

        int temp;
        int len = arr.length;
        for (int i = 0; i < len / 2; i++) {
            temp = arr[i];
            arr[i] = arr[len - i - 1];
            arr[len - i - 1] = temp;
        }
        System.out.print("Инвертированный массив:");
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
