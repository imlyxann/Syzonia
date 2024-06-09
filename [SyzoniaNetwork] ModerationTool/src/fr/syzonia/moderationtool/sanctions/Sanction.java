package fr.syzonia.moderationtool.sanctions;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.syzonia.core.gui.GuiManager;
import fr.syzonia.core.item.ItemBuilder;
import fr.syzonia.core.timeunit.TimeUnit;
import fr.syzonia.core.title.Title;
import fr.syzonia.moderationtool.Main;
import fr.syzonia.moderationtool.ban.Ban;
import fr.syzonia.syzodb.mysql.MySql;
import fr.syzonia.syzodb.mysql.PlayerInfo;

public class Sanction extends GuiManager implements CommandExecutor, Listener {

    public static HashMap<Player, Reason> reasons = new HashMap<Player, Reason>();

    public Sanction() {
        super("§4/ss   §7#We're Not Nazi", 9 * 6);
    }

    public void open(Player player) {
        if (!reasons.containsKey(player)) reasons.put(player, new Reason());
        inv.clear();
        inv.setItem(2, new ItemBuilder().type(Material.BOOK).name("§cMessage").lore("§aMettez une sanction pour Message").build());
        inv.setItem(3, new ItemBuilder().type(Material.BLAZE_ROD).name("§cCheat").lore("§aMettez une sanction pour Cheat").build());
        inv.setItem(4, new ItemBuilder().type(Material.APPLE).name("§cDiscrimination").lore("§aMettez une sanction pour Discrimination").build());
        inv.setItem(5, new ItemBuilder().type(Material.ANVIL).name("§cHarcèlement").lore("§aMettez une sanction pour Harcèlement").build());
        inv.setItem(6, new ItemBuilder().type(Material.ARROW).name("§cAutre").lore("§aMettez une sanction autres").build());
        int[] slots = {18, 19, 20, 21, 22, 23, 24, 25, 26};
        char[] glassname = {'S', 'y', 'z', 'o', 'n', 'i', 'a', 'S', 'S'};

        int count = 0;

        for (int slot : slots) {
            inv.setItem(slot, new ItemBuilder().type(Material.STAINED_GLASS_PANE).data((byte) 3).name(glassname[count] + "").build());
            count++;
        }

        player.openInventory(inv);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getAction() != null && event.getCurrentItem() == null) return;

        if (event.getInventory().getName().contains("§4/ss")) {
            event.setCancelled(true);

            ItemStack currentItem = event.getCurrentItem();
            if (currentItem == null || currentItem.getType() == Material.AIR) return;

            ItemMeta itemMeta = currentItem.getItemMeta();
            if (itemMeta == null || !itemMeta.hasDisplayName()) return;

            String displayName = itemMeta.getDisplayName();

            if (currentItem.getType().equals(Material.SKULL_ITEM)) {
                if (reasons.get((Player) event.getWhoClicked()).getMode() == 1) {
        	        TimeUnit unit = TimeUnit.getFromShortcut("h");
        	        long banTime = unit.getToSecond() * 24;
        	 
        	        Ban.disconnectBungee(event.getCurrentItem().getItemMeta().getDisplayName(), banTime, reasons.get((Player) event.getWhoClicked()).getReason());
        	        new Ban(MySql.getUUID(event.getCurrentItem().getItemMeta().getDisplayName()), banTime, reasons.get((Player) event.getWhoClicked()).getReason()).runTaskTimer(Main.Instance, 0L, 20L);
        	        event.getWhoClicked().sendMessage("§aVous avez banni §6" + event.getCurrentItem().getItemMeta().getDisplayName());
                } else {
                    String targetName = displayName;
                    Player targetPlayer = Bukkit.getPlayer(targetName);

                    if (targetPlayer == null) {
                        event.getWhoClicked().sendMessage("§cLe(a) joueur(se) est inconnu(e) ou Hors-Ligne!");
                    } else {
                        if (!Main.PlayerFreeze.contains(targetName)) {
                            Main.PlayerFreeze.add(targetName);
                            new Title().sendFullTitle(targetPlayer, 10, 30, 10, "§bFreeze", "§4Si tu quittes, c'est un ban!");
                            targetPlayer.sendMessage("§7[§bFreeze§7] §4Tu as été Freeze par §c" + event.getWhoClicked().getName());
                        } else {
                            event.getWhoClicked().sendMessage("§cCe joueur est déjà freeze");
                        }
                    }
                }
            } else {
                switch (displayName.substring(2)) {
                    case "Message":
                        SanctionType.Msg((Player) event.getWhoClicked(), this);
                        break;
                    case "Harcèlement":
                        SanctionType.Harc((Player) event.getWhoClicked(), this);
                        break;
                    case "Insultes":
                        SanctionType.FreezeOrBan((Player) event.getWhoClicked(), this, "Insultes");
                        break;
                    case "Moquerie":
                        SanctionType.FreezeOrBan((Player) event.getWhoClicked(), this, "Moquerie");
                        break;
                    case "Spam":
                        SanctionType.FreezeOrBan((Player) event.getWhoClicked(), this, "Spam");
                        break;
                    case "Message SMS":
                        SanctionType.FreezeOrBan((Player) event.getWhoClicked(), this, "Message SMS");
                        break;
                    case "Message Inutile":
                        SanctionType.FreezeOrBan((Player) event.getWhoClicked(), this, "Message Inutile");
                        break;
                    case "Insultes répétées":
                        SanctionType.FreezeOrBan((Player) event.getWhoClicked(), this, "Insultes répétées");
                        break;
                    case "Moquerie répétées":
                        SanctionType.FreezeOrBan((Player) event.getWhoClicked(), this, "Moquerie répétées");
                        break;
                    case "Spam répétées":
                        SanctionType.FreezeOrBan((Player) event.getWhoClicked(), this, "Spam répétées");
                        break;
                    case "Chantage":
                        SanctionType.FreezeOrBan((Player) event.getWhoClicked(), this, "Chantage");
                        break;
                    case "Freeze":
                        SanctionType.PlayerList((Player) event.getWhoClicked(), this, 2);
                        break;
                    case "Ban":
                        SanctionType.PlayerList((Player) event.getWhoClicked(), this, 1);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (PlayerInfo.getInfos(player.getUniqueId()).getRank() >= 5) {
                open(player);
            }
        }

        return true;
    }
}
