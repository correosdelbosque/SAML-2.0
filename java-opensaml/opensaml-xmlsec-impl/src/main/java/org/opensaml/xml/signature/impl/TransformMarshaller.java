/*
 * Copyright [2006] [University Corporation for Advanced Internet Development, Inc.]
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

package org.opensaml.xml.signature.impl;

import org.opensaml.xml.XMLObject;
import org.opensaml.xml.io.MarshallingException;
import org.opensaml.xml.signature.Transform;
import org.w3c.dom.Element;

/**
 * A thread-safe Marshaller for {@link org.opensaml.xml.signature.Transform} objects.
 */
public class TransformMarshaller extends AbstractXMLSignatureMarshaller {

    /** {@inheritDoc} */
    protected void marshallAttributes(XMLObject xmlObject, Element domElement) throws MarshallingException {
        Transform transform = (Transform) xmlObject;

        if (transform.getAlgorithm() != null) {
            domElement.setAttributeNS(null, Transform.ALGORITHM_ATTRIB_NAME, transform.getAlgorithm());
        }
    }

}
