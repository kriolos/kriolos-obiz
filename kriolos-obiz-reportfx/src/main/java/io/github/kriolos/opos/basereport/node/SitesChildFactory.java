/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.kriolos.opos.basereport.node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Node;
/**
 *
 * @author poolb
 */
public class SitesChildFactory extends ChildFactory.Detachable<String> {

    private ChangeListener listener;

    @Override
    protected void addNotify() {
        SiteNotifier.addChangeListener(listener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ev) {
                refresh(true);
            }
        });
    }

    @Override
    protected void removeNotify() {
        if (listener != null) {
            SiteNotifier.removeChangeListener(listener);
            listener = null;
        }
    }

    @Override
    protected Node createNodeForKey(String key) {
        return new SiteNode(key);
    }

    @Override
    protected boolean createKeys(List<String> toPopulate) {
        List<String> keys = new ArrayList<String>();
        for (Object prop : System.getProperties().keySet()) {
            keys.add((String) prop);
        }
        Collections.sort(keys);
        toPopulate.addAll(keys);
        return true;
    }

}