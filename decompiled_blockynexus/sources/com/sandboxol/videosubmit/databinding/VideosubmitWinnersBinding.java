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
public abstract class VideosubmitWinnersBinding extends ViewDataBinding {
    protected VideoSubmitViewModel mVideoSubmitViewModel;
    public final RecyclerView rvWinners;
    public final TextView vContent1stTitle;

    protected VideosubmitWinnersBinding(Object obj, View view, int i, RecyclerView recyclerView, TextView textView) {
        super(obj, view, i);
        this.rvWinners = recyclerView;
        this.vContent1stTitle = textView;
    }

    public static VideosubmitWinnersBinding bind(View view) {
        return bind(view, e.a());
    }

    public static VideosubmitWinnersBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public VideoSubmitViewModel getVideoSubmitViewModel() {
        return this.mVideoSubmitViewModel;
    }

    public abstract void setVideoSubmitViewModel(VideoSubmitViewModel videoSubmitViewModel);

    @Deprecated
    public static VideosubmitWinnersBinding bind(View view, Object obj) {
        return (VideosubmitWinnersBinding) ViewDataBinding.bind(obj, view, R.layout.videosubmit_winners);
    }

    @Deprecated
    public static VideosubmitWinnersBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VideosubmitWinnersBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_winners, viewGroup, z, obj);
    }

    public static VideosubmitWinnersBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static VideosubmitWinnersBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VideosubmitWinnersBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_winners, null, false, obj);
    }
}
