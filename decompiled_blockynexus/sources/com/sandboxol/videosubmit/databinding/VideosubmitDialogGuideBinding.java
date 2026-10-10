package com.sandboxol.videosubmit.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.view.dialog.GuideDialog;

/* JADX INFO: loaded from: classes4.dex */
public abstract class VideosubmitDialogGuideBinding extends ViewDataBinding {
    public final Button btnSignUp;
    public final View divider;
    public final ImageView iv;
    public final ImageView ivClose;
    protected GuideDialog mViewModel;
    public final View v;

    protected VideosubmitDialogGuideBinding(Object obj, View view, int i, Button button, View view2, ImageView imageView, ImageView imageView2, View view3) {
        super(obj, view, i);
        this.btnSignUp = button;
        this.divider = view2;
        this.iv = imageView;
        this.ivClose = imageView2;
        this.v = view3;
    }

    public static VideosubmitDialogGuideBinding bind(View view) {
        return bind(view, e.a());
    }

    public static VideosubmitDialogGuideBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public GuideDialog getViewModel() {
        return this.mViewModel;
    }

    public abstract void setViewModel(GuideDialog guideDialog);

    @Deprecated
    public static VideosubmitDialogGuideBinding bind(View view, Object obj) {
        return (VideosubmitDialogGuideBinding) ViewDataBinding.bind(obj, view, R.layout.videosubmit_dialog_guide);
    }

    @Deprecated
    public static VideosubmitDialogGuideBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VideosubmitDialogGuideBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_dialog_guide, viewGroup, z, obj);
    }

    public static VideosubmitDialogGuideBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static VideosubmitDialogGuideBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VideosubmitDialogGuideBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_dialog_guide, null, false, obj);
    }
}
