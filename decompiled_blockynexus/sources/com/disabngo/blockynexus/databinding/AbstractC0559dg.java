package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.fragment.updateuserinfo.UpdateUserInfoViewModel;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.dg, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentUpdateUserInfoBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0559dg extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f8267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f8268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f8269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected UpdateUserInfoViewModel f8270d;

    protected AbstractC0559dg(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView) {
        super(obj, view, i);
        this.f8267a = imageView;
        this.f8268b = imageView2;
        this.f8269c = textView;
    }

    public abstract void a(UpdateUserInfoViewModel updateUserInfoViewModel);
}
