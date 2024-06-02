package fr.syzonia.syzobungee.security;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class VpnCheck {

    public static boolean isUsingVPN(String ip) throws Exception {
        URL url = new URL("https://ipinfo.io/" + ip + "/json?token=" + "28a39e0f2c6242");
        
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder content = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            JsonObject jsonObject = JsonParser.parseString(content.toString()).getAsJsonObject();
            
            if (jsonObject.has("vpn")) {
                JsonElement vpnElement = jsonObject.get("vpn");
                if (!vpnElement.isJsonNull()) {
                    String vpnStatus = vpnElement.getAsString();
                    return "true".equals(vpnStatus);
                }
            }
            
            if (jsonObject.has("proxy")) {
                JsonElement proxyElement = jsonObject.get("proxy");
                if (!proxyElement.isJsonNull()) {
                    String proxyStatus = proxyElement.getAsString();
                    return "true".equals(proxyStatus);
                }
            }

            return false;
        } finally {
            connection.disconnect();
        }
    }
	
}
