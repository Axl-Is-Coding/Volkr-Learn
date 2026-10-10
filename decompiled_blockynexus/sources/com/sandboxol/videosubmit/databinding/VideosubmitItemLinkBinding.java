package com.sandboxol.videosubmit.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.view.dialog.signupinfo.LinkItemViewModel;

/* JADX INFO: loaded from: classes4.dex */
public abstract class VideosubmitItemLinkBinding extends ViewDataBinding {
    protected LinkItemViewModel mViewModel;

    protected VideosubmitItemLinkBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static VideosubmitItemLinkBinding bind(View view) {
        return bind(view, e.a());
    }

    public static VideosubmitItemLinkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public LinkItemViewModel getViewModel() {
        return this.mViewModel;
    }

    public abstract void setViewModel(LinkItemViewModel linkItemViewModel);

    @Deprecated
    public static VideosubmitItemLinkBinding bind(View view, Object obj) {
        return (VideosubmitItemLinkBinding) ViewDataBinding.bind(obj, view, R.layout.videosubmit_item_link);
    }

    @Deprecated
    public static VideosubmitItemLinkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VideosubmitItemLinkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_item_link, viewGroup, z, obj);
    }

    public static VideosubmitItemLinkBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static VideosubmitItemLinkBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VideosubmitItemLinkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_item_link, null, false, obj);
    }
}
