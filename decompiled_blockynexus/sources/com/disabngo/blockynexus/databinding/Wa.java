package com.disabngo.blockynexus.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.dialog.DialogC1111pa;
import com.sandboxol.center.entity.DailySignInfo;
import com.sandboxol.center.utils.ViewReturnTextUtils;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: DialogAdsRewardBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Wa extends Va {
    private static final ViewDataBinding.b i = null;
    private static final SparseIntArray j = new SparseIntArray();
    private final TextView k;
    private long l;

    static {
        j.put(R.id.ivFlash, 5);
        j.put(R.id.ll_reward, 6);
        j.put(R.id.view15, 7);
    }

    public Wa(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 8, i, j));
    }

    @Override // com.disabngo.blockynexus.databinding.Va
    public void a(DialogC1111pa dialogC1111pa) {
        this.h = dialogC1111pa;
        synchronized (this) {
            this.l |= 2;
        }
        notifyPropertyChanged(469);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j2;
        Drawable drawable;
        ReplyCommand replyCommand;
        String strValueOf;
        int i2;
        ReplyCommand replyCommand2;
        DailySignInfo dailySignInfo;
        long adAndSignQuantity;
        synchronized (this) {
            j2 = this.l;
            this.l = 0L;
        }
        DialogC1111pa dialogC1111pa = this.h;
        long j3 = j2 & 7;
        ReplyCommand replyCommand3 = null;
        String adType = null;
        replyCommand3 = null;
        if (j3 != 0) {
            ObservableField<Boolean> observableField = dialogC1111pa != null ? dialogC1111pa.f11652c : null;
            updateRegistration(0, observableField);
            boolean zSafeUnbox = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
            if (j3 != 0) {
                j2 |= zSafeUnbox ? 16L : 8L;
            }
            i2 = zSafeUnbox ? 0 : 4;
            if ((j2 & 6) != 0) {
                if (dialogC1111pa != null) {
                    replyCommand = dialogC1111pa.f11655f;
                    dailySignInfo = dialogC1111pa.f11650a;
                    replyCommand2 = dialogC1111pa.f11654e;
                } else {
                    replyCommand2 = null;
                    replyCommand = null;
                    dailySignInfo = null;
                }
                if (dailySignInfo != null) {
                    adAndSignQuantity = dailySignInfo.getAdAndSignQuantity();
                    adType = dailySignInfo.getAdType();
                } else {
                    adAndSignQuantity = 0;
                }
                strValueOf = String.valueOf(adAndSignQuantity);
                Drawable drawableAdsRewardType = ViewReturnTextUtils.adsRewardType(adType);
                replyCommand3 = replyCommand2;
                drawable = drawableAdsRewardType;
            } else {
                drawable = null;
                replyCommand = null;
                strValueOf = null;
            }
        } else {
            drawable = null;
            replyCommand = null;
            strValueOf = null;
            i2 = 0;
        }
        if ((6 & j2) != 0) {
            ViewBindingAdapters.clickCommand(this.f7952b, replyCommand3, false, 0);
            ViewBindingAdapters.clickCommand(this.f7954d, replyCommand, false, 0);
            androidx.databinding.a.e.a(this.f7955e, strValueOf);
            androidx.databinding.a.f.a(this.g, drawable);
        }
        if ((j2 & 7) != 0) {
            this.k.setVisibility(i2);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.l != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.l = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return a((ObservableField) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, Object obj) {
        if (469 != i2) {
            return false;
        }
        a((DialogC1111pa) obj);
        return true;
    }

    private Wa(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (ImageView) objArr[5], (ConstraintLayout) objArr[1], (ImageView) objArr[6], (RelativeLayout) objArr[0], (TextView) objArr[2], (View) objArr[7], (View) objArr[3]);
        this.l = -1L;
        this.f7952b.setTag(null);
        this.k = (TextView) objArr[4];
        this.k.setTag(null);
        this.f7954d.setTag(null);
        this.f7955e.setTag(null);
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Boolean> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 1;
        }
        return true;
    }
}
