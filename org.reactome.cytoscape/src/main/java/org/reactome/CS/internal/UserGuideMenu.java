package org.reactome.CS.internal;

import java.awt.event.ActionEvent;


import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.application.swing.AbstractCyAction;
import org.cytoscape.application.swing.CySwingApplication;
import org.cytoscape.util.swing.OpenBrowser;


/**
 * Creates a new menu item under Apps menu section.
 *
 */
public class UserGuideMenu extends AbstractCyAction {

	private CySwingApplication desktopApp;
	private OpenBrowser browser;
	private String  userGuideURL = "http://wiki.reactome.org/index.php/Reactome_FI_Cytoscape_Plugin";

	public UserGuideMenu(CySwingApplication desktopApp,
		CyApplicationManager cyApplicationManager, final String menuTitle,
		OpenBrowser browser)
	{
		super(menuTitle, cyApplicationManager, null, null);
		this.desktopApp = desktopApp;
		this.browser = browser;
		
		setPreferredMenu("Apps.Reactome FI");
		setMenuGravity(10.0f);
		
	}

	public void actionPerformed(ActionEvent e)
	{
	    browser.openURL(userGuideURL);
	}
}
