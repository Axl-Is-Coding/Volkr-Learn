package com.tendcloud.tenddata;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import java.io.File;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile l f20032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PackageInfo f20033b = null;

    private l() {
    }

    public static l a() {
        if (f20032a == null) {
            synchronized (l.class) {
                if (f20032a == null) {
                    f20032a = new l();
                }
            }
        }
        return f20032a;
    }

    private synchronized boolean i(Context context) {
        try {
            if (this.f20033b == null) {
                this.f20033b = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            }
        } catch (Throwable th) {
            throw th;
        }
        return true;
    }

    public int b(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            if (i(context)) {
                return this.f20033b.versionCode;
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public String c(Context context) {
        if (context == null) {
            return "unknown";
        }
        try {
            return !i(context) ? "unknown" : this.f20033b.versionName;
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public long d(Context context) {
        if (context == null) {
            return -1L;
        }
        try {
            if (i(context) && af.a(9)) {
                return this.f20033b.firstInstallTime;
            }
            return -1L;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public long e(Context context) {
        if (context == null) {
            return -1L;
        }
        try {
            if (i(context) && af.a(9)) {
                return this.f20033b.lastUpdateTime;
            }
            return -1L;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public long f(Context context) {
        if (context == null) {
            return -1L;
        }
        try {
            return new File(context.getApplicationInfo().sourceDir).length();
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public String g(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (!i(context)) {
                return null;
            }
            Signature[] signatureArr = this.f20033b.signatures;
            if (signatureArr.length < 1) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(signatureArr[0].toCharsString());
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public String h(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public String a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageName();
        } catch (Throwable unused) {
            return "";
        }
    }
}
