package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.dialog.PartyTipDialog;
import com.sandboxol.common.widget.StrokeTextView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.dc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogPartyTipBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0555dc extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Button f8253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Button f8254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f8255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f8256d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final StrokeTextView f8257e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected PartyTipDialog f8258f;

    protected AbstractC0555dc(Object obj, View view, int i, Button button, Button button2, ImageView imageView, LinearLayout linearLayout, StrokeTextView strokeTextView) {
        super(obj, view, i);
        this.f8253a = button;
        this.f8254b = button2;
        this.f8255c = imageView;
        this.f8256d = linearLayout;
        this.f8257e = strokeTextView;
    }
}
