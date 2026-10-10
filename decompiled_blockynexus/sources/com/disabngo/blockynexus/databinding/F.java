package com.disabngo.blockynexus.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ObservableMap;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.TribeShopPageList;
import com.disabngo.blockynexus.view.widget.TribeDressRadioGroup;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.decorate.widget.DressLoadingView;

/* JADX INFO: compiled from: ActivityTribeShopBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class F extends E {
    private static final ViewDataBinding.b o = null;
    private static final SparseIntArray p = new SparseIntArray();
    private final ImageView A;
    private final Button B;
    private final ImageView C;
    private final RelativeLayout D;
    private long E;
    private final CoordinatorLayout q;
    private final ImageView r;
    private final LinearLayout s;
    private final ImageView t;
    private final ImageView u;
    private final ImageView v;
    private final Button w;
    private final DressLoadingView x;
    private final TribeDressRadioGroup y;
    private final ViewPager z;

    static {
        p.put(R.id.tbTemplateBar, 21);
        p.put(R.id.tvTitle, 22);
        p.put(R.id.rlTop, 23);
        p.put(R.id.rlDress, 24);
        p.put(R.id.dressViewGroup, 25);
        p.put(R.id.llClothesPage, 26);
    }

    public F(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 27, o, p));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.E |= 4;
        }
        return true;
    }

    private boolean c(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.E |= 128;
        }
        return true;
    }

    private boolean d(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.E |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        return true;
    }

    private boolean e(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.E |= 64;
        }
        return true;
    }

    private boolean f(ObservableField<TribeDressRadioGroup.Tab> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.E |= 512;
        }
        return true;
    }

    private boolean g(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.E |= 2;
        }
        return true;
    }

    private boolean h(ObservableField<Long> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.E |= 8;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.E
    public void a(com.disabngo.blockynexus.view.activity.tribeshop.E e2) {
        updateRegistration(5, e2);
        this.n = e2;
        synchronized (this) {
            this.E |= 32;
        }
        notifyPropertyChanged(486);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01ec  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 1454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.F.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.E != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.E = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return a((TribeCenter) obj, i2);
            case 1:
                return g((ObservableField) obj, i2);
            case 2:
                return b((ObservableField<Boolean>) obj, i2);
            case 3:
                return h((ObservableField) obj, i2);
            case 4:
                return a((ObservableMap<Long, String>) obj, i2);
            case 5:
                return a((com.disabngo.blockynexus.view.activity.tribeshop.E) obj, i2);
            case 6:
                return e((ObservableField) obj, i2);
            case 7:
                return c((ObservableField) obj, i2);
            case 8:
                return b((ObservableMap<Long, TribeShopPageList>) obj, i2);
            case 9:
                return f((ObservableField) obj, i2);
            case 10:
                return a((ObservableList<com.disabngo.blockynexus.view.activity.tribeshop.D>) obj, i2);
            case 11:
                return a((ObservableField<Long>) obj, i2);
            case 12:
                return d((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (486 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.activity.tribeshop.E) obj);
        return true;
    }

    private F(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 13, (FrameLayout) objArr[25], (ImageButton) objArr[1], (ImageView) objArr[11], (ImageView) objArr[8], (ImageView) objArr[7], (ImageView) objArr[9], (LinearLayout) objArr[26], (TextView) objArr[2], (RelativeLayout) objArr[24], (RelativeLayout) objArr[23], (Toolbar) objArr[21], (TextView) objArr[16], (TextView) objArr[22]);
        this.E = -1L;
        this.f7407b.setTag(null);
        this.f7408c.setTag(null);
        this.f7409d.setTag(null);
        this.f7410e.setTag(null);
        this.f7411f.setTag(null);
        this.h.setTag(null);
        this.q = (CoordinatorLayout) objArr[0];
        this.q.setTag(null);
        this.r = (ImageView) objArr[10];
        this.r.setTag(null);
        this.s = (LinearLayout) objArr[12];
        this.s.setTag(null);
        this.t = (ImageView) objArr[13];
        this.t.setTag(null);
        this.u = (ImageView) objArr[14];
        this.u.setTag(null);
        this.v = (ImageView) objArr[15];
        this.v.setTag(null);
        this.w = (Button) objArr[17];
        this.w.setTag(null);
        this.x = (DressLoadingView) objArr[18];
        this.x.setTag(null);
        this.y = (TribeDressRadioGroup) objArr[19];
        this.y.setTag(null);
        this.z = (ViewPager) objArr[20];
        this.z.setTag(null);
        this.A = (ImageView) objArr[3];
        this.A.setTag(null);
        this.B = (Button) objArr[4];
        this.B.setTag(null);
        this.C = (ImageView) objArr[5];
        this.C.setTag(null);
        this.D = (RelativeLayout) objArr[6];
        this.D.setTag(null);
        this.l.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean b(ObservableMap<Long, TribeShopPageList> observableMap, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.E |= 256;
        }
        return true;
    }

    private boolean a(TribeCenter tribeCenter, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.E |= 1;
        }
        return true;
    }

    private boolean a(ObservableMap<Long, String> observableMap, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.E |= 16;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.view.activity.tribeshop.E e2, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.E |= 32;
        }
        return true;
    }

    private boolean a(ObservableList<com.disabngo.blockynexus.view.activity.tribeshop.D> observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.E |= 1024;
        }
        return true;
    }

    private boolean a(ObservableField<Long> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.E |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }
}
