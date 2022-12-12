/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.kriolos.opos.basereport.node;

import org.openide.util.NbBundle.Messages;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
/**
 *
 * @author poolb
 */
public class RefreshSitesAction extends AbstractAction {

    @Messages("LBL_RefreshSitesAction=Refresh")
    public RefreshSitesAction() {
        super(Bundle.LBL_RefreshSitesAction());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SiteNotifier.changed();
    }

}