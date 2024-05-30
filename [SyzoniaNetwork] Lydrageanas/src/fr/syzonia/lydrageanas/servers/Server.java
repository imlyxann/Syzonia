package fr.syzonia.lydrageanas.servers;

import java.util.List;

import fr.syzonia.lydrageanas.Main;

import java.io.File;
import java.sql.SQLException;
import java.util.Arrays;
import net.md_5.bungee.api.config.ServerInfo;


public class Server {

	public ServerType type;
	public ServersCommon common;
	public ServerInfo info;
	
	public Server(ServerType type, ServersCommon common, ServerInfo info) {
		this.type = type;
		this.common = common;
		this.info = info;
	}
	
	public ServerType getType() {
		return type;
	}
	
	//	windows
		public void start() {
			String startpath = Main.INSTANCE.path.get(type)[0].replace("%id%", getID());
			ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/C", "start", ".\\start.bat").directory(new File(startpath));		
			try {														
				System.out.println("Startpath: " + startpath);			
				Process process = builder.start();					
				process.waitFor();
			} catch (Exception err) {
				err.printStackTrace();
			}
		}
		

		/*	linux		
		public void start() {
			String startpath = Main.INSTANCE.path.get(type)[0].replace("%id%", getID());
			ProcessBuilder builder = new ProcessBuilder("sh", "start.sh");
			System.out.println(startpath);
			try {														
				System.out.println("Startpath" + startpath);			
				builder.directory(new File(startpath));						
				Process process = builder.start();							
				
				process.waitFor();
			} catch (Exception err) {
				err.printStackTrace();
			}
		}									
		*/
		
		
		public void stop() throws SQLException {
			common.setStatus(0);
		}
		
		public void reload() throws SQLException {
			common.setStatus(3);
		}
		
	public String getID() {
		String id = "";
		List<Character> number = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
		for(char cha : common.getName().toCharArray()) {
			if(number.contains(cha)) id += new String(new char[] { cha });
		}
		return id;
	}
	
	public void sysout() {
		System.out.println(getID());
	}
	
}
