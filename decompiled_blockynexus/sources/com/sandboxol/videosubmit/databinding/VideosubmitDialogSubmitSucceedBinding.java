package com.sandboxol.videosubmit.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.view.dialog.SubmitSucceedDialog;

/* JADX INFO: loaded from: classes4.dex */
public abstract class VideosubmitDialogSubmitSucceedBinding extends ViewDataBinding {
    public final ImageView ivSuccess;
    protected SubmitSucceedDialog mViewModel;
    public final TextView tvSuccessTips;
    public final View v;

    protected VideosubmitDialogSubmitSucceedBinding(Object obj, View view, int i, ImageView imageView, TextView textView, View view2) {
        super(obj, view, i);
        this.ivSuccess = imageView;
        this.tvSuccessTips = textView;
        this.v = view2;
    }

    public static VideosubmitDialogSubmitSucceedBinding bind(View view) {
        return bind(view, e.a());
    }

    public static VideosubmitDialogSubmitSucceedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public SubmitSucceedDialog getViewModel() {
        return this.mViewModel;
    }

    public abstract void setViewModel(SubmitSucceedDialog submitSucceedDialog);

    @Deprecated
    public static VideosubmitDialogSubmitSucceedBinding bind(View view, Object obj) {
        return (VideosubmitDialogSubmitSucceedBinding) ViewDataBinding.bind(obj, view, R.layout.videosubmit_dialog_submit_succeed);
    }

    @Deprecated
    public static VideosubmitDialogSubmitSucceedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VideosubmitDialogSubmitSucceedBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_dialog_submit_succeed, viewGroup, z, obj);
    }

    public static VideosubmitDialogSubmitSucceedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static VideosubmitDialogSubmitSucceedBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VideosubmitDialogSubmitSucceedBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_dialog_submit_succeed, null, false, obj);
    }
}
