package com.sandboxol.game.a;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.blocky.dialog.scraplist.ScrapListItemViewModel;
import com.sandboxol.center.binding.adapter.ScrapLevelViewBindingAdapter;
import com.sandboxol.center.view.widget.ScrapLevelImageView;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.greendao.entity.ScrapTreasureRewardInfo;

/* JADX INFO: compiled from: ItemScrapListBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class J extends I {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f17657b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f17658c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConstraintLayout f17659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ScrapLevelImageView f17660e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f17661f;

    public J(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, f17657b, f17658c));
    }

    public void a(ScrapListItemViewModel scrapListItemViewModel) {
        updateRegistration(0, scrapListItemViewModel);
        this.f17656a = scrapListItemViewModel;
        synchronized (this) {
            this.f17661f |= 1;
        }
        notifyPropertyChanged(com.sandboxol.game.a.f17627b);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String scrapPic;
        String probability;
        int scrapLevel;
        int scrapType;
        synchronized (this) {
            j = this.f17661f;
            this.f17661f = 0L;
        }
        ScrapListItemViewModel scrapListItemViewModel = this.f17656a;
        long j2 = 7 & j;
        ReplyCommand replyCommand = null;
        if (j2 != 0) {
            ScrapTreasureRewardInfo item = scrapListItemViewModel != null ? scrapListItemViewModel.getItem() : null;
            if (item != null) {
                scrapType = item.getScrapType();
                scrapPic = item.getScrapPic();
                probability = item.getProbability();
                scrapLevel = item.getScrapLevel();
            } else {
                scrapPic = null;
                probability = null;
                scrapLevel = 0;
                scrapType = 0;
            }
            if ((j & 5) != 0 && scrapListItemViewModel != null) {
                replyCommand = scrapListItemViewModel.onShowDetail;
            }
        } else {
            scrapPic = null;
            probability = null;
            scrapLevel = 0;
            scrapType = 0;
        }
        if (j2 != 0) {
            ScrapLevelViewBindingAdapter.setScrapImageViewNum(this.f17660e, scrapLevel);
            ScrapLevelViewBindingAdapter.setScrapImageViewType(this.f17660e, scrapType);
            ScrapLevelViewBindingAdapter.setScrapImageViewUrl(this.f17660e, scrapPic);
            ScrapLevelViewBindingAdapter.setScrapImageViewPercentStatus(this.f17660e, 1, probability);
        }
        if ((j & 5) != 0) {
            ViewBindingAdapters.clickCommand(this.f17660e, replyCommand, false, 0);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f17661f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f17661f = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((ScrapListItemViewModel) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.game.a.f17627b != i) {
            return false;
        }
        a((ScrapListItemViewModel) obj);
        return true;
    }

    private J(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f17661f = -1L;
        this.f17659d = (ConstraintLayout) objArr[0];
        this.f17659d.setTag(null);
        this.f17660e = (ScrapLevelImageView) objArr[1];
        this.f17660e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ScrapListItemViewModel scrapListItemViewModel, int i) {
        if (i == com.sandboxol.game.a.f17626a) {
            synchronized (this) {
                this.f17661f |= 1;
            }
            return true;
        }
        if (i != com.sandboxol.game.a.m) {
            return false;
        }
        synchronized (this) {
            this.f17661f |= 2;
        }
        return true;
    }
}
