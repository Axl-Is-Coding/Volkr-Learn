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
public abstract class BaseDialogNotWifiBinding extends ViewDataBinding {
    public final Button btnCancel;
    public final Button btnSure;
    public final ImageView btnVideo;
    public final CheckBox cbWifi;
    public final TextView tvDetails;
    public final TextView tvTitle;
    public final View vVideo;

    protected BaseDialogNotWifiBinding(Object obj, View view, int i, Button button, Button button2, ImageView imageView, CheckBox checkBox, TextView textView, TextView textView2, View view2) {
        super(obj, view, i);
        this.btnCancel = button;
        this.btnSure = button2;
        this.btnVideo = imageView;
        this.cbWifi = checkBox;
        this.tvDetails = textView;
        this.tvTitle = textView2;
        this.vVideo = view2;
    }

    public static BaseDialogNotWifiBinding bind(View view) {
        return bind(view, e.a());
    }

    public static BaseDialogNotWifiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    @Deprecated
    public static BaseDialogNotWifiBinding bind(View view, Object obj) {
        return (BaseDialogNotWifiBinding) ViewDataBinding.bind(obj, view, R.layout.base_dialog_not_wifi);
    }

    @Deprecated
    public static BaseDialogNotWifiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseDialogNotWifiBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_not_wifi, viewGroup, z, obj);
    }

    public static BaseDialogNotWifiBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static BaseDialogNotWifiBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseDialogNotWifiBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_not_wifi, null, false, obj);
    }
}
