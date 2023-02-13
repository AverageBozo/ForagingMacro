package com.foragingmacro.foragingmacromod;

import net.minecraft.client.Minecraft;

import java.awt.Robot;

public class Press extends Thread {
    public int keyCode1;
    public long delay1;
    private Robot robot1;
    private static Press press;
    @Override
    public void run() {
        robot1.keyPress(keyCode1);
        try {
            Thread.sleep(delay1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        robot1.keyRelease(keyCode1);
    }
    public Press(int button, long delay, Robot robot) {
        keyCode1 = button;
        delay1 = delay;
        robot1 = robot;
    }
    public static void press(int keyCode, long delay, Robot robot) {
        press = new Press(keyCode, delay, robot);
        press.setPriority(3);
        press.start();
        Minecraft.getMinecraft().thePlayer.sendChatMessage(Integer.toString(press.getPriority()));
    }
}