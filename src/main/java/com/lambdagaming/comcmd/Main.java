package com.lambdagaming.comcmd;

import org.apache.logging.log4j.Logger;
import com.lambdagaming.comcmd.proxy.CommonProxy;
import com.lambdagaming.comcmd.util.Reference;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

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
        MinecraftForge.EVENT_BUS.register( new PlayerJoinEventHandler() );
	}
}
