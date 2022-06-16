import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=535 lang=java
 *
 * [535] Encode and Decode TinyURL
 */

// @lc code=start
public class Codec {
    
    public Map<String, String> shortToLong =  new HashMap<>();
    public Map<String, String> longToShort =  new HashMap<>();
    public int count=100;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(longToShort.containsKey(longUrl)){
            return longToShort.get(longUrl);
        }

        String shortUrl = generateShortUrl(count++);
        longToShort.put(longUrl, shortUrl);
        shortToLong.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortToLong.get(shortUrl);
    }

    public String generateShortUrl(int n){
        String alpha = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder s =  new StringBuilder();
        while(n!=0){
            int d = n%62;
            s.append(alpha.charAt(d));
            n=n/62;
        }
        return s.reverse().toString()+"==";
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
// @lc code=end

