class Solution {
    public int lengthLongestPath(String input) {

        String[] lines = input.split("\n");

        int[] pathLength = new int[lines.length + 1];
        int max = 0;

        for (String line : lines) {

            int depth = 0;

            // Count \t
            while (depth < line.length() && line.charAt(depth) == '\t') {
                depth++;
            }

            String name = line.substring(depth);

            // Root level
            if (depth == 0) {
                pathLength[depth] = name.length();
            } 
            // Other levels
            else {
                pathLength[depth] =
                    pathLength[depth - 1] + 1 + name.length();
            }

            // Check if it is a file
            if (name.contains(".")) {
                max = Math.max(max, pathLength[depth]);
            }
        }

        return max;
    }
}