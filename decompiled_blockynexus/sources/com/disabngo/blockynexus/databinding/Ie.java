package com.disabngo.blockynexus.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.fragment.more.MoreViewModel;
import com.disabngo.blockynexus.view.widget.MeItemView;
import com.sandboxol.center.entity.AccountCenter;

/* JADX INFO: compiled from: FragmentMoreBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Ie extends He {
    private static final ViewDataBinding.b j = new ViewDataBinding.b(33);
    private static final SparseIntArray k;
    private final MeItemView A;
    private final MeItemView B;
    private final MeItemView C;
    private final View D;
    private final TextView E;
    private final ImageView F;
    private final ImageView G;
    private final TextView H;
    private final TextView I;
    private final LinearLayout J;
    private long K;
    private final RelativeLayout l;
    private final TextView m;
    private final TextView n;
    private final TextView o;
    private final ImageView p;
    private final ImageView q;
    private final TextView r;
    private final TextView s;
    private final MeItemView t;
    private final MeItemView u;
    private final ImageView v;
    private final MeItemView w;
    private final MeItemView x;
    private final MeItemView y;
    private final MeItemView z;

    static {
        j.a(0, new String[]{"view_diamond_exchange"}, new int[]{28}, new int[]{R.layout.view_diamond_exchange});
        k = new SparseIntArray();
        k.put(R.id.rl_header, 29);
        k.put(R.id.ll_nickname, 30);
        k.put(R.id.ll_account, 31);
        k.put(R.id.ll_id, 32);
    }

    public Ie(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 33, j, k));
    }

    private boolean b(ObservableField<Long> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= 4;
        }
        return true;
    }

    private boolean c(ObservableField<Long> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= 512;
        }
        return true;
    }

    private boolean d(ObservableField<Long> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= PlaybackStateCompat.ACTION_PREPARE;
        }
        return true;
    }

    private boolean e(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= 16;
        }
        return true;
    }

    private boolean f(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        }
        return true;
    }

    private boolean g(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= 256;
        }
        return true;
    }

    private boolean h(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= 1048576;
        }
        return true;
    }

    private boolean i(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
        }
        return true;
    }

    private boolean j(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        return true;
    }

    private boolean k(ObservableField<Long> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= 64;
        }
        return true;
    }

    private boolean l(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean m(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= 128;
        }
        return true;
    }

    private boolean n(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= 2;
        }
        return true;
    }

    private boolean o(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= 65536;
        }
        return true;
    }

    private boolean p(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= 8;
        }
        return true;
    }

    private boolean q(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        }
        return true;
    }

    private boolean r(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= 1024;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.He
    public void a(MoreViewModel moreViewModel) {
        updateRegistration(11, moreViewModel);
        this.i = moreViewModel;
        synchronized (this) {
            this.K |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        notifyPropertyChanged(453);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x046f  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0498  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x04b6  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x04da  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0533  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0563  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0572  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0581  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x05a6  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x05ba  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x05c9  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x05d4  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x05f9  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0604  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0611  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0620  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x062d  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0643  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01ca  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 1619
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Ie.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.K != 0) {
                return true;
            }
            return this.f7518a.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.K = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
        }
        this.f7518a.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return a((AccountCenter) obj, i2);
            case 1:
                return n((ObservableField) obj, i2);
            case 2:
                return b((ObservableField) obj, i2);
            case 3:
                return p((ObservableField) obj, i2);
            case 4:
                return e((ObservableField) obj, i2);
            case 5:
                return a((ObservableField<String>) obj, i2);
            case 6:
                return k((ObservableField) obj, i2);
            case 7:
                return m((ObservableField) obj, i2);
            case 8:
                return g((ObservableField) obj, i2);
            case 9:
                return c((ObservableField) obj, i2);
            case 10:
                return r((ObservableField) obj, i2);
            case 11:
                return a((MoreViewModel) obj, i2);
            case 12:
                return a((xk) obj, i2);
            case 13:
                return j((ObservableField) obj, i2);
            case 14:
                return d((ObservableField) obj, i2);
            case 15:
                return l((ObservableField) obj, i2);
            case 16:
                return o((ObservableField) obj, i2);
            case 17:
                return f((ObservableField) obj, i2);
            case 18:
                return q((ObservableField) obj, i2);
            case 19:
                return i((ObservableField) obj, i2);
            case 20:
                return h((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(androidx.lifecycle.g gVar) {
        super.setLifecycleOwner(gVar);
        this.f7518a.setLifecycleOwner(gVar);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (453 != i) {
            return false;
        }
        a((MoreViewModel) obj);
        return true;
    }

    private Ie(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 21, (xk) objArr[28], (ImageView) objArr[7], (LinearLayout) objArr[31], (LinearLayout) objArr[32], (LinearLayout) objArr[30], (LinearLayout) objArr[1], (MeItemView) objArr[17], (RelativeLayout) objArr[29]);
        this.K = -1L;
        this.f7519b.setTag(null);
        this.f7523f.setTag(null);
        this.l = (RelativeLayout) objArr[0];
        this.l.setTag(null);
        this.m = (TextView) objArr[10];
        this.m.setTag(null);
        this.n = (TextView) objArr[11];
        this.n.setTag(null);
        this.o = (TextView) objArr[12];
        this.o.setTag(null);
        this.p = (ImageView) objArr[13];
        this.p.setTag(null);
        this.q = (ImageView) objArr[14];
        this.q.setTag(null);
        this.r = (TextView) objArr[15];
        this.r.setTag(null);
        this.s = (TextView) objArr[16];
        this.s.setTag(null);
        this.t = (MeItemView) objArr[18];
        this.t.setTag(null);
        this.u = (MeItemView) objArr[19];
        this.u.setTag(null);
        this.v = (ImageView) objArr[2];
        this.v.setTag(null);
        this.w = (MeItemView) objArr[20];
        this.w.setTag(null);
        this.x = (MeItemView) objArr[21];
        this.x.setTag(null);
        this.y = (MeItemView) objArr[22];
        this.y.setTag(null);
        this.z = (MeItemView) objArr[23];
        this.z.setTag(null);
        this.A = (MeItemView) objArr[24];
        this.A.setTag(null);
        this.B = (MeItemView) objArr[25];
        this.B.setTag(null);
        this.C = (MeItemView) objArr[26];
        this.C.setTag(null);
        this.D = (View) objArr[27];
        this.D.setTag(null);
        this.E = (TextView) objArr[3];
        this.E.setTag(null);
        this.F = (ImageView) objArr[4];
        this.F.setTag(null);
        this.G = (ImageView) objArr[5];
        this.G.setTag(null);
        this.H = (TextView) objArr[6];
        this.H.setTag(null);
        this.I = (TextView) objArr[8];
        this.I.setTag(null);
        this.J = (LinearLayout) objArr[9];
        this.J.setTag(null);
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(AccountCenter accountCenter, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= 32;
        }
        return true;
    }

    private boolean a(MoreViewModel moreViewModel, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }

    private boolean a(xk xkVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        return true;
    }
}
