package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.dialog.DialogC1109oa;
import com.sandboxol.center.entity.DressAdsInfo;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: DialogAdsDressRewardBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Ua extends Ta {
    private static final ViewDataBinding.b k = null;
    private static final SparseIntArray l = new SparseIntArray();
    private final ConstraintLayout m;
    private final TextView n;
    private long o;

    static {
        l.put(R.id.ivFlash, 8);
        l.put(R.id.view11, 9);
        l.put(R.id.view12, 10);
    }

    public Ua(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 11, k, l));
    }

    public void a(DialogC1109oa dialogC1109oa) {
        this.j = dialogC1109oa;
        synchronized (this) {
            this.o |= 1;
        }
        notifyPropertyChanged(355);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        String str;
        String str2;
        int i;
        int i2;
        DressAdsInfo dressAdsInfo;
        ReplyCommand replyCommand2;
        long nextQty;
        String addQty;
        long j2;
        long j3;
        synchronized (this) {
            j = this.o;
            this.o = 0L;
        }
        DialogC1109oa dialogC1109oa = this.j;
        long j4 = j & 3;
        ReplyCommand replyCommand3 = null;
        String nextQtyTip = null;
        if (j4 != 0) {
            if (dialogC1109oa != null) {
                dressAdsInfo = dialogC1109oa.f11646a;
                replyCommand2 = dialogC1109oa.f11647b;
                replyCommand = dialogC1109oa.f11648c;
            } else {
                replyCommand = null;
                dressAdsInfo = null;
                replyCommand2 = null;
            }
            if (dressAdsInfo != null) {
                nextQty = dressAdsInfo.getNextQty();
                nextQtyTip = dressAdsInfo.getNextQtyTip();
                addQty = dressAdsInfo.getAddQty();
            } else {
                nextQty = 0;
                addQty = null;
            }
            boolean z = nextQty == 0;
            if (j4 != 0) {
                if (z) {
                    j2 = j | 8;
                    j3 = 32;
                } else {
                    j2 = j | 4;
                    j3 = 16;
                }
                j = j2 | j3;
            }
            i2 = z ? 8 : 0;
            i = z ? 0 : 8;
            String str3 = addQty;
            str = nextQtyTip;
            replyCommand3 = replyCommand2;
            str2 = str3;
        } else {
            replyCommand = null;
            str = null;
            str2 = null;
            i = 0;
            i2 = 0;
        }
        if ((j & 3) != 0) {
            this.f7887a.setVisibility(i2);
            ViewBindingAdapters.clickCommand(this.f7887a, replyCommand3, false, 0);
            this.f7888b.setVisibility(i);
            ViewBindingAdapters.clickCommand(this.f7888b, replyCommand, false, 0);
            this.n.setVisibility(i2);
            androidx.databinding.a.e.a(this.n, str);
            androidx.databinding.a.e.a(this.f7890d, str);
            this.f7891e.setVisibility(i2);
            ViewBindingAdapters.clickCommand(this.f7891e, replyCommand, false, 0);
            androidx.databinding.a.e.a(this.f7892f, str2);
            this.g.setVisibility(i2);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.o != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.o = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (355 != i) {
            return false;
        }
        a((DialogC1109oa) obj);
        return true;
    }

    private Ua(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (Button) objArr[2], (Button) objArr[3], (ImageView) objArr[8], (TextView) objArr[6], (TextView) objArr[7], (TextView) objArr[1], (TextView) objArr[4], (View) objArr[9], (View) objArr[10]);
        this.o = -1L;
        this.f7887a.setTag(null);
        this.f7888b.setTag(null);
        this.m = (ConstraintLayout) objArr[0];
        this.m.setTag(null);
        this.n = (TextView) objArr[5];
        this.n.setTag(null);
        this.f7890d.setTag(null);
        this.f7891e.setTag(null);
        this.f7892f.setTag(null);
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
