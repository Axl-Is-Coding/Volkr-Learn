package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.dialog.UploadApkDialog;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.eb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogAppUploadApkBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0565eb extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Button f8288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Button f8289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Button f8290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Button f8291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Button f8292e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ProgressBar f8293f;
    public final TextView g;
    public final TextView h;
    protected UploadApkDialog.a i;

    protected AbstractC0565eb(Object obj, View view, int i, Button button, Button button2, Button button3, Button button4, Button button5, ProgressBar progressBar, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f8288a = button;
        this.f8289b = button2;
        this.f8290c = button3;
        this.f8291d = button4;
        this.f8292e = button5;
        this.f8293f = progressBar;
        this.g = textView;
        this.h = textView2;
    }

    public abstract void a(UploadApkDialog.a aVar);
}
