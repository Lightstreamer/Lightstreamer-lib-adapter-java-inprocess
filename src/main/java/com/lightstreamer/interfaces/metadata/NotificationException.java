/*
 *  Copyright (c) Lightstreamer Srl
 *  
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *      https://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


package com.lightstreamer.interfaces.metadata;

import javax.annotation.Nullable;

/**
 * Thrown by the notify* methods in MetadataProvider if there is some
 * inconsistency in the supplied parameters.
 * Lightstreamer Kernel ensures that such conditions will never occur,
 * but they may be checked for debugging or documentation reasons.
 */
public class NotificationException extends Exception {

    /**
     * Constructs a NotificationException with a supplied error message text.
     *
     * @param msg The detail message.
     */
    public NotificationException(@Nullable String msg) {
        super(msg);
    }
}


/*--- Formatted in Lightstreamer Java Convention Style on 2004-10-29 ---*/
