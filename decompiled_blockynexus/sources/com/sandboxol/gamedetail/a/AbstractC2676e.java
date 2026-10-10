package com.sandboxol.gamedetail.a;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.gamedetail.c.a.a.ba;

/* JADX INFO: renamed from: com.sandboxol.gamedetail.a.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ContentGameHallBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2676e extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RelativeLayout f17827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RelativeLayout f17828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected ba f17829c;

    protected AbstractC2676e(Object obj, View view, int i, RelativeLayout relativeLayout, RelativeLayout relativeLayout2) {
        super(obj, view, i);
        this.f17827a = relativeLayout;
        this.f17828b = relativeLayout2;
    }

    public abstract void a(ba baVar);
}
