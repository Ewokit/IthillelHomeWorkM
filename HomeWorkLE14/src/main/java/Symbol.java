import java.util.HashMap;

public abstract class Symbol {
    public static String string(String str){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("0", " @@@@ .@@  @@.@@  @@.@@  @@. @@@@ ");
        hashMap.put("1", "  @@  . @@@  .  @@  .  @@  .@@@@@@");
        hashMap.put("2", " @@@@ .@    @.   @@ . @@   .@@@@@@");
        hashMap.put("3", "@@@@@ .    @@.  @@@ .    @@.@@@@@ ");
        hashMap.put("4", "   @@@.  @ @@. @  @@.@@@@@@.    @@");
        hashMap.put("5", "@@@@@ .@@    .@@@@@ .    @@.@@@@@ ");
        hashMap.put("6", " @@@@ .@@    .@@@@@ .@@  @@. @@@@ ");
        hashMap.put("7", "@@@@@@.   @@ .  @@  . @@   .@@    ");
        hashMap.put("8", " @@@@ .@@  @@. @@@@ .@@  @@. @@@@ ");
        hashMap.put("9", " @@@@ .@@  @@. @@@@@.    @@. @@@@ ");
        return hashMap.get(str);
    }

}
