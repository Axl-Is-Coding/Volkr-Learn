package com.sandboxol.game.a;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.recharge.dialog.rechargeshop.StarCodeHelpPopupWindow;

/* JADX INFO: compiled from: GamePopwindowStarCodeHelpBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class C extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f17638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected StarCodeHelpPopupWindow f17639b;

    protected C(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.f17638a = textView;
    }

    public abstract void a(StarCodeHelpPopupWindow starCodeHelpPopupWindow);
}
