package androidx.core.os;

import android.os.Build;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: EnvironmentCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static String a(File file) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            return Environment.getExternalStorageState(file);
        }
        if (i >= 19) {
            return Environment.getStorageState(file);
        }
        try {
            return file.getCanonicalPath().startsWith(Environment.getExternalStorageDirectory().getCanonicalPath()) ? Environment.getExternalStorageState() : "unknown";
        } catch (IOException e2) {
            Log.w("EnvironmentCompat", "Failed to resolve canonical path: " + e2);
            return "unknown";
        }
    }
}
