package org.reactome.CS.internal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Collection;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.application.swing.AbstractCyAction;
import org.cytoscape.application.swing.CySwingApplication;
import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.session.CySession;
import org.cytoscape.session.CySessionManager;
import org.cytoscape.util.swing.FileChooserFilter;
import org.cytoscape.util.swing.FileUtil;
import org.cytoscape.view.model.CyNetworkViewManager;
import org.reactome.CS.design.MenuActionDesigner;




public class MenuActionsImpl extends AbstractCyAction implements MenuActionDesigner
{

    private CySwingApplication desktopApp;
    private CyNetworkManager netManager;
    private CyApplicationManager appManager;
    private CySessionManager sessionManager;

    public MenuActionsImpl(String menuTitle,
	    CyApplicationManager appManager, CyNetworkManager netManager,
	    CySessionManager sessionManager,
	    FileUtil fileUtil)
    {
	super(menuTitle, appManager, null, null);
	this.desktopApp = desktopApp;
	this.netManager = netManager;
	this.appManager = appManager;
	this.sessionManager = sessionManager;
    }

    public void actionPerformed(ActionEvent e)
    {
	// TODO Auto-generated method stub
	
    }

    public boolean createNewSession()
    {
	int networkCount = netManager.getNetworkSet().size();
	if (networkCount == 0)
	    return true;
	String msg = "To use the Reactome FI application you must start a new session.\n"
		+ "Do you want to save your current session?";
	int reply = JOptionPane.showConfirmDialog(desktopApp.getJFrame(), msg, "Save Session?"
		,JOptionPane.YES_NO_CANCEL_OPTION);
	if (reply == JOptionPane.CANCEL_OPTION)
	    return false;
	if (reply == JOptionPane.NO_OPTION)
	{
	    CySession.Builder builder = new CySession.Builder();
	    sessionManager.setCurrentSession(builder.build(), "session.cys");
	}
	else
	{
	    //Save the current session and create a new one.
	    //FileUtil.SAVE;
	    if (sessionManager.getCurrentSession() == null)
		return false;
	    CySession.Builder builder = new CySession.Builder();
	    sessionManager.setCurrentSession(builder.build(), "session.cys");
	}
	return true;
    }

    public boolean validateFile()
    {
	// TODO Auto-generated method stub
	return false;
    }

    public void createFileChooseGUIs(final JTextField fileField,
	    				final JButton okBtn,
	    				final Collection<FileChooserFilter> filters,
	    				JPanel filePanel
	    				)
    {
	JLabel fileLabel = new JLabel("Choose data file:");
        filePanel.add(fileLabel);
        fileField.getDocument().addDocumentListener(new DocumentListener() {
            
            //@Override
            public void removeUpdate(DocumentEvent e) {
                if (fileField.getText().trim().length() > 0)
                    okBtn.setEnabled(true);
                else
                    okBtn.setEnabled(false);
            }
            
            //@Override
            public void insertUpdate(DocumentEvent e) {
                if (fileField.getText().trim().length() > 0)
                    okBtn.setEnabled(true);
                else
                    okBtn.setEnabled(false);
            }
            
            //@Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        fileField.setColumns(20);
//        fileField.setText("This should be a full path name for a file!");

        filePanel.add(fileField);

        JButton browseBtn = new JButton("Browse");
        browseBtn.addActionListener(new ActionListener() {
            
            //@Override
            public void actionPerformed(ActionEvent e) {
              //  browseDataFile(fileField, fileTitle, fileFilters);
            }
        });

        filePanel.add(browseBtn);
        // Disable okBtn as default
        okBtn.setEnabled(false);
    }

    public void chooseFile()
    {
	// TODO Auto-generated method stub
	
    }

    public void browseDataFile()
    {
	// TODO Auto-generated method stub
	
    }

}
