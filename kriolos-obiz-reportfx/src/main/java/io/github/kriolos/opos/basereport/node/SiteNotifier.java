/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.kriolos.opos.basereport.node;

import javax.swing.event.ChangeListener;
import org.openide.util.ChangeSupport;
/**
 *
 * @author poolb
 */
public class SiteNotifier {
    private static final ChangeSupport cs = new ChangeSupport(SiteNotifier.class);

    public static void addChangeListener(ChangeListener listener) {
        cs.addChangeListener(listener);
    }

    public static void removeChangeListener(ChangeListener listener) {
        cs.removeChangeListener(listener);
    }

    public static void changed() {
        cs.fireChange();
    }

}
