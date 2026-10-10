package com.disabngo.blockynexus.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.common.widget.StrokeTextView;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: FragmentMakeFriendBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Ge extends Fe {
    private static final ViewDataBinding.b m = new ViewDataBinding.b(27);
    private static final SparseIntArray n;
    private final View A;
    private final Button B;
    private final LinearLayout C;
    private final ImageView D;
    private final ImageView E;
    private long F;
    private final AbstractC0662na o;
    private final LinearLayout p;
    private final RelativeLayout q;
    private final TextView r;
    private final TextView s;
    private final ImageView t;
    private final DataRecyclerView u;
    private final DataRecyclerView v;
    private final View w;
    private final Button x;
    private final Button y;
    private final StrokeTextView z;

    static {
        m.a(0, new String[]{"content_header"}, new int[]{20}, new int[]{R.layout.content_header});
        n = new SparseIntArray();
        n.put(R.id.ivTribe, 21);
        n.put(R.id.rlSearchClan, 22);
        n.put(R.id.rl_donate, 23);
        n.put(R.id.rlEnterClan, 24);
        n.put(R.id.ivMakeFriend, 25);
        n.put(R.id.btnSearchFriend, 26);
    }

    public Ge(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 27, m, n));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.F |= 16;
        }
        return true;
    }

    private boolean c(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.F |= 1;
        }
        return true;
    }

    private boolean d(ObservableField<Long> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.F |= 2;
        }
        return true;
    }

    private boolean e(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.F |= 32;
        }
        return true;
    }

    private boolean f(ObservableField<Long> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.F |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        return true;
    }

    private boolean g(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.F |= 4;
        }
        return true;
    }

    private boolean h(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.F |= 512;
        }
        return true;
    }

    private boolean i(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.F |= 1024;
        }
        return true;
    }

    private boolean j(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.F |= 256;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.Fe
    public void a(com.disabngo.blockynexus.view.activity.main.nc ncVar) {
        updateRegistration(7, ncVar);
        this.l = ncVar;
        synchronized (this) {
            this.F |= 128;
        }
        notifyPropertyChanged(301);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0155 A[PHI: r2
      0x0155: PHI (r2v24 long) = (r2v0 long), (r2v31 long) binds: [B:62:0x0128, B:76:0x014f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01a8  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 814
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Ge.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.F != 0) {
                return true;
            }
            return this.o.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.F = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        this.o.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return c((ObservableField) obj, i2);
            case 1:
                return d((ObservableField) obj, i2);
            case 2:
                return g((ObservableField) obj, i2);
            case 3:
                return a((TribeCenter) obj, i2);
            case 4:
                return b((ObservableField) obj, i2);
            case 5:
                return e((ObservableField) obj, i2);
            case 6:
                return a((ObservableField<String>) obj, i2);
            case 7:
                return a((com.disabngo.blockynexus.view.activity.main.nc) obj, i2);
            case 8:
                return j((ObservableField) obj, i2);
            case 9:
                return h((ObservableField) obj, i2);
            case 10:
                return i((ObservableField) obj, i2);
            case 11:
                return a((com.disabngo.blockynexus.e.b.O.t) obj, i2);
            case 12:
                return f((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(androidx.lifecycle.g gVar) {
        super.setLifecycleOwner(gVar);
        this.o.setLifecycleOwner(gVar);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (301 == i) {
            a((com.disabngo.blockynexus.view.activity.main.nc) obj);
        } else {
            if (358 != i) {
                return false;
            }
            a((com.disabngo.blockynexus.e.b.O.t) obj);
        }
        return true;
    }

    private Ge(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 13, (RelativeLayout) objArr[26], (ImageView) objArr[15], (ImageView) objArr[2], (ImageView) objArr[25], (ImageView) objArr[21], (LinearLayout) objArr[23], (RelativeLayout) objArr[24], (RelativeLayout) objArr[6], (RelativeLayout) objArr[22], (TextView) objArr[9]);
        this.F = -1L;
        this.f7448b.setTag(null);
        this.f7449c.setTag(null);
        this.o = (AbstractC0662na) objArr[20];
        setContainedBinding(this.o);
        this.p = (LinearLayout) objArr[0];
        this.p.setTag(null);
        this.q = (RelativeLayout) objArr[1];
        this.q.setTag(null);
        this.r = (TextView) objArr[10];
        this.r.setTag(null);
        this.s = (TextView) objArr[11];
        this.s.setTag(null);
        this.t = (ImageView) objArr[12];
        this.t.setTag(null);
        this.u = (DataRecyclerView) objArr[13];
        this.u.setTag(null);
        this.v = (DataRecyclerView) objArr[14];
        this.v.setTag(null);
        this.w = (View) objArr[16];
        this.w.setTag(null);
        this.x = (Button) objArr[17];
        this.x.setTag(null);
        this.y = (Button) objArr[18];
        this.y.setTag(null);
        this.z = (StrokeTextView) objArr[19];
        this.z.setTag(null);
        this.A = (View) objArr[3];
        this.A.setTag(null);
        this.B = (Button) objArr[4];
        this.B.setTag(null);
        this.C = (LinearLayout) objArr[5];
        this.C.setTag(null);
        this.D = (ImageView) objArr[7];
        this.D.setTag(null);
        this.E = (ImageView) objArr[8];
        this.E.setTag(null);
        this.h.setTag(null);
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // com.disabngo.blockynexus.databinding.Fe
    public void a(com.disabngo.blockynexus.e.b.O.t tVar) {
        updateRegistration(11, tVar);
        this.k = tVar;
        synchronized (this) {
            this.F |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        notifyPropertyChanged(358);
        super.requestRebind();
    }

    private boolean a(TribeCenter tribeCenter, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.F |= 8;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.F |= 64;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.view.activity.main.nc ncVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.F |= 128;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.O.t tVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.F |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }
}
