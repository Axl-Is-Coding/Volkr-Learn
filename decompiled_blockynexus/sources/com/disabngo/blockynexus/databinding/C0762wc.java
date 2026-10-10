package com.disabngo.blockynexus.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.view.widget.ScrapLevelImageView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.wc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogScrapRewardDetailsBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0762wc extends AbstractC0751vc {
    private static final ViewDataBinding.b B = null;
    private static final SparseIntArray C = new SparseIntArray();
    private final ConstraintLayout D;
    private final ImageView E;
    private final Group F;
    private final Group G;
    private final Group H;
    private final Group I;
    private final View J;
    private final TextView K;
    private long L;

    static {
        C.put(R.id.bg_main, 30);
        C.put(R.id.v_fill_static, 31);
        C.put(R.id.v_fill, 32);
        C.put(R.id.bg_scrap, 33);
    }

    public C0762wc(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 34, B, C));
    }

    private boolean b(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.L |= 2;
        }
        return true;
    }

    private boolean c(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.L |= PlaybackStateCompat.ACTION_PREPARE;
        }
        return true;
    }

    private boolean d(ObservableField<Drawable> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.L |= 4;
        }
        return true;
    }

    private boolean e(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.L |= 128;
        }
        return true;
    }

    private boolean f(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.L |= 1;
        }
        return true;
    }

    private boolean g(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.L |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }

    private boolean h(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.L |= 256;
        }
        return true;
    }

    private boolean i(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.L |= 32;
        }
        return true;
    }

    private boolean j(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.L |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        return true;
    }

    private boolean k(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.L |= 16;
        }
        return true;
    }

    private boolean l(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.L |= 64;
        }
        return true;
    }

    private boolean m(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.L |= 512;
        }
        return true;
    }

    private boolean n(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.L |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        return true;
    }

    private boolean o(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.L |= 8;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0751vc
    public void a(com.disabngo.blockynexus.view.dialog.Pa pa) {
        this.A = pa;
        synchronized (this) {
            this.L |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0462  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0472  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x04c5  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x04d6  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x053e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x010c  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 1953
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0762wc.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.L != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.L = 65536L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return f((ObservableField) obj, i2);
            case 1:
                return b((ObservableField) obj, i2);
            case 2:
                return d((ObservableField) obj, i2);
            case 3:
                return o((ObservableField) obj, i2);
            case 4:
                return k((ObservableField) obj, i2);
            case 5:
                return i((ObservableField) obj, i2);
            case 6:
                return l((ObservableField) obj, i2);
            case 7:
                return e((ObservableField) obj, i2);
            case 8:
                return h((ObservableField) obj, i2);
            case 9:
                return m((ObservableField) obj, i2);
            case 10:
                return a((ObservableField) obj, i2);
            case 11:
                return g((ObservableField) obj, i2);
            case 12:
                return j((ObservableField) obj, i2);
            case 13:
                return n((ObservableField) obj, i2);
            case 14:
                return c((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.Pa) obj);
        return true;
    }

    private C0762wc(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 15, (View) objArr[3], (View) objArr[30], (View) objArr[2], (View) objArr[33], (View) objArr[5], (Button) objArr[25], (Button) objArr[24], (ImageView) objArr[23], (ImageView) objArr[6], (ImageView) objArr[4], (ScrapLevelImageView) objArr[7], (ScrapLevelImageView) objArr[11], (TextView) objArr[13], (View) objArr[12], (ScrapLevelImageView) objArr[14], (TextView) objArr[16], (View) objArr[15], (ScrapLevelImageView) objArr[17], (TextView) objArr[19], (View) objArr[18], (ScrapLevelImageView) objArr[20], (TextView) objArr[22], (View) objArr[21], (TextView) objArr[1], (View) objArr[32], (View) objArr[31]);
        this.L = -1L;
        this.f8896a.setTag(null);
        this.f8898c.setTag(null);
        this.f8900e.setTag(null);
        this.f8901f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.D = (ConstraintLayout) objArr[0];
        this.D.setTag(null);
        this.E = (ImageView) objArr[10];
        this.E.setTag(null);
        this.F = (Group) objArr[26];
        this.F.setTag(null);
        this.G = (Group) objArr[27];
        this.G.setTag(null);
        this.H = (Group) objArr[28];
        this.H.setTag(null);
        this.I = (Group) objArr[29];
        this.I.setTag(null);
        this.J = (View) objArr[8];
        this.J.setTag(null);
        this.K = (TextView) objArr[9];
        this.K.setTag(null);
        this.k.setTag(null);
        this.l.setTag(null);
        this.m.setTag(null);
        this.n.setTag(null);
        this.o.setTag(null);
        this.p.setTag(null);
        this.q.setTag(null);
        this.r.setTag(null);
        this.s.setTag(null);
        this.t.setTag(null);
        this.u.setTag(null);
        this.v.setTag(null);
        this.w.setTag(null);
        this.x.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.L |= 1024;
        }
        return true;
    }
}
