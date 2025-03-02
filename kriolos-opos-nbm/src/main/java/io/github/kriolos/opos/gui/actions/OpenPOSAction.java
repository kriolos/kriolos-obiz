/*
 * Copyright (C) 2022 Paulo Borges
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.github.kriolos.opos.gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Window",
        id = "io.github.kriolos.opos.gui.actions.OpenPOSAction"
)
@ActionRegistration(
        iconBase = "io/github/kriolos/opos/gui/icons/app_logo.png",
        displayName = "#CTL_OpenPOSAction"
)
@ActionReferences({
    @ActionReference(path = "Menu/Window", position = -100),
    @ActionReference(path = "Toolbars/KriolosPOS", position = 300)
})
@Messages("CTL_OpenPOSAction=Open POS")
public final class OpenPOSAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ev) {
        // TODO use context
    }
}
