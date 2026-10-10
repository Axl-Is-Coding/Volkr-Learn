package com.sandboxol.decorate.c;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableMap;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.view.fragment.dress.fa;

/* JADX INFO: renamed from: com.sandboxol.decorate.c.z, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemDressBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2600z extends AbstractC2599y {
    private static final ViewDataBinding.b p = null;
    private static final SparseIntArray q = new SparseIntArray();
    private final ConstraintLayout r;
    private final ImageView s;
    private long t;

    static {
        q.put(R.id.bgView, 15);
    }

    public C2600z(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 16, p, q));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.t |= 4;
        }
        return true;
    }

    public void a(fa faVar) {
        updateRegistration(0, faVar);
        this.o = faVar;
        synchronized (this) {
            this.t |= 1;
        }
        notifyPropertyChanged(com.sandboxol.decorate.c.f16980b);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:265:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0480 A[PHI: r2
      0x0480: PHI (r2v4 long) = (r2v3 long), (r2v22 long) binds: [B:264:0x0467, B:273:0x047a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:279:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x04e7  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x04fc  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x04ff  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0507  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x052f  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x053f  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0544  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x054e  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x0567  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x056f  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x0596  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x05a1  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x05c0  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x05cd  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x05e0  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x05ef  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x05f6  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x0600  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x061f  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x062a  */
    /* JADX WARN: Removed duplicated region for block: B:411:0x0636  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x0653  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x067c  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x069a  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x06bc  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x06c7  */
    /* JADX WARN: Removed duplicated region for block: B:429:0x06f5  */
    /* JADX WARN: Removed duplicated region for block: B:432:0x0702  */
    /* JADX WARN: Removed duplicated region for block: B:435:0x071e  */
    /* JADX WARN: Removed duplicated region for block: B:438:0x072c  */
    /* JADX WARN: Removed duplicated region for block: B:441:0x0738  */
    /* JADX WARN: Removed duplicated region for block: B:444:0x0756  */
    /* JADX WARN: Removed duplicated region for block: B:447:0x0764  */
    /* JADX WARN: Removed duplicated region for block: B:454:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 1903
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.decorate.c.C2600z.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.t != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.t = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((fa) obj, i2);
        }
        if (i == 1) {
            return a((ObservableMap<Long, Long>) obj, i2);
        }
        if (i == 2) {
            return b((ObservableField) obj, i2);
        }
        if (i == 3) {
            return a((ObservableField<Integer>) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return a((SingleDressInfo) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.decorate.c.f16980b != i) {
            return false;
        }
        a((fa) obj);
        return true;
    }

    private C2600z(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 5, (View) objArr[12], (View) objArr[13], (View) objArr[15], (View) objArr[4], (ImageView) objArr[5], (ImageView) objArr[8], (ImageView) objArr[11], (View) objArr[2], (View) objArr[3], (TextView) objArr[10], (TextView) objArr[6], (TextView) objArr[9], (TextView) objArr[1], (TextView) objArr[7]);
        this.t = -1L;
        this.f17130a.setTag(null);
        this.f17131b.setTag(null);
        this.f17133d.setTag(null);
        this.f17134e.setTag(null);
        this.f17135f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.r = (ConstraintLayout) objArr[0];
        this.r.setTag(null);
        this.s = (ImageView) objArr[14];
        this.s.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        this.l.setTag(null);
        this.m.setTag(null);
        this.n.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(fa faVar, int i) {
        if (i == com.sandboxol.decorate.c.f16979a) {
            synchronized (this) {
                this.t |= 1;
            }
            return true;
        }
        if (i != com.sandboxol.decorate.c.I) {
            return false;
        }
        synchronized (this) {
            this.t |= 16;
        }
        return true;
    }

    private boolean a(ObservableMap<Long, Long> observableMap, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.t |= 2;
        }
        return true;
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.t |= 8;
        }
        return true;
    }

    private boolean a(SingleDressInfo singleDressInfo, int i) {
        if (i == com.sandboxol.decorate.c.f16979a) {
            synchronized (this) {
                this.t |= 16;
            }
            return true;
        }
        if (i == com.sandboxol.decorate.c.l) {
            synchronized (this) {
                this.t |= 32;
            }
            return true;
        }
        if (i == com.sandboxol.decorate.c.h) {
            synchronized (this) {
                this.t |= 64;
            }
            return true;
        }
        if (i == com.sandboxol.decorate.c.j) {
            synchronized (this) {
                this.t |= 128;
            }
            return true;
        }
        if (i == com.sandboxol.decorate.c.f16983e) {
            synchronized (this) {
                this.t |= 256;
            }
            return true;
        }
        if (i == com.sandboxol.decorate.c.m) {
            synchronized (this) {
                this.t |= 512;
            }
            return true;
        }
        if (i == com.sandboxol.decorate.c.g) {
            synchronized (this) {
                this.t |= 1024;
            }
            return true;
        }
        if (i == com.sandboxol.decorate.c.f16984f) {
            synchronized (this) {
                this.t |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        }
        if (i != com.sandboxol.decorate.c.f16982d) {
            return false;
        }
        synchronized (this) {
            this.t |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        return true;
    }
}
