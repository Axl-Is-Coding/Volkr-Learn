package com.sandboxol.decorate.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.center.entity.DressShopGuideConfig;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.decorate.view.dialog.d;

/* JADX INFO: renamed from: com.sandboxol.decorate.c.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ContentDressShopGuideDialogPageBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2579d extends AbstractC2578c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f17069b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f17070c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CardView f17071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ImageView f17072e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f17073f;

    public C2579d(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, f17069b, f17070c));
    }

    public void a(d.a aVar) {
        updateRegistration(0, aVar);
        this.f17068a = aVar;
        synchronized (this) {
            this.f17073f |= 1;
        }
        notifyPropertyChanged(com.sandboxol.decorate.c.E);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f17073f;
            this.f17073f = 0L;
        }
        d.a aVar = this.f17068a;
        long j2 = j & 7;
        String url = null;
        if (j2 != 0) {
            DressShopGuideConfig item = aVar != null ? aVar.getItem() : null;
            if (item != null) {
                url = item.getUrl();
            }
        }
        String str = url;
        if (j2 != 0) {
            ImageViewBindingAdapters.loadImage(this.f17072e, 0, str, 0, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f17073f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f17073f = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((d.a) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.decorate.c.E != i) {
            return false;
        }
        a((d.a) obj);
        return true;
    }

    private C2579d(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f17073f = -1L;
        this.f17071d = (CardView) objArr[0];
        this.f17071d.setTag(null);
        this.f17072e = (ImageView) objArr[1];
        this.f17072e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(d.a aVar, int i) {
        if (i == com.sandboxol.decorate.c.f16979a) {
            synchronized (this) {
                this.f17073f |= 1;
            }
            return true;
        }
        if (i != com.sandboxol.decorate.c.I) {
            return false;
        }
        synchronized (this) {
            this.f17073f |= 2;
        }
        return true;
    }
}
