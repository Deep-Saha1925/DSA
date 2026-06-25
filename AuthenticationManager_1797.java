class AuthenticationManager {

    int ttl;
    Map<String, Integer> map;

    public AuthenticationManager(int timeToLive) {

        ttl = timeToLive;
        map = new HashMap<>();
    }

    public void generate(String tokenId,
                         int currentTime) {

        map.put(tokenId,
                currentTime + ttl);
    }

    public void renew(String tokenId,
                      int currentTime) {

        if (!map.containsKey(tokenId))
            return;

        if (map.get(tokenId) <= currentTime)
            return;

        map.put(tokenId,
                currentTime + ttl);
    }

    public int countUnexpiredTokens(
                        int currentTime) {

        int count = 0;

        for (int expiry : map.values()) {

            if (expiry > currentTime)
                count++;
        }

        return count;
    }
}