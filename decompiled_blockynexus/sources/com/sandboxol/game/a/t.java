package com.sandboxol.game.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.blocky.dialog.ScrapBoxDialog;
import com.sandboxol.center.entity.ScrapTreasureBoxInfo;
import com.sandboxol.center.view.widget.ScrapLevelImageView;
import com.sandboxol.game.R;

/* JADX INFO: compiled from: DialogScrapBoxBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class t extends s {
    private static final ViewDataBinding.b B = null;
    private static final SparseIntArray C = new SparseIntArray();
    private final ConstraintLayout D;
    private final ImageView E;
    private final TextView F;
    private final TextView G;
    private final TextView H;
    private final TextView I;
    private final TextView J;
    private final TextView K;
    private long L;

    static {
        C.put(R.id.v_bg, 26);
        C.put(R.id.tv_title, 27);
        C.put(R.id.tv_reward_value, 28);
        C.put(R.id.gl_horizontal_289, 29);
        C.put(R.id.gl_horizontal_625, 30);
        C.put(R.id.gl_vertical_269, 31);
        C.put(R.id.gl_vertical_5, 32);
        C.put(R.id.gl_vertical_7625, 33);
    }

    public t(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 34, B, C));
    }

    private boolean b(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.game.a.f17626a) {
            return false;
        }
        synchronized (this) {
            this.L |= 1;
        }
        return true;
    }

    private boolean c(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.game.a.f17626a) {
            return false;
        }
        synchronized (this) {
            this.L |= 16;
        }
        return true;
    }

    private boolean d(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.game.a.f17626a) {
            return false;
        }
        synchronized (this) {
            this.L |= 4;
        }
        return true;
    }

    @Override // com.sandboxol.game.a.s
    public void a(ScrapBoxDialog scrapBoxDialog) {
        this.A = scrapBoxDialog;
        synchronized (this) {
            this.L |= 64;
        }
        notifyPropertyChanged(com.sandboxol.game.a.h);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:165:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0476  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x04e3  */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v7 */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 2275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.game.a.t.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.L != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.L = 128L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return b((ObservableField<Integer>) obj, i2);
        }
        if (i == 1) {
            return a((ObservableField<Integer>) obj, i2);
        }
        if (i == 2) {
            return d((ObservableField) obj, i2);
        }
        if (i == 3) {
            return b((ObservableList<Integer>) obj, i2);
        }
        if (i == 4) {
            return c((ObservableField) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return a((ObservableList<ScrapTreasureBoxInfo>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.game.a.h != i) {
            return false;
        }
        a((ScrapBoxDialog) obj);
        return true;
    }

    private t(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 6, (Guideline) objArr[29], (Guideline) objArr[30], (Guideline) objArr[31], (Guideline) objArr[32], (Guideline) objArr[33], (ScrapLevelImageView) objArr[5], (ScrapLevelImageView) objArr[6], (ScrapLevelImageView) objArr[7], (ScrapLevelImageView) objArr[8], (ScrapLevelImageView) objArr[9], (ImageView) objArr[16], (ImageView) objArr[17], (ImageView) objArr[18], (ImageView) objArr[19], (ImageView) objArr[20], (ProgressBar) objArr[10], (ProgressBar) objArr[11], (ProgressBar) objArr[12], (ProgressBar) objArr[13], (ProgressBar) objArr[14], (ProgressBar) objArr[15], (TextView) objArr[4], (TextView) objArr[28], (TextView) objArr[3], (TextView) objArr[27], (View) objArr[26]);
        this.L = -1L;
        this.f17719f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        this.l.setTag(null);
        this.m.setTag(null);
        this.n.setTag(null);
        this.o.setTag(null);
        this.D = (ConstraintLayout) objArr[0];
        this.D.setTag(null);
        this.E = (ImageView) objArr[1];
        this.E.setTag(null);
        this.F = (TextView) objArr[2];
        this.F.setTag(null);
        this.G = (TextView) objArr[21];
        this.G.setTag(null);
        this.H = (TextView) objArr[22];
        this.H.setTag(null);
        this.I = (TextView) objArr[23];
        this.I.setTag(null);
        this.J = (TextView) objArr[24];
        this.J.setTag(null);
        this.K = (TextView) objArr[25];
        this.K.setTag(null);
        this.p.setTag(null);
        this.q.setTag(null);
        this.r.setTag(null);
        this.s.setTag(null);
        this.t.setTag(null);
        this.u.setTag(null);
        this.v.setTag(null);
        this.x.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean b(ObservableList<Integer> observableList, int i) {
        if (i != com.sandboxol.game.a.f17626a) {
            return false;
        }
        synchronized (this) {
            this.L |= 8;
        }
        return true;
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.game.a.f17626a) {
            return false;
        }
        synchronized (this) {
            this.L |= 2;
        }
        return true;
    }

    private boolean a(ObservableList<ScrapTreasureBoxInfo> observableList, int i) {
        if (i != com.sandboxol.game.a.f17626a) {
            return false;
        }
        synchronized (this) {
            this.L |= 32;
        }
        return true;
    }
}
