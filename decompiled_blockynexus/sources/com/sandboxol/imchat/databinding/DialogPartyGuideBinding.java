package com.sandboxol.imchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.imchat.R;
import com.sandboxol.imchat.ui.dialog.PartyGuideDialog;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DialogPartyGuideBinding extends ViewDataBinding {
    public final ImageView ivLoading;
    protected PartyGuideDialog mPartyGuideDialog;
    public final View view;

    protected DialogPartyGuideBinding(Object obj, View view, int i, ImageView imageView, View view2) {
        super(obj, view, i);
        this.ivLoading = imageView;
        this.view = view2;
    }

    public static DialogPartyGuideBinding bind(View view) {
        return bind(view, e.a());
    }

    public static DialogPartyGuideBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public PartyGuideDialog getPartyGuideDialog() {
        return this.mPartyGuideDialog;
    }

    public abstract void setPartyGuideDialog(PartyGuideDialog partyGuideDialog);

    @Deprecated
    public static DialogPartyGuideBinding bind(View view, Object obj) {
        return (DialogPartyGuideBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_party_guide);
    }

    @Deprecated
    public static DialogPartyGuideBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogPartyGuideBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_party_guide, viewGroup, z, obj);
    }

    public static DialogPartyGuideBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static DialogPartyGuideBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogPartyGuideBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_party_guide, null, false, obj);
    }
}
