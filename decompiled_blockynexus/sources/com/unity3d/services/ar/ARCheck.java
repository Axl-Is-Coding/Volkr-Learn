package com.unity3d.services.ar;

/* JADX INFO: loaded from: classes5.dex */
public class ARCheck {
    public static boolean isFrameworkPresent() {
        try {
            Class.forName("com.google.ar.core.Session");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
