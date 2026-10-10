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
import com.sandboxol.center.view.dialog.PasswordSettingDialog;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDialogPasswordSettingBinding extends ViewDataBinding {
    public final Button btnCancel;
    public final Button btnSure;
    public final ImageView btnVideo;
    public final CheckBox cbTip;
    protected PasswordSettingDialog mPasswordSettingDialog;
    public final TextView tvDetails;
    public final TextView tvTitle;
    public final View vVideo;

    protected BaseDialogPasswordSettingBinding(Object obj, View view, int i, Button button, Button button2, ImageView imageView, CheckBox checkBox, TextView textView, TextView textView2, View view2) {
        super(obj, view, i);
        this.btnCancel = button;
        this.btnSure = button2;
        this.btnVideo = imageView;
        this.cbTip = checkBox;
        this.tvDetails = textView;
        this.tvTitle = textView2;
        this.vVideo = view2;
    }

    public static BaseDialogPasswordSettingBinding bind(View view) {
        return bind(view, e.a());
    }

    public static BaseDialogPasswordSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public PasswordSettingDialog getPasswordSettingDialog() {
        return this.mPasswordSettingDialog;
    }

    public abstract void setPasswordSettingDialog(PasswordSettingDialog passwordSettingDialog);

    @Deprecated
    public static BaseDialogPasswordSettingBinding bind(View view, Object obj) {
        return (BaseDialogPasswordSettingBinding) ViewDataBinding.bind(obj, view, R.layout.base_dialog_password_setting);
    }

    @Deprecated
    public static BaseDialogPasswordSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseDialogPasswordSettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_password_setting, viewGroup, z, obj);
    }

    public static BaseDialogPasswordSettingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static BaseDialogPasswordSettingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseDialogPasswordSettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_password_setting, null, false, obj);
    }
}
