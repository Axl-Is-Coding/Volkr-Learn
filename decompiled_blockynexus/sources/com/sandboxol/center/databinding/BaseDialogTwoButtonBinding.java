package com.sandboxol.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.center.R;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDialogTwoButtonBinding extends ViewDataBinding {
    public final Button btnCancel;
    public final Button btnSure;
    public final ImageView btnVideo;
    public final TextView tvDetails;
    public final TextView tvTitle;
    public final View vVideo;

    protected BaseDialogTwoButtonBinding(Object obj, View view, int i, Button button, Button button2, ImageView imageView, TextView textView, TextView textView2, View view2) {
        super(obj, view, i);
        this.btnCancel = button;
        this.btnSure = button2;
        this.btnVideo = imageView;
        this.tvDetails = textView;
        this.tvTitle = textView2;
        this.vVideo = view2;
    }

    public static BaseDialogTwoButtonBinding bind(View view) {
        return bind(view, e.a());
    }

    public static BaseDialogTwoButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    @Deprecated
    public static BaseDialogTwoButtonBinding bind(View view, Object obj) {
        return (BaseDialogTwoButtonBinding) ViewDataBinding.bind(obj, view, R.layout.base_dialog_two_button);
    }

    @Deprecated
    public static BaseDialogTwoButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseDialogTwoButtonBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_two_button, viewGroup, z, obj);
    }

    public static BaseDialogTwoButtonBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static BaseDialogTwoButtonBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseDialogTwoButtonBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_two_button, null, false, obj);
    }
}
