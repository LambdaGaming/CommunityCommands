package com.lambdagaming.comcmd;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class PlayerJoinEventHandler {
	@SubscribeEvent
	public void OnPlayerJoin( PlayerLoggedInEvent event )
	{
		if ( event.player.getServer().isDedicatedServer() )
		{
			String name = event.player.getName();
			TextComponentString text = new TextComponentString( "Welcome, " + name + "! Type /lambdahelp for a list of community commands." );
			Style style = text.getStyle();
			style.setColor( TextFormatting.GOLD );
			event.player.sendMessage( text );
		}
	}
}
