package com.disabngo.blockynexus.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.fragment.updateuserinfo.UpdateUserInfoViewModel;
import com.disabngo.blockynexus.view.widget.ItemView;
import com.sandboxol.center.entity.AccountCenter;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.eg, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentUpdateUserInfoBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0570eg extends AbstractC0559dg {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f8304e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f8305f = new SparseIntArray();
    private final LinearLayout g;
    private final RelativeLayout h;
    private final ItemView i;
    private final ItemView j;
    private final Button k;
    private final ProgressBar l;
    private final TextView m;
    private final RelativeLayout n;
    private final View o;
    private final ItemView p;
    private final ItemView q;
    private long r;

    static {
        f8305f.put(R.id.tvIcon, 12);
        f8305f.put(R.id.ivArrow, 13);
    }

    public C0570eg(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 14, f8304e, f8305f));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.r |= 32;
        }
        return true;
    }

    private boolean c(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.r |= 8;
        }
        return true;
    }

    private boolean d(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.r |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        return true;
    }

    private boolean e(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.r |= 1;
        }
        return true;
    }

    private boolean f(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.r |= 16;
        }
        return true;
    }

    private boolean g(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.r |= 64;
        }
        return true;
    }

    private boolean h(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.r |= 128;
        }
        return true;
    }

    private boolean i(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.r |= 512;
        }
        return true;
    }

    private boolean j(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.r |= 4;
        }
        return true;
    }

    private boolean k(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.r |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0559dg
    public void a(UpdateUserInfoViewModel updateUserInfoViewModel) {
        updateRegistration(10, updateUserInfoViewModel);
        this.f8270d = updateUserInfoViewModel;
        synchronized (this) {
            this.r |= 1024;
        }
        notifyPropertyChanged(366);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:175:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0144  */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v5 */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 744
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0570eg.executeBindings():void");
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
        switch (i) {
            case 0:
                return e((ObservableField) obj, i2);
            case 1:
                return a((AccountCenter) obj, i2);
            case 2:
                return j((ObservableField) obj, i2);
            case 3:
                return c((ObservableField) obj, i2);
            case 4:
                return f((ObservableField) obj, i2);
            case 5:
                return b((ObservableField) obj, i2);
            case 6:
                return g((ObservableField) obj, i2);
            case 7:
                return h((ObservableField) obj, i2);
            case 8:
                return a((ObservableField<String>) obj, i2);
            case 9:
                return i((ObservableField) obj, i2);
            case 10:
                return a((UpdateUserInfoViewModel) obj, i2);
            case 11:
                return k((ObservableField) obj, i2);
            case 12:
                return d((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (366 != i) {
            return false;
        }
        a((UpdateUserInfoViewModel) obj);
        return true;
    }

    private C0570eg(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 13, (ImageView) objArr[13], (ImageView) objArr[6], (TextView) objArr[12]);
        this.r = -1L;
        this.f8268b.setTag(null);
        this.g = (LinearLayout) objArr[0];
        this.g.setTag(null);
        this.h = (RelativeLayout) objArr[1];
        this.h.setTag(null);
        this.i = (ItemView) objArr[10];
        this.i.setTag(null);
        this.j = (ItemView) objArr[11];
        this.j.setTag(null);
        this.k = (Button) objArr[2];
        this.k.setTag(null);
        this.l = (ProgressBar) objArr[3];
        this.l.setTag(null);
        this.m = (TextView) objArr[4];
        this.m.setTag(null);
        this.n = (RelativeLayout) objArr[5];
        this.n.setTag(null);
        this.o = (View) objArr[7];
        this.o.setTag(null);
        this.p = (ItemView) objArr[8];
        this.p.setTag(null);
        this.q = (ItemView) objArr[9];
        this.q.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(AccountCenter accountCenter, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.r |= 2;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.r |= 256;
        }
        return true;
    }

    private boolean a(UpdateUserInfoViewModel updateUserInfoViewModel, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.r |= 1024;
        }
        return true;
    }
}
