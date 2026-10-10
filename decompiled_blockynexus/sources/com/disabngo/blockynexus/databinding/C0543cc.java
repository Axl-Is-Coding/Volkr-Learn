package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;
import com.sandboxol.greendao.entity.Friend;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.cc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogPartyFriendInfoBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0543cc extends AbstractC0531bc {
    private static final ViewDataBinding.b i = null;
    private static final SparseIntArray j = null;
    private final View k;
    private final Button l;
    private final RadioGroup m;
    private final ViewPager n;
    private final HorizontalScrollView o;
    private final DataRecyclerView p;
    private final LinearLayout q;
    private final View r;
    private final View s;
    private final View t;
    private final ImageView u;
    private final ImageView v;
    private final LinearLayout w;
    private final TextView x;
    private final TextView y;
    private long z;

    public C0543cc(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 22, i, j));
    }

    private boolean b(ObservableField<Friend> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.z |= 64;
        }
        return true;
    }

    private boolean c(ObservableField<Boolean> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.z |= 128;
        }
        return true;
    }

    private boolean d(ObservableField<Boolean> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.z |= 256;
        }
        return true;
    }

    private boolean e(ObservableField<Boolean> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.z |= 32;
        }
        return true;
    }

    private boolean f(ObservableField<Integer> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.z |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelPageItems(ObservableList<com.disabngo.blockynexus.view.activity.friends.N> observableList, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.z |= 4;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0531bc
    public void a(com.disabngo.blockynexus.view.dialog.partyfriend.j jVar) {
        updateRegistration(1, jVar);
        this.h = jVar;
        synchronized (this) {
            this.z |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:166:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0421 A[PHI: r2
      0x0421: PHI (r2v3 long) = (r2v2 long), (r2v7 long) binds: [B:229:0x0407, B:239:0x041c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:245:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x04a6  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x04d3  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x04e0  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x053c  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0551  */
    /* JADX WARN: Removed duplicated region for block: B:279:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 1372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0543cc.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.z != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.z = 1024L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return a((ObservableField<Integer>) obj, i3);
            case 1:
                return a((com.disabngo.blockynexus.view.dialog.partyfriend.j) obj, i3);
            case 2:
                return onChangeViewModelPageItems((ObservableList) obj, i3);
            case 3:
                return f((ObservableField) obj, i3);
            case 4:
                return a((Friend) obj, i3);
            case 5:
                return e((ObservableField) obj, i3);
            case 6:
                return b((ObservableField) obj, i3);
            case 7:
                return c((ObservableField) obj, i3);
            case 8:
                return d((ObservableField) obj, i3);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, Object obj) {
        if (2 != i2) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.partyfriend.j) obj);
        return true;
    }

    private C0543cc(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 9, (LinearLayout) objArr[0], (LinearLayout) objArr[11], (AppCompatRadioButton) objArr[13], (AppCompatRadioButton) objArr[14], (RelativeLayout) objArr[2], (TextView) objArr[6], (TextView) objArr[4]);
        this.z = -1L;
        this.f8188a.setTag(null);
        this.f8189b.setTag(null);
        this.k = (View) objArr[1];
        this.k.setTag(null);
        this.l = (Button) objArr[10];
        this.l.setTag(null);
        this.m = (RadioGroup) objArr[12];
        this.m.setTag(null);
        this.n = (ViewPager) objArr[15];
        this.n.setTag(null);
        this.o = (HorizontalScrollView) objArr[16];
        this.o.setTag(null);
        this.p = (DataRecyclerView) objArr[17];
        this.p.setTag(null);
        this.q = (LinearLayout) objArr[18];
        this.q.setTag(null);
        this.r = (View) objArr[19];
        this.r.setTag(null);
        this.s = (View) objArr[20];
        this.s.setTag(null);
        this.t = (View) objArr[21];
        this.t.setTag(null);
        this.u = (ImageView) objArr[3];
        this.u.setTag(null);
        this.v = (ImageView) objArr[5];
        this.v.setTag(null);
        this.w = (LinearLayout) objArr[7];
        this.w.setTag(null);
        this.x = (TextView) objArr[8];
        this.x.setTag(null);
        this.y = (TextView) objArr[9];
        this.y.setTag(null);
        this.f8190c.setTag(null);
        this.f8191d.setTag(null);
        this.f8192e.setTag(null);
        this.f8193f.setTag(null);
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Integer> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.z |= 1;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.view.dialog.partyfriend.j jVar, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.z |= 2;
        }
        return true;
    }

    private boolean a(Friend friend, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.z |= 16;
            }
            return true;
        }
        if (i2 != 18) {
            return false;
        }
        synchronized (this) {
            this.z |= 512;
        }
        return true;
    }
}
