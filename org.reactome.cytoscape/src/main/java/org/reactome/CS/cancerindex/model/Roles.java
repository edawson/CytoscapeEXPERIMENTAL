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
@XmlRootElement(name = "Roles")
public class Roles {
    
    @XmlElement(name="id", required=true)
    protected Long id;
    @XmlElement(name = "PrimaryNCIRoleCode")
    protected List<String> primaryNCIRoleCode;
    @XmlElement(name = "OtherRole")
    protected List<String> otherRole;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrimaryNCIRoleCode(List<String> primaryNCIRoleCode) {
        this.primaryNCIRoleCode = primaryNCIRoleCode;
    }

    public void addPrimaryNCIRoleCode(String value) {
        if (primaryNCIRoleCode == null)
            primaryNCIRoleCode = new ArrayList<String>();
        primaryNCIRoleCode.add(value);
    }
    
    public void setOtherRole(List<String> otherRole) {
        this.otherRole = otherRole;
    }
    
    public void addOtherRole(String value) {
        if (otherRole == null)
            otherRole = new ArrayList<String>();
        otherRole.add(value);
    }

    /**
     * Gets the value of the primaryNCIRoleCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the primaryNCIRoleCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrimaryNCIRoleCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PrimaryNCIRoleCode }
     * 
     * 
     */
    public List<String> getPrimaryNCIRoleCode() {
        if (primaryNCIRoleCode == null) {
            primaryNCIRoleCode = new ArrayList<String>();
        }
        return this.primaryNCIRoleCode;
    }

    /**
     * Gets the value of the otherRole property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the otherRole property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOtherRole().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OtherRole }
     * 
     * 
     */
    public List<String> getOtherRole() {
        if (otherRole == null) {
            otherRole = new ArrayList<String>();
        }
        return this.otherRole;
    }

}
