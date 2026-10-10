package com.sandboxol.game.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.blocky.dialog.scrapanim.ScrapAnimListLayout;
import com.sandboxol.blocky.dialog.scrapanim.ScrapAnimListModel;
import com.sandboxol.blocky.dialog.scrapanim.ScrapReceivedAnimDialog;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;
import com.sandboxol.game.R;

/* JADX INFO: compiled from: DialogScrapAnimBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class p extends o {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f17705d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f17706e = new SparseIntArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ConstraintLayout f17707f;
    private final TextView g;
    private long h;

    static {
        f17706e.put(R.id.iv_flash, 3);
    }

    public p(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f17705d, f17706e));
    }

    @Override // com.sandboxol.game.a.o
    public void a(ScrapReceivedAnimDialog scrapReceivedAnimDialog) {
        this.f17704c = scrapReceivedAnimDialog;
        synchronized (this) {
            this.h |= 2;
        }
        notifyPropertyChanged(com.sandboxol.game.a.k);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        int i;
        ScrapAnimListLayout scrapAnimListLayout;
        ScrapAnimListModel scrapAnimListModel;
        ScrapAnimListModel scrapAnimListModel2;
        ReplyCommand replyCommand2;
        synchronized (this) {
            j = this.h;
            this.h = 0L;
        }
        ScrapReceivedAnimDialog scrapReceivedAnimDialog = this.f17704c;
        long j2 = j & 7;
        if (j2 != 0) {
            if ((j & 6) == 0 || scrapReceivedAnimDialog == null) {
                scrapAnimListModel2 = null;
                replyCommand2 = null;
                scrapAnimListLayout = null;
            } else {
                ScrapAnimListModel scrapAnimListModel3 = scrapReceivedAnimDialog.listModel;
                scrapAnimListLayout = scrapReceivedAnimDialog.listLayout;
                replyCommand2 = scrapReceivedAnimDialog.onClose;
                scrapAnimListModel2 = scrapAnimListModel3;
            }
            ObservableField<Boolean> observableField = scrapReceivedAnimDialog != null ? scrapReceivedAnimDialog.isFromMain : null;
            updateRegistration(0, observableField);
            boolean zSafeUnbox = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
            if (j2 != 0) {
                j |= zSafeUnbox ? 16L : 8L;
            }
            i = zSafeUnbox ? 8 : 0;
            scrapAnimListModel = scrapAnimListModel2;
            replyCommand = replyCommand2;
        } else {
            replyCommand = null;
            i = 0;
            scrapAnimListLayout = null;
            scrapAnimListModel = null;
        }
        if ((6 & j) != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f17702a, scrapAnimListLayout, scrapAnimListModel, me.tatarka.bindingcollectionadapter2.k.a(0, false), false, null, false, 0, false);
            ViewBindingAdapters.clickCommand(this.f17707f, replyCommand, false, 0);
        }
        if ((j & 7) != 0) {
            this.g.setVisibility(i);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.h = 4L;
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
        if (com.sandboxol.game.a.k != i) {
            return false;
        }
        a((ScrapReceivedAnimDialog) obj);
        return true;
    }

    private p(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (DataRecyclerView) objArr[1], (ImageView) objArr[3]);
        this.h = -1L;
        this.f17702a.setTag(null);
        this.f17707f = (ConstraintLayout) objArr[0];
        this.f17707f.setTag(null);
        this.g = (TextView) objArr[2];
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.game.a.f17626a) {
            return false;
        }
        synchronized (this) {
            this.h |= 1;
        }
        return true;
    }
}
