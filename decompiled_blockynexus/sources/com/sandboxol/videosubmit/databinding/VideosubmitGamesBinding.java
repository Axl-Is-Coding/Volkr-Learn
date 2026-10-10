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
public abstract class VideosubmitGamesBinding extends ViewDataBinding {
    protected VideoSubmitViewModel mVideoSubmitViewModel;
    public final RecyclerView rvGames;
    public final TextView tvContentGames;

    protected VideosubmitGamesBinding(Object obj, View view, int i, RecyclerView recyclerView, TextView textView) {
        super(obj, view, i);
        this.rvGames = recyclerView;
        this.tvContentGames = textView;
    }

    public static VideosubmitGamesBinding bind(View view) {
        return bind(view, e.a());
    }

    public static VideosubmitGamesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public VideoSubmitViewModel getVideoSubmitViewModel() {
        return this.mVideoSubmitViewModel;
    }

    public abstract void setVideoSubmitViewModel(VideoSubmitViewModel videoSubmitViewModel);

    @Deprecated
    public static VideosubmitGamesBinding bind(View view, Object obj) {
        return (VideosubmitGamesBinding) ViewDataBinding.bind(obj, view, R.layout.videosubmit_games);
    }

    @Deprecated
    public static VideosubmitGamesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VideosubmitGamesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_games, viewGroup, z, obj);
    }

    public static VideosubmitGamesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static VideosubmitGamesBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VideosubmitGamesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_games, null, false, obj);
    }
}
