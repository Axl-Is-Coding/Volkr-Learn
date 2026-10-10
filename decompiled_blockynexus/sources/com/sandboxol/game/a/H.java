package com.sandboxol.game.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.blocky.dialog.scrapanim.ScrapAnimItemViewModel;
import com.sandboxol.center.binding.adapter.ScrapLevelViewBindingAdapter;
import com.sandboxol.center.view.widget.ScrapLevelImageView;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.greendao.entity.ScrapTreasureRewardInfo;

/* JADX INFO: compiled from: ItemScrapAnimBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class H extends G {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f17652c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f17653d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConstraintLayout f17654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f17655f;
    private long g;

    public H(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f17652c, f17653d));
    }

    public void a(ScrapAnimItemViewModel scrapAnimItemViewModel) {
        updateRegistration(0, scrapAnimItemViewModel);
        this.f17651b = scrapAnimItemViewModel;
        synchronized (this) {
            this.g |= 1;
        }
        notifyPropertyChanged(com.sandboxol.game.a.f17627b);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String scrapName;
        String scrapPic;
        int scrapType;
        int scrapLevel;
        synchronized (this) {
            j = this.g;
            this.g = 0L;
        }
        ScrapAnimItemViewModel scrapAnimItemViewModel = this.f17651b;
        long j2 = 7 & j;
        ReplyCommand replyCommand = null;
        if (j2 != 0) {
            ScrapTreasureRewardInfo item = scrapAnimItemViewModel != null ? scrapAnimItemViewModel.getItem() : null;
            if (item != null) {
                scrapType = item.getScrapType();
                scrapPic = item.getScrapPic();
                scrapLevel = item.getScrapLevel();
                scrapName = item.getScrapName();
            } else {
                scrapName = null;
                scrapPic = null;
                scrapType = 0;
                scrapLevel = 0;
            }
            if ((j & 5) != 0 && scrapAnimItemViewModel != null) {
                replyCommand = scrapAnimItemViewModel.onDescCommand;
            }
        } else {
            scrapName = null;
            scrapPic = null;
            scrapType = 0;
            scrapLevel = 0;
        }
        if (j2 != 0) {
            ScrapLevelViewBindingAdapter.setScrapImageViewNum(this.f17650a, scrapLevel);
            ScrapLevelViewBindingAdapter.setScrapImageViewType(this.f17650a, scrapType);
            ScrapLevelViewBindingAdapter.setScrapImageViewUrl(this.f17650a, scrapPic);
            androidx.databinding.a.e.a(this.f17655f, scrapName);
        }
        if ((j & 5) != 0) {
            ViewBindingAdapters.clickCommand(this.f17654e, replyCommand, false, 0);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.g = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((ScrapAnimItemViewModel) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.game.a.f17627b != i) {
            return false;
        }
        a((ScrapAnimItemViewModel) obj);
        return true;
    }

    private H(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (ScrapLevelImageView) objArr[1]);
        this.g = -1L;
        this.f17650a.setTag(null);
        this.f17654e = (ConstraintLayout) objArr[0];
        this.f17654e.setTag(null);
        this.f17655f = (TextView) objArr[2];
        this.f17655f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ScrapAnimItemViewModel scrapAnimItemViewModel, int i) {
        if (i == com.sandboxol.game.a.f17626a) {
            synchronized (this) {
                this.g |= 1;
            }
            return true;
        }
        if (i != com.sandboxol.game.a.m) {
            return false;
        }
        synchronized (this) {
            this.g |= 2;
        }
        return true;
    }
}
