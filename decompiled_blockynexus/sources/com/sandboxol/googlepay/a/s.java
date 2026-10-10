package com.sandboxol.googlepay.a;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.googlepay.view.widget.StarCodeHelpPopupWindow;

/* JADX INFO: compiled from: PopwindowStarCodeHelpBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f18231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected StarCodeHelpPopupWindow f18232b;

    protected s(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.f18231a = textView;
    }

    public abstract void a(StarCodeHelpPopupWindow starCodeHelpPopupWindow);
}
