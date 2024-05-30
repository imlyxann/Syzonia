package fr.syzonia.syzobungee.commands;


import java.util.ArrayList;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.syzonia.bungeedb.mysql.FriendBDD;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;


public class FriendsCommand extends Command {
	
	public Map<ProxiedPlayer, ProxiedPlayer> requestFriends = new HashMap<ProxiedPlayer, ProxiedPlayer>();
	public Map<ProxiedPlayer, ProxiedPlayer> MP = new HashMap<>();
	public FriendBDD friendsBDD = new FriendBDD();
	public FriendsCommand() {
		super("friend", null, "friends", "poto", "f", "ami");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!(sender instanceof ProxiedPlayer)) {
			sender.sendMessage(new TextComponent("Commande uniquement pour les joueurs! debilos va!"));
			return;
		}
		
		ProxiedPlayer proxiedplayer = (ProxiedPlayer) sender;
		
		if(args.length == 0) {
			displayHelp(proxiedplayer);
		}
		
		if(args.length == 1) {
			if(args[0].equalsIgnoreCase("accept")) {
				if(!(requestFriends.containsKey(proxiedplayer))) {
					sendMessage(proxiedplayer, "§cVous n'avez pas de demande d'amis en cours");
					return;
				}
			
			
			if(requestFriends.get(proxiedplayer) == null) {
				sendMessage(proxiedplayer, "§cErreur lors de la demande d'ami");
				return;
			}
			
			if(friendsBDD.isFriendWith(proxiedplayer.getName(), requestFriends.get(proxiedplayer).getName())) {
				sendMessage(proxiedplayer, "§cVous êtes déjà amis avec cette personne");
				return;
			}
			
			friendsBDD.addFriend(proxiedplayer.getUniqueId(), requestFriends.get(proxiedplayer).getUniqueId());
			friendsBDD.addFriend(requestFriends.get(proxiedplayer).getUniqueId(), proxiedplayer.getUniqueId());
			
			sendMessage(proxiedplayer, "§6Vous êtes désormais amis avec §a" + requestFriends.get(proxiedplayer).getName() + "§6.");
			sendMessage(requestFriends.get(proxiedplayer), "§6Vous êtes désormais amis avec §a" + proxiedplayer.getName() + "§6.");
			
			requestFriends.remove(proxiedplayer);
			} else if(args[0].equalsIgnoreCase("refuse")) {
				
				if(!(requestFriends.containsKey(proxiedplayer))) {
					sendMessage(proxiedplayer, "§cVous n'avez pas de demande d'amis en cours");
					return;
				}
				
				if(requestFriends.get(proxiedplayer) == null) {
					sendMessage(proxiedplayer, "§cErreur lors de la demande d'ami");
					return;
				}
				
				if(friendsBDD.isFriendWith(proxiedplayer.getName(), requestFriends.get(proxiedplayer).getName())) {
					sendMessage(proxiedplayer, "§cVous êtes déjà ami avec cette personne");
					return;
				}
				
				sendMessage(proxiedplayer, "§cVous avez réfusé la demande d'amis de §a" + requestFriends.get(proxiedplayer).getName() + "§6.");
				sendMessage(requestFriends.get(proxiedplayer), "§e" + proxiedplayer.getName() + "§6a réfusé votre demande d'amis..");
				requestFriends.remove(proxiedplayer);
				
			} else if (args[0].equalsIgnoreCase("list")) {
				if(friendsBDD.getFriendsCounter(proxiedplayer.getName()) == 0) {
					sendMessage(proxiedplayer, "§cVous n'avez pas d'amis sur le serveur");
					return;
				} else {
					List<String> friendOnline = new ArrayList<String>();
					List<String> friendOffline = new ArrayList<String>();
					
					for(String amis : friendsBDD.getFriendList(proxiedplayer.getName())) {
						if(ProxyServer.getInstance().getPlayer(amis) == null) {
							friendOffline.add(amis);
						} else {
							friendOnline.add(amis);
						}
					}
						sendMessage(proxiedplayer, " ");
					
						if(friendOnline.isEmpty()) {
							sendMessage(proxiedplayer, "§eAmis en ligne : §cAucun(s) amis(s) en ligne.");
						} else {
							String colorPath = "§a";
							for (int x = 0; x < friendOnline.size(); x++)
								colorPath = colorPath + friendOnline.get(x) + ", ";
							colorPath.trim();
							sendMessage(proxiedplayer, "§eAmie en ligne : §a[" + colorPath.substring(0, colorPath.length() - 2).replace("§a", "") + "§a]");
						}
						
						if(friendOffline.isEmpty()) {
							sendMessage(proxiedplayer, "§eAmis hors-ligne : §cAucun(s) amis(s) en ligne.");
						} else {
							String colorPath = "§c";
							for (int x = 0; x < friendOffline.size(); x++)
								colorPath = colorPath + friendOffline.get(x) + ", ";
							colorPath.trim();
							sendMessage(proxiedplayer, "§eAmie Hors ligne : §c[" + colorPath.substring(0, colorPath.length() - 2).replace("§c", "") + "§c]");
							}
						
						}
				
					} else if (args[0].equalsIgnoreCase("add")) {
						if(args.length < 2) {
							displayHelp(proxiedplayer);
							return;
						} 
					} else if(args[0].equalsIgnoreCase("remove")) {
						if(args.length < 2) {
							displayHelp(proxiedplayer);
							return;
						}
					} else if (args[0].equalsIgnoreCase("enable")) {
						if (friendsBDD.isAllow(proxiedplayer.getName()) == 0) {
							friendsBDD.setAllow(1, proxiedplayer.getName());
							sendMessage(proxiedplayer, "§eDemandes d'amis §aactivées");
						} else {
							sendMessage(proxiedplayer, "§cVous acceptez déjà les demandes d'amis");
						}
					} else if (args[0].equalsIgnoreCase("disable"))	{
						if(friendsBDD.isAllow(proxiedplayer.getName()) == 1) {
							friendsBDD.setAllow(0, proxiedplayer.getName());
							sendMessage(proxiedplayer, "§eDemandes d'amis §adésactivées");
						} else {
							sendMessage(proxiedplayer, "§cVous refusez déjà les demandes d'amis");
						}
					}
			}
				   if (args.length == 2) {
					   if(args[0].equalsIgnoreCase("add")) {
						   String targetName = args[1];
						   if(ProxyServer.getInstance().getPlayer(targetName) != null) {
							   if(friendsBDD.isAllow(targetName) == 1) {
								   if(friendsBDD.isAllow(proxiedplayer.getName()) == 1) {
									   
									   if (requestFriends.containsValue(proxiedplayer)) {
											 sendMessage(proxiedplayer, "§cVous avez déjà une demande d'ami en cours");
											 return;
										 }
										 
										 if (ProxyServer.getInstance().getPlayer(targetName) == proxiedplayer) {
											 sendMessage(proxiedplayer, "§cVous ne pouvez pas vous ajoutez vous même!");
											 return;
										 }
										 
										 if(friendsBDD.isFriendWith(proxiedplayer.getName(), ProxyServer.getInstance().getPlayer(targetName).getName())) {
												sendMessage(proxiedplayer, "§cVous êtes déjà amis avec cette personne");
												return;
											}
										 
										 ProxiedPlayer target = ProxyServer.getInstance().getPlayer(targetName);
										 requestFriends.put(target, proxiedplayer);
										 sendMessage(target, "§e" + proxiedplayer.getName() + " §6vous a demandez en amis.");
										 sendMessage(proxiedplayer, "§6Vous avez demandé en amis §e" + targetName);
									   
								   }
							   }
						   }
					   } else if (args[0].equalsIgnoreCase("remove")){
						   String targetName = args[1];
						   
					   if(!friendsBDD.isFriendWith(proxiedplayer.getName(), targetName)) {
						   sendMessage(proxiedplayer, "§cVous n'êtes pas amis avec cette personne.");
						   return;
					   }
					   
					   sendMessage(proxiedplayer, "§eVous êtes désormais plus amis avec §6" + targetName);
					   friendsBDD.removeFriend(proxiedplayer.getName(), targetName);
					   friendsBDD.removeFriend(targetName, proxiedplayer.getName());
					   }
				   }				 
		}
			
	
			
	
	private void displayHelp(ProxiedPlayer p) {
		sendMessage(p, " ");
		sendMessage(p, " §7> §e§lSystème §f§l| §e§lAmis");
		sendMessage(p, " §8> §6/friends add [pseudo] §7> §bAjoute un nouvel ami");
		sendMessage(p, " §8> §6/friends remove [pseudo] §7> §bSupprimer un de vos amis");
		sendMessage(p, " §8> §6/friend  [accept:refuse] §7> §bAccepter ou refuser une demande");
		sendMessage(p, " §8> §6/friends [enable:disable] §7> §bActivé ou désactivé les demandes");
		sendMessage(p, " §8> §6/friends list §7> §bVoir la liste de vos amis");
		sendMessage(p, " ");
	}
	
	private void sendMessage(ProxiedPlayer p, String string) {
		p.sendMessage(new TextComponent(string));
	}
	
}
