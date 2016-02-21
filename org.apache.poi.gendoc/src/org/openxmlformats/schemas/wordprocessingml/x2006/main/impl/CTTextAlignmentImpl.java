/*
 * XML Type:  CT_TextAlignment
 * Namespace: http://schemas.openxmlformats.org/wordprocessingml/2006/main
 * Java type: org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextAlignment
 *
 * Automatically generated - do not modify.
 */
package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;
/**
 * An XML CT_TextAlignment(@http://schemas.openxmlformats.org/wordprocessingml/2006/main).
 *
 * This is a complex type.
 */
public class CTTextAlignmentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextAlignment
{
    
    public CTTextAlignmentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName VAL$0 = 
        new javax.xml.namespace.QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");
    
    
    /**
     * Gets the "val" attribute
     */
    public org.openxmlformats.schemas.wordprocessingml.x2006.main.STTextAlignment.Enum getVal()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VAL$0);
            if (target == null)
            {
                return null;
            }
            return (org.openxmlformats.schemas.wordprocessingml.x2006.main.STTextAlignment.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "val" attribute
     */
    public org.openxmlformats.schemas.wordprocessingml.x2006.main.STTextAlignment xgetVal()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openxmlformats.schemas.wordprocessingml.x2006.main.STTextAlignment target = null;
            target = (org.openxmlformats.schemas.wordprocessingml.x2006.main.STTextAlignment)get_store().find_attribute_user(VAL$0);
            return target;
        }
    }
    
    /**
     * Sets the "val" attribute
     */
    public void setVal(org.openxmlformats.schemas.wordprocessingml.x2006.main.STTextAlignment.Enum val)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VAL$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(VAL$0);
            }
            target.setEnumValue(val);
        }
    }
    
    /**
     * Sets (as xml) the "val" attribute
     */
    public void xsetVal(org.openxmlformats.schemas.wordprocessingml.x2006.main.STTextAlignment val)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openxmlformats.schemas.wordprocessingml.x2006.main.STTextAlignment target = null;
            target = (org.openxmlformats.schemas.wordprocessingml.x2006.main.STTextAlignment)get_store().find_attribute_user(VAL$0);
            if (target == null)
            {
                target = (org.openxmlformats.schemas.wordprocessingml.x2006.main.STTextAlignment)get_store().add_attribute_user(VAL$0);
            }
            target.set(val);
        }
    }
}