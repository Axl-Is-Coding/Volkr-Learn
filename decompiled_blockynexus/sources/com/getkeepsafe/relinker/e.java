package com.getkeepsafe.relinker;

import android.content.Context;
import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import com.getkeepsafe.relinker.b;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: ReLinkerInstance.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Set<String> f12518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final b.InterfaceC0099b f12519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final b.a f12520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f12521d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected boolean f12522e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected b.d f12523f;

    protected e() {
        this(new f(), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, String str, String str2) throws Throwable {
        if (this.f12518a.contains(str) && !this.f12521d) {
            a("%s already loaded previously!", str);
            return;
        }
        try {
            this.f12519b.loadLibrary(str);
            this.f12518a.add(str);
            a("%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e2) {
            a("Loading the library normally failed: %s", Log.getStackTraceString(e2));
            a("%s (%s) was not loaded normally, re-linking...", str, str2);
            File fileB = b(context, str, str2);
            if (!fileB.exists() || this.f12521d) {
                if (this.f12521d) {
                    a("Forcing a re-link of %s (%s)...", str, str2);
                }
                a(context, str, str2);
                this.f12520c.a(context, this.f12519b.supportedAbis(), this.f12519b.mapLibraryName(str), fileB, this);
            }
            try {
                if (this.f12522e) {
                    com.getkeepsafe.relinker.a.f fVar = null;
                    try {
                        com.getkeepsafe.relinker.a.f fVar2 = new com.getkeepsafe.relinker.a.f(fileB);
                        try {
                            List<String> listD = fVar2.d();
                            fVar2.close();
                            Iterator<String> it = listD.iterator();
                            while (it.hasNext()) {
                                a(context, this.f12519b.unmapLibraryName(it.next()));
                            }
                        } catch (Throwable th) {
                            th = th;
                            fVar = fVar2;
                            fVar.close();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (IOException unused) {
            }
            this.f12519b.loadPath(fileB.getAbsolutePath());
            this.f12518a.add(str);
            a("%s (%s) was re-linked!", str, str2);
        }
    }

    protected File b(Context context, String str, String str2) {
        String strMapLibraryName = this.f12519b.mapLibraryName(str);
        if (g.a(str2)) {
            return new File(a(context), strMapLibraryName);
        }
        return new File(a(context), strMapLibraryName + Consts.DOT + str2);
    }

    protected e(b.InterfaceC0099b interfaceC0099b, b.a aVar) {
        this.f12518a = new HashSet();
        if (interfaceC0099b == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Cannot pass null library installer");
        }
        this.f12519b = interfaceC0099b;
        this.f12520c = aVar;
    }

    public void a(Context context, String str) {
        a(context, str, (String) null, (b.c) null);
    }

    public void a(Context context, String str, String str2, b.c cVar) {
        if (context != null) {
            if (!g.a(str)) {
                a("Beginning load of %s...", str);
                if (cVar == null) {
                    c(context, str, str2);
                    return;
                } else {
                    new Thread(new c(this, context, str, str2, cVar)).start();
                    return;
                }
            }
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        throw new IllegalArgumentException("Given context is null");
    }

    protected File a(Context context) {
        return context.getDir("lib", 0);
    }

    protected void a(Context context, String str, String str2) {
        File fileA = a(context);
        File fileB = b(context, str, str2);
        File[] fileArrListFiles = fileA.listFiles(new d(this, this.f12519b.mapLibraryName(str)));
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (this.f12521d || !file.getAbsolutePath().equals(fileB.getAbsolutePath())) {
                file.delete();
            }
        }
    }

    public void a(String str, Object... objArr) {
        a(String.format(Locale.US, str, objArr));
    }

    public void a(String str) {
        b.d dVar = this.f12523f;
        if (dVar != null) {
            dVar.log(str);
        }
    }
}
