class Solution {
    public int lengthLongestPath(String input) {
        String[] lines = input.splite("\n");

        int[] pathLen = new int[lines.length+1];
        int max = 0;

        int depth = 0;
        while(line.chatAt(depth) == "\t") {
            depth++;
        }

        //removing tabs
        String name = line.substring(depth);

        pathLen[depth] = pathLen[depth - 1] + name.length() + 1;
    }
}