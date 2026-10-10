package com.sandboxol.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.center.R;
import com.sandboxol.center.view.dialog.ActivityGuideDialog;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDialogActivityGuideBinding extends ViewDataBinding {
    public final Button btnSignUp;
    public final View divider;
    public final ImageView iv;
    public final ImageView ivClose;
    protected ActivityGuideDialog mViewModel;
    public final View v;

    protected BaseDialogActivityGuideBinding(Object obj, View view, int i, Button button, View view2, ImageView imageView, ImageView imageView2, View view3) {
        super(obj, view, i);
        this.btnSignUp = button;
        this.divider = view2;
        this.iv = imageView;
        this.ivClose = imageView2;
        this.v = view3;
    }

    public static BaseDialogActivityGuideBinding bind(View view) {
        return bind(view, e.a());
    }

    public static BaseDialogActivityGuideBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public ActivityGuideDialog getViewModel() {
        return this.mViewModel;
    }

    public abstract void setViewModel(ActivityGuideDialog activityGuideDialog);

    @Deprecated
    public static BaseDialogActivityGuideBinding bind(View view, Object obj) {
        return (BaseDialogActivityGuideBinding) ViewDataBinding.bind(obj, view, R.layout.base_dialog_activity_guide);
    }

    @Deprecated
    public static BaseDialogActivityGuideBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseDialogActivityGuideBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_activity_guide, viewGroup, z, obj);
    }

    public static BaseDialogActivityGuideBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static BaseDialogActivityGuideBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseDialogActivityGuideBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_activity_guide, null, false, obj);
    }
}
