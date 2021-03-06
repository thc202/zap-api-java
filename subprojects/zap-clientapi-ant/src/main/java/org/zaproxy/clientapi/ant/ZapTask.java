/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2011 The ZAP Development Team
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
 */
package org.zaproxy.clientapi.ant;

import org.apache.tools.ant.Task;
import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ApiResponseElement;
import org.zaproxy.clientapi.core.ClientApi;

public abstract class ZapTask extends Task {
    private String zapAddress;
    private int zapPort;
    private boolean debug = false;
    private String apikey;

    protected ClientApi getClientApi() {
        return new ClientApi(zapAddress, zapPort, apikey, debug);
    }

    public String getZapAddress() {
        return zapAddress;
    }

    public void setZapAddress(String zapAddress) {
        this.zapAddress = zapAddress;
    }

    public int getZapPort() {
        return zapPort;
    }

    public void setZapPort(int zapPort) {
        this.zapPort = zapPort;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    protected String extractValue(ApiResponse element) {
        if (element instanceof ApiResponseElement) {
            return ((ApiResponseElement) element).getValue();
        }
        return null;
    }
}
