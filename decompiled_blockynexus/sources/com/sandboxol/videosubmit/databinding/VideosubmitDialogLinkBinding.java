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
import com.sandboxol.videosubmit.view.dialog.LinkDialog;

/* JADX INFO: loaded from: classes4.dex */
public abstract class VideosubmitDialogLinkBinding extends ViewDataBinding {
    public final EditText etId;
    public final ImageView ivGameNameSpinner;
    public final ImageView ivTypeSpinner;
    protected LinkDialog mViewModel;
    public final TextView spGameName;
    public final TextView spType;
    public final TextView tvGameName;
    public final TextView tvId;
    public final TextView tvTips;
    public final TextView tvTitle;
    public final TextView tvType;
    public final View v;
    public final View vDivide;
    public final View vGameNameDivide;

    protected VideosubmitDialogLinkBinding(Object obj, View view, int i, EditText editText, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, View view2, View view3, View view4) {
        super(obj, view, i);
        this.etId = editText;
        this.ivGameNameSpinner = imageView;
        this.ivTypeSpinner = imageView2;
        this.spGameName = textView;
        this.spType = textView2;
        this.tvGameName = textView3;
        this.tvId = textView4;
        this.tvTips = textView5;
        this.tvTitle = textView6;
        this.tvType = textView7;
        this.v = view2;
        this.vDivide = view3;
        this.vGameNameDivide = view4;
    }

    public static VideosubmitDialogLinkBinding bind(View view) {
        return bind(view, e.a());
    }

    public static VideosubmitDialogLinkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public LinkDialog getViewModel() {
        return this.mViewModel;
    }

    public abstract void setViewModel(LinkDialog linkDialog);

    @Deprecated
    public static VideosubmitDialogLinkBinding bind(View view, Object obj) {
        return (VideosubmitDialogLinkBinding) ViewDataBinding.bind(obj, view, R.layout.videosubmit_dialog_link);
    }

    @Deprecated
    public static VideosubmitDialogLinkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VideosubmitDialogLinkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_dialog_link, viewGroup, z, obj);
    }

    public static VideosubmitDialogLinkBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static VideosubmitDialogLinkBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VideosubmitDialogLinkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_dialog_link, null, false, obj);
    }
}
