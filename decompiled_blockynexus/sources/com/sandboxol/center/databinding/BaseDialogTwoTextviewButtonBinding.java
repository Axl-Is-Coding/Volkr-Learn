package com.sandboxol.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.center.R;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDialogTwoTextviewButtonBinding extends ViewDataBinding {
    public final TextView btnCancel;
    public final TextView btnSure;
    public final ImageView btnVideo;
    public final TextView tvDetails;
    public final TextView tvTitle;
    public final View vVideo;

    protected BaseDialogTwoTextviewButtonBinding(Object obj, View view, int i, TextView textView, TextView textView2, ImageView imageView, TextView textView3, TextView textView4, View view2) {
        super(obj, view, i);
        this.btnCancel = textView;
        this.btnSure = textView2;
        this.btnVideo = imageView;
        this.tvDetails = textView3;
        this.tvTitle = textView4;
        this.vVideo = view2;
    }

    public static BaseDialogTwoTextviewButtonBinding bind(View view) {
        return bind(view, e.a());
    }

    public static BaseDialogTwoTextviewButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    @Deprecated
    public static BaseDialogTwoTextviewButtonBinding bind(View view, Object obj) {
        return (BaseDialogTwoTextviewButtonBinding) ViewDataBinding.bind(obj, view, R.layout.base_dialog_two_textview_button);
    }

    @Deprecated
    public static BaseDialogTwoTextviewButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseDialogTwoTextviewButtonBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_two_textview_button, viewGroup, z, obj);
    }

    public static BaseDialogTwoTextviewButtonBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static BaseDialogTwoTextviewButtonBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseDialogTwoTextviewButtonBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_two_textview_button, null, false, obj);
    }
}
