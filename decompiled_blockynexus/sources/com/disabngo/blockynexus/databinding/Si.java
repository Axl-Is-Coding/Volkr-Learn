package com.disabngo.blockynexus.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.widget.ScaleConstraintLayout;
import com.sandboxol.center.binding.adapter.ScrapLevelViewBindingAdapter;
import com.sandboxol.center.entity.ScrapRewardInfo;
import com.sandboxol.center.view.widget.ScrapLevelImageView;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: ItemScrapMainBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Si extends Ri {
    private static final ViewDataBinding.b h = null;
    private static final SparseIntArray i = new SparseIntArray();
    private final ScaleConstraintLayout j;
    private final View k;
    private final TextView l;
    private final ImageView m;
    private long n;

    static {
        i.put(R.id.bg_bottom, 7);
        i.put(R.id.bg_main, 8);
        i.put(R.id.bg_pro, 9);
    }

    public Si(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 10, h, i));
    }

    private boolean b(ObservableField<Integer> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 2;
        }
        return true;
    }

    public void a(com.disabngo.blockynexus.e.b.da.j jVar) {
        updateRegistration(0, jVar);
        this.g = jVar;
        synchronized (this) {
            this.n |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [boolean, int] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        long j2;
        int i2;
        int i3;
        String str;
        int i4;
        int i5;
        int colorFromResource;
        int i6;
        String str2;
        boolean z;
        ReplyCommand replyCommand;
        int i7;
        int i8;
        ?? r6;
        int iSafeUnbox;
        int iSafeUnbox2;
        int i9;
        int i10;
        String cardProgress;
        int i11;
        int i12;
        String cardPic;
        long j3;
        long j4;
        long j5;
        long j6;
        ObservableField<Integer> observableField;
        ObservableField<Integer> observableField2;
        synchronized (this) {
            j = this.n;
            this.n = 0L;
        }
        com.disabngo.blockynexus.e.b.da.j jVar = this.g;
        if ((31 & j) != 0) {
            if ((j & 23) != 0) {
                if (jVar != null) {
                    observableField = jVar.f9703b;
                    observableField2 = jVar.f9704c;
                } else {
                    observableField = null;
                    observableField2 = null;
                }
                updateRegistration(1, observableField);
                updateRegistration(2, observableField2);
                Integer num = observableField != null ? observableField.get() : null;
                Integer num2 = observableField2 != null ? observableField2.get() : null;
                iSafeUnbox = ViewDataBinding.safeUnbox(num);
                iSafeUnbox2 = ViewDataBinding.safeUnbox(num2);
            } else {
                iSafeUnbox = 0;
                iSafeUnbox2 = 0;
            }
            long j7 = j & 25;
            if (j7 != 0) {
                ScrapRewardInfo item = jVar != null ? jVar.getItem() : null;
                if (item != null) {
                    int cardQuality = item.getCardQuality();
                    int status = item.getStatus();
                    cardPic = item.getCardPic();
                    cardProgress = item.getCardProgress();
                    i12 = status;
                    i11 = cardQuality;
                } else {
                    i12 = 0;
                    cardProgress = null;
                    i11 = 0;
                    cardPic = null;
                }
                boolean z2 = i12 == 0;
                boolean z3 = i12 == 2;
                boolean z4 = i12 == 1;
                if (j7 != 0) {
                    j |= z2 ? PlaybackStateCompat.ACTION_PREPARE : PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                }
                if ((j & 25) != 0) {
                    if (z3) {
                        j5 = j | 64;
                        j6 = 256;
                    } else {
                        j5 = j | 32;
                        j6 = 128;
                    }
                    j = j5 | j6;
                }
                if ((j & 25) != 0) {
                    if (z4) {
                        j3 = j | 1024;
                        j4 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                    } else {
                        j3 = j | 512;
                        j4 = PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                    }
                    j = j3 | j4;
                }
                i9 = z2 ? 0 : 8;
                i10 = z3 ? 8 : 0;
                int i13 = z3 ? 0 : 8;
                i5 = z4 ? 0 : 8;
                colorFromResource = z4 ? ViewDataBinding.getColorFromResource(this.f7855f, R.color.app_scrap_progress_color_2) : ViewDataBinding.getColorFromResource(this.f7855f, R.color.itemTextHintColor);
                z = z4;
                i4 = i13;
                str2 = cardPic;
            } else {
                i4 = 0;
                i5 = 0;
                colorFromResource = 0;
                str2 = null;
                z = false;
                i9 = 0;
                i10 = 0;
                cardProgress = null;
                i11 = 0;
            }
            if ((j & 17) == 0 || jVar == null) {
                i7 = iSafeUnbox;
                i8 = iSafeUnbox2;
                i3 = i9;
                i6 = i10;
                str = cardProgress;
                i2 = i11;
                j2 = 25;
                replyCommand = null;
            } else {
                replyCommand = jVar.f9705d;
                i7 = iSafeUnbox;
                i8 = iSafeUnbox2;
                i3 = i9;
                i6 = i10;
                str = cardProgress;
                i2 = i11;
                j2 = 25;
            }
        } else {
            j2 = 25;
            i2 = 0;
            i3 = 0;
            str = null;
            i4 = 0;
            i5 = 0;
            colorFromResource = 0;
            i6 = 0;
            str2 = null;
            z = false;
            replyCommand = null;
            i7 = 0;
            i8 = 0;
        }
        if ((j & j2) != 0) {
            ScrapLevelViewBindingAdapter.setScrapImageViewLevel(this.f7853d, i2);
            ScrapLevelViewBindingAdapter.setScrapImageViewUrl(this.f7853d, str2);
            ScrapLevelViewBindingAdapter.setScrapImageViewAnim(this.f7853d, z);
            this.k.setVisibility(i5);
            ViewBindingAdapters.onAnimate(this.k, 0, 0, false, R.anim.app_anim_scrap_flash, z);
            this.l.setVisibility(i4);
            this.m.setVisibility(i5);
            this.f7854e.setVisibility(i3);
            this.f7855f.setTextColor(colorFromResource);
            androidx.databinding.a.e.a(this.f7855f, str);
            this.f7855f.setVisibility(i6);
        }
        if ((16 & j) != 0) {
            r6 = 0;
            ScrapLevelViewBindingAdapter.setScrapImageViewNum(this.f7853d, 0);
        } else {
            r6 = 0;
        }
        if ((17 & j) != 0) {
            ViewBindingAdapters.clickCommand(this.j, replyCommand, r6, r6);
        }
        if ((j & 23) != 0) {
            com.disabngo.blockynexus.binding.adapter.f.a(this.f7854e, i7, i8);
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
            this.n = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return a((com.disabngo.blockynexus.e.b.da.j) obj, i3);
        }
        if (i2 == 1) {
            return b((ObservableField) obj, i3);
        }
        if (i2 != 2) {
            return false;
        }
        return a((ObservableField<Integer>) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, Object obj) {
        if (2 != i2) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.da.j) obj);
        return true;
    }

    private Si(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (View) objArr[7], (View) objArr[8], (View) objArr[9], (ScrapLevelImageView) objArr[1], (ProgressBar) objArr[2], (TextView) objArr[4]);
        this.n = -1L;
        this.f7853d.setTag(null);
        this.j = (ScaleConstraintLayout) objArr[0];
        this.j.setTag(null);
        this.k = (View) objArr[3];
        this.k.setTag(null);
        this.l = (TextView) objArr[5];
        this.l.setTag(null);
        this.m = (ImageView) objArr[6];
        this.m.setTag(null);
        this.f7854e.setTag(null);
        this.f7855f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.da.j jVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.n |= 1;
            }
            return true;
        }
        if (i2 != 244) {
            return false;
        }
        synchronized (this) {
            this.n |= 8;
        }
        return true;
    }

    private boolean a(ObservableField<Integer> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 4;
        }
        return true;
    }
}
