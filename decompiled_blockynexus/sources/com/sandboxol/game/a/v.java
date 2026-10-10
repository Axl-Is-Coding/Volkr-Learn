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
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.ScrapTreasureBoxInfo;
import com.sandboxol.center.view.widget.ScrapLevelImageView;
import com.sandboxol.game.R;

/* JADX INFO: compiled from: DialogScrapBoxWeekendBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class v extends u {
    private static final ViewDataBinding.b J = null;
    private static final SparseIntArray K = new SparseIntArray();
    private final ConstraintLayout L;
    private final ImageView M;
    private final TextView N;
    private final TextView O;
    private final TextView P;
    private final TextView Q;
    private final TextView R;
    private final TextView S;
    private final TextView T;
    private final TextView U;
    private final TextView V;
    private long W;
    private long X;

    static {
        K.put(R.id.v_bg, 38);
        K.put(R.id.tv_title, 39);
        K.put(R.id.tv_reward_value, 40);
        K.put(R.id.gl_horizontal_289, 41);
        K.put(R.id.gl_horizontal_625, 42);
        K.put(R.id.gl_vertical_269, 43);
        K.put(R.id.gl_vertical_5, 44);
    }

    public v(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 45, J, K));
    }

    private boolean b(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.game.a.f17626a) {
            return false;
        }
        synchronized (this) {
            this.W |= 2;
        }
        return true;
    }

    private boolean c(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.game.a.f17626a) {
            return false;
        }
        synchronized (this) {
            this.W |= 1;
        }
        return true;
    }

    private boolean d(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.game.a.f17626a) {
            return false;
        }
        synchronized (this) {
            this.W |= 64;
        }
        return true;
    }

    private boolean e(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.game.a.f17626a) {
            return false;
        }
        synchronized (this) {
            this.W |= 32;
        }
        return true;
    }

    @Override // com.sandboxol.game.a.u
    public void a(ScrapBoxDialog scrapBoxDialog) {
        this.I = scrapBoxDialog;
        synchronized (this) {
            this.W |= 256;
        }
        notifyPropertyChanged(com.sandboxol.game.a.h);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:222:0x04cc  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x05b3  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x05f7  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0604  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x067c  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0834  */
    /* JADX WARN: Removed duplicated region for block: B:475:0x0ad5  */
    /* JADX WARN: Removed duplicated region for block: B:527:0x0b6a  */
    /* JADX WARN: Removed duplicated region for block: B:530:0x0b89  */
    /* JADX WARN: Removed duplicated region for block: B:567:0x0c40  */
    /* JADX WARN: Removed duplicated region for block: B:570:0x0c6d  */
    /* JADX WARN: Removed duplicated region for block: B:579:0x0c9c  */
    /* JADX WARN: Removed duplicated region for block: B:582:0x0caf  */
    /* JADX WARN: Removed duplicated region for block: B:591:0x0cdb  */
    /* JADX WARN: Removed duplicated region for block: B:596:0x0cf1  */
    /* JADX WARN: Removed duplicated region for block: B:601:0x0d06  */
    /* JADX WARN: Removed duplicated region for block: B:604:0x0d15  */
    /* JADX WARN: Removed duplicated region for block: B:621:0x0d67  */
    /* JADX WARN: Removed duplicated region for block: B:633:0x0d98  */
    /* JADX WARN: Removed duplicated region for block: B:636:0x0da3  */
    /* JADX WARN: Removed duplicated region for block: B:645:0x0db8  */
    /* JADX WARN: Removed duplicated region for block: B:648:0x0dc6  */
    /* JADX WARN: Removed duplicated region for block: B:651:0x0ed6  */
    /* JADX WARN: Removed duplicated region for block: B:652:0x0f62  */
    /* JADX WARN: Removed duplicated region for block: B:655:0x0f6d  */
    /* JADX WARN: Removed duplicated region for block: B:658:0x0fad  */
    /* JADX WARN: Removed duplicated region for block: B:661:0x0fc0  */
    /* JADX WARN: Removed duplicated region for block: B:664:0x109a  */
    /* JADX WARN: Removed duplicated region for block: B:667:0x10ab  */
    /* JADX WARN: Removed duplicated region for block: B:670:0x10ba  */
    /* JADX WARN: Removed duplicated region for block: B:673:0x10c7  */
    /* JADX WARN: Removed duplicated region for block: B:682:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 4308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.game.a.v.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.W == 0 && this.X == 0) {
                return false;
            }
            return true;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.W = 512L;
            this.X = 0L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return c((ObservableField) obj, i2);
            case 1:
                return b((ObservableField<Integer>) obj, i2);
            case 2:
                return b((ObservableList<Integer>) obj, i2);
            case 3:
                return a((ObservableField<Integer>) obj, i2);
            case 4:
                return a((AccountCenter) obj, i2);
            case 5:
                return e((ObservableField) obj, i2);
            case 6:
                return d((ObservableField) obj, i2);
            case 7:
                return a((ObservableList<ScrapTreasureBoxInfo>) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.game.a.h != i) {
            return false;
        }
        a((ScrapBoxDialog) obj);
        return true;
    }

    private v(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 8, (Guideline) objArr[41], (Guideline) objArr[42], (Guideline) objArr[43], (Guideline) objArr[44], (ScrapLevelImageView) objArr[5], (ScrapLevelImageView) objArr[9], (ScrapLevelImageView) objArr[6], (ScrapLevelImageView) objArr[10], (ScrapLevelImageView) objArr[7], (ScrapLevelImageView) objArr[11], (ScrapLevelImageView) objArr[8], (ScrapLevelImageView) objArr[12], (ImageView) objArr[22], (ImageView) objArr[23], (ImageView) objArr[24], (ImageView) objArr[25], (ImageView) objArr[26], (ImageView) objArr[27], (ImageView) objArr[28], (ImageView) objArr[29], (ProgressBar) objArr[13], (ProgressBar) objArr[14], (ProgressBar) objArr[15], (ProgressBar) objArr[16], (ProgressBar) objArr[17], (ProgressBar) objArr[18], (ProgressBar) objArr[19], (ProgressBar) objArr[20], (ProgressBar) objArr[21], (TextView) objArr[4], (TextView) objArr[40], (TextView) objArr[3], (TextView) objArr[39], (View) objArr[38]);
        this.W = -1L;
        this.X = -1L;
        this.f17724e.setTag(null);
        this.f17725f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        this.l.setTag(null);
        this.m.setTag(null);
        this.n.setTag(null);
        this.o.setTag(null);
        this.p.setTag(null);
        this.q.setTag(null);
        this.r.setTag(null);
        this.s.setTag(null);
        this.t.setTag(null);
        this.L = (ConstraintLayout) objArr[0];
        this.L.setTag(null);
        this.M = (ImageView) objArr[1];
        this.M.setTag(null);
        this.N = (TextView) objArr[2];
        this.N.setTag(null);
        this.O = (TextView) objArr[30];
        this.O.setTag(null);
        this.P = (TextView) objArr[31];
        this.P.setTag(null);
        this.Q = (TextView) objArr[32];
        this.Q.setTag(null);
        this.R = (TextView) objArr[33];
        this.R.setTag(null);
        this.S = (TextView) objArr[34];
        this.S.setTag(null);
        this.T = (TextView) objArr[35];
        this.T.setTag(null);
        this.U = (TextView) objArr[36];
        this.U.setTag(null);
        this.V = (TextView) objArr[37];
        this.V.setTag(null);
        this.u.setTag(null);
        this.v.setTag(null);
        this.w.setTag(null);
        this.x.setTag(null);
        this.y.setTag(null);
        this.z.setTag(null);
        this.A.setTag(null);
        this.B.setTag(null);
        this.C.setTag(null);
        this.D.setTag(null);
        this.F.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean b(ObservableList<Integer> observableList, int i) {
        if (i != com.sandboxol.game.a.f17626a) {
            return false;
        }
        synchronized (this) {
            this.W |= 4;
        }
        return true;
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.game.a.f17626a) {
            return false;
        }
        synchronized (this) {
            this.W |= 8;
        }
        return true;
    }

    private boolean a(AccountCenter accountCenter, int i) {
        if (i != com.sandboxol.game.a.f17626a) {
            return false;
        }
        synchronized (this) {
            this.W |= 16;
        }
        return true;
    }

    private boolean a(ObservableList<ScrapTreasureBoxInfo> observableList, int i) {
        if (i != com.sandboxol.game.a.f17626a) {
            return false;
        }
        synchronized (this) {
            this.W |= 128;
        }
        return true;
    }
}
