/*
 * Created on Oct 7, 2006
 *
 */
package org.reactome.CS.FIModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.reactome.funcInt.Evidence;
import org.reactome.funcInt.GeneExpressionType;
import org.reactome.funcInt.Interaction;
import org.reactome.funcInt.Protein;
import org.reactome.funcInt.ReactomeSource;
import org.reactome.funcInt.ReactomeSourceType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * This class is used to manage data to be displayed in the view.
 * @author guanming
 *
 */
public class FIDataModel {
    private List<Interaction> interactions;
    
    public FIDataModel() {
        interactions = new ArrayList<Interaction>();
    }
    
    public void setSource(InputStream s) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document doc = builder.parse(s);
        Element root = doc.getDocumentElement();
        parse(root);
    }
    
    private void parse(Element root) {
    }   
    
    public void setSource(File file) throws IOException, Exception {
        FileInputStream fis = new FileInputStream(file);
        setSource(fis);
    }
    
   public List<Interaction> getInteractions() {
       return this.interactions;
   }
    
    public void generateTestData() {
        // First Interaction
        Interaction interaction = new Interaction();
        interaction.setDbId(1);
        Protein firstProtein = new Protein();
        interaction.setFirstProtein(firstProtein);
        firstProtein.setPrimaryAccession("Q9UII8");
        firstProtein.setPrimaryDbName("UniProt");
        Protein secondProtein = new Protein();
        interaction.setSecondProtein(secondProtein);
        secondProtein.setPrimaryAccession("Q9Y5E9");
        secondProtein.setPrimaryDbName("UniProt");
        ReactomeSource source = new ReactomeSource();
        source.setDbId(1);
        source.setReactomeId(187798);
        source.setSourceType(ReactomeSourceType.REACTION);
        source.setDataSource("pantherdb");
        interaction.addReactomeSource(source);
        interactions.add(interaction);
        // Second Interaction
        interaction = new Interaction();
        interaction.setDbId(2);
        firstProtein = new Protein();
        firstProtein.setPrimaryAccession("O95373");
        interaction.setFirstProtein(firstProtein);
        secondProtein = new Protein();
        secondProtein.setPrimaryAccession("Q16576");
        interaction.setSecondProtein(secondProtein);
        Evidence evidence = new Evidence();
        evidence.setHumanInteraction(Boolean.TRUE);
        evidence.setGeneExp(GeneExpressionType.UNCORRELATED);
        evidence.setGoBPSemanticSimilarity(1);
        evidence.setProbability(0.552679794298487);
        interaction.setEvidence(evidence);
        interactions.add(interaction);
    }
}
