package com.foragingmacro.foragingmacromod;

import net.minecraft.client.Minecraft;

import java.awt.Robot;
import java.awt.event.InputEvent;

public class Click extends Thread {
    public int button1;
    public long delay1;
    private Robot robot1;
    private static Click click;
    @Override
    public void run() {
        robot1.mousePress(InputEvent.getMaskForButton(button1));
        try {
            Thread.sleep(delay1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        robot1.mouseRelease(InputEvent.getMaskForButton(button1));
    }
    public Click(int button, long delay, Robot robot) {
        button1 = button;
        delay1 = delay;
        robot1 = robot;
    }
    public static void click(int button, long delay, Robot robot) {
        click = new Click(button, delay, robot);
        click.setPriority(3);
        click.start();
    }
}