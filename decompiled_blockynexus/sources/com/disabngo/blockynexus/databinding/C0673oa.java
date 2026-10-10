package com.disabngo.blockynexus.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.oa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ContentHeaderBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0673oa extends AbstractC0662na {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f8643c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f8644d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RelativeLayout f8645e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ImageButton f8646f;
    private final TextView g;
    private final TextView h;
    private final ImageButton i;
    private final LinearLayout j;
    private final TextView k;
    private final ImageButton l;
    private long m;

    public C0673oa(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 9, f8643c, f8644d));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 64;
        }
        return true;
    }

    private boolean c(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 2;
        }
        return true;
    }

    private boolean d(ObservableField<Long> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 1;
        }
        return true;
    }

    private boolean e(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 256;
        }
        return true;
    }

    private boolean f(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 16;
        }
        return true;
    }

    private boolean g(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 8;
        }
        return true;
    }

    private boolean h(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }

    private boolean i(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 512;
        }
        return true;
    }

    private boolean j(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 1024;
        }
        return true;
    }

    private boolean k(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 4;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0662na
    public void a(com.disabngo.blockynexus.view.activity.main.nc ncVar) {
        updateRegistration(5, ncVar);
        this.f8611b = ncVar;
        synchronized (this) {
            this.m |= 32;
        }
        notifyPropertyChanged(301);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0168 A[PHI: r2
      0x0168: PHI (r2v18 long) = (r2v17 long), (r2v19 long) binds: [B:95:0x0137, B:109:0x0163] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:233:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0083 A[PHI: r2
      0x0083: PHI (r2v14 long) = (r2v0 long), (r2v23 long) binds: [B:23:0x0053, B:37:0x007d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0139  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 811
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0673oa.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.m != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.m = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return d((ObservableField) obj, i2);
            case 1:
                return c((ObservableField) obj, i2);
            case 2:
                return k((ObservableField) obj, i2);
            case 3:
                return g((ObservableField) obj, i2);
            case 4:
                return f((ObservableField) obj, i2);
            case 5:
                return a((com.disabngo.blockynexus.view.activity.main.nc) obj, i2);
            case 6:
                return b((ObservableField) obj, i2);
            case 7:
                return a((ObservableField<Boolean>) obj, i2);
            case 8:
                return e((ObservableField) obj, i2);
            case 9:
                return i((ObservableField) obj, i2);
            case 10:
                return j((ObservableField) obj, i2);
            case 11:
                return h((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (301 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.activity.main.nc) obj);
        return true;
    }

    private C0673oa(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 12, (Toolbar) objArr[0]);
        this.m = -1L;
        this.f8645e = (RelativeLayout) objArr[1];
        this.f8645e.setTag(null);
        this.f8646f = (ImageButton) objArr[2];
        this.f8646f.setTag(null);
        this.g = (TextView) objArr[3];
        this.g.setTag(null);
        this.h = (TextView) objArr[4];
        this.h.setTag(null);
        this.i = (ImageButton) objArr[5];
        this.i.setTag(null);
        this.j = (LinearLayout) objArr[6];
        this.j.setTag(null);
        this.k = (TextView) objArr[7];
        this.k.setTag(null);
        this.l = (ImageButton) objArr[8];
        this.l.setTag(null);
        this.f8610a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.activity.main.nc ncVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 32;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 128;
        }
        return true;
    }
}
