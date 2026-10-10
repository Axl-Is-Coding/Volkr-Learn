package com.sandboxol.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.center.R;
import com.sandboxol.center.view.dialog.VipGcubeGiftOneButtonDialog;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDialogVipGcubeGiftOneButtonBinding extends ViewDataBinding {
    public final Button btnSure;
    protected VipGcubeGiftOneButtonDialog mVipGcubeGiftOneButtonDialog;
    public final TextView tvDetails;
    public final TextView tvTitle;
    public final View view;

    protected BaseDialogVipGcubeGiftOneButtonBinding(Object obj, View view, int i, Button button, TextView textView, TextView textView2, View view2) {
        super(obj, view, i);
        this.btnSure = button;
        this.tvDetails = textView;
        this.tvTitle = textView2;
        this.view = view2;
    }

    public static BaseDialogVipGcubeGiftOneButtonBinding bind(View view) {
        return bind(view, e.a());
    }

    public static BaseDialogVipGcubeGiftOneButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public VipGcubeGiftOneButtonDialog getVipGcubeGiftOneButtonDialog() {
        return this.mVipGcubeGiftOneButtonDialog;
    }

    public abstract void setVipGcubeGiftOneButtonDialog(VipGcubeGiftOneButtonDialog vipGcubeGiftOneButtonDialog);

    @Deprecated
    public static BaseDialogVipGcubeGiftOneButtonBinding bind(View view, Object obj) {
        return (BaseDialogVipGcubeGiftOneButtonBinding) ViewDataBinding.bind(obj, view, R.layout.base_dialog_vip_gcube_gift_one_button);
    }

    @Deprecated
    public static BaseDialogVipGcubeGiftOneButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseDialogVipGcubeGiftOneButtonBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_vip_gcube_gift_one_button, viewGroup, z, obj);
    }

    public static BaseDialogVipGcubeGiftOneButtonBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static BaseDialogVipGcubeGiftOneButtonBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseDialogVipGcubeGiftOneButtonBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_vip_gcube_gift_one_button, null, false, obj);
    }
}
