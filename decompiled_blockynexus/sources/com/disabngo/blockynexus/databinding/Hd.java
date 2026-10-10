package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;

/* JADX INFO: compiled from: FragmentDiskSpaceBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Hd extends Gd {
    private static final SparseIntArray A = new SparseIntArray();
    private static final ViewDataBinding.b z = null;
    private final ConstraintLayout B;
    private final ImageView C;
    private final Button D;
    private final TextView E;
    private final ImageView F;
    private final ImageView G;
    private long H;

    static {
        A.put(R.id.v_flag_1, 17);
        A.put(R.id.tv_app_used_space, 18);
        A.put(R.id.v_flag_2, 19);
        A.put(R.id.tv_disk_used_space, 20);
        A.put(R.id.v_flag_3, 21);
        A.put(R.id.v_line, 22);
        A.put(R.id.tv_app_used_space_tip, 23);
        A.put(R.id.tv_app_disk_space_game_res_title, 24);
        A.put(R.id.tv_app_disk_space_game_res_content, 25);
        A.put(R.id.tv_app_disk_space_game_res_icon, 26);
        A.put(R.id.tv_app_disk_space_game_cache_title, 27);
        A.put(R.id.tv_app_disk_space_game_cache_content, 28);
        A.put(R.id.tv_app_disk_space_game_cache_icon, 29);
    }

    public Hd(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 30, z, A));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H |= 512;
        }
        return true;
    }

    private boolean c(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H |= 64;
        }
        return true;
    }

    private boolean d(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H |= 4;
        }
        return true;
    }

    private boolean e(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H |= 256;
        }
        return true;
    }

    private boolean f(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H |= 16;
        }
        return true;
    }

    private boolean g(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H |= 32;
        }
        return true;
    }

    private boolean h(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H |= 1;
        }
        return true;
    }

    private boolean i(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H |= 8;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.Gd
    public void a(com.disabngo.blockynexus.e.b.r.v vVar) {
        updateRegistration(7, vVar);
        this.y = vVar;
        synchronized (this) {
            this.H |= 128;
        }
        notifyPropertyChanged(306);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0156  */
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
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Hd.executeBindings():void");
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
            this.H = 1024L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return h((ObservableField) obj, i2);
            case 1:
                return a((ObservableField<String>) obj, i2);
            case 2:
                return d((ObservableField) obj, i2);
            case 3:
                return i((ObservableField) obj, i2);
            case 4:
                return f((ObservableField) obj, i2);
            case 5:
                return g((ObservableField) obj, i2);
            case 6:
                return c((ObservableField) obj, i2);
            case 7:
                return a((com.disabngo.blockynexus.e.b.r.v) obj, i2);
            case 8:
                return e((ObservableField) obj, i2);
            case 9:
                return b((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (306 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.r.v) obj);
        return true;
    }

    private Hd(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 10, (ImageView) objArr[15], (ConstraintLayout) objArr[10], (ConstraintLayout) objArr[7], (ProgressBar) objArr[4], (ProgressBar) objArr[3], (TextView) objArr[12], (TextView) objArr[28], (ImageView) objArr[29], (TextView) objArr[27], (TextView) objArr[11], (TextView) objArr[25], (ImageView) objArr[26], (TextView) objArr[24], (TextView) objArr[8], (TextView) objArr[18], (TextView) objArr[23], (TextView) objArr[5], (TextView) objArr[20], (TextView) objArr[2], (View) objArr[17], (View) objArr[19], (View) objArr[21], (View) objArr[22], (ConstraintLayout) objArr[1]);
        this.H = -1L;
        this.f7488a.setTag(null);
        this.f7489b.setTag(null);
        this.f7490c.setTag(null);
        this.B = (ConstraintLayout) objArr[0];
        this.B.setTag(null);
        this.C = (ImageView) objArr[13];
        this.C.setTag(null);
        this.D = (Button) objArr[14];
        this.D.setTag(null);
        this.E = (TextView) objArr[16];
        this.E.setTag(null);
        this.F = (ImageView) objArr[6];
        this.F.setTag(null);
        this.G = (ImageView) objArr[9];
        this.G.setTag(null);
        this.f7491d.setTag(null);
        this.f7492e.setTag(null);
        this.f7493f.setTag(null);
        this.j.setTag(null);
        this.n.setTag(null);
        this.q.setTag(null);
        this.s.setTag(null);
        this.x.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H |= 2;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.r.v vVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H |= 128;
        }
        return true;
    }
}
