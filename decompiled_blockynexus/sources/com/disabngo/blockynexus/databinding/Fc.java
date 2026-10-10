package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.dialog.TribeContributionDialog;

/* JADX INFO: compiled from: DialogTribeContributionBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Fc extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Button f7439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Button f7440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EditText f7441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f7442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f7443e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f7444f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    protected TribeContributionDialog j;

    protected Fc(Object obj, View view, int i, Button button, Button button2, EditText editText, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f7439a = button;
        this.f7440b = button2;
        this.f7441c = editText;
        this.f7442d = imageView;
        this.f7443e = imageView2;
        this.f7444f = linearLayout;
        this.g = textView;
        this.h = textView2;
        this.i = textView3;
    }

    public abstract void a(TribeContributionDialog tribeContributionDialog);
}
