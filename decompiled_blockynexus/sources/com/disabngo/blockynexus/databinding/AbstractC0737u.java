package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivitySearchFriendBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0737u extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageButton f8856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageButton f8857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RelativeLayout f8858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Toolbar f8859d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final EditText f8860e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected com.disabngo.blockynexus.view.activity.searchfriend.q f8861f;

    protected AbstractC0737u(Object obj, View view, int i, ImageButton imageButton, ImageButton imageButton2, RelativeLayout relativeLayout, Toolbar toolbar, EditText editText) {
        super(obj, view, i);
        this.f8856a = imageButton;
        this.f8857b = imageButton2;
        this.f8858c = relativeLayout;
        this.f8859d = toolbar;
        this.f8860e = editText;
    }

    public abstract void a(com.disabngo.blockynexus.view.activity.searchfriend.q qVar);
}
