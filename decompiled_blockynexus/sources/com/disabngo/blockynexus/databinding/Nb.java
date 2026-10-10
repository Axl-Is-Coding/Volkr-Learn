package com.disabngo.blockynexus.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.widget.CareerPentagonView;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.widget.RoundImageView;
import com.sandboxol.greendao.entity.Friend;

/* JADX INFO: compiled from: DialogMapFriendBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Nb extends Mb {
    private static final ViewDataBinding.b h = null;
    private static final SparseIntArray i = new SparseIntArray();
    private final ImageView A;
    private final RelativeLayout B;
    private final ImageView C;
    private final ImageView D;
    private final ImageView E;
    private final TextView F;
    private final Button G;
    private final LinearLayout H;
    private final RoundImageView I;
    private final TextView J;
    private long K;
    private final ConstraintLayout j;
    private final ImageView k;
    private final RoundImageView l;
    private final LinearLayout m;
    private final CareerPentagonView n;
    private final LinearLayout o;
    private final TextView p;
    private final TextView q;
    private final TextView r;
    private final TextView s;
    private final TextView t;
    private final LinearLayout u;
    private final TextView v;
    private final TextView w;
    private final RelativeLayout x;
    private final RelativeLayout y;
    private final ImageView z;

    static {
        i.put(R.id.llDialog, 29);
        i.put(R.id.rlHead, 30);
        i.put(R.id.rlMyPosition, 31);
        i.put(R.id.vLine, 32);
    }

    public Nb(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 33, h, i));
    }

    private boolean b(ObservableField<String> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= 32;
        }
        return true;
    }

    private boolean c(ObservableField<String> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= 4;
        }
        return true;
    }

    private boolean d(ObservableField<String> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= 8;
        }
        return true;
    }

    private boolean e(ObservableField<Boolean> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= 16;
        }
        return true;
    }

    private boolean f(ObservableField<Boolean> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= 128;
        }
        return true;
    }

    private boolean g(ObservableField<Boolean> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= 2;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.Mb
    public void a(com.disabngo.blockynexus.view.dialog.Da da) {
        this.g = da;
        synchronized (this) {
            this.K |= 512;
        }
        notifyPropertyChanged(324);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006c A[PHI: r2
      0x006c: PHI (r2v3 long) = (r2v0 long), (r2v30 long) binds: [B:14:0x003c, B:28:0x0066] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0123  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 1228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Nb.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.K != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.K = PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return a((AccountCenter) obj, i3);
            case 1:
                return g((ObservableField) obj, i3);
            case 2:
                return c((ObservableField) obj, i3);
            case 3:
                return d((ObservableField) obj, i3);
            case 4:
                return e((ObservableField) obj, i3);
            case 5:
                return b((ObservableField) obj, i3);
            case 6:
                return a((Friend) obj, i3);
            case 7:
                return f((ObservableField) obj, i3);
            case 8:
                return a((ObservableField<String>) obj, i3);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, Object obj) {
        if (324 != i2) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.Da) obj);
        return true;
    }

    private Nb(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 9, (LinearLayout) objArr[29], (RelativeLayout) objArr[30], (RelativeLayout) objArr[31], (TextView) objArr[4], (TextView) objArr[2], (ImageView) objArr[32]);
        this.K = -1L;
        this.j = (ConstraintLayout) objArr[0];
        this.j.setTag(null);
        this.k = (ImageView) objArr[1];
        this.k.setTag(null);
        this.l = (RoundImageView) objArr[10];
        this.l.setTag(null);
        this.m = (LinearLayout) objArr[11];
        this.m.setTag(null);
        this.n = (CareerPentagonView) objArr[12];
        this.n.setTag(null);
        this.o = (LinearLayout) objArr[13];
        this.o.setTag(null);
        this.p = (TextView) objArr[14];
        this.p.setTag(null);
        this.q = (TextView) objArr[15];
        this.q.setTag(null);
        this.r = (TextView) objArr[16];
        this.r.setTag(null);
        this.s = (TextView) objArr[17];
        this.s.setTag(null);
        this.t = (TextView) objArr[18];
        this.t.setTag(null);
        this.u = (LinearLayout) objArr[19];
        this.u.setTag(null);
        this.v = (TextView) objArr[20];
        this.v.setTag(null);
        this.w = (TextView) objArr[21];
        this.w.setTag(null);
        this.x = (RelativeLayout) objArr[22];
        this.x.setTag(null);
        this.y = (RelativeLayout) objArr[23];
        this.y.setTag(null);
        this.z = (ImageView) objArr[24];
        this.z.setTag(null);
        this.A = (ImageView) objArr[25];
        this.A.setTag(null);
        this.B = (RelativeLayout) objArr[26];
        this.B.setTag(null);
        this.C = (ImageView) objArr[27];
        this.C.setTag(null);
        this.D = (ImageView) objArr[28];
        this.D.setTag(null);
        this.E = (ImageView) objArr[3];
        this.E.setTag(null);
        this.F = (TextView) objArr[5];
        this.F.setTag(null);
        this.G = (Button) objArr[6];
        this.G.setTag(null);
        this.H = (LinearLayout) objArr[7];
        this.H.setTag(null);
        this.I = (RoundImageView) objArr[8];
        this.I.setTag(null);
        this.J = (TextView) objArr[9];
        this.J.setTag(null);
        this.f7669d.setTag(null);
        this.f7670e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(AccountCenter accountCenter, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= 1;
        }
        return true;
    }

    private boolean a(Friend friend, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.K |= 64;
            }
            return true;
        }
        if (i2 != 18) {
            return false;
        }
        synchronized (this) {
            this.K |= 1024;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= 256;
        }
        return true;
    }
}
