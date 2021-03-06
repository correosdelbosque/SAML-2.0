/*
 * Copyright [2007] [University Corporation for Advanced Internet Development, Inc.]
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

package org.opensaml.xml.encryption.validator;

import org.opensaml.xml.encryption.EncryptedType;
import org.opensaml.xml.validation.ValidationException;
import org.opensaml.xml.validation.Validator;

/**
 * Checks {@link org.opensaml.xml.encryption.EncryptedType} for Schema compliance. 
 */
public class EncryptedTypeSchemaValidator implements Validator<EncryptedType> {

    /** {@inheritDoc} */
    public void validate(EncryptedType xmlObject) throws ValidationException {
        validateChildrenPresence(xmlObject);
    }

    /**
     * Validate that required children are present.
     * 
     * @param xmlObject the object to validate
     * @throws ValidationException  thrown if the object is invalid
     */
    protected void validateChildrenPresence(EncryptedType xmlObject) throws ValidationException {
        if (xmlObject.getCipherData() == null) {
            throw new ValidationException("EncryptedType did not contain a CipherData child");
        }
    }
}
