package me.limeglass.skungee.bungeecord.handlers.returnables;

import java.net.InetAddress;
import java.util.stream.Collectors;

import me.limeglass.skungee.bungeecord.handlercontroller.SkungeePlayerHandler;
import me.limeglass.skungee.objects.packets.SkungeePacket;
import me.limeglass.skungee.objects.packets.SkungeePacketType;

public class PlayerServerHandler extends SkungeePlayerHandler {

	public PlayerServerHandler() {
		super(SkungeePacketType.PLAYERSERVER);
	}

	@Override
	public Object handlePacket(SkungeePacket packet, InetAddress address) {
		if (players == null || players.isEmpty())
			return null;
		return players.parallelStream()
				.map(player -> player.getServer().getInfo().getName())
				.collect(Collectors.toSet());
	}

}
