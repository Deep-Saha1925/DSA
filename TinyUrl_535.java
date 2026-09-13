import java.util.HashMap;

public class Codec {

    HashMap<String, String> map = new HashMap<>();
    int id = 0;

    public String encode(String longUrl) {

        String key = String.valueOf(id++);

        map.put(key, longUrl);

        return "http://tinyurl.com/" + key;
    }

    public String decode(String shortUrl) {

        String key = shortUrl.substring(shortUrl.lastIndexOf("/") + 1);

        return map.get(key);
    }
}