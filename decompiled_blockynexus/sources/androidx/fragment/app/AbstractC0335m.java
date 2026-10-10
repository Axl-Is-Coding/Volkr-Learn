package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.app.ActivityCompat;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: renamed from: androidx.fragment.app.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentHostCallback.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0335m<E> extends AbstractC0332j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f1509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f1510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f1511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f1512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final LayoutInflaterFactory2C0343v f1513e;

    AbstractC0335m(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new Handler(), 0);
    }

    @Override // androidx.fragment.app.AbstractC0332j
    public View a(int i) {
        return null;
    }

    void a(Fragment fragment) {
    }

    public void a(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.f1510b.startActivity(intent);
    }

    public void a(Fragment fragment, String[] strArr, int i) {
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // androidx.fragment.app.AbstractC0332j
    public boolean a() {
        return true;
    }

    public boolean a(String str) {
        return false;
    }

    Activity b() {
        return this.f1509a;
    }

    public boolean b(Fragment fragment) {
        return true;
    }

    Context c() {
        return this.f1510b;
    }

    Handler d() {
        return this.f1511c;
    }

    public abstract E e();

    public LayoutInflater f() {
        return LayoutInflater.from(this.f1510b);
    }

    public int g() {
        return this.f1512d;
    }

    public boolean h() {
        return true;
    }

    public void i() {
    }

    AbstractC0335m(Activity activity, Context context, Handler handler, int i) {
        this.f1513e = new LayoutInflaterFactory2C0343v();
        this.f1509a = activity;
        androidx.core.f.h.a(context, "context == null");
        this.f1510b = context;
        androidx.core.f.h.a(handler, "handler == null");
        this.f1511c = handler;
        this.f1512d = i;
    }

    public void a(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (i == -1) {
            ActivityCompat.a(this.f1509a, intentSender, i, intent, i2, i3, i4, bundle);
            return;
        }
        throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
    }
}
