package com.foragingmacro.foragingmacromod;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

import java.awt.*;
import java.awt.event.InputEvent;

public class ForagingMacro extends Thread {
    Robot robot;
    boolean active;

    public ForagingMacro() throws AWTException {
        robot = new Robot();
        active = true;
    }

    public void run() {
        // these use the same hex value as the ASCII standard
        int a = 0x41;
        int d = 0x44;
        long milliseconds = 700;
        while (active) {
            if (Minecraft.getMinecraft().gameSettings.keyBindSneak.isKeyDown()) {
                active = false;
            }
            //press(saplingsSlot, 100);
            Minecraft.getMinecraft().thePlayer.inventory.currentItem = 1;
            robot.mousePress(InputEvent.getMaskForButton(3));
            strafe(new int[]{a, d}, milliseconds);
            robot.mouseRelease(InputEvent.getMaskForButton(3));
            Minecraft.getMinecraft().thePlayer.inventory.currentItem = 2;
            click(3, 500);
            Minecraft.getMinecraft().thePlayer.inventory.currentItem = 0;
            click(1, 100);
        }
    }
    public void click(int button, long delay) {
        robot.mousePress(InputEvent.getMaskForButton(button));
        try {
            Thread.sleep(delay);
        } catch(InterruptedException e) {}
        robot.mouseRelease(InputEvent.getMaskForButton(button));
    }

    public void press(int key, long delay) {
        robot.keyPress(key);
        try {
            Thread.sleep(delay);
        } catch(InterruptedException e) {}
        robot.keyRelease(key);
    }

    public void strafe(int[] keys, long delay) {
        for (int i = 0; i < keys.length; i++) {
            press(keys[i], delay);
        }
    }
}
