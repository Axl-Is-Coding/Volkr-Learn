package com.sandboxol.game.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.blocky.dialog.scraplist.ScrapListDialog;
import com.sandboxol.blocky.dialog.scraplist.ScrapListModel;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;
import com.sandboxol.game.R;

/* JADX INFO: compiled from: DialogScrapListBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class x extends w {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f17730e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f17731f = new SparseIntArray();
    private final ConstraintLayout g;
    private final ImageView h;
    private final DataRecyclerView i;
    private long j;

    static {
        f17731f.put(R.id.v_bg, 4);
        f17731f.put(R.id.tv_title, 5);
    }

    public x(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, f17730e, f17731f));
    }

    @Override // com.sandboxol.game.a.w
    public void a(ScrapListDialog scrapListDialog) {
        this.f17729d = scrapListDialog;
        synchronized (this) {
            this.j |= 2;
        }
        notifyPropertyChanged(com.sandboxol.game.a.f17631f);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String string;
        ScrapListModel scrapListModel;
        ScrapListModel scrapListModel2;
        ReplyCommand replyCommand;
        synchronized (this) {
            j = this.j;
            this.j = 0L;
        }
        ScrapListDialog scrapListDialog = this.f17729d;
        long j2 = 7 & j;
        ReplyCommand replyCommand2 = null;
        if (j2 != 0) {
            if ((j & 6) == 0 || scrapListDialog == null) {
                scrapListModel2 = null;
                replyCommand = null;
            } else {
                scrapListModel2 = scrapListDialog.listModel;
                replyCommand = scrapListDialog.closeCommand;
            }
            ObservableField<Integer> observableField = scrapListDialog != null ? scrapListDialog.rewardQuantity : null;
            updateRegistration(0, observableField);
            string = this.f17726a.getResources().getString(R.string.game_dialog_scrap_bag_list_tip, observableField != null ? observableField.get() : null);
            scrapListModel = scrapListModel2;
            replyCommand2 = replyCommand;
        } else {
            string = null;
            scrapListModel = null;
        }
        if ((j & 6) != 0) {
            ViewBindingAdapters.clickCommand(this.h, replyCommand2, false, 0);
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.i, null, scrapListModel, me.tatarka.bindingcollectionadapter2.k.a(5), false, null, false, 0, false);
        }
        if (j2 != 0) {
            androidx.databinding.a.e.a(this.f17726a, string);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.j != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.j = 4L;
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
        if (com.sandboxol.game.a.f17631f != i) {
            return false;
        }
        a((ScrapListDialog) obj);
        return true;
    }

    private x(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (TextView) objArr[2], (TextView) objArr[5], (View) objArr[4]);
        this.j = -1L;
        this.g = (ConstraintLayout) objArr[0];
        this.g.setTag(null);
        this.h = (ImageView) objArr[1];
        this.h.setTag(null);
        this.i = (DataRecyclerView) objArr[3];
        this.i.setTag(null);
        this.f17726a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.game.a.f17626a) {
            return false;
        }
        synchronized (this) {
            this.j |= 1;
        }
        return true;
    }
}
