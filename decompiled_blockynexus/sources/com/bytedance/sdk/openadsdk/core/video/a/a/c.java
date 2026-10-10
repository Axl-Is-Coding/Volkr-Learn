package com.bytedance.sdk.openadsdk.core.video.a.a;

import android.content.Context;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: VideoFilesUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static void a(File file) throws IOException {
        if (!file.exists()) {
            if (!file.mkdirs()) {
                throw new IOException(String.format("Directory %s can't be created", file.getAbsolutePath()));
            }
        } else {
            if (file.isDirectory()) {
                return;
            }
            throw new IOException("File " + file + " is not directory!");
        }
    }

    public static File b(Context context, String str) {
        File file = new File(context.getExternalFilesDir(null) + File.separator + "ttvideo", str + ".pre");
        try {
            a(file.getParentFile());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return file;
    }

    public static File a(Context context, String str) {
        File file = new File(context.getExternalFilesDir(null) + File.separator + "ttvideo", str);
        try {
            a(file.getParentFile());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (file.exists()) {
            return file;
        }
        return new File(file.getParentFile(), file.getName() + ".download");
    }
}
