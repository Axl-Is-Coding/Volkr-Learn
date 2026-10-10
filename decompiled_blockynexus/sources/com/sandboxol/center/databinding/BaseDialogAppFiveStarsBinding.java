package com.sandboxol.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.center.R;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDialogAppFiveStarsBinding extends ViewDataBinding {
    public final Button btnCancel;
    public final Button btnFiveStar;
    public final Button btnSend;
    public final TextView tvTitle;

    protected BaseDialogAppFiveStarsBinding(Object obj, View view, int i, Button button, Button button2, Button button3, TextView textView) {
        super(obj, view, i);
        this.btnCancel = button;
        this.btnFiveStar = button2;
        this.btnSend = button3;
        this.tvTitle = textView;
    }

    public static BaseDialogAppFiveStarsBinding bind(View view) {
        return bind(view, e.a());
    }

    public static BaseDialogAppFiveStarsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    @Deprecated
    public static BaseDialogAppFiveStarsBinding bind(View view, Object obj) {
        return (BaseDialogAppFiveStarsBinding) ViewDataBinding.bind(obj, view, R.layout.base_dialog_app_five_stars);
    }

    @Deprecated
    public static BaseDialogAppFiveStarsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseDialogAppFiveStarsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_app_five_stars, viewGroup, z, obj);
    }

    public static BaseDialogAppFiveStarsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static BaseDialogAppFiveStarsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseDialogAppFiveStarsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_app_five_stars, null, false, obj);
    }
}
