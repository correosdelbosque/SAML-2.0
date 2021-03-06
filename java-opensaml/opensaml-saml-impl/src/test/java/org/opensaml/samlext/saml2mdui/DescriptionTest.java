/*
 * Copyright [2005] [University Corporation for Advanced Internet Development, Inc.]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * 
 */
package org.opensaml.samlext.saml2mdui;

import javax.xml.namespace.QName;

import org.opensaml.common.BaseSAMLObjectProviderTestCase;
import org.opensaml.samlext.saml2mdui.Description;
import org.opensaml.samlext.saml2mdui.UIInfo;

/**
 * Test case for creating, marshalling, and unmarshalling
 * {@link org.opensaml.saml2.metadata.OrganizationName}.
 */
public class DescriptionTest extends BaseSAMLObjectProviderTestCase {
    
    /** Expected name. */
    protected String expectValue = "Textual Desriptice prose";
    /** Expected language. */
    protected String expectLang =  "lang";
    
    /**
     * Constructor.
     */
    public DescriptionTest() {
        singleElementFile = "/data/org/opensaml/samlext/saml2mdui/Description.xml";
    }
    

    /** {@inheritDoc} */
    public void testSingleElementUnmarshall() {
        Description name = (Description) unmarshallElement(singleElementFile);
        
        assertEquals("Name was not expected value", expectValue, name.getValue());
        assertEquals("xml:lang was not expected value", expectLang, name.getXMLLang());
    }

    /** {@inheritDoc} */
    public void testSingleElementMarshall() {
        QName qname = new QName(UIInfo.MDUI_NS, 
                                Description.DEFAULT_ELEMENT_LOCAL_NAME, 
                                UIInfo.MDUI_PREFIX);
        
        Description name = (Description) buildXMLObject(qname);
        
        name.setValue(expectValue);
        name.setXMLLang(expectLang);

        assertEquals(expectedDOM, name);
    }
}