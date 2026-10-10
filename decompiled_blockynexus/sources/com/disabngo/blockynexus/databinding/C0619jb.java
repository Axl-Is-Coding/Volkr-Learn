package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.dialog.videotag.VideoTagPopupWindowDialog;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;
import com.sandboxol.greendao.entity.VideoTagInfo;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.jb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogAppVideoTagBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0619jb extends AbstractC0609ib {
    private static final ViewDataBinding.b j = null;
    private static final SparseIntArray k = new SparseIntArray();
    private final ConstraintLayout l;
    private final AppCompatButton m;
    private final AppCompatButton n;
    private long o;

    static {
        k.put(R.id.clTag, 5);
        k.put(R.id.tvSelect, 6);
        k.put(R.id.view5, 7);
        k.put(R.id.constraintLayout2, 8);
        k.put(R.id.tvTitle, 9);
        k.put(R.id.linearLayout, 10);
    }

    public C0619jb(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 11, j, k));
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0609ib
    public void a(VideoTagPopupWindowDialog videoTagPopupWindowDialog) {
        this.i = videoTagPopupWindowDialog;
        synchronized (this) {
            this.o |= 2;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j2;
        ReplyCommand replyCommand;
        com.disabngo.blockynexus.view.dialog.videotag.f fVar;
        String str;
        String str2;
        synchronized (this) {
            j2 = this.o;
            this.o = 0L;
        }
        VideoTagPopupWindowDialog videoTagPopupWindowDialog = this.i;
        long j3 = 15 & j2;
        ReplyCommand replyCommand2 = null;
        if (j3 != 0) {
            VideoTagInfo videoTagInfo = videoTagPopupWindowDialog != null ? videoTagPopupWindowDialog.tag : null;
            updateRegistration(0, videoTagInfo);
            String tagName = videoTagInfo != null ? videoTagInfo.getTagName() : null;
            if ((j2 & 10) == 0 || videoTagPopupWindowDialog == null) {
                replyCommand = null;
                fVar = null;
                str = tagName;
            } else {
                ReplyCommand replyCommand3 = videoTagPopupWindowDialog.onConfirmCommand;
                ReplyCommand replyCommand4 = videoTagPopupWindowDialog.onCancelCommand;
                fVar = videoTagPopupWindowDialog.listModel;
                replyCommand = replyCommand3;
                str = tagName;
                replyCommand2 = replyCommand4;
            }
        } else {
            replyCommand = null;
            fVar = null;
            str = null;
        }
        if ((j2 & 10) != 0) {
            ViewBindingAdapters.clickCommand(this.m, replyCommand2, false, 0);
            ViewBindingAdapters.clickCommand(this.n, replyCommand, false, 0);
            str2 = str;
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f8441d, null, fVar, me.tatarka.bindingcollectionadapter2.k.a(4), false, null, false, 0, false);
        } else {
            str2 = str;
        }
        if (j3 != 0) {
            androidx.databinding.a.e.a(this.f8443f, str2);
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
            this.o = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((VideoTagInfo) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (1 != i) {
            return false;
        }
        a((VideoTagPopupWindowDialog) obj);
        return true;
    }

    private C0619jb(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (ConstraintLayout) objArr[5], (ConstraintLayout) objArr[8], (LinearLayout) objArr[10], (DataRecyclerView) objArr[2], (AppCompatTextView) objArr[6], (AppCompatTextView) objArr[1], (AppCompatTextView) objArr[9], (View) objArr[7]);
        this.o = -1L;
        this.l = (ConstraintLayout) objArr[0];
        this.l.setTag(null);
        this.m = (AppCompatButton) objArr[3];
        this.m.setTag(null);
        this.n = (AppCompatButton) objArr[4];
        this.n.setTag(null);
        this.f8441d.setTag(null);
        this.f8443f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(VideoTagInfo videoTagInfo, int i) {
        if (i == 0) {
            synchronized (this) {
                this.o |= 1;
            }
            return true;
        }
        if (i != 22) {
            return false;
        }
        synchronized (this) {
            this.o |= 4;
        }
        return true;
    }
}
