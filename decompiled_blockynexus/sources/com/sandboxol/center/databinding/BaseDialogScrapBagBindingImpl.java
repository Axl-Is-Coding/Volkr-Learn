package com.sandboxol.center.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.e;
import androidx.databinding.a.f;
import androidx.databinding.d;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.sandboxol.center.BR;
import com.sandboxol.center.R;
import com.sandboxol.center.binding.adapter.TabLayoutBindAdapter;
import com.sandboxol.center.utils.ScrapOutlineViewReturnHelper;
import com.sandboxol.center.view.dialog.scrap.ScrapBagPageViewModel;
import com.sandboxol.center.view.dialog.scrap.ScrapBagViewModel;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import me.tatarka.bindingcollectionadapter2.b;
import me.tatarka.bindingcollectionadapter2.g;

/* JADX INFO: loaded from: classes3.dex */
public class BaseDialogScrapBagBindingImpl extends BaseDialogScrapBagBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    public BaseDialogScrapBagBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 8, sIncludes, sViewsWithIds));
    }

    private boolean onChangeViewModelIsFromMain(ObservableField<Boolean> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelPageItems(ObservableList<ScrapBagPageViewModel> observableList, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelScrapValue(ObservableField<Integer> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        long j2;
        int i;
        int i2;
        String strValueOf;
        int i3;
        String str;
        ObservableList observableList;
        g<ScrapBagPageViewModel> gVar;
        int i4;
        Drawable drawable;
        Drawable drawable2;
        int colorFromResource;
        Drawable drawableFromResource;
        int i5;
        Drawable drawableFromResource2;
        ReplyCommand replyCommand;
        ObservableList observableList2;
        g<ScrapBagPageViewModel> gVar2;
        int scrapTabColor;
        int scrapTabTextColor;
        long j3;
        ObservableField<Integer> observableField;
        TextView textView;
        int i6;
        TextView textView2;
        int i7;
        TextView textView3;
        int i8;
        long j4;
        long j5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        ScrapBagViewModel scrapBagViewModel = this.mViewModel;
        if ((31 & j) != 0) {
            if ((j & 25) != 0) {
                if (scrapBagViewModel != null) {
                    observableList = scrapBagViewModel.pageItems;
                    gVar = scrapBagViewModel.itemBinding;
                } else {
                    observableList = null;
                    gVar = null;
                }
                updateRegistration(0, observableList);
            } else {
                observableList = null;
                gVar = null;
            }
            long j6 = j & 26;
            if (j6 != 0) {
                ObservableField<Boolean> observableField2 = scrapBagViewModel != null ? scrapBagViewModel.isFromMain : null;
                updateRegistration(1, observableField2);
                boolean zSafeUnbox = ViewDataBinding.safeUnbox(observableField2 != null ? observableField2.get() : null);
                if (j6 != 0) {
                    if (zSafeUnbox) {
                        j4 = j | 64 | 256 | 1024 | PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                        j5 = PlaybackStateCompat.ACTION_PREPARE;
                    } else {
                        j4 = j | 32 | 128 | 512 | PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                        j5 = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    }
                    j = j4 | j5;
                }
                int scrapTabIndicatorColor = ScrapOutlineViewReturnHelper.getScrapTabIndicatorColor(zSafeUnbox);
                int colorFromResource2 = zSafeUnbox ? ViewDataBinding.getColorFromResource(this.tvValue, R.color.base_text_hint) : ViewDataBinding.getColorFromResource(this.tvValue, R.color.base_text_default);
                if (zSafeUnbox) {
                    textView = this.tvValueRight;
                    i6 = R.color.base_text_hint;
                } else {
                    textView = this.tvValueRight;
                    i6 = R.color.base_text_default;
                }
                colorFromResource = ViewDataBinding.getColorFromResource(textView, i6);
                Drawable scrapBagBg = ScrapOutlineViewReturnHelper.getScrapBagBg(zSafeUnbox);
                scrapTabColor = ScrapOutlineViewReturnHelper.getScrapTabColor(zSafeUnbox);
                String string = zSafeUnbox ? this.tvTitle.getResources().getString(R.string.base_tv_scrap_bag_title) : this.tvTitle.getResources().getString(R.string.tv_scrap_bag_title_2);
                Drawable scrapBagTitleBg = ScrapOutlineViewReturnHelper.getScrapBagTitleBg(zSafeUnbox);
                int scrapTabSelectedTextColor = ScrapOutlineViewReturnHelper.getScrapTabSelectedTextColor(zSafeUnbox);
                scrapTabTextColor = ScrapOutlineViewReturnHelper.getScrapTabTextColor(zSafeUnbox);
                if (zSafeUnbox) {
                    textView2 = this.tvValueRight;
                    i7 = R.drawable.bg_scrap_bag_main_value_right_shape;
                } else {
                    textView2 = this.tvValueRight;
                    i7 = R.drawable.bg_scrap_bag_value_right_shape;
                }
                drawableFromResource2 = ViewDataBinding.getDrawableFromResource(textView2, i7);
                if (zSafeUnbox) {
                    textView3 = this.tvValue;
                    i8 = R.drawable.bg_scrap_bag_main_value_left_shape;
                } else {
                    textView3 = this.tvValue;
                    i8 = R.drawable.bg_scrap_bag_value_left_shape;
                }
                j3 = 24;
                str = string;
                i3 = scrapTabSelectedTextColor;
                i4 = colorFromResource2;
                drawable2 = scrapBagTitleBg;
                drawableFromResource = ViewDataBinding.getDrawableFromResource(textView3, i8);
                drawable = scrapBagBg;
                i5 = scrapTabIndicatorColor;
            } else {
                i3 = 0;
                str = null;
                i4 = 0;
                drawable = null;
                drawable2 = null;
                colorFromResource = 0;
                drawableFromResource = null;
                i5 = 0;
                drawableFromResource2 = null;
                scrapTabColor = 0;
                scrapTabTextColor = 0;
                j3 = 24;
            }
            replyCommand = ((j & j3) == 0 || scrapBagViewModel == null) ? null : scrapBagViewModel.onCloseCommand;
            if ((j & 28) != 0) {
                if (scrapBagViewModel != null) {
                    observableField = scrapBagViewModel.scrapValue;
                    j2 = j;
                } else {
                    j2 = j;
                    observableField = null;
                }
                updateRegistration(2, observableField);
                strValueOf = String.valueOf(ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null));
                i = scrapTabColor;
                i2 = scrapTabTextColor;
            } else {
                j2 = j;
                i = scrapTabColor;
                i2 = scrapTabTextColor;
                strValueOf = null;
            }
        } else {
            j2 = j;
            i = 0;
            i2 = 0;
            strValueOf = null;
            i3 = 0;
            str = null;
            observableList = null;
            gVar = null;
            i4 = 0;
            drawable = null;
            drawable2 = null;
            colorFromResource = 0;
            drawableFromResource = null;
            i5 = 0;
            drawableFromResource2 = null;
            replyCommand = null;
        }
        if ((j2 & 24) != 0) {
            observableList2 = observableList;
            gVar2 = gVar;
            ViewBindingAdapters.clickCommand(this.ivClose, replyCommand, false, 0);
        } else {
            observableList2 = observableList;
            gVar2 = gVar;
        }
        if ((j2 & 26) != 0) {
            ViewBindingAdapters.backgroundColor(this.tlTab, i);
            TabLayoutBindAdapter.setTabLayout(this.tlTab, i5, i3, i2);
            f.a(this.tvTitle, drawable2);
            e.a(this.tvTitle, str);
            this.tvTitle.setTextColor(i2);
            f.a(this.tvValue, drawableFromResource);
            this.tvValue.setTextColor(i4);
            f.a(this.tvValueRight, drawableFromResource2);
            this.tvValueRight.setTextColor(colorFromResource);
            f.a(this.v, drawable);
        }
        if ((j2 & 28) != 0) {
            e.a(this.tvValueRight, strValueOf);
        }
        if ((j2 & 25) != 0) {
            b.a(this.vpContent, gVar2, observableList2, null, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeViewModelPageItems((ObservableList) obj, i2);
        }
        if (i == 1) {
            return onChangeViewModelIsFromMain((ObservableField) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return onChangeViewModelScrapValue((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.ViewModel != i) {
            return false;
        }
        setViewModel((ScrapBagViewModel) obj);
        return true;
    }

    @Override // com.sandboxol.center.databinding.BaseDialogScrapBagBinding
    public void setViewModel(ScrapBagViewModel scrapBagViewModel) {
        this.mViewModel = scrapBagViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.ViewModel);
        super.requestRebind();
    }

    private BaseDialogScrapBagBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (ImageView) objArr[7], (TabLayout) objArr[3], (TextView) objArr[2], (TextView) objArr[5], (TextView) objArr[6], (View) objArr[1], (ViewPager) objArr[4]);
        this.mDirtyFlags = -1L;
        this.ivClose.setTag(null);
        this.mboundView0 = (ConstraintLayout) objArr[0];
        this.mboundView0.setTag(null);
        this.tlTab.setTag(null);
        this.tvTitle.setTag(null);
        this.tvValue.setTag(null);
        this.tvValueRight.setTag(null);
        this.v.setTag(null);
        this.vpContent.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
