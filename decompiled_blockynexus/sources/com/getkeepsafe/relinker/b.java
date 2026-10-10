package com.getkeepsafe.relinker;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: ReLinker.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: compiled from: ReLinker.java */
    public interface a {
        void a(Context context, String[] strArr, String str, File file, e eVar);
    }

    /* JADX INFO: renamed from: com.getkeepsafe.relinker.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ReLinker.java */
    public interface InterfaceC0099b {
        void loadLibrary(String str);

        void loadPath(String str);

        String mapLibraryName(String str);

        String[] supportedAbis();

        String unmapLibraryName(String str);
    }

    /* JADX INFO: compiled from: ReLinker.java */
    public interface c {
        void failure(Throwable th);

        void success();
    }

    /* JADX INFO: compiled from: ReLinker.java */
    public interface d {
        void log(String str);
    }

    public static void a(Context context, String str) {
        a(context, str, null, null);
    }

    public static void a(Context context, String str, String str2, c cVar) {
        new e().a(context, str, str2, cVar);
    }
}
