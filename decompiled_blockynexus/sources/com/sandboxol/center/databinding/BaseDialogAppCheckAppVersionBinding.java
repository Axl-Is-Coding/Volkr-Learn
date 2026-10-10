package com.sandboxol.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.center.R;
import com.sandboxol.center.view.dialog.CheckAppVersionDialog;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDialogAppCheckAppVersionBinding extends ViewDataBinding {
    protected CheckAppVersionDialog.CheckAppVersionDialogViewModel mCheckAppVersionDialogViewModel;

    protected BaseDialogAppCheckAppVersionBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static BaseDialogAppCheckAppVersionBinding bind(View view) {
        return bind(view, e.a());
    }

    public static BaseDialogAppCheckAppVersionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public CheckAppVersionDialog.CheckAppVersionDialogViewModel getCheckAppVersionDialogViewModel() {
        return this.mCheckAppVersionDialogViewModel;
    }

    public abstract void setCheckAppVersionDialogViewModel(CheckAppVersionDialog.CheckAppVersionDialogViewModel checkAppVersionDialogViewModel);

    @Deprecated
    public static BaseDialogAppCheckAppVersionBinding bind(View view, Object obj) {
        return (BaseDialogAppCheckAppVersionBinding) ViewDataBinding.bind(obj, view, R.layout.base_dialog_app_check_app_version);
    }

    @Deprecated
    public static BaseDialogAppCheckAppVersionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseDialogAppCheckAppVersionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_app_check_app_version, viewGroup, z, obj);
    }

    public static BaseDialogAppCheckAppVersionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static BaseDialogAppCheckAppVersionBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseDialogAppCheckAppVersionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_app_check_app_version, null, false, obj);
    }
}
