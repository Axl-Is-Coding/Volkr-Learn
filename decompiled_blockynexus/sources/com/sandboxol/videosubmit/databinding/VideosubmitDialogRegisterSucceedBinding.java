package com.sandboxol.videosubmit.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.view.dialog.RegisterSucceedDialog;

/* JADX INFO: loaded from: classes4.dex */
public abstract class VideosubmitDialogRegisterSucceedBinding extends ViewDataBinding {
    public final ImageView ivSuccess;
    protected RegisterSucceedDialog mViewModel;
    public final TextView tvSuccessTips;
    public final View v;

    protected VideosubmitDialogRegisterSucceedBinding(Object obj, View view, int i, ImageView imageView, TextView textView, View view2) {
        super(obj, view, i);
        this.ivSuccess = imageView;
        this.tvSuccessTips = textView;
        this.v = view2;
    }

    public static VideosubmitDialogRegisterSucceedBinding bind(View view) {
        return bind(view, e.a());
    }

    public static VideosubmitDialogRegisterSucceedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public RegisterSucceedDialog getViewModel() {
        return this.mViewModel;
    }

    public abstract void setViewModel(RegisterSucceedDialog registerSucceedDialog);

    @Deprecated
    public static VideosubmitDialogRegisterSucceedBinding bind(View view, Object obj) {
        return (VideosubmitDialogRegisterSucceedBinding) ViewDataBinding.bind(obj, view, R.layout.videosubmit_dialog_register_succeed);
    }

    @Deprecated
    public static VideosubmitDialogRegisterSucceedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VideosubmitDialogRegisterSucceedBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_dialog_register_succeed, viewGroup, z, obj);
    }

    public static VideosubmitDialogRegisterSucceedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static VideosubmitDialogRegisterSucceedBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VideosubmitDialogRegisterSucceedBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_dialog_register_succeed, null, false, obj);
    }
}
