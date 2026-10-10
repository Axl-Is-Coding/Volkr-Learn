package com.bytedance.sdk.openadsdk.core.f;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: PermissionsResultAction.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6174a = "e";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<String> f6175b = new HashSet(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Looper f6176c = Looper.getMainLooper();

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.f.e$5, reason: invalid class name */
    /* JADX INFO: compiled from: PermissionsResultAction.java */
    static /* synthetic */ class AnonymousClass5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6183a = new int[c.values().length];

        static {
            try {
                f6183a[c.GRANTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6183a[c.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6183a[c.NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public abstract void a();

    public abstract void a(String str);

    protected final synchronized boolean a(String str, int i) {
        if (i == 0) {
            return a(str, c.GRANTED);
        }
        return a(str, c.DENIED);
    }

    public synchronized boolean b(String str) {
        Log.d(f6174a, "Permission not found: " + str);
        return true;
    }

    protected final synchronized boolean a(final String str, c cVar) {
        this.f6175b.remove(str);
        int i = AnonymousClass5.f6183a[cVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                new Handler(this.f6176c).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.f.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.a(str);
                    }
                });
                return true;
            }
            if (i == 3) {
                if (b(str)) {
                    if (this.f6175b.isEmpty()) {
                        new Handler(this.f6176c).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.f.e.3
                            @Override // java.lang.Runnable
                            public void run() {
                                e.this.a();
                            }
                        });
                        return true;
                    }
                } else {
                    new Handler(this.f6176c).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.f.e.4
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.a(str);
                        }
                    });
                    return true;
                }
            }
        } else if (this.f6175b.isEmpty()) {
            new Handler(this.f6176c).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.f.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.a();
                }
            });
            return true;
        }
        return false;
    }

    protected final synchronized void a(String[] strArr) {
        Collections.addAll(this.f6175b, strArr);
    }
}
