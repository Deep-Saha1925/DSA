class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder s = new StringBuilder();
        int count = 0;

        while (s.length() < b.length()) {
            s.append(a);
            count++;
        }

        // Check after reaching b's length
        if (s.toString().contains(b)) {
            return count;
        }

        // One extra repetition may be needed
        s.append(a);
        count++;

        return count;
    }
}