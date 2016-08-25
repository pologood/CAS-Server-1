/*
 * Licensed to Jasig under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Jasig licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 * 配置位置 deployerConfigContext.xml
 * 主要涉及的方法是Authentication authenticate(final Credential... credentials)
 * 以及在authenticate方法中调用的AuthenticationBuilder authenticateInternal(final Credential... credentials)
 *
 * 身份认证管理器，通过指定认证凭证的认证处理程序来定义认证的安全策略。
 *      3.5的时候实现类是 org.jasig.cas.authentication.AuthenticationManagerImpl，
 *      4.0变为org.jasig.cas.authentication.PolicyBasedAuthenticationManager，
 *      这是3.5和4.0改变最大的原因。没有改造的必要，
 *      如果debug看代码从PolicyBasedAuthenticationManager的Authentication authenticate(final Credential... credentials) 方法开始
 */
package org.jasig.cas.authentication;

/**
 * Authenticates one or more credentials.
 *
 * @author Scott Battaglia
 * @author Marvin S. Addison
 *
 * @since 3.0
 */
public interface AuthenticationManager {

    /** Authentication method attribute name. **/
    String AUTHENTICATION_METHOD_ATTRIBUTE = "authenticationMethod";

    /**
     * Authenticates the provided credentials. On success, an {@link Authentication} object
     * is returned containing metadata about the result of each authenticated credential.
     * Note that a particular implementation may require some or all credentials to be
     * successfully authenticated. Failure to authenticate is considered an exceptional case, and
     * an AuthenticationException is thrown.
     *
     * @param credentials One or more credentials to authenticate.
     *
     * @return Authentication object on success that contains metadata about credentials that were authenticated.
     *
     * @throws AuthenticationException On authentication failure. The exception contains details
     * on each of the credentials that failed to authenticate.
     */
    Authentication authenticate(final Credential... credentials) throws AuthenticationException;
}
