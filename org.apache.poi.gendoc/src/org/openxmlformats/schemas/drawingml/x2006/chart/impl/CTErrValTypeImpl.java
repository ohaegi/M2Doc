/*
 * XML Type:  CT_ErrValType
 * Namespace: http://schemas.openxmlformats.org/drawingml/2006/chart
 * Java type: org.openxmlformats.schemas.drawingml.x2006.chart.CTErrValType
 *
 * Automatically generated - do not modify.
 */
package org.openxmlformats.schemas.drawingml.x2006.chart.impl;
/**
 * An XML CT_ErrValType(@http://schemas.openxmlformats.org/drawingml/2006/chart).
 *
 * This is a complex type.
 */
public class CTErrValTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.openxmlformats.schemas.drawingml.x2006.chart.CTErrValType
{
    
    public CTErrValTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName VAL$0 = 
        new javax.xml.namespace.QName("", "val");
    
    
    /**
     * Gets the "val" attribute
     */
    public org.openxmlformats.schemas.drawingml.x2006.chart.STErrValType.Enum getVal()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VAL$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(VAL$0);
            }
            if (target == null)
            {
                return null;
            }
            return (org.openxmlformats.schemas.drawingml.x2006.chart.STErrValType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "val" attribute
     */
    public org.openxmlformats.schemas.drawingml.x2006.chart.STErrValType xgetVal()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openxmlformats.schemas.drawingml.x2006.chart.STErrValType target = null;
            target = (org.openxmlformats.schemas.drawingml.x2006.chart.STErrValType)get_store().find_attribute_user(VAL$0);
            if (target == null)
            {
                target = (org.openxmlformats.schemas.drawingml.x2006.chart.STErrValType)get_default_attribute_value(VAL$0);
            }
            return target;
        }
    }
    
    /**
     * True if has "val" attribute
     */
    public boolean isSetVal()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(VAL$0) != null;
        }
    }
    
    /**
     * Sets the "val" attribute
     */
    public void setVal(org.openxmlformats.schemas.drawingml.x2006.chart.STErrValType.Enum val)
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
    public void xsetVal(org.openxmlformats.schemas.drawingml.x2006.chart.STErrValType val)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openxmlformats.schemas.drawingml.x2006.chart.STErrValType target = null;
            target = (org.openxmlformats.schemas.drawingml.x2006.chart.STErrValType)get_store().find_attribute_user(VAL$0);
            if (target == null)
            {
                target = (org.openxmlformats.schemas.drawingml.x2006.chart.STErrValType)get_store().add_attribute_user(VAL$0);
            }
            target.set(val);
        }
    }
    
    /**
     * Unsets the "val" attribute
     */
    public void unsetVal()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(VAL$0);
        }
    }
}