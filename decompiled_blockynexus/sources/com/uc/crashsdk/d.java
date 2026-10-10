package com.uc.crashsdk;

import android.os.Bundle;
import android.webkit.ValueCallback;
import com.uc.crashsdk.export.ICrashClient;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ICrashClient f20530a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f20531b = 3;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile List<ValueCallback<Bundle>> f20532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile List<ValueCallback<Bundle>> f20533d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile List<ValueCallback<Bundle>> f20534e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile List<ValueCallback<Bundle>> f20535f;
    private static final Object g = new Object();

    public static void a(ICrashClient iCrashClient) {
        f20530a = iCrashClient;
    }

    public static boolean b(ValueCallback<Bundle> valueCallback) {
        if (f20533d == null) {
            synchronized (g) {
                if (f20533d == null) {
                    f20533d = new ArrayList();
                }
            }
        }
        synchronized (f20533d) {
            if (f20533d.size() >= f20531b) {
                return false;
            }
            f20533d.add(valueCallback);
            return true;
        }
    }

    public static boolean c(ValueCallback<Bundle> valueCallback) {
        if (f20534e == null) {
            synchronized (g) {
                if (f20534e == null) {
                    f20534e = new ArrayList();
                }
            }
        }
        synchronized (f20534e) {
            if (f20534e.size() >= f20531b) {
                return false;
            }
            f20534e.add(valueCallback);
            return true;
        }
    }

    public static boolean d(ValueCallback<Bundle> valueCallback) {
        if (f20535f == null) {
            synchronized (g) {
                if (f20535f == null) {
                    f20535f = new ArrayList();
                }
            }
        }
        synchronized (f20535f) {
            if (f20535f.size() >= f20531b) {
                return false;
            }
            f20535f.add(valueCallback);
            return true;
        }
    }

    public static void a(String str, String str2, String str3) {
        if (com.uc.crashsdk.a.g.a(str)) {
            com.uc.crashsdk.a.a.a("crashsdk", "onLogGenerated file name is null!", null);
            return;
        }
        boolean zEquals = e.h().equals(str2);
        if (f20530a != null) {
            File file = new File(str);
            try {
                if (zEquals) {
                    f20530a.onLogGenerated(file, str3);
                } else {
                    f20530a.onClientProcessLogGenerated(str2, file, str3);
                }
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        List<ValueCallback<Bundle>> list = f20532c;
        if (!zEquals) {
            list = f20533d;
        }
        if (list != null) {
            synchronized (list) {
                for (ValueCallback<Bundle> valueCallback : list) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString("filePathName", str);
                        if (!zEquals) {
                            bundle.putString("processName", str2);
                        }
                        bundle.putString("logType", str3);
                        valueCallback.onReceiveValue(bundle);
                    } catch (Throwable th2) {
                        com.uc.crashsdk.a.g.a(th2);
                    }
                }
            }
        }
    }

    public static File a(File file) {
        ICrashClient iCrashClient = f20530a;
        if (iCrashClient != null) {
            try {
                return iCrashClient.onBeforeUploadLog(file);
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        return file;
    }

    public static void a(boolean z) {
        ICrashClient iCrashClient = f20530a;
        if (iCrashClient != null) {
            try {
                iCrashClient.onCrashRestarting(z);
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        if (f20534e != null) {
            synchronized (f20534e) {
                for (ValueCallback<Bundle> valueCallback : f20534e) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("isJava", z);
                        valueCallback.onReceiveValue(bundle);
                    } catch (Throwable th2) {
                        com.uc.crashsdk.a.g.a(th2);
                    }
                }
            }
        }
    }

    public static void a(String str, int i, int i2) {
        ICrashClient iCrashClient = f20530a;
        if (iCrashClient != null) {
            iCrashClient.onAddCrashStats(str, i, i2);
        }
        if (f20535f != null) {
            synchronized (f20535f) {
                for (ValueCallback<Bundle> valueCallback : f20535f) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString("processName", str);
                        bundle.putInt("key", i);
                        bundle.putInt("count", i2);
                        valueCallback.onReceiveValue(bundle);
                    } catch (Throwable th) {
                        com.uc.crashsdk.a.g.a(th);
                    }
                }
            }
        }
    }

    public static String a(String str, boolean z) {
        ICrashClient iCrashClient = f20530a;
        return iCrashClient != null ? iCrashClient.onGetCallbackInfo(str, z) : "";
    }

    public static boolean a(ValueCallback<Bundle> valueCallback) {
        if (f20532c == null) {
            synchronized (g) {
                if (f20532c == null) {
                    f20532c = new ArrayList();
                }
            }
        }
        synchronized (f20532c) {
            if (f20532c.size() >= f20531b) {
                return false;
            }
            f20532c.add(valueCallback);
            return true;
        }
    }
}
