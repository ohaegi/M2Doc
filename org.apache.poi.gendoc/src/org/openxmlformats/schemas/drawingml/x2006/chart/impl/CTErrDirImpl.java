/*
 * XML Type:  CT_ErrDir
 * Namespace: http://schemas.openxmlformats.org/drawingml/2006/chart
 * Java type: org.openxmlformats.schemas.drawingml.x2006.chart.CTErrDir
 *
 * Automatically generated - do not modify.
 */
package org.openxmlformats.schemas.drawingml.x2006.chart.impl;
/**
 * An XML CT_ErrDir(@http://schemas.openxmlformats.org/drawingml/2006/chart).
 *
 * This is a complex type.
 */
public class CTErrDirImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.openxmlformats.schemas.drawingml.x2006.chart.CTErrDir
{
    
    public CTErrDirImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName VAL$0 = 
        new javax.xml.namespace.QName("", "val");
    
    
    /**
     * Gets the "val" attribute
     */
    public org.openxmlformats.schemas.drawingml.x2006.chart.STErrDir.Enum getVal()
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
            return (org.openxmlformats.schemas.drawingml.x2006.chart.STErrDir.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "val" attribute
     */
    public org.openxmlformats.schemas.drawingml.x2006.chart.STErrDir xgetVal()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openxmlformats.schemas.drawingml.x2006.chart.STErrDir target = null;
            target = (org.openxmlformats.schemas.drawingml.x2006.chart.STErrDir)get_store().find_attribute_user(VAL$0);
            return target;
        }
    }
    
    /**
     * Sets the "val" attribute
     */
    public void setVal(org.openxmlformats.schemas.drawingml.x2006.chart.STErrDir.Enum val)
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
    public void xsetVal(org.openxmlformats.schemas.drawingml.x2006.chart.STErrDir val)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openxmlformats.schemas.drawingml.x2006.chart.STErrDir target = null;
            target = (org.openxmlformats.schemas.drawingml.x2006.chart.STErrDir)get_store().find_attribute_user(VAL$0);
            if (target == null)
            {
                target = (org.openxmlformats.schemas.drawingml.x2006.chart.STErrDir)get_store().add_attribute_user(VAL$0);
            }
            target.set(val);
        }
    }
}