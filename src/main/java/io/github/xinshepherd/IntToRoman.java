package io.github.xinshepherd;

//12 整数转罗马数字
public class IntToRoman {

    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        intToRoman(num, stringBuilder);
        return stringBuilder.toString();
    }

    //太复杂了
    private void intToRoman(int num, StringBuilder sb) {
        if (num == 0) return;
        if (num >= 1000) {
            sb.append('M');
            intToRoman(num - 1000, sb);
        } else if (num >= 900) {
            sb.append("CM");
            intToRoman(num - 900, sb);
        } else if (num >= 500) {
            sb.append('D');
            intToRoman(num - 500, sb);
        } else if (num >= 400) {
            sb.append("CD");
            intToRoman(num - 400, sb);
        } else if (num >= 100) {
            sb.append('C');
            intToRoman(num - 100, sb);
        } else if (num >= 90) {
            sb.append("XC");
            intToRoman(num - 90, sb);
        } else if (num >= 50) {
            sb.append("L");
            intToRoman(num - 50, sb);
        } else if (num >= 40) {
            sb.append("XL");
            intToRoman(num - 40, sb);
        } else if (num >= 10) {
            sb.append("X");
            intToRoman(num - 10, sb);
        } else if (num >= 9) {
            sb.append("IX");
            intToRoman(num - 9, sb);
        } else if (num >= 5) {
            sb.append("V");
            intToRoman(num - 5, sb);
        } else if (num >= 4) {
            sb.append("IV");
            intToRoman(num - 4, sb);
        } else if (num > 0) {
            sb.append("I");
            intToRoman(num - 1, sb);
        }
    }

    public static void main(String[] args) {
        IntToRoman intToRoman = new IntToRoman();
        System.out.println(intToRoman.intToRoman(3));
        System.out.println(intToRoman.intToRoman(4));
        System.out.println(intToRoman.intToRoman(9));
        System.out.println(intToRoman.intToRoman(58));
        System.out.println(intToRoman.intToRoman(1994));
    }
}
