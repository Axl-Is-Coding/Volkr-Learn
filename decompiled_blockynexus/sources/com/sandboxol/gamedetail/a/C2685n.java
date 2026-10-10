package com.sandboxol.gamedetail.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.gamedetail.R;
import com.sandboxol.gamedetail.view.dialog.ClickingHideView;
import com.sandboxol.gamedetail.view.dialog.marioguide.HandleLinearLayoutView;
import com.sandboxol.gamedetail.view.dialog.marioguide.HandlerView;
import com.sandboxol.gamedetail.view.dialog.marioguide.MarioGuideDialog;

/* JADX INFO: renamed from: com.sandboxol.gamedetail.a.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogMarioGuideBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2685n extends AbstractC2684m {
    private static final ViewDataBinding.b k = null;
    private static final SparseIntArray l = new SparseIntArray();
    private final ConstraintLayout m;
    private final ImageButton n;
    private long o;

    static {
        l.put(R.id.banner, 5);
        l.put(R.id.iv_machine, 6);
        l.put(R.id.iv_handler_left, 7);
        l.put(R.id.iv_handler_right, 8);
        l.put(R.id.hllHandle, 9);
        l.put(R.id.bg_click_press, 10);
    }

    public C2685n(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 11, k, l));
    }

    @Override // com.sandboxol.gamedetail.a.AbstractC2684m
    public void a(MarioGuideDialog marioGuideDialog) {
        this.j = marioGuideDialog;
        synchronized (this) {
            this.o |= 1;
        }
        notifyPropertyChanged(com.sandboxol.gamedetail.a.f17769b);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        ReplyCommand replyCommand2;
        ReplyCommand replyCommand3;
        synchronized (this) {
            j = this.o;
            this.o = 0L;
        }
        MarioGuideDialog marioGuideDialog = this.j;
        long j2 = j & 3;
        ReplyCommand replyCommand4 = null;
        if (j2 == 0 || marioGuideDialog == null) {
            replyCommand = null;
            replyCommand2 = null;
            replyCommand3 = null;
        } else {
            ReplyCommand replyCommand5 = marioGuideDialog.k;
            ReplyCommand replyCommand6 = marioGuideDialog.m;
            replyCommand3 = marioGuideDialog.j;
            replyCommand = marioGuideDialog.l;
            replyCommand2 = replyCommand5;
            replyCommand4 = replyCommand6;
        }
        if (j2 != 0) {
            ViewBindingAdapters.clickCommand(this.f17852b, replyCommand4, false, 0);
            ViewBindingAdapters.clickCommand(this.f17854d, replyCommand, true, 0);
            ViewBindingAdapters.clickCommand(this.f17855e, replyCommand2, true, 0);
            ViewBindingAdapters.clickCommand(this.n, replyCommand3, false, 0);
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
        if (com.sandboxol.gamedetail.a.f17769b != i) {
            return false;
        }
        a((MarioGuideDialog) obj);
        return true;
    }

    private C2685n(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (ViewPager) objArr[5], (ClickingHideView) objArr[3], (View) objArr[10], (HandlerView) objArr[1], (HandlerView) objArr[2], (HandleLinearLayoutView) objArr[9], (ImageView) objArr[7], (ImageView) objArr[8], (ImageView) objArr[6]);
        this.o = -1L;
        this.f17852b.setTag(null);
        this.f17854d.setTag(null);
        this.f17855e.setTag(null);
        this.m = (ConstraintLayout) objArr[0];
        this.m.setTag(null);
        this.n = (ImageButton) objArr[4];
        this.n.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
