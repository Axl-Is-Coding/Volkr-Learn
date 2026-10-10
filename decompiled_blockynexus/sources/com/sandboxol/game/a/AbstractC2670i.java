package com.sandboxol.game.a;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.widget.StrokeTextView;

/* JADX INFO: renamed from: com.sandboxol.game.a.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogRechargeShopBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2670i extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f17684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StrokeTextView f17685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.sandboxol.recharge.dialog.rechargeshop.k f17686c;

    protected AbstractC2670i(Object obj, View view, int i, k kVar, StrokeTextView strokeTextView) {
        super(obj, view, i);
        this.f17684a = kVar;
        setContainedBinding(this.f17684a);
        this.f17685b = strokeTextView;
    }

    public abstract void a(com.sandboxol.recharge.dialog.rechargeshop.k kVar);
}
