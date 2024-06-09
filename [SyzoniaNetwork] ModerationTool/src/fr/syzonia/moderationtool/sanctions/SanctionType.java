package fr.syzonia.moderationtool.sanctions;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import fr.syzonia.core.item.ItemBuilder;

public class SanctionType {

    /*
     * MSG
     */
    public static void Msg(Player player, Sanction inventory) {
        updateInventory(player, inventory, new String[]{"§cInsultes", "§cMoquerie", "§cSpam", "§cMessage SMS", "§cMessage Inutile"},
                new Material[]{Material.CACTUS, Material.BRICK, Material.LAVA_BUCKET, Material.NETHER_STAR, Material.PAPER});
    }

    /*
     * HARC
     */
    public static void Harc(Player player, Sanction inventory) {
        updateInventory(player, inventory, new String[]{"§cInsultes répétées", "§cMoquerie répétées", "§cSpam répétées", "§cChantage", "§c..."},
                new Material[]{Material.CACTUS, Material.BRICK, Material.LAVA_BUCKET, Material.NETHER_STAR, Material.PAPER});
    }

    /*
     * OPTIONS
     */
    public static void FreezeOrBan(Player player, Sanction inventory, String reason) {
        inventory.inv.setItem(39, new ItemBuilder().type(Material.GOLD_AXE).name("§cBan").build());
        inventory.inv.setItem(41, new ItemBuilder().type(Material.SIGN).name("§cFreeze").build());
        Sanction.reasons.get(player).setReason(reason);
        player.openInventory(inventory.getInv());
    }

    /*
     * LIST
     */
    public static void PlayerList(Player player, Sanction inventory, int type) {
        Sanction.reasons.get(player).setMode(type);
        inventory.inv.clear(); // Clear the inventory before adding new items
        for (Player p : Bukkit.getOnlinePlayers()) {
            inventory.inv.addItem(new ItemBuilder().type(Material.SKULL_ITEM).data((byte) 3).name(p.getName()).build());
        }
        player.openInventory(inventory.getInv());
    }

    private static void updateInventory(Player player, Sanction inventory, String[] names, Material[] materials) {
        inventory.inv.clear(); // Clear the inventory before adding new items
        for (int i = 0; i < names.length; i++) {
            inventory.inv.setItem(20 + i, new ItemBuilder().type(materials[i]).name(names[i]).build());
        }
        player.openInventory(inventory.getInv());
    }
}
