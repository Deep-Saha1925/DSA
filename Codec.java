import java.util.HashMap;

class Codec {

    HashMap<String, String> map = new HashMap<>();
    int id = 0;

    public String encode(String longUrl) {

        String key = "url" + id++;
        map.put(key, longUrl);

        return key;
    }

    public String decode(String shortUrl) {

        String key = shortUrl.substring(shortUrl.lastIndexOf("/") + 1);

        return map.get(key);
    }
}