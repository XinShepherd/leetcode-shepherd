package io.github.xinshepherd;

/**
 * 38. 外观数列
 *
 * @author Fuxin
 * @since 2020/2/25 9:58
 */
public class CountAndSay {

    public String countAndSay(int n) {
        if (n <= 0)
            return "";
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = generate(result);
        }
        return result;
    }

    String generate(String prev) {
        StringBuilder builder = new StringBuilder();
        char temp = prev.charAt(0);
        int count = 0;
        for (int i = 0; i < prev.length(); i++) {
            if (prev.charAt(i) != temp) {
                builder.append(count).append(temp);
                temp = prev.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        builder.append(count).append(temp);
        return builder.toString();
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(0));
        System.out.println(countAndSay.countAndSay(1));
        System.out.println(countAndSay.countAndSay(3));
        System.out.println(countAndSay.countAndSay(4));
        System.out.println(countAndSay.countAndSay(5));
        System.out.println(countAndSay.countAndSay(6));
    }

}
