package fr.syzonia.syzobungee.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class ConfigHelp {

    private static final String CONFIG_PATH = "C:\\Users\\Sacha\\OneDrive\\Documents\\MC\\Serveur\\SyzoniaServLocal\\Bungee1\\config.yml";

    public static void addServer(String serverName, String address) throws IOException {
        Map<String, Object> config = loadConfig();

        if (config != null) {
            @SuppressWarnings("unchecked")
            Map<String, Map<String, Object>> servers = (Map<String, Map<String, Object>>) config.get("servers");

            if (servers == null) {
                servers = new HashMap<>();
                config.put("servers", servers);
            }

            Map<String, Object> serverDetails = new HashMap<>();
            serverDetails.put("address", address);
            serverDetails.put("motd", "&6Lydrageanas system Powered by Syzonia");
            serverDetails.put("restricted", false);

            servers.put(serverName, serverDetails);

            saveConfig(config);
        }
    }

    public static void removeServer(String serverName) throws IOException {
        Map<String, Object> config = loadConfig();

        if (config != null) {
            @SuppressWarnings("unchecked")
            Map<String, Map<String, Object>> servers = (Map<String, Map<String, Object>>) config.get("servers");

            if (servers != null) {
                servers.remove(serverName);
                saveConfig(config);
            }
        }
    }

    private static Map<String, Object> loadConfig() throws IOException {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(CONFIG_PATH));
            Yaml yaml = new Yaml();
            return yaml.load(inputStream);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    private static void saveConfig(Map<String, Object> config) throws IOException {
        Yaml yaml = new Yaml();
        FileWriter writer = null;
        try {
            writer = new FileWriter(new File(CONFIG_PATH));
            yaml.dump(config, writer);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
	
}
