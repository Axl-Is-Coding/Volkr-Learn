package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.dialog.UploadNewGameDialog;

/* JADX INFO: compiled from: DialogNewGameDownloadBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Qb extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Button f7792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProgressBar f7793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f7794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f7795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f7796e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected UploadNewGameDialog.a f7797f;

    protected Qb(Object obj, View view, int i, Button button, ProgressBar progressBar, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f7792a = button;
        this.f7793b = progressBar;
        this.f7794c = textView;
        this.f7795d = textView2;
        this.f7796e = textView3;
    }

    public abstract void a(UploadNewGameDialog.a aVar);

    public UploadNewGameDialog.a f() {
        return this.f7797f;
    }
}
