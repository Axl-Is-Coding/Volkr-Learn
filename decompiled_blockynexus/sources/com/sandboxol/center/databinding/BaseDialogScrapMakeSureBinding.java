package com.sandboxol.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.center.R;
import com.sandboxol.center.view.dialog.ScrapMakeSureDialog;
import com.sandboxol.center.view.widget.ScrapLevelImageView;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDialogScrapMakeSureBinding extends ViewDataBinding {
    public final View bgBtn;
    public final View bgContent;
    public final ScrapLevelImageView ivScrap;
    protected ScrapMakeSureDialog mScrapMakeSureDialog;
    public final TextView tvCancel;
    public final TextView tvSure;
    public final TextView tvTitle;

    protected BaseDialogScrapMakeSureBinding(Object obj, View view, int i, View view2, View view3, ScrapLevelImageView scrapLevelImageView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.bgBtn = view2;
        this.bgContent = view3;
        this.ivScrap = scrapLevelImageView;
        this.tvCancel = textView;
        this.tvSure = textView2;
        this.tvTitle = textView3;
    }

    public static BaseDialogScrapMakeSureBinding bind(View view) {
        return bind(view, e.a());
    }

    public static BaseDialogScrapMakeSureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public ScrapMakeSureDialog getScrapMakeSureDialog() {
        return this.mScrapMakeSureDialog;
    }

    public abstract void setScrapMakeSureDialog(ScrapMakeSureDialog scrapMakeSureDialog);

    @Deprecated
    public static BaseDialogScrapMakeSureBinding bind(View view, Object obj) {
        return (BaseDialogScrapMakeSureBinding) ViewDataBinding.bind(obj, view, R.layout.base_dialog_scrap_make_sure);
    }

    @Deprecated
    public static BaseDialogScrapMakeSureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseDialogScrapMakeSureBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_scrap_make_sure, viewGroup, z, obj);
    }

    public static BaseDialogScrapMakeSureBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static BaseDialogScrapMakeSureBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseDialogScrapMakeSureBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_scrap_make_sure, null, false, obj);
    }
}
