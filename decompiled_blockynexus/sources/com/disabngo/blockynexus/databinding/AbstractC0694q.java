package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityNewSearchFriendBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0694q extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputEditText f8709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextInputLayout f8710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f8711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f8712d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatCheckBox f8713e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AppCompatCheckBox f8714f;
    public final Toolbar g;
    protected com.disabngo.blockynexus.view.activity.newsearch.o h;

    protected AbstractC0694q(Object obj, View view, int i, TextInputEditText textInputEditText, TextInputLayout textInputLayout, LinearLayout linearLayout, LinearLayout linearLayout2, AppCompatCheckBox appCompatCheckBox, AppCompatCheckBox appCompatCheckBox2, Toolbar toolbar) {
        super(obj, view, i);
        this.f8709a = textInputEditText;
        this.f8710b = textInputLayout;
        this.f8711c = linearLayout;
        this.f8712d = linearLayout2;
        this.f8713e = appCompatCheckBox;
        this.f8714f = appCompatCheckBox2;
        this.g = toolbar;
    }

    public abstract void a(com.disabngo.blockynexus.view.activity.newsearch.o oVar);
}
