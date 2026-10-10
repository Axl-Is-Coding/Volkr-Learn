package me.iwf.photopicker.utils;

import java.io.File;

/* JADX INFO: compiled from: FileUtils.java */
/* JADX INFO: loaded from: classes5.dex */
public class b {
    public static boolean a(String str) {
        if (str != null && str.trim().length() > 0) {
            try {
                return new File(str).exists();
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
