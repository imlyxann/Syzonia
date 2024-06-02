package fr.syzonia.syzobungee.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.TimeUnit;

import fr.syzonia.syzobungee.Main;
import io.netty.channel.unix.DomainSocketAddress;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.YamlConfiguration;

public class ConfigHelp {

	private static File file;
    private static Configuration bungeeConfig;
    private static boolean locked; // TODO: This is dumb. Writes are lost when locked

    static {
        // Plugins are loaded before the config (on first run) so uhhhhh, here we go
        setupConfig();

        if (locked) {
            ProxyServer.getInstance().getScheduler().schedule(Main.Instance, new Runnable() {
                @Override
                public void run() {
                    setupConfig();
                }
            }, 5L, TimeUnit.SECONDS);
        }
    }
	
	 public static void addToConfig(ServerInfo serverInfo) {
	        bungeeConfig.set("servers." + serverInfo.getName() + ".motd", serverInfo.getMotd().replace(ChatColor.COLOR_CHAR, '&'));
	        bungeeConfig.set("servers." + serverInfo.getName() + ".address", socketAddressToString(serverInfo.getSocketAddress(), true));
	        bungeeConfig.set("servers." + serverInfo.getName() + ".restricted", serverInfo.isRestricted());
	        saveConfig();
	    }
	 
	 private static void saveConfig() {
	        if (locked) {
	            return;
	        }

	        try {
	            YamlConfiguration.getProvider(YamlConfiguration.class).save(bungeeConfig, file);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private static void setupConfig() {
	        FileInputStream fis = null;
	        InputStreamReader isr = null;
	        try {
	            file = new File(ProxyServer.getInstance().getPluginsFolder().getParentFile(), "config.yml");

	            fis = new FileInputStream(file);
	            isr = new InputStreamReader(fis);

	            bungeeConfig = YamlConfiguration.getProvider(YamlConfiguration.class).load(isr);
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (fis != null) {
	                    fis.close();
	                }

	                if (isr != null) {
	                    isr.close();
	                }
	            } catch (IOException ignored) {}
	        }

	        locked = bungeeConfig == null;
	    }
	    
	    public static String socketAddressToString(SocketAddress socketAddress, boolean appendPort) {
	        String addressString;

	        if (socketAddress instanceof DomainSocketAddress) {
	            addressString = "unix:" + ((DomainSocketAddress) socketAddress).path();
	        } else if (socketAddress instanceof InetSocketAddress) {
	            InetSocketAddress inetAddress = (InetSocketAddress) socketAddress;

	            addressString = inetAddress.getHostString();

	            if (appendPort) {
	                addressString += ":" + inetAddress.getPort();
	            }
	        } else {
	            addressString = socketAddress.toString();
	        }

	        return addressString;
	    }
	
}
