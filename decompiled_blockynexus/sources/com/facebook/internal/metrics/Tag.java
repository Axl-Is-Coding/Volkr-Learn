package com.facebook.internal.metrics;

/* JADX INFO: loaded from: classes.dex */
public enum Tag {
    FACEBOOK_CORE_STARTUP("facebook_core_startup");

    private final String suffix;

    Tag(String str) {
        this.suffix = str;
    }

    public String getSuffix() {
        return this.suffix;
    }
}
