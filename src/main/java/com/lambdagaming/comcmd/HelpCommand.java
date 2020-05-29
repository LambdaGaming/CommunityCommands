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

public class HelpCommand extends CommandBase {
	@Override
	public void execute( MinecraftServer server, ICommandSender sender, String[] params ) throws CommandException {
		TextComponentString text = new TextComponentString( "List of available community commands: /rules, /group, /discord" );
		Style style = text.getStyle();
		style.setColor( TextFormatting.GOLD );
		sender.sendMessage( text );
	}
	
	@Override
	public String getName() {
		return "lambdahelp";
	}

	@Override
	public String getUsage( ICommandSender sender ) {
		return "/lambdahelp";
	}
	
	@Override
	public boolean checkPermission( MinecraftServer server, ICommandSender sender ) {
		return true;
	}
}
