import java.util.*;

public class Codec {

    HashMap<String, String> map = new HashMap<>();
    int id = 0;

    public String encode(String longUrl) {

        String key = "url" + id++;
        map.put(key, longUrl);

        return key;
    }

    public String decode(String shortUrl) {

        return map.get(shortUrl);
    }
}