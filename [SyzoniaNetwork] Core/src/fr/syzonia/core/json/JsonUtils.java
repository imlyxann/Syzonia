package fr.syzonia.core.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.plugin.Plugin;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

public class JsonUtils {

    public static void toJson(Plugin plugin, Object object, String fileName) {
        File file = new File(plugin.getDataFolder(), fileName);
        try (Writer writer = new OutputStreamWriter(
                new FileOutputStream(file), StandardCharsets.UTF_8)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(object, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static Object fromJson(Plugin plugin, String fileName, Type typeOfT) {
        File file = new File(plugin.getDataFolder(), fileName);
        if (!file.exists()) return null;
        try (Reader reader = new InputStreamReader(
                new FileInputStream(file), StandardCharsets.UTF_8)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, typeOfT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
	
}
