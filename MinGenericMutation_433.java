class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        // If the target gene is not in the bank, it's impossible to reach
        if (!bankSet.contains(endGene)) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        
        char[] possibleGenes = new char[]{'A', 'C', 'G', 'T'};
        int steps = 0;
    }
}