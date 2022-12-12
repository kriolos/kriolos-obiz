/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.kriolos.opos.basereport.node;

import java.io.IOException;
import javax.swing.Action;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.actions.NewAction;
import org.openide.actions.OpenLocalExplorerAction;
import org.openide.actions.PropertiesAction;
import org.openide.actions.ToolsAction;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle.Messages;
import org.openide.util.actions.SystemAction;
import org.openide.util.datatransfer.NewType;

/**
 *
 * @author poolb
 */
@Messages({
    "LBL_AllPropsNode=System Properties",
    "HINT_AllPropsNode=Shows all currently set system properties."
})
public class SitesRootNode extends AbstractNode {

    public SitesRootNode() {
        super(Children.create(new SitesChildFactory(), false));
        setDisplayName(Bundle.LBL_AllPropsNode());
        setShortDescription(Bundle.HINT_AllPropsNode());
        setIconBaseWithExtension("org/myorg/systemproperties/allPropsIcon.gif");
    }

    @Override
    public Action[] getActions(boolean context) {
        Action[] result = new Action[]{
            new RefreshSitesAction(),
            null,
            SystemAction.get(OpenLocalExplorerAction.class),
            null,
            SystemAction.get(NewAction.class),
            null,
            SystemAction.get(ToolsAction.class),
            SystemAction.get(PropertiesAction.class),};
        return result;
    }

    @Override
    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }

    @Override
    public Node cloneNode() {
        return new SitesRootNode();
    }

    @Messages({
        "LBL_NewProp=System Property",
        "LBL_NewProp_dialog=Create New Property",
        "MSG_NewProp_dialog_key=New property name:",
        "MSG_NewProp_dialog_value=New property value:"})
    @Override
    public NewType[] getNewTypes() {
        return new NewType[]{
            new NewType() {
                @Override
                public String getName() {
                    return Bundle.LBL_NewProp();
                }
                @Override
                public void create() throws IOException {
                    NotifyDescriptor.InputLine msg = new NotifyDescriptor.InputLine(Bundle.LBL_NewProp_dialog(), Bundle.MSG_NewProp_dialog_key());
                    DialogDisplayer.getDefault().notify(msg);
                    String key = msg.getInputText();
                    if ("".equals(key)) {
                        return;
                    }
                    msg = new NotifyDescriptor.InputLine(Bundle.MSG_NewProp_dialog_value(), Bundle.MSG_NewProp_dialog_key());
                    DialogDisplayer.getDefault().notify(msg);
                    String value = msg.getInputText();
                    System.setProperty(key, value);
                    SiteNotifier.changed();
                }
            }
        };
    }

}