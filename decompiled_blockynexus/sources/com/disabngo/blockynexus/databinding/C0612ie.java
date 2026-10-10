package com.disabngo.blockynexus.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ie, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentGroupInfoBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0612ie extends AbstractC0601he {
    private static final ViewDataBinding.b g = null;
    private static final SparseIntArray h = new SparseIntArray();
    private final FrameLayout i;
    private final DataRecyclerView j;
    private final LinearLayout k;
    private final RelativeLayout l;
    private final CheckBox m;
    private final RelativeLayout n;
    private final CheckBox o;
    private final Button p;
    private final Button q;
    private final RelativeLayout r;
    private final LinearLayout s;
    private final RelativeLayout t;
    private final TextView u;
    private final LinearLayout v;
    private final TextView w;
    private long x;

    static {
        h.put(R.id.text_into_all_member, 17);
        h.put(R.id.right_into_icon_0, 18);
        h.put(R.id.right_into_icon, 19);
    }

    public C0612ie(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 20, g, h));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.x |= 4;
        }
        return true;
    }

    private boolean c(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.x |= 512;
        }
        return true;
    }

    private boolean d(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.x |= 16;
        }
        return true;
    }

    private boolean e(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.x |= 256;
        }
        return true;
    }

    private boolean f(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.x |= 1;
        }
        return true;
    }

    private boolean g(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.x |= 8;
        }
        return true;
    }

    private boolean h(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.x |= 128;
        }
        return true;
    }

    private boolean i(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.x |= 64;
        }
        return true;
    }

    private boolean j(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.x |= 1024;
        }
        return true;
    }

    private boolean k(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.x |= 2;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0601he
    public void a(com.disabngo.blockynexus.e.b.D.I i) {
        updateRegistration(5, i);
        this.f8411f = i;
        synchronized (this) {
            this.x |= 32;
        }
        notifyPropertyChanged(293);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0091 A[PHI: r2
      0x0091: PHI (r2v35 long) = (r2v34 long), (r2v54 long) binds: [B:31:0x0065, B:45:0x008b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0136  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 1087
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0612ie.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.x != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.x = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return f((ObservableField) obj, i2);
            case 1:
                return k((ObservableField) obj, i2);
            case 2:
                return b((ObservableField) obj, i2);
            case 3:
                return g((ObservableField) obj, i2);
            case 4:
                return d((ObservableField) obj, i2);
            case 5:
                return a((com.disabngo.blockynexus.e.b.D.I) obj, i2);
            case 6:
                return i((ObservableField) obj, i2);
            case 7:
                return h((ObservableField) obj, i2);
            case 8:
                return e((ObservableField) obj, i2);
            case 9:
                return c((ObservableField) obj, i2);
            case 10:
                return j((ObservableField) obj, i2);
            case 11:
                return a((ObservableField<Boolean>) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (293 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.D.I) obj);
        return true;
    }

    private C0612ie(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 12, (ImageView) objArr[19], (ImageView) objArr[18], (ImageView) objArr[7], (TextView) objArr[4], (TextView) objArr[17]);
        this.x = -1L;
        this.i = (FrameLayout) objArr[0];
        this.i.setTag(null);
        this.j = (DataRecyclerView) objArr[1];
        this.j.setTag(null);
        this.k = (LinearLayout) objArr[10];
        this.k.setTag(null);
        this.l = (RelativeLayout) objArr[11];
        this.l.setTag(null);
        this.m = (CheckBox) objArr[12];
        this.m.setTag(null);
        this.n = (RelativeLayout) objArr[13];
        this.n.setTag(null);
        this.o = (CheckBox) objArr[14];
        this.o.setTag(null);
        this.p = (Button) objArr[15];
        this.p.setTag(null);
        this.q = (Button) objArr[16];
        this.q.setTag(null);
        this.r = (RelativeLayout) objArr[2];
        this.r.setTag(null);
        this.s = (LinearLayout) objArr[3];
        this.s.setTag(null);
        this.t = (RelativeLayout) objArr[5];
        this.t.setTag(null);
        this.u = (TextView) objArr[6];
        this.u.setTag(null);
        this.v = (LinearLayout) objArr[8];
        this.v.setTag(null);
        this.w = (TextView) objArr[9];
        this.w.setTag(null);
        this.f8408c.setTag(null);
        this.f8409d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.D.I i, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.x |= 32;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.x |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }
}
