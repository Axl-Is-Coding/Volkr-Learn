package com.sandboxol.decorate.c;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ObservableMap;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.entity.ShopRecommendDecorationInfo;
import com.sandboxol.decorate.view.fragment.dress.va;
import com.sandboxol.decorate.widget.DressLoadingView;
import com.sandboxol.decorate.widget.DressRadioGroup;
import com.sandboxol.decorate.widget.DressViewPageFilter;

/* JADX INFO: renamed from: com.sandboxol.decorate.c.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentDressBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2598x extends AbstractC2597w {
    private static final ViewDataBinding.b q = null;
    private static final SparseIntArray r = new SparseIntArray();
    private final ConstraintLayout s;
    private final ImageView t;
    private final View u;
    private final DressLoadingView v;
    private final Button w;
    private final ViewPager x;
    private long y;

    static {
        r.put(R.id.vBg, 17);
        r.put(R.id.relativeLayout4, 18);
        r.put(R.id.dressViewGroup, 19);
        r.put(R.id.ll_balance_shopping_cart, 20);
    }

    public C2598x(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 21, q, r));
    }

    private boolean b(ObservableField<Long> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.y |= 512;
        }
        return true;
    }

    private boolean c(ObservableField<Long> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.y |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        return true;
    }

    private boolean d(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.y |= 64;
        }
        return true;
    }

    private boolean e(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.y |= 4;
        }
        return true;
    }

    private boolean f(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.y |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean g(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.y |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }

    private boolean h(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.y |= 128;
        }
        return true;
    }

    private boolean i(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.y |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        return true;
    }

    private boolean j(ObservableField<DressRadioGroup.Tab> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.y |= 256;
        }
        return true;
    }

    private boolean k(ObservableField<Long> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.y |= 1024;
        }
        return true;
    }

    private boolean l(ObservableField<Long> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.y |= 16;
        }
        return true;
    }

    @Override // com.sandboxol.decorate.c.AbstractC2597w
    public void a(va vaVar) {
        updateRegistration(5, vaVar);
        this.p = vaVar;
        synchronized (this) {
            this.y |= 32;
        }
        notifyPropertyChanged(com.sandboxol.decorate.c.C);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01e3  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 1374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.decorate.c.C2598x.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.y != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.y = 65536L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return a((AccountCenter) obj, i2);
            case 1:
                return a((ObservableMap<Long, ShopRecommendDecorationInfo>) obj, i2);
            case 2:
                return e((ObservableField) obj, i2);
            case 3:
                return a((ObservableField<Long>) obj, i2);
            case 4:
                return l((ObservableField) obj, i2);
            case 5:
                return a((va) obj, i2);
            case 6:
                return d((ObservableField) obj, i2);
            case 7:
                return h((ObservableField) obj, i2);
            case 8:
                return j((ObservableField) obj, i2);
            case 9:
                return b((ObservableField) obj, i2);
            case 10:
                return k((ObservableField) obj, i2);
            case 11:
                return g((ObservableField) obj, i2);
            case 12:
                return c((ObservableField) obj, i2);
            case 13:
                return i((ObservableField) obj, i2);
            case 14:
                return a((ObservableList<ViewModel>) obj, i2);
            case 15:
                return f((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.decorate.c.C != i) {
            return false;
        }
        a((va) obj);
        return true;
    }

    private C2598x(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 16, (View) objArr[7], (ImageView) objArr[16], (DressRadioGroup) objArr[6], (FrameLayout) objArr[19], (ImageView) objArr[10], (ImageView) objArr[11], (LinearLayout) objArr[20], (RelativeLayout) objArr[18], (TextView) objArr[14], (TextView) objArr[15], (TextView) objArr[13], (TextView) objArr[3], (TextView) objArr[4], (View) objArr[17], (DressViewPageFilter) objArr[9]);
        this.y = -1L;
        this.f17124a.setTag(null);
        this.f17125b.setTag(null);
        this.f17126c.setTag(null);
        this.f17128e.setTag(null);
        this.f17129f.setTag(null);
        this.s = (ConstraintLayout) objArr[0];
        this.s.setTag(null);
        this.t = (ImageView) objArr[1];
        this.t.setTag(null);
        this.u = (View) objArr[12];
        this.u.setTag(null);
        this.v = (DressLoadingView) objArr[2];
        this.v.setTag(null);
        this.w = (Button) objArr[5];
        this.w.setTag(null);
        this.x = (ViewPager) objArr[8];
        this.x.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        this.l.setTag(null);
        this.m.setTag(null);
        this.o.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(AccountCenter accountCenter, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.y |= 1;
        }
        return true;
    }

    private boolean a(ObservableMap<Long, ShopRecommendDecorationInfo> observableMap, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.y |= 2;
        }
        return true;
    }

    private boolean a(ObservableField<Long> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.y |= 8;
        }
        return true;
    }

    private boolean a(va vaVar, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.y |= 32;
        }
        return true;
    }

    private boolean a(ObservableList<ViewModel> observableList, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.y |= PlaybackStateCompat.ACTION_PREPARE;
        }
        return true;
    }
}
