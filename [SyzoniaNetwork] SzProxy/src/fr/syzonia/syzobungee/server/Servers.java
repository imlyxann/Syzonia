package fr.syzonia.syzobungee.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Comparator;

import fr.syzonia.bungeedb.mysql.DatabaseManager;

public class Servers {

		public void create(String name, int port) {
		    String serverName = name; // Nom du serveur
		    String modelFolder = "C:\\Users\\Sacha\\OneDrive\\Documents\\MC\\Serveur\\SyzoniaServLocal\\Lobby1";
		    String serverFolder = "C:\\Users\\Sacha\\OneDrive\\Documents\\MC\\Serveur\\SyzoniaServLocal\\" + serverName;
		    try {
		        copyFolder(new File(modelFolder), new File(serverFolder));
		    } catch (IOException e) {
		        e.printStackTrace();
		        return;
		    }
		    try {
		        modifyServerProperties(serverFolder + "/server.properties", serverName, port + "");
		    } catch (IOException e) {
		        e.printStackTrace();
		        return;
		    }
		    try {
		        startServer(serverFolder);
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		
		public static void copyFolder(File sourceFolder, File destinationFolder) throws IOException {
		    if (sourceFolder.isDirectory()) {
		        if (!destinationFolder.exists()) {
		            destinationFolder.mkdir();
		        }
		
		        String[] files = sourceFolder.list();
		
		        for (String file : files) {
		            File srcFile = new File(sourceFolder, file);
		            File destFile = new File(destinationFolder, file);
		            copyFolder(srcFile, destFile);
		        }
		    } else {
		        Files.copy(sourceFolder.toPath(), destinationFolder.toPath(), StandardCopyOption.REPLACE_EXISTING);
		    }
		}
		
		public static void modifyServerProperties(String filePath, String name, String port) throws IOException {
		    File file = new File(filePath);
		
		    BufferedReader reader = new BufferedReader(new FileReader(file));
		    String line;
		    StringBuilder stringBuilder = new StringBuilder();
		
		    while ((line = reader.readLine()) != null) {
		        if (line.startsWith("server-name=")) {
		            line = "server-name=" + name; 
		        } else if(line.startsWith("server-port=")){
		        	line = "server-port=" + port;	 
		        } else if(line.startsWith("server-ip=")) {
		        	line = "server-ip=" + "localhost";	 
		        }
		        stringBuilder.append(line).append("\n");
		    }
		    reader.close();
		
		    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		    writer.write(stringBuilder.toString());
		    writer.close();
		}

		public static void startServer(String folderPath) throws IOException {
		    Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"cd " + folderPath + " && java -jar spigot.jar\"");
		}
		
		public void setStatus(int status, String name) {
			try {
				
				PreparedStatement stat = DatabaseManager.getConnexion().prepareStatement("UPDATE " + "server" + " SET status = ? WHERE server_name = ?");
				stat.setInt(1, status);
				stat.setString(2, name);
				stat.executeUpdate();
				stat.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	    public void removeServer(String servername) throws IOException {
	        Path path = Paths.get("C:\\Users\\Sacha\\OneDrive\\Documents\\MC\\Serveur\\SyzoniaServLocal\\" + servername);
	        if (Files.exists(path)) {
	            Files.walk(path).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
	        }
	    }
			
}
