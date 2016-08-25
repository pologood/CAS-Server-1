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
 * 一个通用概念，代表一个经过认证的东西。这里是认证结果的封装
 * 在这里是一个接口，SimplePrincipal是官方提供的一个实现。有两个方法 getId() 方法用于返回唯一标识
 *      Map<String, Object> getAttributes()可以在重写后返回其它的属性，但是需要修改
 *      casServiceValidationSuccess.jsp，修改方法之前的文章中有过讲解,这里不再赘述
 *      结果属性中Map<String, Object> Object尽量不要放集合，casServiceValidationSuccess.jsp不好修改
 */
package org.jasig.cas.authentication.principal;

import java.io.Serializable;
import java.util.Map;

/**
 * Generic concept of an authenticated thing. Examples include a person or a
 * service.
 * <p>
 * The implementation SimplePrincipal just contains the Id property. More
 * complex Principal objects may contain additional information that are
 * meaningful to the View layer but are generally transparent to the rest of
 * CAS.
 * </p>
 *
 * @author Scott Battaglia
 * @since 3.0
 * <p>
 * This is a published and supported CAS Server 3 API.
 * </p>
 */
public interface Principal extends Serializable {

    /**
     * @return the unique id for the Principal
     */
    String getId();

    /**
     *
     * @return the map of configured attributes for this principal
     */
    Map<String, Object> getAttributes();
}
