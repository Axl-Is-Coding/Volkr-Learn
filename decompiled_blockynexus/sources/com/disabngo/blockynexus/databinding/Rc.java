package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.dialog.FollowFriendBottomDialog;

/* JADX INFO: compiled from: FollowDialogFollowFriendBottomBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Rc extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f7827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f7828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f7829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f7830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f7831e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f7832f;
    protected FollowFriendBottomDialog g;

    protected Rc(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, View view2, View view3) {
        super(obj, view, i);
        this.f7827a = linearLayout;
        this.f7828b = linearLayout2;
        this.f7829c = linearLayout3;
        this.f7830d = textView;
        this.f7831e = view2;
        this.f7832f = view3;
    }

    public abstract void a(FollowFriendBottomDialog followFriendBottomDialog);
}
