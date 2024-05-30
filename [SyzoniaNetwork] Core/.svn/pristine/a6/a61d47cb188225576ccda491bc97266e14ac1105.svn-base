package fr.syzonia.core.packet;

import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.Packet;

public abstract class Subscribe {

	 public static void call(Packet<?> packet, Player player) {
		new Subscribe() { @Override public void handle(Packet<?> packet, Player player) {} }.handle(packet, player);
	 }
	 
	 public abstract void handle(Packet<?> packet, Player player);
	
	
}
