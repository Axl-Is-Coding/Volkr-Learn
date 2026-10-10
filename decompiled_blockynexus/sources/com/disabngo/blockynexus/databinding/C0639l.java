package com.disabngo.blockynexus.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.StatusBean;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;
import com.sandboxol.decorate.widget.DressLoadingView;
import com.sandboxol.greendao.entity.Friend;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityFriendsInfoBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0639l extends AbstractC0628k {
    private static final ViewDataBinding.b l = null;
    private static final SparseIntArray m = new SparseIntArray();
    private final DataRecyclerView A;
    private final LinearLayout B;
    private final Button C;
    private final View D;
    private final ImageView E;
    private final ImageView F;
    private final LinearLayout G;
    private long H;
    private final CoordinatorLayout n;
    private final TextView o;
    private final TextView p;
    private final TextView q;
    private final LinearLayout r;
    private final ImageView s;
    private final TextView t;
    private final TextView u;
    private final Button v;
    private final RadioGroup w;
    private final ViewPager x;
    private final ImageView y;
    private final DressLoadingView z;

    static {
        m.put(R.id.rl_user_head, 27);
        m.put(R.id.llBackground, 28);
        m.put(R.id.dressViewGroup, 29);
    }

    public C0639l(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 30, l, m));
    }

    private boolean b(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        return true;
    }

    private boolean c(ObservableField<Friend> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }

    private boolean d(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H |= 1024;
        }
        return true;
    }

    private boolean e(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H |= 4;
        }
        return true;
    }

    private boolean f(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H |= 512;
        }
        return true;
    }

    private boolean g(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H |= 64;
        }
        return true;
    }

    private boolean h(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean i(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H |= 16;
        }
        return true;
    }

    private boolean j(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H |= 32;
        }
        return true;
    }

    private boolean k(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H |= 2;
        }
        return true;
    }

    private boolean l(ObservableField<StatusBean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H |= PlaybackStateCompat.ACTION_PREPARE;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0628k
    public void a(com.disabngo.blockynexus.view.activity.friends.M m2) {
        updateRegistration(7, m2);
        this.k = m2;
        synchronized (this) {
            this.H |= 128;
        }
        notifyPropertyChanged(291);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a5 A[PHI: r2
      0x00a5: PHI (r2v8 long) = (r2v0 long), (r2v37 long) binds: [B:25:0x0076, B:39:0x00a0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x013f  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 1771
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0639l.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.H != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.H = 65536L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return a((AccountCenter) obj, i2);
            case 1:
                return k((ObservableField) obj, i2);
            case 2:
                return e((ObservableField) obj, i2);
            case 3:
                return a((ObservableList<com.disabngo.blockynexus.view.activity.friends.N>) obj, i2);
            case 4:
                return i((ObservableField) obj, i2);
            case 5:
                return j((ObservableField) obj, i2);
            case 6:
                return g((ObservableField) obj, i2);
            case 7:
                return a((com.disabngo.blockynexus.view.activity.friends.M) obj, i2);
            case 8:
                return a((ObservableField<Long>) obj, i2);
            case 9:
                return f((ObservableField) obj, i2);
            case 10:
                return d((ObservableField) obj, i2);
            case 11:
                return c((ObservableField) obj, i2);
            case 12:
                return b((ObservableField) obj, i2);
            case 13:
                return a((Friend) obj, i2);
            case 14:
                return l((ObservableField) obj, i2);
            case 15:
                return h((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (291 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.activity.friends.M) obj);
        return true;
    }

    private C0639l(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 16, (FrameLayout) objArr[29], (ImageButton) objArr[1], (ImageButton) objArr[2], (ImageView) objArr[6], (LinearLayout) objArr[28], (AppCompatRadioButton) objArr[19], (AppCompatRadioButton) objArr[20], (RelativeLayout) objArr[27], (TextView) objArr[8], (TextView) objArr[5]);
        this.H = -1L;
        this.f8503b.setTag(null);
        this.f8504c.setTag(null);
        this.f8505d.setTag(null);
        this.n = (CoordinatorLayout) objArr[0];
        this.n.setTag(null);
        this.o = (TextView) objArr[10];
        this.o.setTag(null);
        this.p = (TextView) objArr[11];
        this.p.setTag(null);
        this.q = (TextView) objArr[12];
        this.q.setTag(null);
        this.r = (LinearLayout) objArr[13];
        this.r.setTag(null);
        this.s = (ImageView) objArr[14];
        this.s.setTag(null);
        this.t = (TextView) objArr[15];
        this.t.setTag(null);
        this.u = (TextView) objArr[16];
        this.u.setTag(null);
        this.v = (Button) objArr[17];
        this.v.setTag(null);
        this.w = (RadioGroup) objArr[18];
        this.w.setTag(null);
        this.x = (ViewPager) objArr[21];
        this.x.setTag(null);
        this.y = (ImageView) objArr[22];
        this.y.setTag(null);
        this.z = (DressLoadingView) objArr[23];
        this.z.setTag(null);
        this.A = (DataRecyclerView) objArr[24];
        this.A.setTag(null);
        this.B = (LinearLayout) objArr[25];
        this.B.setTag(null);
        this.C = (Button) objArr[26];
        this.C.setTag(null);
        this.D = (View) objArr[3];
        this.D.setTag(null);
        this.E = (ImageView) objArr[4];
        this.E.setTag(null);
        this.F = (ImageView) objArr[7];
        this.F.setTag(null);
        this.G = (LinearLayout) objArr[9];
        this.G.setTag(null);
        this.f8507f.setTag(null);
        this.g.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(AccountCenter accountCenter, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H |= 1;
        }
        return true;
    }

    private boolean a(ObservableList<com.disabngo.blockynexus.view.activity.friends.N> observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H |= 8;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.view.activity.friends.M m2, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H |= 128;
        }
        return true;
    }

    private boolean a(ObservableField<Long> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H |= 256;
        }
        return true;
    }

    private boolean a(Friend friend, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        return true;
    }
}
