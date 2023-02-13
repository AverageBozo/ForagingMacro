package com.foragingmacro.foragingmacromod;

import net.minecraft.client.Minecraft;

import java.awt.*;
import java.awt.event.InputEvent;
import javax.swing.JFrame;

public class ForagingMacro {
    public ForagingMacro() throws AWTException, InterruptedException {
        PauseThread thread = new PauseThread();
        thread.start();
    }
}