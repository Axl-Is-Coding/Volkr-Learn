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
public abstract class VideosubmitEventRulesBinding extends ViewDataBinding {
    protected VideoSubmitViewModel mVideoSubmitViewModel;
    public final RecyclerView rvRules;
    public final TextView tvContentRulesTitle;
    public final View vContentRules;

    protected VideosubmitEventRulesBinding(Object obj, View view, int i, RecyclerView recyclerView, TextView textView, View view2) {
        super(obj, view, i);
        this.rvRules = recyclerView;
        this.tvContentRulesTitle = textView;
        this.vContentRules = view2;
    }

    public static VideosubmitEventRulesBinding bind(View view) {
        return bind(view, e.a());
    }

    public static VideosubmitEventRulesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public VideoSubmitViewModel getVideoSubmitViewModel() {
        return this.mVideoSubmitViewModel;
    }

    public abstract void setVideoSubmitViewModel(VideoSubmitViewModel videoSubmitViewModel);

    @Deprecated
    public static VideosubmitEventRulesBinding bind(View view, Object obj) {
        return (VideosubmitEventRulesBinding) ViewDataBinding.bind(obj, view, R.layout.videosubmit_event_rules);
    }

    @Deprecated
    public static VideosubmitEventRulesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VideosubmitEventRulesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_event_rules, viewGroup, z, obj);
    }

    public static VideosubmitEventRulesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static VideosubmitEventRulesBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VideosubmitEventRulesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_event_rules, null, false, obj);
    }
}
