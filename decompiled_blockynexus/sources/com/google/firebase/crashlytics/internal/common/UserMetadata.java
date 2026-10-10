package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class UserMetadata {
    static final int MAX_ATTRIBUTES = 64;
    static final int MAX_ATTRIBUTE_SIZE = 1024;
    private String userId = null;
    private final ConcurrentHashMap<String, String> attributes = new ConcurrentHashMap<>();

    private static String sanitizeAttribute(String str) {
        if (str == null) {
            return str;
        }
        String strTrim = str.trim();
        return strTrim.length() > 1024 ? strTrim.substring(0, 1024) : strTrim;
    }

    public Map<String, String> getCustomKeys() {
        return Collections.unmodifiableMap(this.attributes);
    }

    public String getUserId() {
        return this.userId;
    }

    public void setCustomKey(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Custom attribute key must not be null.");
        }
        String strSanitizeAttribute = sanitizeAttribute(str);
        if (this.attributes.size() < 64 || this.attributes.containsKey(strSanitizeAttribute)) {
            this.attributes.put(strSanitizeAttribute, str2 == null ? "" : sanitizeAttribute(str2));
        } else {
            Logger.getLogger().d("Exceeded maximum number of custom attributes (64)");
        }
    }

    public void setUserId(String str) {
        this.userId = sanitizeAttribute(str);
    }
}
