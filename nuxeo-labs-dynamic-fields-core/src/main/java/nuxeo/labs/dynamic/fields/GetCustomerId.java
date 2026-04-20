/*
 * (C) Copyright 2025 Hyland (http://hyland.com/) and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Thibaud Arguillere
 */
package nuxeo.labs.dynamic.fields;

import org.nuxeo.ecm.automation.core.Constants;
import org.nuxeo.ecm.automation.core.annotations.Context;
import org.nuxeo.ecm.automation.core.annotations.Operation;
import org.nuxeo.ecm.automation.core.annotations.OperationMethod;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.NuxeoPrincipal;

/**
 * Returns the customer ID for the current user.
 * <p>
 * This default implementation returns a hard-coded value for development
 * and testing purposes. In production, override this operation with an
 * Automation Scripting in Nuxeo Studio that resolves the customer ID
 * from the current user's profile, organization, or any other source.
 * <p>
 * Example Studio Automation Scripting override:
 * <pre>
 * // Operation ID: DynamicFields.GetCustomerId
 * function run(input, params) {
 *   return currentUser.getPropertyValue("user:company");
 * }
 * </pre>
 *
 * @since 2025.1
 */
@Operation(id = GetCustomerId.ID, category = Constants.CAT_SERVICES,
        label = "Dynamic Fields: Get Customer ID",
        description = "Returns the customer ID for the current user. "
                + "Override this operation in Studio to provide your own resolution logic.")
public class GetCustomerId {

    public static final String ID = "DynamicFields.GetCustomerId";

    // Default hard-coded value for development/testing
    private static final String DEFAULT_CUSTOMER_ID = "ABCD-1234";

    @Context
    protected CoreSession session;

    @OperationMethod
    public String run() {
        return DEFAULT_CUSTOMER_ID;
    }
}
