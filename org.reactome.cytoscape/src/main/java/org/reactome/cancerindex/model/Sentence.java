//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.07.13 at 06:14:13 PM PDT 
//


package org.reactome.cancerindex.model;

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
@XmlRootElement(name = "Sentence")
public class Sentence {

    @XmlElement(name = "id", required = true)
    protected Long id;
    @XmlElement(name = "GeneData", required = true)
    protected GeneData geneData;
    @XmlElement(name = "DiseaseData", required = true)
    protected DiseaseData diseaseData;
    @XmlElement(name = "Statement", required = true)
    protected String statement;
    @XmlElement(name = "PubMedID", required = true)
    protected String pubMedID;
    @XmlElement(name = "Organism", required = true)
    protected String organism;
    @XmlElement(name = "NegationIndicator", required = true)
    protected String negationIndicator;
    @XmlElement(name = "CellineIndicator", required = true)
    protected String cellineIndicator;
    @XmlElement(name = "Comments")
    protected String comments;
    @XmlElement(name = "EvidenceCode")
    protected List<String> evidenceCode;
    @XmlElement(name = "Roles")
    protected List<Roles> roles;
    @XmlElement(name = "SentenceStatusFlag", required = true)
    protected String sentenceStatusFlag;

    /**
     * Gets the value of the geneData property.
     * 
     * @return
     *     possible object is
     *     {@link GeneData }
     *     
     */
    public GeneData getGeneData() {
        return geneData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEvidenceCode(List<String> evidenceCode) {
        this.evidenceCode = evidenceCode;
    }
    
    public void addEvidenceCode(String value) {
        if (evidenceCode == null)
            evidenceCode = new ArrayList<String>();
        evidenceCode.add(value);
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }
    
    public void addRoles(Roles value) {
        if (roles == null)
            roles = new ArrayList<Roles>();
        roles.add(value);
    }
    
    /**
     * Sets the value of the geneData property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeneData }
     *     
     */
    public void setGeneData(GeneData value) {
        this.geneData = value;
    }

    /**
     * Gets the value of the diseaseData property.
     * 
     * @return
     *     possible object is
     *     {@link DiseaseData }
     *     
     */
    public DiseaseData getDiseaseData() {
        return diseaseData;
    }

    /**
     * Sets the value of the diseaseData property.
     * 
     * @param value
     *     allowed object is
     *     {@link DiseaseData }
     *     
     */
    public void setDiseaseData(DiseaseData value) {
        this.diseaseData = value;
    }

    /**
     * Gets the value of the statement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatement() {
        return statement;
    }

    /**
     * Sets the value of the statement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatement(String value) {
        this.statement = value;
    }

    /**
     * Gets the value of the pubMedID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPubMedID() {
        return pubMedID;
    }

    /**
     * Sets the value of the pubMedID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPubMedID(String value) {
        this.pubMedID = value;
    }

    /**
     * Gets the value of the organism property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganism() {
        return organism;
    }

    /**
     * Sets the value of the organism property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganism(String value) {
        this.organism = value;
    }

    /**
     * Gets the value of the negationIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNegationIndicator() {
        return negationIndicator;
    }

    /**
     * Sets the value of the negationIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNegationIndicator(String value) {
        this.negationIndicator = value;
    }

    /**
     * Gets the value of the cellineIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCellineIndicator() {
        return cellineIndicator;
    }

    /**
     * Sets the value of the cellineIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCellineIndicator(String value) {
        this.cellineIndicator = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComments(String value) {
        this.comments = value;
    }

    /**
     * Gets the value of the evidenceCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the evidenceCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEvidenceCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EvidenceCode }
     * 
     * 
     */
    public List<String> getEvidenceCode() {
        if (evidenceCode == null) {
            evidenceCode = new ArrayList<String>();
        }
        return this.evidenceCode;
    }

    /**
     * Gets the value of the roles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Roles }
     * 
     * 
     */
    public List<Roles> getRoles() {
        if (roles == null) {
            roles = new ArrayList<Roles>();
        }
        return this.roles;
    }

    /**
     * Gets the value of the sentenceStatusFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSentenceStatusFlag() {
        return sentenceStatusFlag;
    }

    /**
     * Sets the value of the sentenceStatusFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSentenceStatusFlag(String value) {
        this.sentenceStatusFlag = value;
    }

}
