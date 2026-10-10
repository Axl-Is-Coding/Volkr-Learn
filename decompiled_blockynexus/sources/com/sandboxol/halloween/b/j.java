package com.sandboxol.halloween.b;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.halloween.R;
import com.sandboxol.halloween.view.fragment.exchange.ExchangeViewModel;
import com.sandboxol.halloween.widget.CenterStrokeTextView;

/* JADX INFO: compiled from: HalloweenFragmentExchangeBindingImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class j extends i {
    private static final ViewDataBinding.b H = null;
    private static final SparseIntArray I = new SparseIntArray();
    private final ConstraintLayout J;
    private final TextView K;
    private final CenterStrokeTextView L;
    private long M;

    static {
        I.put(R.id.bg_main, 32);
        I.put(R.id.bg_reward, 33);
        I.put(R.id.bg_dec, 34);
    }

    public j(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 35, H, I));
    }

    private boolean b(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.M |= 16;
        }
        return true;
    }

    private boolean c(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.M |= 2;
        }
        return true;
    }

    private boolean d(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.M |= 1024;
        }
        return true;
    }

    private boolean e(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.M |= 128;
        }
        return true;
    }

    private boolean f(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.M |= 8;
        }
        return true;
    }

    private boolean g(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.M |= 1;
        }
        return true;
    }

    private boolean h(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.M |= 512;
        }
        return true;
    }

    private boolean i(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.M |= 256;
        }
        return true;
    }

    private boolean j(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.M |= 64;
        }
        return true;
    }

    @Override // com.sandboxol.halloween.b.i
    public void a(ExchangeViewModel exchangeViewModel) {
        updateRegistration(2, exchangeViewModel);
        this.G = exchangeViewModel;
        synchronized (this) {
            this.M |= 4;
        }
        notifyPropertyChanged(com.sandboxol.halloween.a.f18578b);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0055 A[PHI: r2
      0x0055: PHI (r2v40 long) = (r2v0 long), (r2v65 long) binds: [B:9:0x0021, B:27:0x004f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008d A[PHI: r2
      0x008d: PHI (r2v42 long) = (r2v41 long), (r2v63 long) binds: [B:32:0x005a, B:50:0x0087] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0130  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 1298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.halloween.b.j.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.M != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.M = PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return g((ObservableField) obj, i2);
            case 1:
                return c((ObservableField) obj, i2);
            case 2:
                return a((ExchangeViewModel) obj, i2);
            case 3:
                return f((ObservableField) obj, i2);
            case 4:
                return b((ObservableField) obj, i2);
            case 5:
                return a((ObservableField<Integer>) obj, i2);
            case 6:
                return j((ObservableField) obj, i2);
            case 7:
                return e((ObservableField) obj, i2);
            case 8:
                return i((ObservableField) obj, i2);
            case 9:
                return h((ObservableField) obj, i2);
            case 10:
                return d((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.halloween.a.f18578b != i) {
            return false;
        }
        a((ExchangeViewModel) obj);
        return true;
    }

    private j(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 11, (View) objArr[34], (View) objArr[30], (View) objArr[32], (View) objArr[33], (View) objArr[9], (View) objArr[12], (View) objArr[15], (View) objArr[18], (View) objArr[21], (View) objArr[24], (View) objArr[27], (ImageView) objArr[8], (ImageView) objArr[11], (ImageView) objArr[14], (ImageView) objArr[17], (ImageView) objArr[20], (ImageView) objArr[23], (ImageView) objArr[26], (ImageView) objArr[10], (ImageView) objArr[13], (ImageView) objArr[16], (ImageView) objArr[19], (ImageView) objArr[22], (ImageView) objArr[25], (ImageView) objArr[28], (View) objArr[1], (View) objArr[2], (View) objArr[3], (View) objArr[4], (View) objArr[5], (View) objArr[6], (View) objArr[7]);
        this.M = -1L;
        this.f18608b.setTag(null);
        this.f18611e.setTag(null);
        this.f18612f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
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
        this.y.setTag(null);
        this.J = (ConstraintLayout) objArr[0];
        this.J.setTag(null);
        this.K = (TextView) objArr[29];
        this.K.setTag(null);
        this.L = (CenterStrokeTextView) objArr[31];
        this.L.setTag(null);
        this.z.setTag(null);
        this.A.setTag(null);
        this.B.setTag(null);
        this.C.setTag(null);
        this.D.setTag(null);
        this.E.setTag(null);
        this.F.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ExchangeViewModel exchangeViewModel, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.M |= 4;
        }
        return true;
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.M |= 32;
        }
        return true;
    }
}
