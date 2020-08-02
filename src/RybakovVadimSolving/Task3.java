package RybakovVadimSolving;

public class Task3 {
    public static void main(String[] args) {
        int N = 35;
        String binary = Integer.toBinaryString(N);
        System.out.println(binary);
        int index = binary.lastIndexOf("0");
        StringBuilder sb = new StringBuilder(binary);
        sb.replace(index, index + 1, "1");
        String result = new String(sb);
        System.out.println(result);
        System.out.println(Integer.parseInt(result, 2));
    }
}
