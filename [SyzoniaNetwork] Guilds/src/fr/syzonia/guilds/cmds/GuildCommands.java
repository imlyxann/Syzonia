package fr.syzonia.guilds.cmds;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.syzonia.bungeedb.mysql.DatabaseManager;
import fr.syzonia.bungeedb.mysql.guilds.GuildsManager;
import fr.syzonia.guilds.guild.GuildComponent;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class GuildCommands extends Command {

	public static Map<ProxiedPlayer, String> requestGuild = new HashMap<ProxiedPlayer, String>();
	
	public GuildCommands() {
		super("guilds");
	}
	
	public static final String PREFIX = "§7[§aGuilds§7]";
	public GuildsManager guildsManager = new GuildsManager();
	public GuildComponent guildsComponent = new GuildComponent();

	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!(sender instanceof ProxiedPlayer)) {
			sender.sendMessage(new TextComponent("Commande uniquement pour les joueurs! debilos va!"));
			return;
		}
		
		ProxiedPlayer player = (ProxiedPlayer) sender;
		
		if(args.length == 0) {
			displayHelp(player);
		}
		
		if(args.length == 1) {
			if (args[0].equalsIgnoreCase("list")) {
				if(guildsComponent.getPlayerGuild(player.getName()) == null) {
					return;
				}
				
				List<String> members = GuildsManager.getMembersList(guildsComponent.getPlayerGuild(player.getName()));
				
				  StringBuilder builder = new StringBuilder();
                  for (int i = 0; i < members.size(); i++) {
                      builder.append(members.get(i));
                      if (i < members.size() - 1) {
                          builder.append(", ");
                      }
                  }

                  sendMessage(player, "§aMembres §f» §e" + builder);
			}
		} else if (args.length == 2) {
			if(args[0].equalsIgnoreCase("create")) {
				
				String name = args[1];
				
				if(guildsComponent.getPlayerGuild(player.getName()) != null) {
					sendMessage(player, "§cTu as déjà une guild!");
					return;
				}
				
				if(name == null) {
					return;
				}
				
				if(name.length() > 24) {
					sendMessage(player, "§cLe nom ne doit pas contenir plus 24 caractères !");
					return;
				}
				
				sendMessage(player, "§a" + name + " a été crée !");
				guildsManager.create(name, player.getName(), 1);
			} else if(args[0].equalsIgnoreCase("disband")) {
				String guild = args[1];
				
				if(guild == null) {
					return;
				}
				
				if(guildsComponent.getPlayerGuild(player.getName()) == null) {
					sendMessage(player, "§cTu n'as pas déjà une guild!");
					return;
				}
				
				if(!guildsManager.getCreator(guildsComponent.getPlayerGuild(player.getName())).equals(player.getName())) {
					sendMessage(player, "§cTu n'es pas le Créateur de ta Guild!");
					return;
				}
				
				guildsComponent.sendMessageToAll(guildsComponent.getPlayerGuild(player.getName()), "§e" + guild +" §c est supprimé. §bTu n'as plus de guild!");
				guildsManager.disband(guildsComponent.getPlayerGuild(player.getName()));
			} else { if(args[0].equalsIgnoreCase("invite")) {
				ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[1]);
				
				if(DatabaseManager.getUUID(args[1]) == null) {
					sendMessage(player, "§cLe joueur ne s'est jamais connecté sur le serveur :c");
					return;
				}
				
				if(target == null) {
					sendMessage(player, "§cLe joueur n'est pas connecté...");
					return;
				}
				
				if(target == player) {
					sendMessage(player, "§cTu ne peux pas!");
					return;
				}
				
				if(guildsComponent.getPlayerGuild(player.getName()) == null) {
					sendMessage(player, "§cTu n'as pas de guild!");
					return;
				}
				if(!guildsManager.getCreator(guildsComponent.getPlayerGuild(player.getName())).equals(player.getName())) {
					sendMessage(player, "§cTu n'es pas le Créateur de ta Guild!");
					return;
				}
				
				if(!(guildsManager.getStatus(guildsManager.getGuild(player.getName())).equalsIgnoreCase("Ouvert"))) {
					sendMessage(player, "§cT'as guild est au complet ou fermer!");
					return;
				}
				
				if(requestGuild.containsKey(target) && requestGuild.get(target).equals(guildsComponent.getPlayerGuild(player.getName()))) {
					sendMessage(player, "§cVous avez déjà envoyé une demande à " + target.getName());
					return;
				}
			/*	
				if(guildsManager.isAllow(target.getName()) == 0) {
					sendMessage(player, "§cCe joueur n'accepte pas les demandes de guilds");
					return;
				} */
				
				if(guildsComponent.getPlayerGuild(target.getName()) != null) {
					sendMessage(player, "§cCe joueur est déjà dans une guild");
					return;
				} 

				sendMessage(player, "§aVous avez invité §a" + target.getName() + " §adans §d" + guildsManager.getColor(guildsComponent.getPlayerGuild(player.getName())) + guildsComponent.getPlayerGuild(player.getName()));
				sendMessage(target, "§aVous êtes invité par §a" + player.getName() + " §adans §d" + guildsManager.getColor(guildsComponent.getPlayerGuild(player.getName())) + guildsComponent.getPlayerGuild(player.getName()));
				requestGuild.put(target, guildsComponent.getPlayerGuild(player.getName()));
			} else if (args[0].equalsIgnoreCase("removeinvite")){
				ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[1]);
 
				if(!!requestGuild.containsKey(target) || !requestGuild.get(target).equals(guildsComponent.getPlayerGuild(player.getName()))) {
					sendMessage(player, "§cVous avez déjà envoyé une demande à " + target.getName());
					return;
				}
				
				if(guildsComponent.getPlayerGuild(player.getName()) == null) {
					sendMessage(player, "§cTu n'as pas de guild!");
					return;
				}

				if(!guildsManager.getCreator(guildsComponent.getPlayerGuild(player.getName())).equals(player.getName())) {
					sendMessage(player, "§cTu n'es pas le Créateur de ta Guild!");
					return;
				}
				
				requestGuild.remove(player, guildsComponent.getPlayerGuild(player.getName()));
				sendMessage(player, "§aInvitation enlevée avec succès");
			} else if(args[0].equalsIgnoreCase("remove")) {
				ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[1]);
				
				if(DatabaseManager.getUUID(args[1]) == null) {
					sendMessage(player, "§cLe joueur ne s'est jamais connecté sur le serveur :c");
					return;
				}
				
				if(target == null) {
					sendMessage(player, "§cLe joueur n'est pas connecté...");
					return;
				}
				
				if(target == player) {
					sendMessage(player, "§cTu ne peux pas!");
					return;
				}
				
				if(guildsComponent.getPlayerGuild(player.getName()) == null) {
					sendMessage(player, "§cTu n'as pas de guild!");
					return;
				}
				
				if(!guildsComponent.getPlayerGuild(player.getName()).equals(guildsComponent.getPlayerGuild(target.getName()))) {
					sendMessage(player, "§cCe joueur n'est pas dans " + guildsComponent.getPlayerGuild(player.getName()));
					return;
				}

				if(!guildsManager.getCreator(guildsComponent.getPlayerGuild(player.getName())).equals(player.getName())) {
					sendMessage(player, "§cTu n'es pas le Créateur de ta Guild!");
					return;
				}

				
				GuildsManager.removeMembers(guildsComponent.getPlayerGuild(player.getName()), target.getName());
				guildsComponent.sendMessageToAll(guildsComponent.getPlayerGuild(player.getName()), "§e" + target.getName() + " §ca été enlevé par §d" + player.getName());
			} else if(args[0].equalsIgnoreCase("accept")) {
				String guild = args[1];
				
				if(guild == null) {
					sendMessage(player, "§cErreur");
					return;
				}
				
				if(!requestGuild.containsKey(player)) {
					sendMessage(player, "§cVous n'avez pas de demande de guild...");
					return;
				}
				
				if(requestGuild.get(player) == null) {
					sendMessage(player, "§cErreur");
					return;
				}
				
				if(!requestGuild.get(player).equals(guild)) {
					sendMessage(player, "§cCette guild vous a pas invité.");
					return;
				}
			
				requestGuild.remove(player, guild);
				GuildsManager.addMembers(guild, player.getName());
				sendMessage(player, "§aTu as rejoins " + guildsManager.getColor(guild) + guild);
				guildsComponent.sendMessageToAll(guild, "§d" + player.getName() + " §a est maitenant dans " + guildsManager.getColor(guild) + guild);
			} else if(args[0].equalsIgnoreCase("refuse")) {
				String guild = args[1];
				
				if(guild == null) {
					sendMessage(player, "§cErreur");
					return;
				}
				
				if(!requestGuild.containsKey(player)) {
					sendMessage(player, "§cVous n'avez pas de demande de guild...");
					return;
				}
				
				if(requestGuild.get(player) == null) {
					sendMessage(player, "§cErreur");
					return;
				}
				
				if(!requestGuild.get(player).equals(guild)) {
					sendMessage(player, "§cCette guild vous a pas invité.");
					return;
				}
			
				sendMessage(player, "§aDemande refusée avec succès pour " + guildsManager.getColor(guild) + guild);
				requestGuild.remove(player, guild);
			} else if(args[0].equalsIgnoreCase("setcolor")) {
				int guild = Integer.parseInt(args[1]);
				
				if(guildsComponent.getPlayerGuild(player.getName()) == null) {
					sendMessage(player, "§cTu n'as pas de guild!");
					return;
				}

				if(!guildsManager.getCreator(guildsComponent.getPlayerGuild(player.getName())).equals(player.getName())) {
					sendMessage(player, "§cTu n'es pas le Créateur de ta Guild!");
					return;
				}
				
				guildsManager.setColor(guildsComponent.getPlayerGuild(player.getName()), guild);
				sendMessage(player, "§aCouleur actualisé, " + guildsManager.getColor(guildsComponent.getPlayerGuild(player.getName())) + guild);
			} else if(args[0].equalsIgnoreCase("leave")) {
				String guild = args[1];
				
				if(guild == null) {
					sendMessage(player, "§cErreur");
					return;
				}
				
				if(guildsComponent.getPlayerGuild(player.getName()).equals(null)) {
					sendMessage(player, "§cVous n'avez pas dans de guild!");
					return;
				}
				
				
				if(!guildsComponent.getPlayerGuild(player.getName()).equals(guild)) {
					sendMessage(player, "§cVous n'êtes pas dans cette guild!");
					return;
				}
				
				if(guildsManager.getCreator(guild).equals(player.getName())) {
					sendMessage(player, "§cTu dois supprimer ta guild pour quitter!");
					return;
				}
				
				guildsComponent.sendMessageToAll(guild, "§e" + player.getName() + " §c a quitté la guild!");
				GuildsManager.removeMembers(guild, player.getName());
			}
			
			return;
			}
		}
	}
			
	
			
	
	private void displayHelp(ProxiedPlayer p) {
		sendNormalMessage(p, " ");
		sendNormalMessage(p, " §7> §e§lSystème §f§l| §c§lGuilds");
		sendNormalMessage(p, " §8» §6/guild create [Nom] §7> §bCréer une guild");
		sendNormalMessage(p, " §8» §6/guild disband [Nom] §7> §bSupprime une guild");
		sendNormalMessage(p, " §8» §6/guild invite [pseudo] §7> §bInviter un Joueur");
		sendNormalMessage(p, " §8» §6/guild remove [pseudo] §7> §bSupprimer un Joueur");
		sendNormalMessage(p, " §8» §6/guild  [accept:refuse] §7> §bAccepter ou refuser une demande");
		sendNormalMessage(p, " §8» §6/guild [enable:disable] §7> §bActivé ou désactivé les demandes");
		sendNormalMessage(p, " §8» §6/guild list §7> §bVoir la liste des membres");
		sendNormalMessage(p, " §cTu peux créer une seule guild!");
		sendNormalMessage(p, " ");
	}
	
	private void sendMessage(ProxiedPlayer p, String string) {
		p.sendMessage(new TextComponent(PREFIX + " " + string));
	}
	
	private void sendNormalMessage(ProxiedPlayer p, String string) {
		p.sendMessage(new TextComponent(string));
	}
	
	

}
