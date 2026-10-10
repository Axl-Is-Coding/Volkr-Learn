package com.sandboxol.videosubmit.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.entity.Winner;

/* JADX INFO: loaded from: classes4.dex */
public abstract class VideosubmitItemWinnerBinding extends ViewDataBinding {
    public final ImageView ivContent1stContentLeft;
    public final ImageView ivContent1stContentUpPic;
    protected Winner mWinner;
    public final TextView tvContent1stContent;
    public final TextView tvContent1stContentGrow;
    public final TextView tvContent1stContentName;
    public final TextView tvContent1stContentUp;
    public final TextView tvContent1stContentUpCount;

    protected VideosubmitItemWinnerBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.ivContent1stContentLeft = imageView;
        this.ivContent1stContentUpPic = imageView2;
        this.tvContent1stContent = textView;
        this.tvContent1stContentGrow = textView2;
        this.tvContent1stContentName = textView3;
        this.tvContent1stContentUp = textView4;
        this.tvContent1stContentUpCount = textView5;
    }

    public static VideosubmitItemWinnerBinding bind(View view) {
        return bind(view, e.a());
    }

    public static VideosubmitItemWinnerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public Winner getWinner() {
        return this.mWinner;
    }

    public abstract void setWinner(Winner winner);

    @Deprecated
    public static VideosubmitItemWinnerBinding bind(View view, Object obj) {
        return (VideosubmitItemWinnerBinding) ViewDataBinding.bind(obj, view, R.layout.videosubmit_item_winner);
    }

    @Deprecated
    public static VideosubmitItemWinnerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VideosubmitItemWinnerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_item_winner, viewGroup, z, obj);
    }

    public static VideosubmitItemWinnerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static VideosubmitItemWinnerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VideosubmitItemWinnerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_item_winner, null, false, obj);
    }
}
