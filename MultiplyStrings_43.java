class Solution {

    int charToInt(char c) {
        return c - '0';
    }

    public String multiply(String num1, String num2) {

        // If either number is zero
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int n = num1.length();
        int m = num2.length();

        int[] result = new int[n + m];

        // Multiply digit by digit
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                int d1 = charToInt(num1.charAt(i));
                int d2 = charToInt(num2.charAt(j));

                int mul = d1 * d2;
                int sum = mul + result[i + j + 1];

                result[i + j + 1] = sum % 10;   // digit
                result[i + j] += sum / 10;      // carry
            }
        }

        // Convert result array to string
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }

        return sb.toString();
    }
}