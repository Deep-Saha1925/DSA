class TopVotedCandidate {

    int[] times;
    int[] leaders;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        leaders = new int[persons.length];

        Map<Integer, Integer> votes = new HashMap<>();

        int leader = -1;
        int maxVotes = 0;
    }
    
    public int q(int t) {
        
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */