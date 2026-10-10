package androidx.core.app;

import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import java.util.Set;

/* JADX INFO: compiled from: RemoteInput.java */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharSequence f1031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CharSequence[] f1032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f1033d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f1034e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Bundle f1035f;
    private final Set<String> g;

    public boolean a() {
        return this.f1033d;
    }

    public Set<String> b() {
        return this.g;
    }

    public CharSequence[] c() {
        return this.f1032c;
    }

    public int d() {
        return this.f1034e;
    }

    public Bundle e() {
        return this.f1035f;
    }

    public CharSequence f() {
        return this.f1031b;
    }

    public String g() {
        return this.f1030a;
    }

    public boolean h() {
        return (a() || (c() != null && c().length != 0) || b() == null || b().isEmpty()) ? false : true;
    }

    static RemoteInput[] a(p[] pVarArr) {
        if (pVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[pVarArr.length];
        for (int i = 0; i < pVarArr.length; i++) {
            remoteInputArr[i] = a(pVarArr[i]);
        }
        return remoteInputArr;
    }

    static RemoteInput a(p pVar) {
        RemoteInput.Builder builderAddExtras = new RemoteInput.Builder(pVar.g()).setLabel(pVar.f()).setChoices(pVar.c()).setAllowFreeFormInput(pVar.a()).addExtras(pVar.e());
        if (Build.VERSION.SDK_INT >= 29) {
            builderAddExtras.setEditChoicesBeforeSending(pVar.d());
        }
        return builderAddExtras.build();
    }
}
