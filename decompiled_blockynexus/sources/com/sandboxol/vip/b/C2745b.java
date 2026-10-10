package com.sandboxol.vip.b;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.vip.R;
import com.sandboxol.vip.entity.PrivilegeInfo;

/* JADX INFO: renamed from: com.sandboxol.vip.b.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: VipContentPageDetailTypeBindingImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class C2745b extends AbstractC2744a {
    private static final ViewDataBinding.b g = null;
    private static final SparseIntArray h = new SparseIntArray();
    private final ConstraintLayout i;
    private final TextView j;
    private final TextView k;
    private long l;

    static {
        h.put(R.id.gl_horizontal_875, 7);
    }

    public C2745b(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 8, g, h));
    }

    public void a(com.sandboxol.vip.d.b.a.g gVar) {
        updateRegistration(0, gVar);
        this.f18971f = gVar;
        synchronized (this) {
            this.l |= 1;
        }
        notifyPropertyChanged(com.sandboxol.vip.a.f18955e);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        Drawable drawable;
        String str2;
        int i;
        int iB;
        int i2;
        String str3;
        String detailDesc;
        String title;
        int detailRes;
        int thumbnailRes;
        int vipType;
        synchronized (this) {
            j = this.l;
            this.l = 0L;
        }
        com.sandboxol.vip.d.b.a.g gVar = this.f18971f;
        long j2 = 7 & j;
        String strValueOf = null;
        if (j2 != 0) {
            PrivilegeInfo item = gVar != null ? gVar.getItem() : null;
            if (item != null) {
                detailRes = item.getDetailRes();
                thumbnailRes = item.getThumbnailRes();
                vipType = item.getVipType();
                title = item.getTitle();
                detailDesc = item.getDetailDesc();
            } else {
                detailDesc = null;
                title = null;
                detailRes = 0;
                thumbnailRes = 0;
                vipType = 0;
            }
            Drawable drawableD = com.sandboxol.vip.c.b.d(vipType);
            iB = com.sandboxol.vip.c.b.b(vipType);
            if ((j & 5) != 0) {
                strValueOf = String.valueOf(gVar != null ? gVar.f19079a : 0);
            }
            str = detailDesc;
            i2 = detailRes;
            i = thumbnailRes;
            str2 = title;
            drawable = drawableD;
        } else {
            str = null;
            drawable = null;
            str2 = null;
            i = 0;
            iB = 0;
            i2 = 0;
        }
        if (j2 != 0) {
            ImageViewBindingAdapters.loadImage(this.f18967b, 0, null, i2, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
            str3 = strValueOf;
            ImageViewBindingAdapters.loadImage(this.f18968c, 0, null, i, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
            androidx.databinding.a.e.a(this.j, str);
            this.k.setTextColor(iB);
            androidx.databinding.a.e.a(this.f18969d, str2);
            androidx.databinding.a.f.a(this.f18970e, drawable);
        } else {
            str3 = strValueOf;
        }
        if ((j & 5) != 0) {
            androidx.databinding.a.e.a(this.k, str3);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.l != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.l = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.sandboxol.vip.d.b.a.g) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.vip.a.f18955e != i) {
            return false;
        }
        a((com.sandboxol.vip.d.b.a.g) obj);
        return true;
    }

    private C2745b(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (Guideline) objArr[7], (ImageView) objArr[5], (ImageView) objArr[2], (TextView) objArr[3], (View) objArr[1]);
        this.l = -1L;
        this.f18967b.setTag(null);
        this.f18968c.setTag(null);
        this.i = (ConstraintLayout) objArr[0];
        this.i.setTag(null);
        this.j = (TextView) objArr[4];
        this.j.setTag(null);
        this.k = (TextView) objArr[6];
        this.k.setTag(null);
        this.f18969d.setTag(null);
        this.f18970e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandboxol.vip.d.b.a.g gVar, int i) {
        if (i == com.sandboxol.vip.a.f18951a) {
            synchronized (this) {
                this.l |= 1;
            }
            return true;
        }
        if (i != com.sandboxol.vip.a.h) {
            return false;
        }
        synchronized (this) {
            this.l |= 2;
        }
        return true;
    }
}
