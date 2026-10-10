package com.sandboxol.decorate.c;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableMap;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.decorate.R;

/* JADX INFO: compiled from: ItemNewDressShopBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class U extends T {
    private static final ViewDataBinding.b n = null;
    private static final SparseIntArray o = new SparseIntArray();
    private final ConstraintLayout p;
    private final ImageView q;
    private long r;

    static {
        o.put(R.id.bgView, 12);
        o.put(R.id.tvTimeTip, 13);
    }

    public U(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 14, n, o));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.r |= 2;
        }
        return true;
    }

    private boolean c(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.r |= 8;
        }
        return true;
    }

    public void a(com.sandboxol.decorate.view.activity.dress.I i) {
        updateRegistration(0, i);
        this.m = i;
        synchronized (this) {
            this.r |= 1;
        }
        notifyPropertyChanged(com.sandboxol.decorate.c.f16980b);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0163 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0474  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0481  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x04a4  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x04d0  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x04f7  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0506  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x0515  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0524  */
    /* JADX WARN: Removed duplicated region for block: B:348:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009e A[PHI: r2
      0x009e: PHI (r2v29 long) = (r2v0 long), (r2v51 long) binds: [B:28:0x007a, B:41:0x0098] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0139  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 1327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.decorate.c.U.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.r != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.r = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.sandboxol.decorate.view.activity.dress.I) obj, i2);
        }
        if (i == 1) {
            return b((ObservableField) obj, i2);
        }
        if (i == 2) {
            return a((SingleDressInfo) obj, i2);
        }
        if (i == 3) {
            return c((ObservableField) obj, i2);
        }
        if (i == 4) {
            return a((ObservableField<Integer>) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return a((ObservableMap<Long, String>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.decorate.c.f16980b != i) {
            return false;
        }
        a((com.sandboxol.decorate.view.activity.dress.I) obj);
        return true;
    }

    private U(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 6, (View) objArr[8], (View) objArr[9], (View) objArr[12], (Group) objArr[11], (ImageView) objArr[1], (ImageView) objArr[2], (ImageView) objArr[6], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[3], (TextView) objArr[7], (TextView) objArr[13]);
        this.r = -1L;
        this.f17039a.setTag(null);
        this.f17040b.setTag(null);
        this.f17042d.setTag(null);
        this.f17043e.setTag(null);
        this.f17044f.setTag(null);
        this.g.setTag(null);
        this.p = (ConstraintLayout) objArr[0];
        this.p.setTag(null);
        this.q = (ImageView) objArr[10];
        this.q.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandboxol.decorate.view.activity.dress.I i, int i2) {
        if (i2 == com.sandboxol.decorate.c.f16979a) {
            synchronized (this) {
                this.r |= 1;
            }
            return true;
        }
        if (i2 != com.sandboxol.decorate.c.I) {
            return false;
        }
        synchronized (this) {
            this.r |= 4;
        }
        return true;
    }

    private boolean a(SingleDressInfo singleDressInfo, int i) {
        if (i == com.sandboxol.decorate.c.f16979a) {
            synchronized (this) {
                this.r |= 4;
            }
            return true;
        }
        if (i == com.sandboxol.decorate.c.j) {
            synchronized (this) {
                this.r |= 64;
            }
            return true;
        }
        if (i == com.sandboxol.decorate.c.m) {
            synchronized (this) {
                this.r |= 128;
            }
            return true;
        }
        if (i == com.sandboxol.decorate.c.i) {
            synchronized (this) {
                this.r |= 256;
            }
            return true;
        }
        if (i == com.sandboxol.decorate.c.g) {
            synchronized (this) {
                this.r |= 512;
            }
            return true;
        }
        if (i == com.sandboxol.decorate.c.f16984f) {
            synchronized (this) {
                this.r |= 1024;
            }
            return true;
        }
        if (i == com.sandboxol.decorate.c.f16982d) {
            synchronized (this) {
                this.r |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        }
        if (i != com.sandboxol.decorate.c.f16981c) {
            return false;
        }
        synchronized (this) {
            this.r |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        return true;
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.r |= 16;
        }
        return true;
    }

    private boolean a(ObservableMap<Long, String> observableMap, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.r |= 32;
        }
        return true;
    }
}
