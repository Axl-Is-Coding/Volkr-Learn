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
public abstract class VideosubmitVideoThemesBinding extends ViewDataBinding {
    protected VideoSubmitViewModel mVideoSubmitViewModel;
    public final RecyclerView rvGames;
    public final TextView tvContentGames;

    protected VideosubmitVideoThemesBinding(Object obj, View view, int i, RecyclerView recyclerView, TextView textView) {
        super(obj, view, i);
        this.rvGames = recyclerView;
        this.tvContentGames = textView;
    }

    public static VideosubmitVideoThemesBinding bind(View view) {
        return bind(view, e.a());
    }

    public static VideosubmitVideoThemesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public VideoSubmitViewModel getVideoSubmitViewModel() {
        return this.mVideoSubmitViewModel;
    }

    public abstract void setVideoSubmitViewModel(VideoSubmitViewModel videoSubmitViewModel);

    @Deprecated
    public static VideosubmitVideoThemesBinding bind(View view, Object obj) {
        return (VideosubmitVideoThemesBinding) ViewDataBinding.bind(obj, view, R.layout.videosubmit_video_themes);
    }

    @Deprecated
    public static VideosubmitVideoThemesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VideosubmitVideoThemesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_video_themes, viewGroup, z, obj);
    }

    public static VideosubmitVideoThemesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static VideosubmitVideoThemesBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VideosubmitVideoThemesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_video_themes, null, false, obj);
    }
}
