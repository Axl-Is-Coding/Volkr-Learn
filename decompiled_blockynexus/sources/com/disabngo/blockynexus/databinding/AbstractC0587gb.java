package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.dialog.UploadSoDialog;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.gb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogAppUploadSoBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0587gb extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Button f8357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Button f8358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Button f8359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Button f8360d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f8361e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ProgressBar f8362f;
    public final TextView g;
    public final TextView h;
    protected UploadSoDialog.a i;

    protected AbstractC0587gb(Object obj, View view, int i, Button button, Button button2, Button button3, Button button4, ImageView imageView, ProgressBar progressBar, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f8357a = button;
        this.f8358b = button2;
        this.f8359c = button3;
        this.f8360d = button4;
        this.f8361e = imageView;
        this.f8362f = progressBar;
        this.g = textView;
        this.h = textView2;
    }

    public abstract void a(UploadSoDialog.a aVar);
}
