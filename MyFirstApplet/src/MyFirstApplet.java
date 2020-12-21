/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.*;
import java.awt.*;

/**
 *
 * @author Manohar V
 */
public class MyFirstApplet extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void paint(Graphics g) {
        // TODO start asynchronous download of heavy resources
        g.drawString("Hello, World",100,100);
    }

    // TODO overwrite start(), stop() and destroy() methods
}
