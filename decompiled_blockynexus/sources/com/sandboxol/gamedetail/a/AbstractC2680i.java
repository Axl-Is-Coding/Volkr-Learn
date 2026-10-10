package com.sandboxol.gamedetail.a;

import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.gamedetail.c.a.a.ba;
import com.sandboxol.gamedetail.view.widget.MaxLayout;

/* JADX INFO: renamed from: com.sandboxol.gamedetail.a.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogEnterGameGuideBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2680i extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f17839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC2676e f17840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MaxLayout f17841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected com.sandboxol.gamedetail.view.dialog.d f17842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected ba f17843e;

    protected AbstractC2680i(Object obj, View view, int i, LinearLayout linearLayout, AbstractC2676e abstractC2676e, MaxLayout maxLayout) {
        super(obj, view, i);
        this.f17839a = linearLayout;
        this.f17840b = abstractC2676e;
        setContainedBinding(this.f17840b);
        this.f17841c = maxLayout;
    }

    public abstract void a(ba baVar);

    public abstract void a(com.sandboxol.gamedetail.view.dialog.d dVar);
}
