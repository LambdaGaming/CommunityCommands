package com.lambdagaming.comcmd;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.ClickEvent.Action;

public class RulesCommand extends CommandBase {
	@Override
	public void execute( MinecraftServer server, ICommandSender sender, String[] params ) throws CommandException {
		String link = "https://lambdagaming.github.io/minecraft/main.html";
		TextComponentString text = new TextComponentString( link );
		Style style = text.getStyle();
		style.setColor( TextFormatting.BLUE );
		style.setUnderlined( true );
		style.setClickEvent( new ClickEvent( Action.OPEN_URL, link ) );
		sender.sendMessage( text );
	}
	
	@Override
	public String getName() {
		return "rules";
	}

	@Override
	public String getUsage( ICommandSender sender ) {
		return "/rules";
	}
	
	@Override
	public boolean checkPermission( MinecraftServer server, ICommandSender sender ) {
		return true;
	}
}
