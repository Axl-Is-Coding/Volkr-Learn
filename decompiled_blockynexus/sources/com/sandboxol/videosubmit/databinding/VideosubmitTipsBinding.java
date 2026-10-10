package com.sandboxol.videosubmit.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.view.activity.VideoSubmitViewModel;

/* JADX INFO: loaded from: classes4.dex */
public abstract class VideosubmitTipsBinding extends ViewDataBinding {
    protected VideoSubmitViewModel mVideoSubmitViewModel;
    public final RecyclerView rvTips;
    public final TextView tvContentEspecialTipsTitle;

    protected VideosubmitTipsBinding(Object obj, View view, int i, RecyclerView recyclerView, TextView textView) {
        super(obj, view, i);
        this.rvTips = recyclerView;
        this.tvContentEspecialTipsTitle = textView;
    }

    public static VideosubmitTipsBinding bind(View view) {
        return bind(view, e.a());
    }

    public static VideosubmitTipsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public VideoSubmitViewModel getVideoSubmitViewModel() {
        return this.mVideoSubmitViewModel;
    }

    public abstract void setVideoSubmitViewModel(VideoSubmitViewModel videoSubmitViewModel);

    @Deprecated
    public static VideosubmitTipsBinding bind(View view, Object obj) {
        return (VideosubmitTipsBinding) ViewDataBinding.bind(obj, view, R.layout.videosubmit_tips);
    }

    @Deprecated
    public static VideosubmitTipsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VideosubmitTipsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_tips, viewGroup, z, obj);
    }

    public static VideosubmitTipsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static VideosubmitTipsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VideosubmitTipsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_tips, null, false, obj);
    }
}
