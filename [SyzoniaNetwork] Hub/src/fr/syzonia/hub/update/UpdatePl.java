package fr.syzonia.hub.update;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.bukkit.Bukkit;

import fr.syzonia.hub.Hub;

public class UpdatePl {

	 private int resourceId;
		
		public boolean updateCheck(){
		        setResourceId(108424);
		        try {
					URL url = new URL("https://api.spigotmc.org/legacy/");
		            HttpURLConnection con = (HttpURLConnection) url.openConnection();
		            con.setRequestMethod("GET");
		            con.setConnectTimeout(5000);
		            con.setReadTimeout(5000);

		            BufferedReader in = new BufferedReader(
		                    new InputStreamReader(con.getInputStream()));
		            String inputLine;
		            StringBuffer content = new StringBuffer();
		            while ((inputLine = in.readLine()) != null) {
		                content.append(inputLine);
		            }
		            in.close();
		            if (!(content.toString().equals(Hub.getInstance().getDescription().getVersion()))) {
		                return true;
		            }
		        } catch (Exception e) {
		            Bukkit.getConsoleSender().sendMessage("§cError :c" + e.getMessage());
		            return false;
		        }
		        return false;
		    }

		public int getResourceId() {
			return resourceId;
		}

		public void setResourceId(int resourceId) {
			this.resourceId = resourceId;
		}
	
}
