package com.sandboxol.game.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.ProductEntity;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.StrokeTextView;
import com.sandboxol.game.R;

/* JADX INFO: renamed from: com.sandboxol.game.a.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogRechargeDetailBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2669h extends AbstractC2668g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f17682e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f17683f = new SparseIntArray();
    private final RelativeLayout g;
    private final ImageView h;
    private final TextView i;
    private final TextView j;
    private final TextView k;
    private long l;

    static {
        f17683f.put(R.id.tvTitle, 6);
        f17683f.put(R.id.llAccount, 7);
    }

    public C2669h(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 8, f17682e, f17683f));
    }

    @Override // com.sandboxol.game.a.AbstractC2668g
    public void a(b.h.c.a.a.c cVar) {
        this.f17681d = cVar;
        synchronized (this) {
            this.l |= 4;
        }
        notifyPropertyChanged(com.sandboxol.game.a.f17630e);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        ReplyCommand replyCommand2;
        String stringPrice;
        String strValueOf;
        ProductEntity productEntity;
        int diamonds;
        synchronized (this) {
            j = this.l;
            this.l = 0L;
        }
        b.h.c.a.a.c cVar = this.f17681d;
        long j2 = 12 & j;
        String str = null;
        if (j2 != 0) {
            if (cVar != null) {
                replyCommand2 = cVar.f2815d;
                productEntity = cVar.f2812a;
                replyCommand = cVar.f2814c;
            } else {
                replyCommand = null;
                replyCommand2 = null;
                productEntity = null;
            }
            if (productEntity != null) {
                diamonds = productEntity.getDiamonds();
                stringPrice = productEntity.getStringPrice();
            } else {
                stringPrice = null;
                diamonds = 0;
            }
            strValueOf = String.valueOf(diamonds);
        } else {
            replyCommand = null;
            replyCommand2 = null;
            stringPrice = null;
            strValueOf = null;
        }
        long j3 = j & 10;
        if (j3 != 0) {
            ObservableField<String> observableField = AccountCenter.newInstance().nickName;
            updateRegistration(1, observableField);
            if (observableField != null) {
                str = observableField.get();
            }
        }
        if (j2 != 0) {
            ViewBindingAdapters.clickCommand(this.h, replyCommand, false, 0);
            androidx.databinding.a.e.a(this.j, strValueOf);
            androidx.databinding.a.e.a(this.k, stringPrice);
            ViewBindingAdapters.clickCommand(this.f17679b, replyCommand2, false, 0);
        }
        if (j3 != 0) {
            androidx.databinding.a.e.a(this.i, str);
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
            this.l = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((AccountCenter) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((ObservableField<String>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.game.a.f17630e != i) {
            return false;
        }
        a((b.h.c.a.a.c) obj);
        return true;
    }

    private C2669h(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (LinearLayout) objArr[7], (RelativeLayout) objArr[2], (StrokeTextView) objArr[6]);
        this.l = -1L;
        this.g = (RelativeLayout) objArr[0];
        this.g.setTag(null);
        this.h = (ImageView) objArr[1];
        this.h.setTag(null);
        this.i = (TextView) objArr[3];
        this.i.setTag(null);
        this.j = (TextView) objArr[4];
        this.j.setTag(null);
        this.k = (TextView) objArr[5];
        this.k.setTag(null);
        this.f17679b.setTag(null);
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

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.game.a.f17626a) {
            return false;
        }
        synchronized (this) {
            this.l |= 2;
        }
        return true;
    }
}
