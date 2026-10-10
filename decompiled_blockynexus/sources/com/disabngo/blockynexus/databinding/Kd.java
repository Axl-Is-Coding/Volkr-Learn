package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.EditText;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.e.b.t.C0927f;

/* JADX INFO: compiled from: FragmentEnsureEmailBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Kd extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f7607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected C0927f f7608b;

    protected Kd(Object obj, View view, int i, EditText editText) {
        super(obj, view, i);
        this.f7607a = editText;
    }

    public abstract void a(C0927f c0927f);
}
