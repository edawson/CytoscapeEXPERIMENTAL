package org.reactome.CS.internal;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.application.swing.AbstractCyAction;
import org.cytoscape.application.swing.CySwingApplication;
import org.cytoscape.work.Tunable;


/**
 * Creates a new menu item under Apps menu section.
 *
 */
public class GeneSetMutationAnalysisMenu extends AbstractCyAction {

	private CySwingApplication desktopApp;
	private String OLD_FI_VERSION = "2009";
	private String LATEST_FI_VERSION = "2013";
	
	public GeneSetMutationAnalysisMenu(CySwingApplication desktopApp,
		CyApplicationManager cyApplicationManager, final String menuTitle)
	{
		super(menuTitle, cyApplicationManager, null, null);
		this.desktopApp = desktopApp;

		setPreferredMenu("Apps.Reactome FI");
		setMenuGravity(1.0f);

		
	}

	public void actionPerformed(ActionEvent e)
	{
	    
	}
	private class MutationDataPopoutMenu extends JDialog
	{
	    CySwingApplication desktopApp;
	    public MutationDataPopoutMenu(CySwingApplication desktopApp)
	    {
	    }
	}
}
