/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.kriolos.opos.basereport.node;

import java.io.IOException;
import java.util.Properties;
import javax.swing.Action;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.openide.actions.DeleteAction;
import org.openide.actions.PropertiesAction;
import org.openide.actions.RenameAction;
import org.openide.actions.ToolsAction;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.nodes.PropertySupport;
import org.openide.nodes.Sheet;
import org.openide.util.NbBundle.Messages;
import org.openide.util.actions.SystemAction;
/**
 *
 * @author poolb
 */
public class SiteNode extends AbstractNode {

    private String key;
    private ChangeListener listener;

    @Messages("HINT_SiteNode=Represents one system property.")
    public SiteNode(String key) {
        super(Children.LEAF);
        this.key = key;
        setIconBaseWithExtension("org/myorg/systemproperties/SiteIcon.gif");
        super.setName(key);
        setShortDescription(Bundle.HINT_SiteNode());
    }

    @Override
    public Action[] getActions(boolean context) {
        Action[] result = new Action[]{
            SystemAction.get(DeleteAction.class),
            SystemAction.get(RenameAction.class),
            null,
            SystemAction.get(ToolsAction.class),
            SystemAction.get(PropertiesAction.class),};
        return result;
    }

    @Override
    public Action getPreferredAction() {
        return SystemAction.get(PropertiesAction.class);
    }

    @Override
    public Node cloneNode() {
        return new SiteNode(key);
    }

    @Messages({"PROP_value=Value","HINT_value=Value of this system property."})
    @Override
    protected Sheet createSheet() {
        Sheet sheet = super.createSheet();
        Sheet.Set props = sheet.get(Sheet.PROPERTIES);
        if (props == null) {
            props = Sheet.createPropertiesSet();
            sheet.put(props);
        }
        props.put(new PropertySupport.Name(this));
        class ValueProp extends PropertySupport.ReadWrite {
            public ValueProp() {
                super("value", String.class, Bundle.PROP_value(), Bundle.HINT_value());
            }
            @Override
            public Object getValue() {
                return System.getProperty(key);
            }
            @Override
            public void setValue(Object nue) {
                System.setProperty(key, (String) nue);
                SiteNotifier.changed();
            }
        }
        props.put(new ValueProp());
        SiteNotifier.addChangeListener(listener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ev) {
                firePropertyChange("value", null, null);
            }
        });
        return sheet;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if (listener != null) {
            SiteNotifier.removeChangeListener(listener);
        }
    }

    @Override
    public boolean canRename() {
        return true;
    }

    @Override
    public void setName(String nue) {
        Properties p = System.getProperties();
        String value = p.getProperty(key);
        p.remove(key);
        if (value != null) {
            p.setProperty(nue, value);
        }
        System.setProperties(p);
        SiteNotifier.changed();
    }

    @Override
    public boolean canDestroy() {
        return true;
    }

    @Override
    public void destroy() throws IOException {
        Properties p = System.getProperties();
        p.remove(key);
        System.setProperties(p);
        SiteNotifier.changed();
    }
    
}
