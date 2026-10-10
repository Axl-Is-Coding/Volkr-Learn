package com.sandboxol.videosubmit.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.videosubmit.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class VideosubmitItemGameBinding extends ViewDataBinding {
    public final ImageView ivPic;

    protected VideosubmitItemGameBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.ivPic = imageView;
    }

    public static VideosubmitItemGameBinding bind(View view) {
        return bind(view, e.a());
    }

    public static VideosubmitItemGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    @Deprecated
    public static VideosubmitItemGameBinding bind(View view, Object obj) {
        return (VideosubmitItemGameBinding) ViewDataBinding.bind(obj, view, R.layout.videosubmit_item_game);
    }

    @Deprecated
    public static VideosubmitItemGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VideosubmitItemGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_item_game, viewGroup, z, obj);
    }

    public static VideosubmitItemGameBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static VideosubmitItemGameBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VideosubmitItemGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_item_game, null, false, obj);
    }
}
