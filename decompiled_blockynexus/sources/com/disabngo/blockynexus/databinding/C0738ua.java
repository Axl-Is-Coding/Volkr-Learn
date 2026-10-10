package com.disabngo.blockynexus.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.util.ConvertUtils;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.PageRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.pagerv.PageRecyclerView;
import com.sandboxol.greendao.entity.RankInfoResponse;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ua, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ContentRankClanDetailPageBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0738ua extends AbstractC0727ta {
    private static final ViewDataBinding.b x = new ViewDataBinding.b(29);
    private static final SparseIntArray y;
    private final PageRecyclerView A;
    private final TextView B;
    private final ConstraintLayout C;
    private final ImageView D;
    private final TextView E;
    private final TextView F;
    private long G;
    private final ConstraintLayout z;

    static {
        x.a(0, new String[]{"item_rank_detail_title"}, new int[]{17}, new int[]{R.layout.item_rank_detail_title});
        y = new SparseIntArray();
        y.put(R.id.iv_rank_detail_top_1, 18);
        y.put(R.id.iv_rank_detail_top_2, 19);
        y.put(R.id.iv_rank_detail_top_3, 20);
        y.put(R.id.iv_rank_detail_steps, 21);
        y.put(R.id.iv_rank_detail_top_1_step, 22);
        y.put(R.id.iv_rank_detail_top_2_step, 23);
        y.put(R.id.iv_rank_detail_top_3_step, 24);
        y.put(R.id.v_bg_list, 25);
        y.put(R.id.gl_vertical_122, 26);
        y.put(R.id.gl_vertical_394, 27);
        y.put(R.id.gl_vertical_69, 28);
    }

    public C0738ua(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 29, x, y));
    }

    public void a(com.disabngo.blockynexus.e.b.W.b.o oVar) {
        this.w = oVar;
        synchronized (this) {
            this.G |= 8;
        }
        notifyPropertyChanged(408);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ObservableList observableList;
        boolean z;
        boolean z2;
        ReplyCommand replyCommand;
        ReplyCommand replyCommand2;
        int i;
        int i2;
        ReplyCommand replyCommand3;
        int i3;
        String strValueOf;
        String name;
        boolean z3;
        boolean z4;
        boolean z5;
        String pic;
        long rank;
        com.disabngo.blockynexus.e.b.W.c cVar;
        com.disabngo.blockynexus.e.b.W.b.n nVar;
        int i4;
        ReplyCommand replyCommand4;
        String strValueOf2;
        String pic2;
        String name2;
        String name3;
        String strValueOf3;
        String pic3;
        String str;
        String strValueOf4;
        String pic4;
        String name4;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        long j2;
        String str9;
        String str10;
        String str11;
        String str12;
        int i5;
        String str13;
        RankInfoResponse rankInfoResponse;
        ReplyCommand replyCommand5;
        com.disabngo.blockynexus.e.b.W.b.n nVar2;
        com.disabngo.blockynexus.e.b.W.c cVar2;
        ReplyCommand replyCommand6;
        int i6;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        long quantity;
        long id;
        synchronized (this) {
            j = this.G;
            this.G = 0L;
        }
        com.disabngo.blockynexus.e.b.W.b.o oVar = this.w;
        if ((30 & j) != 0) {
            if ((j & 24) == 0 || oVar == null) {
                replyCommand = null;
                replyCommand2 = null;
                replyCommand5 = null;
                nVar2 = null;
                cVar2 = null;
                replyCommand6 = null;
            } else {
                com.disabngo.blockynexus.e.b.W.b.n nVar3 = oVar.f9534e;
                replyCommand2 = oVar.i;
                ReplyCommand replyCommand7 = oVar.g;
                replyCommand5 = oVar.h;
                cVar2 = oVar.f9533d;
                replyCommand6 = oVar.f9535f;
                nVar2 = nVar3;
                replyCommand = replyCommand7;
            }
            long j9 = j & 26;
            if (j9 != 0) {
                ObservableField<RankInfoResponse> observableField = oVar != null ? oVar.f9532c : null;
                updateRegistration(1, observableField);
                RankInfoResponse rankInfoResponse2 = observableField != null ? observableField.get() : null;
                if (rankInfoResponse2 != null) {
                    quantity = rankInfoResponse2.getQuantity();
                    name = rankInfoResponse2.getName();
                    pic = rankInfoResponse2.getPic();
                    rank = rankInfoResponse2.getRank();
                    id = rankInfoResponse2.getId();
                } else {
                    quantity = 0;
                    rank = 0;
                    id = 0;
                    name = null;
                    pic = null;
                }
                strValueOf = String.valueOf(quantity);
                z4 = name != null;
                z5 = rank == -1;
                boolean z6 = id == -1;
                if (j9 != 0) {
                    j |= z4 ? 64L : 32L;
                }
                if ((j & 26) != 0) {
                    j = z5 ? j | PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : j | PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                }
                if ((j & 26) != 0) {
                    j |= z6 ? PlaybackStateCompat.ACTION_PREPARE : PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                }
                i6 = z6 ? 8 : 0;
            } else {
                rank = 0;
                strValueOf = null;
                name = null;
                i6 = 0;
                z4 = false;
                z5 = false;
                pic = null;
            }
            long j10 = j & 28;
            if (j10 != 0) {
                observableList = oVar != null ? oVar.f9531b : null;
                updateRegistration(2, observableList);
                int size = observableList != null ? observableList.size() : 0;
                z2 = size > 2;
                z3 = size > 0;
                z = size > 1;
                if (j10 != 0) {
                    if (z2) {
                        j7 = j | 1024 | 1048576 | 4194304;
                        j8 = 268435456;
                    } else {
                        j7 = j | 512 | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                        j8 = 134217728;
                    }
                    j = j7 | j8;
                }
                if ((j & 28) != 0) {
                    if (z3) {
                        j5 = j | 256 | 67108864 | 4294967296L;
                        j6 = 17179869184L;
                    } else {
                        j5 = j | 128 | 33554432 | 2147483648L;
                        j6 = 8589934592L;
                    }
                    j = j5 | j6;
                }
                if ((j & 28) != 0) {
                    if (z) {
                        j3 = j | 65536 | PlaybackStateCompat.ACTION_SET_REPEAT_MODE | 16777216;
                        j4 = ConvertUtils.GB;
                    } else {
                        j3 = j | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID | PlaybackStateCompat.ACTION_PREPARE_FROM_URI | 8388608;
                        j4 = 536870912;
                    }
                    j = j3 | j4;
                }
                int i7 = z2 ? 0 : 4;
                int i8 = z3 ? 0 : 4;
                nVar = nVar2;
                cVar = cVar2;
                replyCommand4 = replyCommand6;
                i2 = z ? 0 : 4;
                i3 = i7;
                i4 = i8;
            } else {
                nVar = nVar2;
                cVar = cVar2;
                replyCommand4 = replyCommand6;
                observableList = null;
                z = false;
                z2 = false;
                i2 = 0;
                i3 = 0;
                z3 = false;
                i4 = 0;
            }
            replyCommand3 = replyCommand5;
            i = i6;
        } else {
            observableList = null;
            z = false;
            z2 = false;
            replyCommand = null;
            replyCommand2 = null;
            i = 0;
            i2 = 0;
            replyCommand3 = null;
            i3 = 0;
            strValueOf = null;
            name = null;
            z3 = false;
            z4 = false;
            z5 = false;
            pic = null;
            rank = 0;
            cVar = null;
            nVar = null;
            i4 = 0;
            replyCommand4 = null;
        }
        long j11 = j & 26;
        if (j11 == 0) {
            name = null;
        } else if (!z4) {
            name = "";
        }
        if ((j & 5243904) != 0) {
            RankInfoResponse rankInfoResponse3 = observableList != null ? (RankInfoResponse) observableList.get(2) : null;
            pic2 = ((j & 1024) == 0 || rankInfoResponse3 == null) ? null : rankInfoResponse3.getPic();
            name2 = ((j & 4194304) == 0 || rankInfoResponse3 == null) ? null : rankInfoResponse3.getName();
            if ((j & 1048576) != 0) {
                strValueOf2 = String.valueOf(rankInfoResponse3 != null ? rankInfoResponse3.getQuantity() : 0L);
            } else {
                strValueOf2 = null;
            }
        } else {
            strValueOf2 = null;
            pic2 = null;
            name2 = null;
        }
        if ((j & 1090781184) != 0) {
            RankInfoResponse rankInfoResponse4 = observableList != null ? (RankInfoResponse) observableList.get(1) : null;
            if ((j & 16777216) != 0) {
                strValueOf3 = String.valueOf(rankInfoResponse4 != null ? rankInfoResponse4.getQuantity() : 0L);
            } else {
                strValueOf3 = null;
            }
            pic3 = ((j & PlaybackStateCompat.ACTION_SET_REPEAT_MODE) == 0 || rankInfoResponse4 == null) ? null : rankInfoResponse4.getPic();
            name3 = ((j & ConvertUtils.GB) == 0 || rankInfoResponse4 == null) ? null : rankInfoResponse4.getName();
        } else {
            name3 = null;
            strValueOf3 = null;
            pic3 = null;
        }
        if ((j & 17246978304L) != 0) {
            if (observableList != null) {
                str = strValueOf2;
                rankInfoResponse = (RankInfoResponse) observableList.get(0);
            } else {
                str = strValueOf2;
                rankInfoResponse = null;
            }
            pic4 = ((j & 256) == 0 || rankInfoResponse == null) ? null : rankInfoResponse.getPic();
            name4 = ((j & 17179869184L) == 0 || rankInfoResponse == null) ? null : rankInfoResponse.getName();
            if ((j & 67108864) != 0) {
                strValueOf4 = String.valueOf(rankInfoResponse != null ? rankInfoResponse.getQuantity() : 0L);
            } else {
                strValueOf4 = null;
            }
        } else {
            str = strValueOf2;
            strValueOf4 = null;
            pic4 = null;
            name4 = null;
        }
        String strValueOf5 = (j & PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) != 0 ? String.valueOf(rank) : null;
        long j12 = j & 28;
        if (j12 != 0) {
            if (!z3) {
                pic4 = "";
            }
            str8 = z2 ? pic2 : "";
            String str14 = z ? pic3 : "";
            String str15 = z2 ? str : "";
            if (!z2) {
                name2 = "";
            }
            str5 = z ? strValueOf3 : "";
            if (!z3) {
                strValueOf4 = "";
            }
            if (!z) {
                name3 = "";
            }
            str10 = pic4;
            str9 = str14;
            str7 = strValueOf4;
            str2 = strValueOf;
            str3 = str15;
            j2 = 0;
            str6 = z3 ? name4 : "";
            str4 = name2;
        } else {
            str2 = strValueOf;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            name3 = null;
            str8 = null;
            j2 = 0;
            str9 = null;
            str10 = null;
        }
        if (j11 != j2) {
            if (z5) {
                strValueOf5 = "-";
            }
            String str16 = strValueOf5;
            str11 = name;
            str12 = str16;
        } else {
            str11 = name;
            str12 = null;
        }
        if (j12 != j2) {
            str13 = str12;
            i5 = i;
            this.f8820f.setVisibility(i4);
            ImageViewBindingAdapters.loadImage(this.f8820f, 0, str10, R.mipmap.ic_tribe_default_head, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
            this.i.setVisibility(i2);
            ImageViewBindingAdapters.loadImage(this.i, 0, str9, R.mipmap.ic_tribe_default_head, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
            this.l.setVisibility(i3);
            ImageViewBindingAdapters.loadImage(this.l, 0, str8, R.mipmap.ic_tribe_default_head, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
            androidx.databinding.a.e.a(this.p, str7);
            androidx.databinding.a.e.a(this.q, str6);
            androidx.databinding.a.e.a(this.r, str5);
            androidx.databinding.a.e.a(this.s, name3);
            androidx.databinding.a.e.a(this.t, str3);
            androidx.databinding.a.e.a(this.u, str4);
        } else {
            i5 = i;
            str13 = str12;
        }
        if ((j & 24) != 0) {
            ViewBindingAdapters.clickCommand(this.f8820f, replyCommand4, false, 0);
            ViewBindingAdapters.clickCommand(this.i, replyCommand, false, 0);
            ViewBindingAdapters.clickCommand(this.l, replyCommand3, false, 0);
            PageRecyclerViewBindingAdapters.setPageRecyclerView(this.A, cVar, nVar, null, false, false, false, 0, 0, false, null);
            ViewBindingAdapters.clickCommand(this.C, replyCommand2, false, 0);
        }
        if ((j & 16) != 0) {
            this.n.setType("clan");
        }
        if (j11 != 0) {
            this.o.setVisibility(i5);
            androidx.databinding.a.e.a(this.B, str13);
            ImageViewBindingAdapters.loadImage(this.D, 0, pic, 0, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
            androidx.databinding.a.e.a(this.E, str11);
            androidx.databinding.a.e.a(this.F, str2);
        }
        ViewDataBinding.executeBindingsOn(this.n);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.G != 0) {
                return true;
            }
            return this.n.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.G = 16L;
        }
        this.n.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((Di) obj, i2);
        }
        if (i == 1) {
            return a((ObservableField<RankInfoResponse>) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return a((ObservableList<RankInfoResponse>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(androidx.lifecycle.g gVar) {
        super.setLifecycleOwner(gVar);
        this.n.setLifecycleOwner(gVar);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (408 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.W.b.o) obj);
        return true;
    }

    private C0738ua(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (Guideline) objArr[26], (Guideline) objArr[27], (Guideline) objArr[28], (ImageView) objArr[21], (ImageView) objArr[18], (ImageView) objArr[1], (ImageView) objArr[22], (ImageView) objArr[19], (ImageView) objArr[2], (ImageView) objArr[23], (ImageView) objArr[20], (ImageView) objArr[3], (ImageView) objArr[24], (Di) objArr[17], (LinearLayout) objArr[11], (TextView) objArr[5], (TextView) objArr[4], (TextView) objArr[7], (TextView) objArr[6], (TextView) objArr[9], (TextView) objArr[8], (View) objArr[25]);
        this.G = -1L;
        this.f8820f.setTag(null);
        this.i.setTag(null);
        this.l.setTag(null);
        this.o.setTag(null);
        this.z = (ConstraintLayout) objArr[0];
        this.z.setTag(null);
        this.A = (PageRecyclerView) objArr[10];
        this.A.setTag(null);
        this.B = (TextView) objArr[12];
        this.B.setTag(null);
        this.C = (ConstraintLayout) objArr[13];
        this.C.setTag(null);
        this.D = (ImageView) objArr[14];
        this.D.setTag(null);
        this.E = (TextView) objArr[15];
        this.E.setTag(null);
        this.F = (TextView) objArr[16];
        this.F.setTag(null);
        this.p.setTag(null);
        this.q.setTag(null);
        this.r.setTag(null);
        this.s.setTag(null);
        this.t.setTag(null);
        this.u.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(Di di, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.G |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<RankInfoResponse> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.G |= 2;
        }
        return true;
    }

    private boolean a(ObservableList<RankInfoResponse> observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.G |= 4;
        }
        return true;
    }
}
