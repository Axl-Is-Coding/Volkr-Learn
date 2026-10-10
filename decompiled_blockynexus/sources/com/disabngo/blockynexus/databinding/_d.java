package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.e.b.z.C0966e;

/* JADX INFO: compiled from: FragmentGroupAdminManageBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class _d extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Button f8125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f8126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected C0966e f8127c;

    protected _d(Object obj, View view, int i, Button button, TextView textView) {
        super(obj, view, i);
        this.f8125a = button;
        this.f8126b = textView;
    }

    public abstract void a(C0966e c0966e);
}
