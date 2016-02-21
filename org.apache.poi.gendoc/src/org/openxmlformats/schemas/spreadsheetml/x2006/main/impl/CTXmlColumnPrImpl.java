/*
 * XML Type:  CT_XmlColumnPr
 * Namespace: http://schemas.openxmlformats.org/spreadsheetml/2006/main
 * Java type: org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXmlColumnPr
 *
 * Automatically generated - do not modify.
 */
package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;
/**
 * An XML CT_XmlColumnPr(@http://schemas.openxmlformats.org/spreadsheetml/2006/main).
 *
 * This is a complex type.
 */
public class CTXmlColumnPrImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXmlColumnPr
{
    
    public CTXmlColumnPrImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName EXTLST$0 = 
        new javax.xml.namespace.QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
    private static final javax.xml.namespace.QName MAPID$2 = 
        new javax.xml.namespace.QName("", "mapId");
    private static final javax.xml.namespace.QName XPATH$4 = 
        new javax.xml.namespace.QName("", "xpath");
    private static final javax.xml.namespace.QName DENORMALIZED$6 = 
        new javax.xml.namespace.QName("", "denormalized");
    private static final javax.xml.namespace.QName XMLDATATYPE$8 = 
        new javax.xml.namespace.QName("", "xmlDataType");
    
    
    /**
     * Gets the "extLst" element
     */
    public org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList getExtLst()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList target = null;
            target = (org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList)get_store().find_element_user(EXTLST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "extLst" element
     */
    public boolean isSetExtLst()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(EXTLST$0) != 0;
        }
    }
    
    /**
     * Sets the "extLst" element
     */
    public void setExtLst(org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList extLst)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList target = null;
            target = (org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList)get_store().find_element_user(EXTLST$0, 0);
            if (target == null)
            {
                target = (org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList)get_store().add_element_user(EXTLST$0);
            }
            target.set(extLst);
        }
    }
    
    /**
     * Appends and returns a new empty "extLst" element
     */
    public org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList addNewExtLst()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList target = null;
            target = (org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList)get_store().add_element_user(EXTLST$0);
            return target;
        }
    }
    
    /**
     * Unsets the "extLst" element
     */
    public void unsetExtLst()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(EXTLST$0, 0);
        }
    }
    
    /**
     * Gets the "mapId" attribute
     */
    public long getMapId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(MAPID$2);
            if (target == null)
            {
                return 0L;
            }
            return target.getLongValue();
        }
    }
    
    /**
     * Gets (as xml) the "mapId" attribute
     */
    public org.apache.xmlbeans.XmlUnsignedInt xgetMapId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlUnsignedInt target = null;
            target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().find_attribute_user(MAPID$2);
            return target;
        }
    }
    
    /**
     * Sets the "mapId" attribute
     */
    public void setMapId(long mapId)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(MAPID$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(MAPID$2);
            }
            target.setLongValue(mapId);
        }
    }
    
    /**
     * Sets (as xml) the "mapId" attribute
     */
    public void xsetMapId(org.apache.xmlbeans.XmlUnsignedInt mapId)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlUnsignedInt target = null;
            target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().find_attribute_user(MAPID$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().add_attribute_user(MAPID$2);
            }
            target.set(mapId);
        }
    }
    
    /**
     * Gets the "xpath" attribute
     */
    public java.lang.String getXpath()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(XPATH$4);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "xpath" attribute
     */
    public org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring xgetXpath()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring target = null;
            target = (org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring)get_store().find_attribute_user(XPATH$4);
            return target;
        }
    }
    
    /**
     * Sets the "xpath" attribute
     */
    public void setXpath(java.lang.String xpath)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(XPATH$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(XPATH$4);
            }
            target.setStringValue(xpath);
        }
    }
    
    /**
     * Sets (as xml) the "xpath" attribute
     */
    public void xsetXpath(org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring xpath)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring target = null;
            target = (org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring)get_store().find_attribute_user(XPATH$4);
            if (target == null)
            {
                target = (org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring)get_store().add_attribute_user(XPATH$4);
            }
            target.set(xpath);
        }
    }
    
    /**
     * Gets the "denormalized" attribute
     */
    public boolean getDenormalized()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DENORMALIZED$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(DENORMALIZED$6);
            }
            if (target == null)
            {
                return false;
            }
            return target.getBooleanValue();
        }
    }
    
    /**
     * Gets (as xml) the "denormalized" attribute
     */
    public org.apache.xmlbeans.XmlBoolean xgetDenormalized()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(DENORMALIZED$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_default_attribute_value(DENORMALIZED$6);
            }
            return target;
        }
    }
    
    /**
     * True if has "denormalized" attribute
     */
    public boolean isSetDenormalized()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(DENORMALIZED$6) != null;
        }
    }
    
    /**
     * Sets the "denormalized" attribute
     */
    public void setDenormalized(boolean denormalized)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DENORMALIZED$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(DENORMALIZED$6);
            }
            target.setBooleanValue(denormalized);
        }
    }
    
    /**
     * Sets (as xml) the "denormalized" attribute
     */
    public void xsetDenormalized(org.apache.xmlbeans.XmlBoolean denormalized)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(DENORMALIZED$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_store().add_attribute_user(DENORMALIZED$6);
            }
            target.set(denormalized);
        }
    }
    
    /**
     * Unsets the "denormalized" attribute
     */
    public void unsetDenormalized()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(DENORMALIZED$6);
        }
    }
    
    /**
     * Gets the "xmlDataType" attribute
     */
    public org.openxmlformats.schemas.spreadsheetml.x2006.main.STXmlDataType.Enum getXmlDataType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(XMLDATATYPE$8);
            if (target == null)
            {
                return null;
            }
            return (org.openxmlformats.schemas.spreadsheetml.x2006.main.STXmlDataType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "xmlDataType" attribute
     */
    public org.openxmlformats.schemas.spreadsheetml.x2006.main.STXmlDataType xgetXmlDataType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openxmlformats.schemas.spreadsheetml.x2006.main.STXmlDataType target = null;
            target = (org.openxmlformats.schemas.spreadsheetml.x2006.main.STXmlDataType)get_store().find_attribute_user(XMLDATATYPE$8);
            return target;
        }
    }
    
    /**
     * Sets the "xmlDataType" attribute
     */
    public void setXmlDataType(org.openxmlformats.schemas.spreadsheetml.x2006.main.STXmlDataType.Enum xmlDataType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(XMLDATATYPE$8);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(XMLDATATYPE$8);
            }
            target.setEnumValue(xmlDataType);
        }
    }
    
    /**
     * Sets (as xml) the "xmlDataType" attribute
     */
    public void xsetXmlDataType(org.openxmlformats.schemas.spreadsheetml.x2006.main.STXmlDataType xmlDataType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openxmlformats.schemas.spreadsheetml.x2006.main.STXmlDataType target = null;
            target = (org.openxmlformats.schemas.spreadsheetml.x2006.main.STXmlDataType)get_store().find_attribute_user(XMLDATATYPE$8);
            if (target == null)
            {
                target = (org.openxmlformats.schemas.spreadsheetml.x2006.main.STXmlDataType)get_store().add_attribute_user(XMLDATATYPE$8);
            }
            target.set(xmlDataType);
        }
    }
}