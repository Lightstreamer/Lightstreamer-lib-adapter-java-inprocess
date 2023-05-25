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

import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Thrown by the {@link MetadataProvider#notifyNewSession(String, String, Map)}
 * method if a User is not
 * enabled to open a new Session but he would be enabled as soon as another
 * Session were closed. By using this exception, the ID of the other Session
 * is also supplied.
 * <BR>After receiving this exception, the Server may try to close the specified
 * session and invoke {@link MetadataProvider#notifyNewSession(String, String, Map)} again.
 */
public class ConflictingSessionException extends CreditsException {
    private String conflictingSessionID;

    /**
     * Constructs a ConflictingSessionException with supplied error code and
     * message text that will be forwarded to the Client in case the Server
     * can't solve the issue by closing the conflicting session.
     * An internal error message text can also be specified.
     *
     * @param clientErrorCode  Error code that can be used to distinguish the
     * kind of problem. It must be a negative integer, or zero to mean an
     * unspecified problem.
     * @param msg The detail message.
     * @param userMsg A detail message to be forwarded to the Client.
     * It can be null, in which case an empty string message will be forwarded.
     * The message is free, but if it is not in simple ASCII or if it is
     * multiline, it might be altered in order to be sent to very old
     * non-TLCP clients.
     * @param conflictingSessionID  ID of a Session that can be closed in
     * order to eliminate the reported problem. It must not be null.
     */
    public ConflictingSessionException(int clientErrorCode, @Nullable String msg, 
    								   @Nullable String userMsg,
    								   @Nullable String conflictingSessionID) {
        super(clientErrorCode, msg, userMsg);
        this.conflictingSessionID = conflictingSessionID;
    }

    /**
     * Returns the ID of a Session that can be closed in order to eliminate
     * the problem reported in this exception.
     *
     * @return ID of a Session. It should not be null.
     */
    @Nullable 
    public String getConflictingSessionID() {
        return conflictingSessionID;
    }
}


/*--- Formatted in Lightstreamer Java Convention Style on 2004-10-29 ---*/
