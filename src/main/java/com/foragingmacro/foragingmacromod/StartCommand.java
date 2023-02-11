package com.foragingmacro.foragingmacromod;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

import java.awt.*;

public class StartCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "startforagingmacro";
    }
    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "startforagingmacro";
    }
    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        try {
            ForagingMacro macro = new ForagingMacro();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}