//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.07.13 at 06:14:13 PM PDT 
//


package org.reactome.CS.cancerindex.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GeneEntryCollection")
public class GeneEntryCollection {

    @XmlElement(name = "GeneEntry", required = true)
    protected List<GeneEntry> geneEntry;

    /**
     * Gets the value of the geneEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the geneEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGeneEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GeneEntry }
     * 
     * 
     */
    public List<GeneEntry> getGeneEntry() {
        if (geneEntry == null) {
            geneEntry = new ArrayList<GeneEntry>();
        }
        return this.geneEntry;
    }

}
