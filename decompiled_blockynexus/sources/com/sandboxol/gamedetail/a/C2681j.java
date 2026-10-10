package com.sandboxol.gamedetail.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.gamedetail.R;
import com.sandboxol.gamedetail.c.a.a.ba;
import com.sandboxol.gamedetail.view.widget.MaxLayout;

/* JADX INFO: renamed from: com.sandboxol.gamedetail.a.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogEnterGameGuideBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2681j extends AbstractC2680i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ViewDataBinding.b f17844f = new ViewDataBinding.b(5);
    private static final SparseIntArray g;
    private final RelativeLayout h;
    private final View i;
    private long j;

    static {
        f17844f.a(1, new String[]{"content_game_hall"}, new int[]{4}, new int[]{R.layout.content_game_hall});
        g = null;
    }

    public C2681j(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 5, f17844f, g));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.j |= 4;
        }
        return true;
    }

    @Override // com.sandboxol.gamedetail.a.AbstractC2680i
    public void a(com.sandboxol.gamedetail.view.dialog.d dVar) {
        this.f17842d = dVar;
        synchronized (this) {
            this.j |= 16;
        }
        notifyPropertyChanged(com.sandboxol.gamedetail.a.i);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0081 A[PHI: r2
      0x0081: PHI (r2v5 long) = (r2v4 long), (r2v7 long) binds: [B:33:0x0059, B:47:0x007f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0091  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 211
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.gamedetail.a.C2681j.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.j != 0) {
                return true;
            }
            return this.f17840b.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.j = 32L;
        }
        this.f17840b.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((ba) obj, i2);
        }
        if (i == 1) {
            return a((ObservableField<Integer>) obj, i2);
        }
        if (i == 2) {
            return b((ObservableField) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return a((AbstractC2676e) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(androidx.lifecycle.g gVar) {
        super.setLifecycleOwner(gVar);
        this.f17840b.setLifecycleOwner(gVar);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.gamedetail.a.i == i) {
            a((com.sandboxol.gamedetail.view.dialog.d) obj);
        } else {
            if (com.sandboxol.gamedetail.a.h != i) {
                return false;
            }
            a((ba) obj);
        }
        return true;
    }

    private C2681j(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 4, (LinearLayout) objArr[1], (AbstractC2676e) objArr[4], (MaxLayout) objArr[2]);
        this.j = -1L;
        this.f17839a.setTag(null);
        this.h = (RelativeLayout) objArr[0];
        this.h.setTag(null);
        this.i = (View) objArr[3];
        this.i.setTag(null);
        this.f17841c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // com.sandboxol.gamedetail.a.AbstractC2680i
    public void a(ba baVar) {
        updateRegistration(0, baVar);
        this.f17843e = baVar;
        synchronized (this) {
            this.j |= 1;
        }
        notifyPropertyChanged(com.sandboxol.gamedetail.a.h);
        super.requestRebind();
    }

    private boolean a(ba baVar, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.j |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.j |= 2;
        }
        return true;
    }

    private boolean a(AbstractC2676e abstractC2676e, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.j |= 8;
        }
        return true;
    }
}
