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

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                
                // If we reach the target, return the number of steps
                if (current.equals(endGene)) {
                    return steps;
                }

                char[] currArray = current.toCharArray();
                // Try changing each character of the current gene
                for (int j = 0; j < currArray.length; j++) {
                    char oldChar = currArray[j];
                    for (char g : possibleGenes) {
                        currArray[j] = g;
                        String neighbor = new String(currArray);
                        
                        // If the mutated gene is valid and hasn't been visited yet
                        if (bankSet.contains(neighbor)) {
                            queue.offer(neighbor);
                            bankSet.remove(neighbor); // Remove to mark as visited
                        }
                    }
                    currArray[j] = oldChar; // Restore character back for next iteration
                }
            }
            steps++;
        }
    }
}