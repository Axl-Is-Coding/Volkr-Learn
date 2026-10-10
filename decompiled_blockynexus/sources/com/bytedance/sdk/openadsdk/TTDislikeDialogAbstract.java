package com.bytedance.sdk.openadsdk;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeListView;

/* JADX INFO: loaded from: classes.dex */
public abstract class TTDislikeDialogAbstract extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f5610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h f5611b;

    public TTDislikeDialogAbstract(Context context) {
        super(context);
    }

    private void a() {
        if (this.f5611b == null || this.f5610a == null) {
            return;
        }
        int[] tTDislikeListViewIds = getTTDislikeListViewIds();
        if (tTDislikeListViewIds == null || tTDislikeListViewIds.length <= 0) {
            throw new IllegalArgumentException("dislike选项列表为空，请设置TTDislikeListView");
        }
        for (int i : tTDislikeListViewIds) {
            View viewFindViewById = this.f5610a.findViewById(i);
            if (viewFindViewById == null) {
                throw new IllegalArgumentException("getTTDislikeListViewIds提供的id找不到view，请检查");
            }
            if (!(viewFindViewById instanceof TTDislikeListView)) {
                throw new IllegalArgumentException("getTTDislikeListViewIds找到的view类型异常，请检查");
            }
            ((TTDislikeListView) viewFindViewById).setMaterialMeta(this.f5611b);
        }
    }

    public abstract int getLayoutId();

    public abstract ViewGroup.LayoutParams getLayoutParams();

    public abstract int[] getTTDislikeListViewIds();

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5610a = LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) null);
        if (this.f5610a == null) {
            throw new IllegalArgumentException("getLayoutId布局文件id可能异常，请检查");
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        View view = this.f5610a;
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        setContentView(view, layoutParams);
        a();
    }

    public void setMaterialMeta(h hVar) {
        this.f5611b = hVar;
        a();
    }

    public TTDislikeDialogAbstract(Context context, int i) {
        super(context, i);
    }
}
