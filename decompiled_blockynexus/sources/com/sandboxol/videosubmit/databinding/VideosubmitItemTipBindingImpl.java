package com.sandboxol.videosubmit.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.e;
import androidx.databinding.d;
import com.sandboxol.videosubmit.BR;
import com.sandboxol.videosubmit.adapter.VideoSubmitTextViewBindingAdapters;

/* JADX INFO: loaded from: classes4.dex */
public class VideosubmitItemTipBindingImpl extends VideosubmitItemTipBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    public VideosubmitItemTipBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        String str = this.mTip;
        Drawable drawable = this.mDrawableStart;
        long j2 = 5 & j;
        if ((j & 6) != 0) {
            e.b(this.tvContentEspecialTipsDetail1, drawable);
        }
        if (j2 != 0) {
            VideoSubmitTextViewBindingAdapters.setHtmlText(this.tvContentEspecialTipsDetail1, str);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // com.sandboxol.videosubmit.databinding.VideosubmitItemTipBinding
    public void setDrawableStart(Drawable drawable) {
        this.mDrawableStart = drawable;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.drawableStart);
        super.requestRebind();
    }

    @Override // com.sandboxol.videosubmit.databinding.VideosubmitItemTipBinding
    public void setTip(String str) {
        this.mTip = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.tip);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.tip == i) {
            setTip((String) obj);
        } else {
            if (BR.drawableStart != i) {
                return false;
            }
            setDrawableStart((Drawable) obj);
        }
        return true;
    }

    private VideosubmitItemTipBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (TextView) objArr[0]);
        this.mDirtyFlags = -1L;
        this.tvContentEspecialTipsDetail1.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
