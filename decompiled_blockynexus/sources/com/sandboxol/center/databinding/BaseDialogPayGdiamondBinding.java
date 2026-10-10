package com.sandboxol.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.center.R;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDialogPayGdiamondBinding extends ViewDataBinding {
    public final Button btnCancel;
    public final Button btnSure;
    public final ImageView btnVideo;
    public final CheckBox cbWifi;
    public final TextView tvDetails;
    public final TextView tvDetails1;
    public final TextView tvTitle;
    public final View vVideo;

    protected BaseDialogPayGdiamondBinding(Object obj, View view, int i, Button button, Button button2, ImageView imageView, CheckBox checkBox, TextView textView, TextView textView2, TextView textView3, View view2) {
        super(obj, view, i);
        this.btnCancel = button;
        this.btnSure = button2;
        this.btnVideo = imageView;
        this.cbWifi = checkBox;
        this.tvDetails = textView;
        this.tvDetails1 = textView2;
        this.tvTitle = textView3;
        this.vVideo = view2;
    }

    public static BaseDialogPayGdiamondBinding bind(View view) {
        return bind(view, e.a());
    }

    public static BaseDialogPayGdiamondBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    @Deprecated
    public static BaseDialogPayGdiamondBinding bind(View view, Object obj) {
        return (BaseDialogPayGdiamondBinding) ViewDataBinding.bind(obj, view, R.layout.base_dialog_pay_gdiamond);
    }

    @Deprecated
    public static BaseDialogPayGdiamondBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseDialogPayGdiamondBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_pay_gdiamond, viewGroup, z, obj);
    }

    public static BaseDialogPayGdiamondBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static BaseDialogPayGdiamondBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseDialogPayGdiamondBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_pay_gdiamond, null, false, obj);
    }
}
