
package com.balaji;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for add complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="add"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="n1" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="n2" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "add", propOrder = {
    "n1",
    "n2"
})
public class Add {

    protected double n1;
    protected double n2;

    /**
     * Gets the value of the n1 property.
     * 
     */
    public double getN1() {
        return n1;
    }

    /**
     * Sets the value of the n1 property.
     * 
     */
    public void setN1(double value) {
        this.n1 = value;
    }

    /**
     * Gets the value of the n2 property.
     * 
     */
    public double getN2() {
        return n2;
    }

    /**
     * Sets the value of the n2 property.
     * 
     */
    public void setN2(double value) {
        this.n2 = value;
    }

}
