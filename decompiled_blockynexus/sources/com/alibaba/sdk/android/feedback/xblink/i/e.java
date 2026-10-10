package com.alibaba.sdk.android.feedback.xblink.i;

import fi.iki.elonen.NanoHTTPD;

/* JADX INFO: loaded from: classes.dex */
public enum e {
    JS("js", "application/x-javascript"),
    CSS("css", "text/css"),
    JPG("jpg", "image/jpeg"),
    JPEG("jpep", "image/jpeg"),
    PNG("png", "image/png"),
    WEBP("webp", "image/webp"),
    GIF("gif", "image/gif"),
    HTM("htm", NanoHTTPD.MIME_HTML),
    HTML("html", NanoHTTPD.MIME_HTML);

    private String j;
    private String k;

    e(String str, String str2) {
        this.j = str;
        this.k = str2;
    }

    public String b() {
        return this.j;
    }

    public String c() {
        return this.k;
    }
}
