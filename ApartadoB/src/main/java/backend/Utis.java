package backend;

import com.google.gson.Gson;
import com.googlecode.gentyref.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Utis {

    //TO DO leer fichero JSON
    // TO DO Buscar fichero


    public static ArrayList<GeoIP> getFile(){
         Gson gson = new Gson();
         ArrayList<GeoIP> ListIP = null;
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader("LocalizaIP.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ListIP = gson.fromJson(br, new TypeToken<ArrayList<GeoIP>>(){}.getType());
        return ListIP;
        }

    public static String longToIp(long ip) {
        StringBuilder result = new StringBuilder(15);
        for (int i = 0; i < 4; i++) {
            result.insert(0, Long.toString(ip & 0xff));
            if (i < 3) {
                result.insert(0, '.');
            }
            ip = ip >> 8;
        }
        return result.toString();
    }

    public static Long Dot2LongIP(String dottedIP) {
        String[] addrArray = dottedIP.split("\\.");
        long num = 0;
        for (int i = 0; i < addrArray.length; i++) {
            int power = 3 - i;
            num += ((Integer.parseInt(addrArray[i]) % 256) *
                    Math.pow(256, power));
        }
        return num;
    }

}
