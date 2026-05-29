class Solution {
    public int strongPasswordChecker(String s) {

        int lower = 1, upper = 1, digit = 1;

        for(char c : s.toCharArray()) {
            if(Character.isLowerCase(c)) lower = 0;
            else if(Character.isUpperCase(c)) upper = 0;
            else if(Character.isDigit(c)) digit = 0;
        }

        int missing = lower + upper + digit;

        int replace = 0;

        for(int i = 2; i < s.length(); i++) {class Solution {
    public int strongPasswordChecker(String password) {

        int n = password.length();

        int lower = 1, upper = 1, digit = 1;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) lower = 0;
            else if (Character.isUpperCase(c)) upper = 0;
            else if (Character.isDigit(c)) digit = 0;
        }

        int missing = lower + upper + digit;

        int replace = 0;
        int[] arr = new int[n];

        for (int i = 0; i < n;) {
            int j = i;
            while (j < n && password.charAt(j) == password.charAt(i))
                j++;

            arr[i] = j - i;

            if (arr[i] >= 3)
                replace += arr[i] / 3;

            i = j;
        }

        if (n < 6)
            return Math.max(missing, 6 - n);

        if (n <= 20)
            return Math.max(missing, replace);

        int delete = n - 20;
        int remainDelete = delete;

        // First: groups where len % 3 == 0
        for (int i = 0; i < n && remainDelete > 0; i++) {
            if (arr[i] >= 3 && arr[i] % 3 == 0) {
                arr[i]--;
                remainDelete--;
                replace--;
            }
        }

        // Second: groups where len % 3 == 1
        for (int i = 0; i < n && remainDelete > 1; i++) {
            if (arr[i] >= 3 && arr[i] % 3 == 1) {
                arr[i] -= 2;
                remainDelete -= 2;
                replace--;
            }
        }

        // Third: groups where len % 3 == 2
        for (int i = 0; i < n && remainDelete > 0; i++) {

            if (arr[i] >= 3) {

                int need = arr[i] - 2;

                int used = Math.min(remainDelete, need);

                arr[i] -= used;
                remainDelete -= used;

                replace -= used / 3;
            }
        }

        return delete + Math.max(missing, replace);
    }
}
            if(s.charAt(i) == s.charAt(i-1) &&
               s.charAt(i) == s.charAt(i-2)) {

                replace++;
                i += 2; // skip next two chars
            }
        }

        if(s.length() < 6) {
            return Math.max(missing, 6 - s.length());
        }

        if(s.length() <= 20) {
            return Math.max(missing, replace);
        }

        return (s.length() - 20) +
               Math.max(missing, replace);
    }
}