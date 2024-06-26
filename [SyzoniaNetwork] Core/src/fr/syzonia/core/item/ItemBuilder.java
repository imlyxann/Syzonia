package fr.syzonia.core.item;

import java.util.Arrays;



import java.util.List;
import java.util.Map;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemBuilder {

		 
		private Material material = null;
		private Integer amount = Integer.valueOf(1);
		private Byte data = Byte.valueOf((byte) 0);
		private String displayName = null;
		private List<String> lore = null;
		private Map<Enchantment, Integer> enchantments = null;
		private String owner;
		private Color color;
		
	 
		/* USAGE
		 * 
		 * ItemStack itemStack = new ItemBuilder().type(Material.CHEST).amount(1).name("Â§cCoffre").lore("Lore", "du", "coffre.").build();
		 * On peut mettre des datas aussi. 
		 * 
		 */
	 
		public ItemBuilder() {}
	 
		public Material getMaterial() {
			return this.material;
		}
	 
		public Integer getAmount() {
			return this.amount;
		}
	 
		public Byte getData() {
			return this.data;
		}
	 
		public String getDisplayName() {
			return this.displayName;
		}
	 
		public List<String> getLore() {
			return this.lore;
		}
	 
		public Map<Enchantment, Integer> getEnchantments() {
			return this.enchantments;
		}
	 
		public ItemBuilder type(Material material) {
			this.material = material;
	 
			return this;
		}
	 
		public ItemBuilder amount(Integer amount) {
			this.amount = amount;
	 
			return this;
		}
	 
		public ItemBuilder data(Byte data) {
			this.data = data;
	 
			return this;
		}
	 
		public ItemBuilder name(String displayName) {
			this.displayName = displayName;
	 
			return this;
		}
	 
		public ItemBuilder lore(String... strings) {
			this.lore = Arrays.asList(strings);
	 
			return this;
		}
	 
		public ItemBuilder enchant(Enchantment enchantment, Integer level) {
			this.enchantments.put(enchantment, level);
	 
			return this;
		}
		
	 
		public ItemBuilder enchantments(Map<Enchantment, Integer> enchantments) {
			this.enchantments = enchantments;
	 
			return this;
		}
		
		
		public ItemBuilder setSkullOwner(String owner) {
				this.owner = owner;
				
				return this;
		}
		
		public ItemBuilder setLeatherColor(Color color) {
			this.color = color;
			
			return this;
		}
		
	 
		public ItemStack build() {
			ItemStack itemStack = new ItemStack(getMaterial(), getAmount().intValue(), (short) getData().byteValue());
			ItemMeta itemMeta;
			if ((this.displayName != null) || (this.lore != null)) {
				itemMeta = itemStack.getItemMeta();
				if(itemStack.getType() == Material.SKULL_ITEM) {
					SkullMeta skullmeta = (SkullMeta) itemMeta;
					skullmeta.setOwner(owner);
				}
				if(itemStack.getType() == Material.LEATHER_HELMET  || itemStack.getType() == Material.LEATHER_CHESTPLATE || itemStack.getType() == Material.LEATHER_LEGGINGS || itemStack.getType() == Material.LEATHER_BOOTS) {
					LeatherArmorMeta meta = (LeatherArmorMeta) itemMeta;
					meta.setColor(color);
				}
				if (this.displayName != null) {
					itemMeta.setDisplayName(this.displayName);
				}
				if (this.lore != null) {
					itemMeta.setLore(this.lore);
				}
				itemStack.setItemMeta(itemMeta);
			}
			if (this.enchantments != null) {
				for (Enchantment ench : this.enchantments.keySet()) {
					int level = ((Integer) this.enchantments.get(ench)).intValue();
					itemStack.addUnsafeEnchantment(ench, level);
				}
			}
			return itemStack;
		}
	
}
