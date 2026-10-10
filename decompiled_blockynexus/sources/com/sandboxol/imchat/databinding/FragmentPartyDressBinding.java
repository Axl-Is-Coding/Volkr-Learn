package com.sandboxol.imchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.imchat.R;
import com.sandboxol.imchat.ui.fragment.partydress.PartyDressViewModel;

/* JADX INFO: loaded from: classes4.dex */
public abstract class FragmentPartyDressBinding extends ViewDataBinding {
    public final FrameLayout dressViewGroup;
    public final ImageView ivLoading;
    protected PartyDressViewModel mViewModel;
    public final TextView tvTop;

    protected FragmentPartyDressBinding(Object obj, View view, int i, FrameLayout frameLayout, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.dressViewGroup = frameLayout;
        this.ivLoading = imageView;
        this.tvTop = textView;
    }

    public static FragmentPartyDressBinding bind(View view) {
        return bind(view, e.a());
    }

    public static FragmentPartyDressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public PartyDressViewModel getViewModel() {
        return this.mViewModel;
    }

    public abstract void setViewModel(PartyDressViewModel partyDressViewModel);

    @Deprecated
    public static FragmentPartyDressBinding bind(View view, Object obj) {
        return (FragmentPartyDressBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_party_dress);
    }

    @Deprecated
    public static FragmentPartyDressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentPartyDressBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_party_dress, viewGroup, z, obj);
    }

    public static FragmentPartyDressBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static FragmentPartyDressBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentPartyDressBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_party_dress, null, false, obj);
    }
}
