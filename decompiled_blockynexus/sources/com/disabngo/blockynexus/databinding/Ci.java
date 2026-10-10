package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.greendao.entity.RankInfoResponse;

/* JADX INFO: compiled from: ItemRankDetailContentBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Ci extends Bi {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f7356c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f7357d = new SparseIntArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConstraintLayout f7358e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f7359f;
    private final ConstraintLayout g;
    private final ImageView h;
    private final TextView i;
    private final TextView j;
    private long k;

    static {
        f7357d.put(R.id.ll_item, 6);
    }

    public Ci(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, f7356c, f7357d));
    }

    public void a(com.disabngo.blockynexus.e.b.W.b bVar) {
        updateRegistration(0, bVar);
        this.f7323b = bVar;
        synchronized (this) {
            this.k |= 1;
        }
        notifyPropertyChanged(361);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        ReplyCommand replyCommand;
        String strValueOf;
        String str2;
        int i;
        long quantity;
        long rank;
        String pic;
        synchronized (this) {
            j = this.k;
            this.k = 0L;
        }
        com.disabngo.blockynexus.e.b.W.b bVar = this.f7323b;
        long j2 = j & 7;
        String str3 = null;
        if (j2 != 0) {
            replyCommand = ((j & 5) == 0 || bVar == null) ? null : bVar.f9504a;
            RankInfoResponse item = bVar != null ? bVar.getItem() : null;
            if (item != null) {
                String name = item.getName();
                quantity = item.getQuantity();
                String rankType = item.getRankType();
                pic = item.getPic();
                rank = item.getRank();
                str = name;
                str3 = rankType;
            } else {
                quantity = 0;
                rank = 0;
                str = null;
                pic = null;
            }
            strValueOf = String.valueOf(quantity);
            String strValueOf2 = String.valueOf(rank);
            boolean zEquals = str3 != null ? str3.equals("clan") : false;
            if (j2 != 0) {
                j |= zEquals ? 16L : 8L;
            }
            i = zEquals ? R.mipmap.ic_tribe_default_head : R.mipmap.ic_head_default;
            str3 = strValueOf2;
            str2 = pic;
        } else {
            str = null;
            replyCommand = null;
            strValueOf = null;
            str2 = null;
            i = 0;
        }
        if ((7 & j) != 0) {
            androidx.databinding.a.e.a(this.f7359f, str3);
            ImageViewBindingAdapters.loadImage(this.h, 0, str2, i, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
            androidx.databinding.a.e.a(this.i, str);
            androidx.databinding.a.e.a(this.j, strValueOf);
        }
        if ((j & 5) != 0) {
            ViewBindingAdapters.clickCommand(this.g, replyCommand, false, 0);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.k != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.k = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.W.b) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (361 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.W.b) obj);
        return true;
    }

    private Ci(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (LinearLayout) objArr[6]);
        this.k = -1L;
        this.f7358e = (ConstraintLayout) objArr[0];
        this.f7358e.setTag(null);
        this.f7359f = (TextView) objArr[1];
        this.f7359f.setTag(null);
        this.g = (ConstraintLayout) objArr[2];
        this.g.setTag(null);
        this.h = (ImageView) objArr[3];
        this.h.setTag(null);
        this.i = (TextView) objArr[4];
        this.i.setTag(null);
        this.j = (TextView) objArr[5];
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.W.b bVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.k |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.k |= 2;
        }
        return true;
    }
}
