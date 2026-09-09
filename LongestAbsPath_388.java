class Solution {
    public int lengthLongestPath(String input) {
        String[] lines = input.split("\n");

        int[] pathLength = new int[lines.length + 1];
        int max = 0;

        for (String line : lines) {

            // Find depth (number of \t)
            int depth = 0;
            while (line.charAt(depth) == '\t') {
                depth++;
            }

            // Remove tabs
            String name = line.substring(depth);

            // Calculate current path length
            pathLength[depth] = pathLength[depth - 1] + name.length() + 1;

            // If it is a file
            if (name.contains(".")) {
                max = Math.max(max, pathLength[depth] - 1);
            }
        }

        return max;
    }
}