package com.sandboxol.googlepay.a;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: FragmentRechargeBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Button f18184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EditText f18185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f18186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f18187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f18188e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final NestedScrollView f18189f;
    public final DataRecyclerView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    protected com.sandboxol.googlepay.view.fragment.recharge.w l;

    protected c(Object obj, View view, int i, Button button, EditText editText, ImageView imageView, ImageView imageView2, ImageView imageView3, NestedScrollView nestedScrollView, DataRecyclerView dataRecyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.f18184a = button;
        this.f18185b = editText;
        this.f18186c = imageView;
        this.f18187d = imageView2;
        this.f18188e = imageView3;
        this.f18189f = nestedScrollView;
        this.g = dataRecyclerView;
        this.h = textView;
        this.i = textView2;
        this.j = textView3;
        this.k = textView4;
    }

    public abstract void a(com.sandboxol.googlepay.view.fragment.recharge.w wVar);
}
