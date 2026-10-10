package com.sandboxol.imchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.imchat.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DialogGameCountDownBinding extends ViewDataBinding {
    public final Button btnCancel;
    public final LinearLayout llDialog;
    public final TextView tvCountDown;

    protected DialogGameCountDownBinding(Object obj, View view, int i, Button button, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.btnCancel = button;
        this.llDialog = linearLayout;
        this.tvCountDown = textView;
    }

    public static DialogGameCountDownBinding bind(View view) {
        return bind(view, e.a());
    }

    public static DialogGameCountDownBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    @Deprecated
    public static DialogGameCountDownBinding bind(View view, Object obj) {
        return (DialogGameCountDownBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_game_count_down);
    }

    @Deprecated
    public static DialogGameCountDownBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogGameCountDownBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_game_count_down, viewGroup, z, obj);
    }

    public static DialogGameCountDownBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static DialogGameCountDownBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogGameCountDownBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_game_count_down, null, false, obj);
    }
}
