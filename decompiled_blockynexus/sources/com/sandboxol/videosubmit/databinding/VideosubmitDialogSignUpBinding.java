package com.sandboxol.videosubmit.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.view.dialog.SignUpDialog;

/* JADX INFO: loaded from: classes4.dex */
public abstract class VideosubmitDialogSignUpBinding extends ViewDataBinding {
    public final EditText etYtName;
    public final ImageView ivSpinner;
    protected SignUpDialog mViewModel;
    public final TextView spLanguageName;
    public final TextView tvFbName;
    public final TextView tvTips;
    public final TextView tvTitle;
    public final TextView tvYtName;
    public final View v;
    public final View vDivide;

    protected VideosubmitDialogSignUpBinding(Object obj, View view, int i, EditText editText, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view2, View view3) {
        super(obj, view, i);
        this.etYtName = editText;
        this.ivSpinner = imageView;
        this.spLanguageName = textView;
        this.tvFbName = textView2;
        this.tvTips = textView3;
        this.tvTitle = textView4;
        this.tvYtName = textView5;
        this.v = view2;
        this.vDivide = view3;
    }

    public static VideosubmitDialogSignUpBinding bind(View view) {
        return bind(view, e.a());
    }

    public static VideosubmitDialogSignUpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public SignUpDialog getViewModel() {
        return this.mViewModel;
    }

    public abstract void setViewModel(SignUpDialog signUpDialog);

    @Deprecated
    public static VideosubmitDialogSignUpBinding bind(View view, Object obj) {
        return (VideosubmitDialogSignUpBinding) ViewDataBinding.bind(obj, view, R.layout.videosubmit_dialog_sign_up);
    }

    @Deprecated
    public static VideosubmitDialogSignUpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VideosubmitDialogSignUpBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_dialog_sign_up, viewGroup, z, obj);
    }

    public static VideosubmitDialogSignUpBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static VideosubmitDialogSignUpBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VideosubmitDialogSignUpBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_dialog_sign_up, null, false, obj);
    }
}
