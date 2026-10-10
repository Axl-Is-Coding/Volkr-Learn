package com.sandboxol.gamedetail.a;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.gamedetail.c.a.a.ba;
import com.sandboxol.gamedetail.view.widget.CenterRadioButton;
import com.sandboxol.gamedetail.view.widget.GameDetailRelativeLayout;

/* JADX INFO: compiled from: FragmentGameDetailBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class o extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f17857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f17858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f17859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f17860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AbstractC2676e f17861e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final GameDetailRelativeLayout f17862f;
    public final CenterRadioButton g;
    public final CenterRadioButton h;
    public final CenterRadioButton i;
    protected ba j;

    protected o(Object obj, View view, int i, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, AbstractC2676e abstractC2676e, GameDetailRelativeLayout gameDetailRelativeLayout, CenterRadioButton centerRadioButton, CenterRadioButton centerRadioButton2, CenterRadioButton centerRadioButton3) {
        super(obj, view, i);
        this.f17857a = frameLayout;
        this.f17858b = imageView;
        this.f17859c = imageView2;
        this.f17860d = linearLayout;
        this.f17861e = abstractC2676e;
        setContainedBinding(this.f17861e);
        this.f17862f = gameDetailRelativeLayout;
        this.g = centerRadioButton;
        this.h = centerRadioButton2;
        this.i = centerRadioButton3;
    }

    public abstract void a(ba baVar);

    public ba f() {
        return this.j;
    }
}
