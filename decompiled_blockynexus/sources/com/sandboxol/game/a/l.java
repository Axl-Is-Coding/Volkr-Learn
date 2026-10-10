package com.sandboxol.game.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.center.entity.StarCodeUser;
import com.sandboxol.common.binding.adapter.EditTextBindingAdapters;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.game.R;

/* JADX INFO: compiled from: DialogRechargeStarCodeViewBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class l extends k {
    private static final ViewDataBinding.b k = null;
    private static final SparseIntArray l = new SparseIntArray();
    private final ConstraintLayout m;
    private long n;

    static {
        l.put(R.id.tv_star_code_tip, 7);
        l.put(R.id.iv_star_code_arrow, 8);
        l.put(R.id.gl, 9);
    }

    public l(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 10, k, l));
    }

    @Override // com.sandboxol.game.a.k
    public void a(com.sandboxol.recharge.dialog.rechargeshop.k kVar) {
        this.j = kVar;
        synchronized (this) {
            this.n |= 2;
        }
        notifyPropertyChanged(com.sandboxol.game.a.l);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        ReplyCommand replyCommand2;
        ReplyCommand replyCommand3;
        ReplyCommand<String> replyCommand4;
        ReplyCommand replyCommand5;
        String picUrl;
        int i;
        synchronized (this) {
            j = this.n;
            this.n = 0L;
        }
        com.sandboxol.recharge.dialog.rechargeshop.k kVar = this.j;
        long j2 = 7 & j;
        if (j2 != 0) {
            int i2 = R.mipmap.ic_head_default;
            if ((j & 6) == 0 || kVar == null) {
                replyCommand = null;
                replyCommand2 = null;
                replyCommand3 = null;
                replyCommand4 = null;
                replyCommand5 = null;
            } else {
                ReplyCommand replyCommand6 = kVar.g;
                replyCommand4 = kVar.j;
                replyCommand5 = kVar.f18876f;
                ReplyCommand replyCommand7 = kVar.h;
                replyCommand2 = kVar.i;
                replyCommand = replyCommand7;
                replyCommand3 = replyCommand6;
            }
            ObservableField<StarCodeUser> observableField = kVar != null ? kVar.f18875e : null;
            updateRegistration(0, observableField);
            StarCodeUser starCodeUser = observableField != null ? observableField.get() : null;
            if (starCodeUser != null) {
                picUrl = starCodeUser.getPicUrl();
                i = i2;
            } else {
                i = i2;
                picUrl = null;
            }
        } else {
            replyCommand = null;
            replyCommand2 = null;
            replyCommand3 = null;
            replyCommand4 = null;
            replyCommand5 = null;
            picUrl = null;
            i = 0;
        }
        if ((j & 6) != 0) {
            ViewBindingAdapters.clickCommand(this.f17690a, replyCommand, false, 0);
            EditTextBindingAdapters.editTextCommand(this.f17691b, null, null, replyCommand4);
            ViewBindingAdapters.clickCommand(this.f17695f, replyCommand5, false, 0);
            ViewBindingAdapters.clickCommand(this.g, replyCommand3, false, 0);
            ViewBindingAdapters.clickCommand(this.h, replyCommand2, false, 0);
        }
        if (j2 != 0) {
            ImageViewBindingAdapters.loadImage(this.f17694e, 0, picUrl, i, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.n != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.n = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.game.a.l != i) {
            return false;
        }
        a((com.sandboxol.recharge.dialog.rechargeshop.k) obj);
        return true;
    }

    private l(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (Button) objArr[5], (EditText) objArr[4], (Guideline) objArr[9], (ImageView) objArr[8], (ImageView) objArr[2], (ImageView) objArr[6], (TextView) objArr[1], (TextView) objArr[3], (TextView) objArr[7]);
        this.n = -1L;
        this.f17690a.setTag(null);
        this.f17691b.setTag(null);
        this.f17694e.setTag(null);
        this.f17695f.setTag(null);
        this.m = (ConstraintLayout) objArr[0];
        this.m.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<StarCodeUser> observableField, int i) {
        if (i != com.sandboxol.game.a.f17626a) {
            return false;
        }
        synchronized (this) {
            this.n |= 1;
        }
        return true;
    }
}
