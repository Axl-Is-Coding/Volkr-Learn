package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.view.widget.ScrapLevelImageView;
import com.sandboxol.common.widget.rv.pagerv.PageRecyclerView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.uc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogScrapRequestBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0740uc extends AbstractC0729tc {
    private static final ViewDataBinding.b m = null;
    private static final SparseIntArray n = new SparseIntArray();
    private final ConstraintLayout o;
    private final PageRecyclerView p;
    private final TextView q;
    private long r;

    static {
        n.put(R.id.bg_main, 8);
        n.put(R.id.tv_scrap_name, 9);
        n.put(R.id.bg_tips, 10);
        n.put(R.id.tv_tips_1, 11);
        n.put(R.id.bg_friend_list, 12);
        n.put(R.id.tv_tips_3, 13);
    }

    public C0740uc(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 14, m, n));
    }

    private boolean b(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.r |= 2;
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
            this.r |= 1;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0729tc
    public void a(com.disabngo.blockynexus.view.dialog.g.e eVar) {
        this.l = eVar;
        synchronized (this) {
            this.r |= 16;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:176:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x011c  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 635
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0740uc.executeBindings():void");
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
            this.r = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return d((ObservableField) obj, i2);
        }
        if (i == 1) {
            return b((ObservableField) obj, i2);
        }
        if (i == 2) {
            return a((ObservableField) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return c((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.g.e) obj);
        return true;
    }

    private C0740uc(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 4, (View) objArr[12], (View) objArr[8], (View) objArr[10], (Button) objArr[3], (Button) objArr[4], (ImageView) objArr[7], (ScrapLevelImageView) objArr[1], (TextView) objArr[9], (TextView) objArr[11], (TextView) objArr[2], (TextView) objArr[13]);
        this.r = -1L;
        this.f8824d.setTag(null);
        this.f8825e.setTag(null);
        this.f8826f.setTag(null);
        this.g.setTag(null);
        this.o = (ConstraintLayout) objArr[0];
        this.o.setTag(null);
        this.p = (PageRecyclerView) objArr[5];
        this.p.setTag(null);
        this.q = (TextView) objArr[6];
        this.q.setTag(null);
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Long> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.r |= 4;
        }
        return true;
    }
}
