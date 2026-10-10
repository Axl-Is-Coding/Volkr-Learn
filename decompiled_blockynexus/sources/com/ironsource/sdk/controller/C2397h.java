package com.ironsource.sdk.controller;

import android.os.Build;
import android.webkit.JavascriptInterface;
import com.ironsource.sdk.controller.WebController;
import java.lang.reflect.Method;
import java.security.AccessControlException;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ControllerAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
class C2397h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15284a = "h";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WebController.c f15285b;

    C2397h(WebController.c cVar) {
        this.f15285b = cVar;
    }

    synchronized void a(String str, String str2) throws Exception {
        if (this.f15285b == null) {
            com.ironsource.sdk.utils.f.b(f15284a, "!!! nativeAPI == null !!!");
            return;
        }
        Method declaredMethod = WebController.c.class.getDeclaredMethod(str, String.class);
        if (Build.VERSION.SDK_INT >= 17 && !declaredMethod.isAnnotationPresent(JavascriptInterface.class)) {
            throw new AccessControlException("Trying to access a private function: " + str);
        }
        declaredMethod.invoke(this.f15285b, str2);
    }

    void a(String str) {
        WebController.c cVar = this.f15285b;
        if (cVar != null) {
            cVar.b(str);
        }
    }
}
