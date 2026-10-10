package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: ActivityTribeSearchBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class C extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageButton f7330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RelativeLayout f7331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Toolbar f7332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EditText f7333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected com.disabngo.blockynexus.view.activity.tribesearch.k f7334e;

    protected C(Object obj, View view, int i, ImageButton imageButton, RelativeLayout relativeLayout, Toolbar toolbar, EditText editText) {
        super(obj, view, i);
        this.f7330a = imageButton;
        this.f7331b = relativeLayout;
        this.f7332c = toolbar;
        this.f7333d = editText;
    }

    public abstract void a(com.disabngo.blockynexus.view.activity.tribesearch.k kVar);
}
