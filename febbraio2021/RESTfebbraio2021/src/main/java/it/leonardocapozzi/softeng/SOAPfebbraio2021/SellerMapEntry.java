/**
 * SellerMapEntry.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.leonardocapozzi.softeng.SOAPfebbraio2021;

public class SellerMapEntry  implements java.io.Serializable {
    private java.lang.String deliveryDate;

    private it.leonardocapozzi.softeng.SOAPfebbraio2021.SellerImpl seller;

    public SellerMapEntry() {
    }

    public SellerMapEntry(
           java.lang.String deliveryDate,
           it.leonardocapozzi.softeng.SOAPfebbraio2021.SellerImpl seller) {
           this.deliveryDate = deliveryDate;
           this.seller = seller;
    }


    /**
     * Gets the deliveryDate value for this SellerMapEntry.
     * 
     * @return deliveryDate
     */
    public java.lang.String getDeliveryDate() {
        return deliveryDate;
    }


    /**
     * Sets the deliveryDate value for this SellerMapEntry.
     * 
     * @param deliveryDate
     */
    public void setDeliveryDate(java.lang.String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }


    /**
     * Gets the seller value for this SellerMapEntry.
     * 
     * @return seller
     */
    public it.leonardocapozzi.softeng.SOAPfebbraio2021.SellerImpl getSeller() {
        return seller;
    }


    /**
     * Sets the seller value for this SellerMapEntry.
     * 
     * @param seller
     */
    public void setSeller(it.leonardocapozzi.softeng.SOAPfebbraio2021.SellerImpl seller) {
        this.seller = seller;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SellerMapEntry)) return false;
        SellerMapEntry other = (SellerMapEntry) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.deliveryDate==null && other.getDeliveryDate()==null) || 
             (this.deliveryDate!=null &&
              this.deliveryDate.equals(other.getDeliveryDate()))) &&
            ((this.seller==null && other.getSeller()==null) || 
             (this.seller!=null &&
              this.seller.equals(other.getSeller())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDeliveryDate() != null) {
            _hashCode += getDeliveryDate().hashCode();
        }
        if (getSeller() != null) {
            _hashCode += getSeller().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SellerMapEntry.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://SOAPfebbraio2021.softeng.leonardocapozzi.it/", "SellerMapEntry"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deliveryDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deliveryDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seller");
        elemField.setXmlName(new javax.xml.namespace.QName("", "seller"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://SOAPfebbraio2021.softeng.leonardocapozzi.it/", "sellerImpl"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
