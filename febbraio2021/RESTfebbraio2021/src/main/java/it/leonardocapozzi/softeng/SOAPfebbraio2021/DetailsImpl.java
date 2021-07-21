/**
 * DetailsImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.leonardocapozzi.softeng.SOAPfebbraio2021;

public class DetailsImpl  implements java.io.Serializable {
    private int bookId;

    private double price;

    private it.leonardocapozzi.softeng.SOAPfebbraio2021.SellerMapEntry[] sellerMap;

    public DetailsImpl() {
    }

    public DetailsImpl(
           int bookId,
           double price,
           it.leonardocapozzi.softeng.SOAPfebbraio2021.SellerMapEntry[] sellerMap) {
           this.bookId = bookId;
           this.price = price;
           this.sellerMap = sellerMap;
    }


    /**
     * Gets the bookId value for this DetailsImpl.
     * 
     * @return bookId
     */
    public int getBookId() {
        return bookId;
    }


    /**
     * Sets the bookId value for this DetailsImpl.
     * 
     * @param bookId
     */
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }


    /**
     * Gets the price value for this DetailsImpl.
     * 
     * @return price
     */
    public double getPrice() {
        return price;
    }


    /**
     * Sets the price value for this DetailsImpl.
     * 
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }


    /**
     * Gets the sellerMap value for this DetailsImpl.
     * 
     * @return sellerMap
     */
    public it.leonardocapozzi.softeng.SOAPfebbraio2021.SellerMapEntry[] getSellerMap() {
        return sellerMap;
    }


    /**
     * Sets the sellerMap value for this DetailsImpl.
     * 
     * @param sellerMap
     */
    public void setSellerMap(it.leonardocapozzi.softeng.SOAPfebbraio2021.SellerMapEntry[] sellerMap) {
        this.sellerMap = sellerMap;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DetailsImpl)) return false;
        DetailsImpl other = (DetailsImpl) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.bookId == other.getBookId() &&
            this.price == other.getPrice() &&
            ((this.sellerMap==null && other.getSellerMap()==null) || 
             (this.sellerMap!=null &&
              java.util.Arrays.equals(this.sellerMap, other.getSellerMap())));
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
        _hashCode += getBookId();
        _hashCode += new Double(getPrice()).hashCode();
        if (getSellerMap() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSellerMap());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSellerMap(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DetailsImpl.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://SOAPfebbraio2021.softeng.leonardocapozzi.it/", "detailsImpl"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bookId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bookId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("price");
        elemField.setXmlName(new javax.xml.namespace.QName("", "price"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sellerMap");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sellerMap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://SOAPfebbraio2021.softeng.leonardocapozzi.it/", "SellerMapEntry"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "entry"));
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
