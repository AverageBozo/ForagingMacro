package com.foragingmacro.foragingmacromod;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class ForagingMacro {
    Robot robot = new Robot();
    JFrame frame = new JFrame();
    boolean active = true;
    public ForagingMacro() throws AWTException, InterruptedException {
        // these use the same hex value as the ASCII standard
        int a = 0x41;
        int d = 0x44;
        long milliseconds = 700;
        // these slots are slot 1, 2 and 3
        int treecapSlot = 0x31;
        int saplingsSlot = 0x32;
        int boneMealSlot = 0x33;
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent key) {
                int code = key.getKeyCode();
                if(code == KeyEvent.VK_ESCAPE) {
                    active = false;
                }
            }
        });
        while (active) {
            press(saplingsSlot, 100);
            robot.mousePress(InputEvent.getMaskForButton(2));
            strafe(new int[]{a, d}, milliseconds);
            robot.mouseRelease(InputEvent.getMaskForButton(2));
            press(boneMealSlot, 100);
            click(2, 500);
            press(treecapSlot, 100);
            click(1, 100);
        }
    }

    public void click(int button, long delay) throws InterruptedException {
        robot.mousePress(InputEvent.getMaskForButton(button));
        Thread.sleep(delay);
        robot.mouseRelease(InputEvent.getMaskForButton(button));
    }

    public void press(int key, long delay) throws InterruptedException {
        robot.keyPress(key);
        Thread.sleep(delay);
        robot.keyRelease(key);
    }

    public void strafe(int[] keys, long delay) throws InterruptedException {
        for (int i = 0; i < keys.length; i++) {
            press(keys[i], delay);
        }
    }
}