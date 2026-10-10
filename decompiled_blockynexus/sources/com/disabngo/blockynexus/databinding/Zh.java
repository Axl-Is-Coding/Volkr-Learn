package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.widget.ScaleRelativeLayout;
import com.sandboxol.center.view.widget.DownloadCircleView;

/* JADX INFO: compiled from: ItemLatelyPlayItemNewViewBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Zh extends Yh {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f8107d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f8108e = new SparseIntArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ScaleRelativeLayout f8109f;
    private final ImageView g;
    private final DownloadCircleView h;
    private final ImageView i;
    private long j;

    static {
        f8108e.put(R.id.img, 5);
    }

    public Zh(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, f8107d, f8108e));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 8;
        }
        return true;
    }

    private boolean c(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 16;
        }
        return true;
    }

    private boolean d(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 4;
        }
        return true;
    }

    private boolean e(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 64;
        }
        return true;
    }

    public void a(com.disabngo.blockynexus.e.b.N.c cVar) {
        updateRegistration(5, cVar);
        this.f8071c = cVar;
        synchronized (this) {
            this.j |= 32;
        }
        notifyPropertyChanged(368);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0061 A[PHI: r2
      0x0061: PHI (r2v3 long) = (r2v0 long), (r2v7 long) binds: [B:13:0x0035, B:27:0x005c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x010c  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 508
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Zh.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.j != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.j = 256L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return a((ObservableList<String>) obj, i2);
            case 1:
                return a((ObservableField<Boolean>) obj, i2);
            case 2:
                return d((ObservableField) obj, i2);
            case 3:
                return b((ObservableField) obj, i2);
            case 4:
                return c((ObservableField) obj, i2);
            case 5:
                return a((com.disabngo.blockynexus.e.b.N.c) obj, i2);
            case 6:
                return e((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (368 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.N.c) obj);
        return true;
    }

    private Zh(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 7, (RelativeLayout) objArr[5], (TextView) objArr[3]);
        this.j = -1L;
        this.f8070b.setTag(null);
        this.f8109f = (ScaleRelativeLayout) objArr[0];
        this.f8109f.setTag(null);
        this.g = (ImageView) objArr[1];
        this.g.setTag(null);
        this.h = (DownloadCircleView) objArr[2];
        this.h.setTag(null);
        this.i = (ImageView) objArr[4];
        this.i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableList<String> observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 2;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.N.c cVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.j |= 32;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.j |= 128;
        }
        return true;
    }
}
