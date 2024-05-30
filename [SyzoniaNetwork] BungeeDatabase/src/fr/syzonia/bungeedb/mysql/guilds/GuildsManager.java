package fr.syzonia.bungeedb.mysql.guilds;

import java.sql.PreparedStatement;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import fr.syzonia.bungeedb.mysql.DatabaseManager;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;

public class GuildsManager {

	public static final String table = "guilds";
	
	public void create(String name, String creatorname, int status) {
		try {
			PreparedStatement stat = DatabaseManager.getConnexion().prepareStatement("INSERT INTO " + table + " (guild_name, creator_name, status, members_name, guild_color) VALUES (?, ?, ?, ?, ?)");
			stat.setString(1, name);
			stat.setString(2, creatorname);
			stat.setInt(3, status);
			stat.setString(4, creatorname + ";");
			stat.setInt(5, 1);
			stat.execute();
			stat.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void disband(String guildname) {
		try {
			PreparedStatement stat = DatabaseManager.getConnexion().prepareStatement("DELETE FROM `guilds` WHERE guild_name = '" + guildname + "'");
			stat.execute();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getGuild(String pseudo) {
		try {
			
			PreparedStatement stat = DatabaseManager.getConnexion().prepareStatement("SELECT guild_name FROM guilds WHERE creator_name = ?");
			stat.setString(1, pseudo);
			ResultSet rs = stat.executeQuery();
			String string = "";
			
			while(rs.next()) {
				string = rs.getString("guild_name");
			}
			stat.close();
			
			return string;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}		
	}
	

	
	public ChatColor getColor(String guildname) {
		try {
			
			PreparedStatement stat = DatabaseManager.getConnexion().prepareStatement("SELECT guild_color FROM guilds WHERE guild_name = ?");
			stat.setString(1, guildname);
			ResultSet rs = stat.executeQuery();
			int x = 0;
			
			while(rs.next()) {
				x = rs.getInt("guild_color");
			}
			
			if(x == 1) {
				return ChatColor.YELLOW;
			} else if(x == 2) {
				return ChatColor.AQUA;
			} else if(x == 3) {
				return ChatColor.RED;
			} else if(x == 4) {
				return ChatColor.BLUE;
			} else if(x == 5) {
				return ChatColor.BLACK;
			} else if(x == 6) {
				return ChatColor.DARK_AQUA;
			} else if(x == 7) {
				return ChatColor.GOLD;
			} else if(x == 8) {
				return ChatColor.DARK_PURPLE;
			} else if(x == 9) {
				return ChatColor.LIGHT_PURPLE;
			}
			stat.close();
			
			return null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public void setColor(String guild_name, int x) {
		try {
			PreparedStatement stat = DatabaseManager.getConnexion().prepareStatement("UPDATE guilds SET guild_color = ? WHERE guild_name = ?");
			stat.setString(1, guild_name);
			stat.setDouble(2, x);
			stat.executeUpdate();
			stat.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getCreator(String guild_name) {
		try {
			
			PreparedStatement stat = DatabaseManager.getConnexion().prepareStatement("SELECT creator_name FROM guilds WHERE guild_name = ?");
			stat.setString(1, guild_name);
			ResultSet rs = stat.executeQuery();
			String string = "";
			
			while(rs.next()) {
				string = rs.getString("creator_name");
			}
			stat.close();
			
			return string;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}		
	}
	
	public List<String> getAllGuilds() {
		List<String> guilds = new ArrayList<String>();
		try {
			
			PreparedStatement stat = DatabaseManager.getConnexion().prepareStatement("SELECT * FROM `guilds` WHERE 1");
			ResultSet rs = stat.executeQuery();
			
			while(rs.next()) {
				guilds.add(rs.getString("guild_name"));
			}
			stat.close();
			
			return guilds;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public String getStatus(String guild_name) {
		try {
			
			PreparedStatement stat = DatabaseManager.getConnexion().prepareStatement("SELECT status FROM guilds WHERE guild_name = ?");
			stat.setString(1, guild_name);
			ResultSet rs = stat.executeQuery();
			
			while(rs.next()) {
				int x = rs.getInt("status");
				if(x == 1) {
					return "Ouvert";
				} else if(x == 2) {
					return "Fermer";
				} else if(x == 3) {
					return "Complet";
				} else if(x == 4) {
					return "Sur Invitation";
				}
			}
			stat.close();
			
			return "";
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}		
	}
	
	public void setStatus(String guild_name, int x) {
		try {
			PreparedStatement stat = DatabaseManager.getConnexion().prepareStatement("UPDATE guilds SET status = ? WHERE guild_name = ?");
			stat.setString(1, guild_name);
			stat.setInt(2, x);
			stat.executeUpdate();
			stat.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void createGuildAllowOnJoin(UUID uuid) {
		if(!hasGuildAllow(uuid)) {
			try {
				PreparedStatement stat = DatabaseManager.getConnexion().prepareStatement("INSERT INTO players_guild_allow (uuid_player, pseudo_player, isAllow) VALUES (?, ?, ?)");
				stat.setString(1, uuid.toString());
				stat.setString(2, ProxyServer.getInstance().getPlayer(uuid).getName());
				stat.setInt(3, 1);
				stat.execute();
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean hasGuildAllow(UUID uuid) {
		try {
		    PreparedStatement preparedStatement = DatabaseManager.getConnexion().prepareStatement("SELECT pseudo_player FROM players_guild_allow WHERE uuid_player = ?");
		    preparedStatement.setString(1, uuid.toString());
		    ResultSet rs = preparedStatement.executeQuery();
 
		    while(rs.next()) {
		    	return true;
		    }
		    return false;
 
		}catch (SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	public int isAllow(String pseudo) {
		try {
			
			PreparedStatement stat = DatabaseManager.getConnexion().prepareStatement("SELECT isAllow FROM players_guild_allow WHERE pseudo_player = ?");
			stat.setString(1, pseudo);
			ResultSet rs = stat.executeQuery();
			int allow = 0;
			
			while(rs.next()) {
				allow = rs.getInt("isAllow");
			}
			stat.close();
			
			return allow;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}		
	}
	
	public void setAllow(int i, String pseudo) {
		try {
			
			PreparedStatement stat = DatabaseManager.getConnexion().prepareStatement("UPDATE players_guild_allow SET isAllow = ? WHERE pseudo_player = ?");
			stat.setInt(1, i);
			stat.setString(2, pseudo);
			stat.executeUpdate();
			stat.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<String> getMembersList(String guild_name) {
		Object cache = get("SELECT guild_name FROM guilds WHERE guild_name = '" + guild_name.toString() + "'", "guild_name");
		if(cache != null) {
			String ids  = (String) get("SELECT members_name FROM guilds WHERE guild_name = '" + guild_name.toString() + "'" , "members_name");
			return GuildsSerilization.SerilizationToList(ids);
		}
		return null;
	}
	
	public static String getMembersText(String guild_name) {
		Object cache = get("SELECT guild_name FROM guilds WHERE guild_name = '" + guild_name.toString() + "'", "guild_name");
		if(cache != null) {
			String ids  = (String) get("SELECT members_name FROM guilds WHERE guild_name = '" + guild_name.toString() + "'" , "members_name");
			return ids;
		}
		return "";
	}
	
	
	public static void addMembers(String guild_name, String id) {
		Object cache = get("SELECT guild_name FROM guilds WHERE guild_name = '" + guild_name.toString() + "'", "guild_name");
		if(cache != null) {
			List<String> members = getMembersList(guild_name);
			members.add(id);
			Update("UPDATE guilds SET members_name = '" + GuildsSerilization.ListToSerilization(members) + "' WHERE guild_name = '" + guild_name.toString() + "'");
		}
	}
	
	public static void removeMembers(String guild, String id) {
		Object cache = get("SELECT guild_name FROM guilds WHERE guild_name = '" + guild.toString() + "'", "guild_name");
		if(cache != null) {
			List<String> Members = getMembersList(guild);
			Members.remove(id);
			Update("UPDATE guilds SET members_name = '" + GuildsSerilization.ListToSerilization(Members) + "' WHERE guild_name = '" + guild.toString() + "'");
		}
	}
	
	public boolean MemberIsInGuild(String guild, String id) {
		Object cache = get("SELECT guild_name FROM guilds WHERE guild_name = '" + guild.toString() + "'", "guild_name");
		if(cache != null) {
			if(getMembersText(guild).contains(id + ";")) {
				return true;
			}
			return false;
		}
		return false;
	}
	
	public static void Request(String sql) {
		try {
			PreparedStatement stat = DatabaseManager.getConnexion().prepareStatement(sql);
			stat.execute();
			stat.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Object get(String query, String name) {
		try {
			
			PreparedStatement stat = DatabaseManager.getConnexion().prepareStatement(query);
			ResultSet set = stat.executeQuery();
			
			while(set.next()) {
				return set.getObject(name);
			}
			
			return null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static void Update(String sql) {
		try {
			PreparedStatement stat = DatabaseManager.getConnexion().prepareStatement(sql);
			stat.executeUpdate();
			stat.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
