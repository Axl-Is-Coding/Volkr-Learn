package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.entity.TribeShopPageList;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.zj, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemTribeShopCarViewBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0802zj extends AbstractC0791yj {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f9052c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f9053d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinearLayout f9054e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ImageView f9055f;
    private final TextView g;
    private final TextView h;
    private final TextView i;
    private final TextView j;
    private long k;

    public C0802zj(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, f9052c, f9053d));
    }

    public void a(com.disabngo.blockynexus.e.b.ta.f fVar) {
        updateRegistration(0, fVar);
        this.f9024b = fVar;
        synchronized (this) {
            this.k |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String name;
        String str;
        String str2;
        String str3;
        int i;
        int i2;
        int i3;
        int i4;
        String strShowQuantityText;
        String strShowExpireText;
        String iconUrl;
        int price;
        int hasPurchase;
        int expire;
        int quantity;
        long j2;
        long j3;
        synchronized (this) {
            j = this.k;
            this.k = 0L;
        }
        com.disabngo.blockynexus.e.b.ta.f fVar = this.f9024b;
        long j4 = j & 7;
        String str4 = null;
        if (j4 != 0) {
            TribeShopPageList item = fVar != null ? fVar.getItem() : null;
            if (item != null) {
                price = item.getPrice();
                strShowQuantityText = item.showQuantityText();
                hasPurchase = item.getHasPurchase();
                expire = item.getExpire();
                quantity = item.getQuantity();
                strShowExpireText = item.showExpireText();
                iconUrl = item.getIconUrl();
                name = item.getName();
            } else {
                name = null;
                strShowQuantityText = null;
                strShowExpireText = null;
                iconUrl = null;
                price = 0;
                hasPurchase = 0;
                expire = 0;
                quantity = 0;
            }
            String strValueOf = String.valueOf(price);
            boolean z = hasPurchase == 1;
            boolean z2 = expire > 0;
            boolean z3 = quantity > 0;
            if (j4 != 0) {
                if (z) {
                    j2 = j | 16;
                    j3 = 256;
                } else {
                    j2 = j | 8;
                    j3 = 128;
                }
                j = j2 | j3;
            }
            if ((j & 7) != 0) {
                j |= z2 ? 1024L : 512L;
            }
            if ((j & 7) != 0) {
                j |= z3 ? 64L : 32L;
            }
            int i5 = z ? 8 : 0;
            int i6 = z ? 0 : 8;
            i4 = z2 ? 0 : 8;
            i = z3 ? 0 : 8;
            i2 = i6;
            str3 = strShowExpireText;
            str2 = strValueOf;
            str4 = iconUrl;
            String str5 = strShowQuantityText;
            i3 = i5;
            str = str5;
        } else {
            name = null;
            str = null;
            str2 = null;
            str3 = null;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        if ((j & 7) != 0) {
            ImageViewBindingAdapters.loadImage(this.f9055f, 0, str4, 0, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
            androidx.databinding.a.e.a(this.g, name);
            androidx.databinding.a.e.a(this.h, str3);
            this.h.setVisibility(i4);
            androidx.databinding.a.e.a(this.i, str2);
            this.i.setVisibility(i3);
            this.j.setVisibility(i2);
            androidx.databinding.a.e.a(this.f9023a, str);
            this.f9023a.setVisibility(i);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.k != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.k = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.ta.f) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.ta.f) obj);
        return true;
    }

    private C0802zj(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (TextView) objArr[4]);
        this.k = -1L;
        this.f9054e = (LinearLayout) objArr[0];
        this.f9054e.setTag(null);
        this.f9055f = (ImageView) objArr[1];
        this.f9055f.setTag(null);
        this.g = (TextView) objArr[2];
        this.g.setTag(null);
        this.h = (TextView) objArr[3];
        this.h.setTag(null);
        this.i = (TextView) objArr[5];
        this.i.setTag(null);
        this.j = (TextView) objArr[6];
        this.j.setTag(null);
        this.f9023a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.ta.f fVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.k |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.k |= 2;
        }
        return true;
    }
}
