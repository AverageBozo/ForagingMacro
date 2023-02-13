package com.foragingmacro;

import com.foragingmacro.foragingmacromod.StartCommand;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = "foragingxpdisplay", name = "Foraging Macro", version = "2.4.1", clientSideOnly = true, acceptedMinecraftVersions = "[1.8.9]")
public class MacroModModules {

    @Mod.EventHandler
    public void init(FMLPostInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new StartCommand());
    }
}