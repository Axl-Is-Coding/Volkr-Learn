package com.sandboxol.game.a;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.ProductEntity;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: ItemRechargeShopBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class F extends E {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f17647d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f17648e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RelativeLayout f17649f;
    private final TextView g;
    private final TextView h;
    private final TextView i;
    private final Button j;
    private final TextView k;
    private long l;

    public F(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 8, f17647d, f17648e));
    }

    public void a(com.sandboxol.recharge.dialog.rechargeshop.l lVar) {
        updateRegistration(1, lVar);
        this.f17646c = lVar;
        synchronized (this) {
            this.l |= 2;
        }
        notifyPropertyChanged(com.sandboxol.game.a.f17627b);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        ReplyCommand replyCommand;
        String str5;
        int i;
        boolean z;
        int i2;
        long j2;
        int i3;
        int i4;
        String strValueOf;
        String addGift;
        String depreciateString;
        String strValueOf2;
        int i5;
        int iA;
        String resourcePic;
        String stringPrice;
        int diamonds;
        synchronized (this) {
            j = this.l;
            this.l = 0L;
        }
        com.sandboxol.recharge.dialog.rechargeshop.l lVar = this.f17646c;
        if ((j & 30) != 0) {
            ProductEntity item = lVar != null ? lVar.getItem() : null;
            long j3 = j & 26;
            if (j3 != 0) {
                if (item != null) {
                    diamonds = item.getDiamonds();
                    addGift = item.getAddGift();
                    depreciateString = item.getDepreciateString();
                    resourcePic = item.getResourcePic();
                    stringPrice = item.getStringPrice();
                } else {
                    addGift = null;
                    depreciateString = null;
                    resourcePic = null;
                    stringPrice = null;
                    diamonds = 0;
                }
                strValueOf = String.valueOf(diamonds);
                boolean zIsEmpty = TextUtils.isEmpty(depreciateString);
                iA = b.h.c.b.a.a(resourcePic);
                strValueOf2 = String.valueOf(stringPrice);
                if (j3 != 0) {
                    j |= zIsEmpty ? 256L : 128L;
                }
                i5 = zIsEmpty ? 8 : 0;
            } else {
                strValueOf = null;
                addGift = null;
                depreciateString = null;
                strValueOf2 = null;
                i5 = 0;
                iA = 0;
            }
            int gift = item != null ? item.getGift() : 0;
            String strValueOf3 = (j & 26) != 0 ? String.valueOf(gift) : null;
            boolean z2 = gift == 0;
            if ((j & 30) != 0) {
                j = z2 ? j | 64 : j | 32;
            }
            if ((j & 18) == 0 || lVar == null) {
                str3 = strValueOf;
                replyCommand = null;
            } else {
                replyCommand = lVar.f18877a;
                str3 = strValueOf;
            }
            i = i5;
            str2 = addGift;
            str5 = depreciateString;
            i2 = iA;
            str4 = strValueOf2;
            String str6 = strValueOf3;
            z = z2;
            str = str6;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            replyCommand = null;
            str5 = null;
            i = 0;
            z = false;
            i2 = 0;
        }
        long j4 = 32 & j;
        if (j4 != 0) {
            ObservableField<Integer> observableField = AccountCenter.newInstance().vip;
            updateRegistration(2, observableField);
            boolean z3 = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null) == 0;
            if (j4 != 0) {
                j |= z3 ? 1024L : 512L;
            }
            i3 = z3 ? 8 : 0;
            j2 = 30;
        } else {
            j2 = 30;
            i3 = 0;
        }
        long j5 = j2 & j;
        if (j5 != 0) {
            i4 = z ? 8 : i3;
        } else {
            i4 = 0;
        }
        if ((j & 26) != 0) {
            ImageViewBindingAdapters.loadImage(this.f17644a, 0, null, i2, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
            androidx.databinding.a.e.a(this.g, str);
            androidx.databinding.a.e.a(this.h, str3);
            androidx.databinding.a.e.a(this.i, str2);
            androidx.databinding.a.e.a(this.j, str4);
            androidx.databinding.a.e.a(this.k, str5);
            this.k.setVisibility(i);
        }
        if (j5 != 0) {
            this.f17645b.setVisibility(i4);
            this.i.setVisibility(i4);
        }
        if ((j & 18) != 0) {
            ViewBindingAdapters.clickCommand(this.j, replyCommand, false, 0);
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
            this.l = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((AccountCenter) obj, i2);
        }
        if (i == 1) {
            return a((com.sandboxol.recharge.dialog.rechargeshop.l) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return a((ObservableField<Integer>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.game.a.f17627b != i) {
            return false;
        }
        a((com.sandboxol.recharge.dialog.rechargeshop.l) obj);
        return true;
    }

    private F(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (ImageView) objArr[3], (LinearLayout) objArr[1]);
        this.l = -1L;
        this.f17644a.setTag(null);
        this.f17645b.setTag(null);
        this.f17649f = (RelativeLayout) objArr[0];
        this.f17649f.setTag(null);
        this.g = (TextView) objArr[2];
        this.g.setTag(null);
        this.h = (TextView) objArr[4];
        this.h.setTag(null);
        this.i = (TextView) objArr[5];
        this.i.setTag(null);
        this.j = (Button) objArr[6];
        this.j.setTag(null);
        this.k = (TextView) objArr[7];
        this.k.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(AccountCenter accountCenter, int i) {
        if (i != com.sandboxol.game.a.f17626a) {
            return false;
        }
        synchronized (this) {
            this.l |= 1;
        }
        return true;
    }

    private boolean a(com.sandboxol.recharge.dialog.rechargeshop.l lVar, int i) {
        if (i == com.sandboxol.game.a.f17626a) {
            synchronized (this) {
                this.l |= 2;
            }
            return true;
        }
        if (i != com.sandboxol.game.a.m) {
            return false;
        }
        synchronized (this) {
            this.l |= 8;
        }
        return true;
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.game.a.f17626a) {
            return false;
        }
        synchronized (this) {
            this.l |= 4;
        }
        return true;
    }
}
