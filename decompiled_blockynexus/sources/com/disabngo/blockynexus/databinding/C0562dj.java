package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.center.entity.ShareRewardEntity;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.dj, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemShareBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0562dj extends AbstractC0550cj {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8276b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8277c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RelativeLayout f8278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ImageView f8279e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f8280f;
    private long g;

    public C0562dj(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f8276b, f8277c));
    }

    public void a(com.disabngo.blockynexus.e.b.ja.d dVar) {
        updateRegistration(0, dVar);
        this.f8242a = dVar;
        synchronized (this) {
            this.g |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String strValueOf;
        String str;
        long count;
        synchronized (this) {
            j = this.g;
            this.g = 0L;
        }
        com.disabngo.blockynexus.e.b.ja.d dVar = this.f8242a;
        long j2 = j & 7;
        String picUrl = null;
        if (j2 != 0) {
            ShareRewardEntity item = dVar != null ? dVar.getItem() : null;
            if (item != null) {
                picUrl = item.getPicUrl();
                count = item.getCount();
            } else {
                count = 0;
            }
            strValueOf = String.valueOf(count);
            str = picUrl;
        } else {
            strValueOf = null;
            str = null;
        }
        if (j2 != 0) {
            ImageViewBindingAdapters.loadImage(this.f8279e, 0, str, 0, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
            androidx.databinding.a.e.a(this.f8280f, strValueOf);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.g = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.ja.d) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.ja.d) obj);
        return true;
    }

    private C0562dj(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.g = -1L;
        this.f8278d = (RelativeLayout) objArr[0];
        this.f8278d.setTag(null);
        this.f8279e = (ImageView) objArr[1];
        this.f8279e.setTag(null);
        this.f8280f = (TextView) objArr[2];
        this.f8280f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.ja.d dVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.g |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.g |= 2;
        }
        return true;
    }
}
