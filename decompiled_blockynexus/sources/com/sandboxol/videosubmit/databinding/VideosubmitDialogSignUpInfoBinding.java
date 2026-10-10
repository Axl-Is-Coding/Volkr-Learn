package com.sandboxol.videosubmit.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.view.dialog.signupinfo.SignUpInfoDialog;

/* JADX INFO: loaded from: classes4.dex */
public abstract class VideosubmitDialogSignUpInfoBinding extends ViewDataBinding {
    public final TextView etYtName;
    protected SignUpInfoDialog mViewModel;
    public final TextView tvCountryName;
    public final TextView tvFbName;
    public final TextView tvLink;
    public final TextView tvTitle;
    public final TextView tvYtName;
    public final ConstraintLayout v;

    protected VideosubmitDialogSignUpInfoBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.etYtName = textView;
        this.tvCountryName = textView2;
        this.tvFbName = textView3;
        this.tvLink = textView4;
        this.tvTitle = textView5;
        this.tvYtName = textView6;
        this.v = constraintLayout;
    }

    public static VideosubmitDialogSignUpInfoBinding bind(View view) {
        return bind(view, e.a());
    }

    public static VideosubmitDialogSignUpInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public SignUpInfoDialog getViewModel() {
        return this.mViewModel;
    }

    public abstract void setViewModel(SignUpInfoDialog signUpInfoDialog);

    @Deprecated
    public static VideosubmitDialogSignUpInfoBinding bind(View view, Object obj) {
        return (VideosubmitDialogSignUpInfoBinding) ViewDataBinding.bind(obj, view, R.layout.videosubmit_dialog_sign_up_info);
    }

    @Deprecated
    public static VideosubmitDialogSignUpInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VideosubmitDialogSignUpInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_dialog_sign_up_info, viewGroup, z, obj);
    }

    public static VideosubmitDialogSignUpInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static VideosubmitDialogSignUpInfoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VideosubmitDialogSignUpInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_dialog_sign_up_info, null, false, obj);
    }
}
