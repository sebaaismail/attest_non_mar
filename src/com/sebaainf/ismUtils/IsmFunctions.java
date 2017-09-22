package com.sebaainf.ismUtils;

import net.sf.jasperreports.engine.JRDefaultScriptlet;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by sebaainf.com on 13/05/2017.
 * https://bitbucket.org/sebaa_ismail
 * https://github.com/sebaaismail
 */
public class IsmFunctions extends JRDefaultScriptlet {

public String capitalizeFirstLetter(String original) {
    if (original == null || original.length() == 0) {
        return original;
    }
    return original.substring(0, 1).toUpperCase() + original.substring(1);
}

    public static BufferedImage process(BufferedImage old, String s
            ,JComponent comp) {
        int w = old.getWidth();
        int h = old.getHeight();
        BufferedImage img = new BufferedImage(
                w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.drawImage(old, 0, 0, w, h, comp);
        g2d.setPaint(Color.BLUE);
        g2d.setFont(new Font("Serif", Font.BOLD, 14));
        FontMetrics fm = g2d.getFontMetrics();
        int x = img.getWidth()*17/100;
        int y = fm.getHeight()*5;
        g2d.drawString(s, x, y);
        g2d.dispose();
        return img;
    }
}
