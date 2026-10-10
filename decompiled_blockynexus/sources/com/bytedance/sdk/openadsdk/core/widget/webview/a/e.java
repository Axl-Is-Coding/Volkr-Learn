package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.net.Uri;
import android.text.TextUtils;
import fi.iki.elonen.NanoHTTPD;

/* JADX INFO: compiled from: UrlUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: compiled from: UrlUtils.java */
    public enum a {
        HTML(NanoHTTPD.MIME_HTML),
        CSS("text/css"),
        JS("application/x-javascript"),
        IMAGE("image/*");


        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f6667e;

        a(String str) {
            this.f6667e = str;
        }

        public String a() {
            return this.f6667e;
        }
    }

    public static a a(String str) {
        a aVar;
        a aVar2 = a.IMAGE;
        if (TextUtils.isEmpty(str)) {
            return aVar2;
        }
        try {
            String path = Uri.parse(str).getPath();
            if (path == null) {
                return aVar2;
            }
            if (path.endsWith(".css")) {
                aVar = a.CSS;
            } else if (path.endsWith(".js")) {
                aVar = a.JS;
            } else if (path.endsWith(".jpg") || path.endsWith(".gif") || path.endsWith(".png") || path.endsWith(".jpeg") || path.endsWith(".webp") || path.endsWith(".bmp") || path.endsWith(".ico")) {
                aVar = a.IMAGE;
            } else {
                if (!path.endsWith(".html")) {
                    return aVar2;
                }
                aVar = a.HTML;
            }
            return aVar;
        } catch (Throwable unused) {
            return aVar2;
        }
    }
}
