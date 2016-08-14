/*
 *  Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.oauth2poc.util;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.util.HashSet;
import java.util.Set;

public class OAuth2Util {

    public static Set<String> buildScopeSet(String scopes) {
        Set<String> scopeSet = new HashSet<String>();
        if (StringUtils.isNotBlank(scopes)) {
            String[] scopeArray = scopes.split("\\s");
            for(String scope:scopeArray){
                if(StringUtils.isNotBlank(scope)) {
                    scopeSet.add(scope);
                }
            }
        }
        return scopeSet;
    }

    public static String buildScopeString(Set<String> scopes) {
        StringBuilder builder = new StringBuilder("");
        if(CollectionUtils.isNotEmpty(scopes)) {
            for (String scope : scopes) {
                if (StringUtils.isNotBlank(scope)) {
                    builder.append(scope);
                    builder.append(" ");
                }
            }
            if (builder.charAt(builder.length() - 1) == ' ') {
                builder.substring(0, builder.charAt(builder.length() - 1));
            }
        }
        return builder.toString();
    }
}
