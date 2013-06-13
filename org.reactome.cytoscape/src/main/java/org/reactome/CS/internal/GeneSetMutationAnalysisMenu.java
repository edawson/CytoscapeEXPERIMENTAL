package org.reactome.CS.internal;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.application.swing.AbstractCyAction;
import org.cytoscape.application.swing.CySwingApplication;
import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.session.CySessionManager;
import org.cytoscape.util.swing.FileChooserFilter;
import org.cytoscape.util.swing.FileUtil;
import org.cytoscape.work.Tunable;
import org.gk.util.DialogControlPane;





/**
 * Creates a new menu item under Apps menu section.
 *
 */
public class GeneSetMutationAnalysisMenu extends MenuActionsImpl {

	private CySwingApplication desktopApp;
	private String OLD_FI_VERSION = "2009";
	private String LATEST_FI_VERSION = "2013";
	
	public GeneSetMutationAnalysisMenu(CySwingApplication desktopApp,
		CyApplicationManager cyApplicationManager,
		CyNetworkManager netManager,
		CySessionManager sessionManager,
		FileUtil fileUtil, final String menuTitle)
	{
		super(menuTitle, cyApplicationManager, netManager, sessionManager, fileUtil);
		this.desktopApp = desktopApp;

		setPreferredMenu("Apps.Reactome FI");
		setMenuGravity(1.0f);

		
	}

	public void actionPerformed(ActionEvent e)
	{
	    
	}
	private class MutationDataOptionDialog extends JDialog
	{
	    CySwingApplication desktopApp;
	    private boolean isOkClicked;
	    private JTextField sampleCutoffField;
	    private JCheckBox useLinkerBox;
	    private JCheckBox showUnlinkedBox;
	    private JCheckBox chooseHomoBox;
	    private JCheckBox fetchFIAnnotations;
	    private JLabel sampleCutoffLabel;
	    private JLabel sampleCommentLabel;
	    private JTextField fileTF;
	    // These radio buttons are used for file format
	    private JRadioButton geneSetBtn;
	    private JRadioButton geneSampleBtn;
	    private JRadioButton mafBtn;
	    public MutationDataOptionDialog(CySwingApplication desktopApp)
	    {
		super(desktopApp.getJFrame());
		init();
	    }
	    private void init() {
	            setTitle("Set Parameters for FI Network");
	            JPanel panel = new JPanel();
	            panel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
	            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	            // Add a pane for selecting a FI network version
	            FIVersionSelectionPanel versionPane = new FIVersionSelectionPanel();
	            Border etchedBorder = BorderFactory.createEtchedBorder();
	            Border titleBorder = BorderFactory.createTitledBorder(etchedBorder,
	                                                                  versionPane.getTitle());
	            versionPane.setBorder(titleBorder);
	            panel.add(versionPane);
	            // For loading files
	            JPanel loadPanel = new JPanel();
	            etchedBorder = BorderFactory.createEtchedBorder();
	            titleBorder = BorderFactory.createTitledBorder(etchedBorder, "Loading Altered Genes");
	            loadPanel.setBorder(titleBorder);
	            loadPanel.setLayout(new GridBagLayout());
	            GridBagConstraints constraints = new GridBagConstraints();
	            constraints.insets = new Insets(0, 4, 0, 0);
	            constraints.anchor = GridBagConstraints.WEST;
	            constraints.fill = GridBagConstraints.HORIZONTAL;
	            JLabel fileChooseLabel = new JLabel("Choose gene set/mutation file:");
	            fileTF = new JTextField();
	            // Add a control panel
	            DialogControlPane controlPane = new DialogControlPane();
	            JButton okBtn = controlPane.getOKBtn();
	            FileChooserFilter mafFilter = new FileChooserFilter("maf", "maf");
	            FileChooserFilter txtFilter = new FileChooserFilter("txt", "txt");
//	            createFileChooseGUIs(fileTF, 
//	                                 okBtn, 
//	                                 "Load Gene/Protein File",
//	                                 new CyFileFilter[]{new CyFileFilter("maf"), new CyFileFilter("txt")},
//	                                 loadPanel, 
//	                                 constraints);
	            
	            JLabel fileFormatLabel = new JLabel("Specify file format:");
	            geneSetBtn = new JRadioButton("Gene set");
	            geneSetBtn.setSelected(true);
	            geneSampleBtn = new JRadioButton("Gene/sample number pair");
	            mafBtn = new JRadioButton("NCI MAF (Mutation Annotation File)");
	            ButtonGroup formatGroup = new ButtonGroup();
	            formatGroup.add(geneSetBtn);
	            formatGroup.add(geneSampleBtn);
	            formatGroup.add(mafBtn);
	            ActionListener formatBtnListner = new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    if (geneSetBtn.isSelected()) {
	                        sampleCutoffLabel.setEnabled(false);
	                        sampleCutoffField.setEnabled(false);
	                        chooseHomoBox.setEnabled(false);
	                        sampleCommentLabel.setEnabled(false);
	                    }
	                    else if (geneSampleBtn.isSelected()) {
	                        sampleCutoffLabel.setEnabled(true);
	                        sampleCutoffField.setEnabled(true);
	                        chooseHomoBox.setEnabled(false);
	                        sampleCommentLabel.setEnabled(true);
	                    }
	                    else if (mafBtn.isSelected()) {
	                        sampleCutoffField.setEnabled(true);
	                        sampleCutoffLabel.setEnabled(true);
	                        chooseHomoBox.setEnabled(true);
	                        sampleCommentLabel.setEnabled(true);
	                    }
	                }
	            };
	            geneSetBtn.addActionListener(formatBtnListner);
	            geneSampleBtn.addActionListener(formatBtnListner);
	            mafBtn.addActionListener(formatBtnListner);
	            constraints.gridx = 0;
	            constraints.gridy = 1;
	            loadPanel.add(fileFormatLabel, constraints);
	            constraints.gridx = 1;
	            constraints.gridwidth = 2;
	            loadPanel.add(geneSetBtn, constraints);
	            constraints.gridy = 2;
	            constraints.gridwidth = 1;
	            loadPanel.add(geneSampleBtn, constraints);
	            constraints.gridy = 3;
	            constraints.gridwidth = 2;
	            loadPanel.add(mafBtn, constraints);
	            // Add a sample cutoff value
	            constraints.insets = new Insets(4, 4, 4, 4);
	            sampleCutoffLabel = new JLabel("Choose sample cutoff:");
	            sampleCutoffField = new JFormattedTextField(new Integer(2));
	            sampleCutoffField.setColumns(4);
	            constraints.gridx = 0;
	            constraints.gridy = 4;
	            constraints.gridwidth = 1;
	            loadPanel.add(sampleCutoffLabel, constraints);
	            constraints.gridx = 1;
	            constraints.gridwidth = 2;
	            loadPanel.add(sampleCutoffField, constraints);
	            // Add a text annotation
	            sampleCommentLabel = new JLabel();
	            sampleCommentLabel.setText("* Genes altered in 2 or more samples will be chosen if enter 2.");
	            Font font = sampleCutoffLabel.getFont();
	            Font commentFont = font.deriveFont(Font.ITALIC, font.getSize() - 1);
	            sampleCommentLabel.setFont(commentFont);
	            constraints.gridx = 0;
	            constraints.gridy = 5;
	            constraints.gridwidth = 3;
	            constraints.insets = new Insets(0, 4, 0, 4);
	            loadPanel.add(sampleCommentLabel, constraints);
	            // To control homo or not
	            chooseHomoBox = new JCheckBox("Choose genes mutated at both alleles");
	            constraints.gridy = 6;
	            constraints.gridheight = 1;
	            constraints.insets = new Insets(4, 4, 4, 4);
	            loadPanel.add(chooseHomoBox, constraints);
	            
	            panel.add(loadPanel);
	            panel.add(Box.createVerticalStrut(8));
	            // For constructing network
	            JPanel constructPanel = new JPanel();
	            constructPanel.setBorder(BorderFactory.createTitledBorder(etchedBorder, "Constructing FI Network"));
	            constructPanel.setLayout(new GridBagLayout());
	            constraints.gridheight = 1;
	            constraints.gridwidth = 1;
	            constraints.gridx = 0;
	            constraints.gridy = 0;
	            constraints.anchor = GridBagConstraints.CENTER;
	            constraints.weightx = 0.0d;
	            fetchFIAnnotations = new JCheckBox("Fetch FI annotations (Slow step!)");
	            JLabel label = new JLabel("* Annotations may be fetched later.");
	            label.setFont(font);
	            constructPanel.add(fetchFIAnnotations, constraints);
	            constraints.gridy = 1;
	            constraints.insets = new Insets(0, 4, 0, 4);
	            constructPanel.add(label, constraints);
	            useLinkerBox = new JCheckBox("Use linker genes");
	            // To control another JCheckBox
	            useLinkerBox.addChangeListener(new ChangeListener() {
	                public void stateChanged(ChangeEvent e) {
	                    if (useLinkerBox.isSelected())
	                        showUnlinkedBox.setEnabled(false);
	                    else
	                        showUnlinkedBox.setEnabled(true);
	                }
	            });
	            constraints.gridy = 2;
	            constraints.insets = new Insets(4, 4, 4, 4);
	            constructPanel.add(useLinkerBox, constraints);
	            showUnlinkedBox = new JCheckBox("Show genes not linked to others");
	            constraints.gridy = 3;
	            constructPanel.add(showUnlinkedBox, constraints);
	            panel.add(constructPanel);
	            getContentPane().add(panel, BorderLayout.CENTER);

	            okBtn.addActionListener(new ActionListener() {
	                
	                public void actionPerformed(ActionEvent e) {
	                    isOkClicked = true;
	                    dispose();
	                }
	            });
	            JButton cancelBtn = controlPane.getCancelBtn();
	            cancelBtn.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    isOkClicked = false;
	                    dispose();
	                }
	            });
	            okBtn.setDefaultCapable(true);
	            getRootPane().setDefaultButton(okBtn);
	            getContentPane().add(controlPane, BorderLayout.SOUTH);
	            // Default: the following controls should be disabled!
	            sampleCutoffLabel.setEnabled(false);
	            sampleCutoffField.setEnabled(false);
	            chooseHomoBox.setEnabled(false);
	            sampleCommentLabel.setEnabled(false);
	            
	            setSize(540, 535);
//	            addComponentListener(new ComponentListener() {
//	                
//	                @Override
//	                public void componentShown(ComponentEvent e) {
//	                }
//	                
//	                @Override
//	                public void componentResized(ComponentEvent e) {
//	                    System.out.println("Size: " + getSize());
//	                }
//	                
//	                @Override
//	                public void componentMoved(ComponentEvent e) {
//	                }
//	                
//	                @Override
//	                public void componentHidden(ComponentEvent e) {
//	                }
//	            });
	        }
	        public boolean isOkClicked() {
	            return this.isOkClicked;
	        }
	        
	        public int getSampleCutoffValue() {
	            String text = sampleCutoffField.getText().trim();
	            if (text.length() == 0)
	                return 0;
	            return Integer.parseInt(text);
	        }
	        
	        public boolean shouldLinkerGenesUsed() {
	            return this.useLinkerBox.isSelected();
	        }
	        
	        public JCheckBox getUnlinkedGeneBox() {
	            return this.showUnlinkedBox;
	        }
	        
	        public boolean chooseHomoGenes() {
	            return this.chooseHomoBox.isSelected();
	        }
	        
	        public String getFileFormat() {
	            if (mafBtn.isSelected())
	                return "MAF";
	            if (geneSampleBtn.isSelected())
	                return "GeneSample";
	            return "GeneSet";
	        }
	        
	        public boolean showFIAnnotationsBeFetched() {
	            return fetchFIAnnotations.isSelected();
	        }
	}
}
