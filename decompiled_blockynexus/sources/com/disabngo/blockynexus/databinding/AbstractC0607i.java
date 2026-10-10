package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.activity.friendmatch.FriendMatchViewModel;
import com.disabngo.blockynexus.view.widget.MapLayout;
import com.sandboxol.common.widget.RoundImageView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityFriendMatchBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0607i extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Button f8428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f8429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RoundImageView f8430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f8431d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f8432e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f8433f;
    public final MapLayout g;
    public final RelativeLayout h;
    public final RelativeLayout i;
    public final TextView j;
    public final View k;
    public final View l;
    protected FriendMatchViewModel m;

    protected AbstractC0607i(Object obj, View view, int i, Button button, ConstraintLayout constraintLayout, RoundImageView roundImageView, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, MapLayout mapLayout, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, View view2, View view3) {
        super(obj, view, i);
        this.f8428a = button;
        this.f8429b = constraintLayout;
        this.f8430c = roundImageView;
        this.f8431d = imageView;
        this.f8432e = imageView2;
        this.f8433f = linearLayout;
        this.g = mapLayout;
        this.h = relativeLayout;
        this.i = relativeLayout2;
        this.j = textView;
        this.k = view2;
        this.l = view3;
    }

    public abstract void a(FriendMatchViewModel friendMatchViewModel);
}
