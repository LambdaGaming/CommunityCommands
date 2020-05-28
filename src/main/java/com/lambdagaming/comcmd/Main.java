package com.lambdagaming.comcmd;

import org.apache.logging.log4j.Logger;
import com.lambdagaming.comcmd.proxy.CommonProxy;
import com.lambdagaming.comcmd.util.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod( modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION )
public class Main {
	@Instance
	public static Main instance;
	
	@SidedProxy( clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS )
	public static CommonProxy proxy;
	
	public static Logger logger;
	
	@EventHandler
	public static void PreInit( FMLPreInitializationEvent event )
	{
		logger = event.getModLog();
	}
	
	@EventHandler
	public static void init( FMLServerStartingEvent event )
	{
		logger.info( "[CommunityCommands] Successfully loaded." );
        event.registerServerCommand( new RulesCommand() );
        event.registerServerCommand( new GroupCommand() );
        event.registerServerCommand( new DiscordCommand() );
        event.registerServerCommand( new HelpCommand() );
	}
}
