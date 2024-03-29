package org.reactome.CS.internal;

import java.util.Properties;


import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.application.swing.CySwingApplication;
import org.cytoscape.model.CyNetworkFactory;
import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.session.CySessionManager;
import org.cytoscape.util.swing.FileUtil;
import org.cytoscape.util.swing.OpenBrowser;
import org.cytoscape.view.model.CyNetworkViewFactory;
import org.osgi.framework.BundleContext;
import org.reactome.CS.internal.*;


public class CyActivator extends AbstractCyActivator {

	public void start(BundleContext context) throws Exception {
		
	    	//Application, Session, and File managers
		CyApplicationManager cyApplicationManager = getService(context, CyApplicationManager.class);
		CySwingApplication desktopApp = getService(context, CySwingApplication.class);
		OpenBrowser browser = getService(context, OpenBrowser.class);
		CyNetworkFactory networkFactory = getService(context, CyNetworkFactory.class);
		CyNetworkViewFactory viewFactory = getService(context, CyNetworkViewFactory.class);
		CyNetworkManager netManager = getService(context, CyNetworkManager.class);
		CySessionManager sessionManager = getService(context, CySessionManager.class);
		FileUtil fileUtil = getService(context, FileUtil.class);
		//SaveSessionTaskFactory saveFactory = getService(context, SaveSessionTaskFactory.class);
		
		
		//Plugin related classes and services
		UserGuideMenu userGuideMenu = new UserGuideMenu(desktopApp,
			cyApplicationManager, "User Guide", browser);
		GeneSetMutationAnalysisMenu geneSetMenu = new GeneSetMutationAnalysisMenu(desktopApp,
			cyApplicationManager, netManager, sessionManager, fileUtil, "GeneSetMutation/Analysis");
		Properties properties = new Properties();
		
		registerAllServices(context, userGuideMenu, properties);
		registerAllServices(context, geneSetMenu, properties);
	}

}
