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

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.wa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ContentRankGdiamondDetailPageBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0760wa extends AbstractC0749va {
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

    public C0760wa(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 29, x, y));
    }

    public void a(com.disabngo.blockynexus.e.b.W.c.o oVar) {
        this.w = oVar;
        synchronized (this) {
            this.G |= 8;
        }
        notifyPropertyChanged(272);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        String name;
        boolean z;
        int i3;
        ReplyCommand replyCommand;
        ReplyCommand replyCommand2;
        String str;
        int i4;
        boolean z2;
        ObservableList observableList;
        ReplyCommand replyCommand3;
        ReplyCommand replyCommand4;
        boolean z3;
        boolean z4;
        boolean z5;
        long rank;
        String str2;
        com.disabngo.blockynexus.e.b.W.c cVar;
        com.disabngo.blockynexus.e.b.W.c.n nVar;
        String str3;
        String pic;
        String name2;
        String strValueOf;
        String str4;
        String str5;
        String str6;
        String pic2;
        String strValueOf2;
        String name3;
        String str7;
        String name4;
        String strValueOf3;
        String pic3;
        int i5;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        long j2;
        String str13;
        String str14;
        String str15;
        String str16;
        ReplyCommand replyCommand5;
        RankInfoResponse rankInfoResponse;
        RankInfoResponse rankInfoResponse2;
        RankInfoResponse rankInfoResponse3;
        int i6;
        int i7;
        com.disabngo.blockynexus.e.b.W.c cVar2;
        com.disabngo.blockynexus.e.b.W.c.n nVar2;
        String pic4;
        long quantity;
        long id;
        long j3;
        boolean z6;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        synchronized (this) {
            j = this.G;
            this.G = 0L;
        }
        com.disabngo.blockynexus.e.b.W.c.o oVar = this.w;
        if ((30 & j) != 0) {
            long j10 = j & 26;
            if (j10 != 0) {
                observableList = oVar != null ? oVar.f9568b : null;
                updateRegistration(1, observableList);
                int size = observableList != null ? observableList.size() : 0;
                z3 = size > 1;
                boolean z7 = size > 0;
                boolean z8 = size > 2;
                if (j10 != 0) {
                    if (z3) {
                        j8 = j | PlaybackStateCompat.ACTION_SET_REPEAT_MODE | 1048576 | 4294967296L;
                        j9 = 17179869184L;
                    } else {
                        j8 = j | PlaybackStateCompat.ACTION_PREPARE_FROM_URI | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED | 2147483648L;
                        j9 = 8589934592L;
                    }
                    j = j8 | j9;
                }
                if ((j & 26) != 0) {
                    if (z7) {
                        j6 = j | 256 | PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM | 16777216;
                        j7 = ConvertUtils.GB;
                    } else {
                        j6 = j | 128 | PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH | 8388608;
                        j7 = 536870912;
                    }
                    j = j6 | j7;
                }
                if ((j & 26) != 0) {
                    if (z8) {
                        j4 = j | 64 | 1024 | 4194304;
                        j5 = 268435456;
                    } else {
                        j4 = j | 32 | 512 | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                        j5 = 134217728;
                    }
                    j = j4 | j5;
                }
                int i8 = z3 ? 0 : 4;
                i7 = z7 ? 0 : 4;
                int i9 = i8;
                i3 = z8 ? 0 : 4;
                z = z8;
                z2 = z7;
                i6 = i9;
            } else {
                z = false;
                i3 = 0;
                z2 = false;
                observableList = null;
                z3 = false;
                i6 = 0;
                i7 = 0;
            }
            if ((j & 24) == 0 || oVar == null) {
                replyCommand = null;
                replyCommand2 = null;
                cVar2 = null;
                nVar2 = null;
                replyCommand3 = null;
                replyCommand4 = null;
            } else {
                replyCommand = oVar.f9572f;
                replyCommand2 = oVar.h;
                cVar2 = oVar.f9570d;
                nVar2 = oVar.f9571e;
                replyCommand4 = oVar.g;
                replyCommand3 = oVar.i;
            }
            long j11 = j & 28;
            if (j11 != 0) {
                ObservableField<RankInfoResponse> observableField = oVar != null ? oVar.f9569c : null;
                updateRegistration(2, observableField);
                RankInfoResponse rankInfoResponse4 = observableField != null ? observableField.get() : null;
                if (rankInfoResponse4 != null) {
                    pic4 = rankInfoResponse4.getPic();
                    quantity = rankInfoResponse4.getQuantity();
                    name = rankInfoResponse4.getName();
                    rank = rankInfoResponse4.getRank();
                    id = rankInfoResponse4.getId();
                } else {
                    pic4 = null;
                    name = null;
                    quantity = 0;
                    rank = 0;
                    id = 0;
                }
                String strValueOf4 = String.valueOf(quantity);
                z4 = name != null;
                z5 = rank == -1;
                if (id == -1) {
                    j3 = 0;
                    z6 = true;
                } else {
                    j3 = 0;
                    z6 = false;
                }
                if (j11 != j3) {
                    j |= z4 ? PlaybackStateCompat.ACTION_PREPARE : PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                }
                if ((j & 28) != j3) {
                    j = z5 ? j | 67108864 : j | 33554432;
                }
                if ((j & 28) != j3) {
                    j |= z6 ? 65536L : PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                }
                str2 = pic4;
                cVar = cVar2;
                nVar = nVar2;
                i4 = i6;
                i2 = z6 ? 8 : 0;
                str = strValueOf4;
                i = i7;
            } else {
                cVar = cVar2;
                nVar = nVar2;
                i4 = i6;
                i = i7;
                i2 = 0;
                name = null;
                str = null;
                z4 = false;
                z5 = false;
                rank = 0;
                str2 = null;
            }
        } else {
            i = 0;
            i2 = 0;
            name = null;
            z = false;
            i3 = 0;
            replyCommand = null;
            replyCommand2 = null;
            str = null;
            i4 = 0;
            z2 = false;
            observableList = null;
            replyCommand3 = null;
            replyCommand4 = null;
            z3 = false;
            z4 = false;
            z5 = false;
            rank = 0;
            str2 = null;
            cVar = null;
            nVar = null;
        }
        if ((j & 272629824) != 0) {
            if (observableList != null) {
                str3 = name;
                rankInfoResponse3 = (RankInfoResponse) observableList.get(2);
            } else {
                str3 = name;
                rankInfoResponse3 = null;
            }
            name2 = ((j & 64) == 0 || rankInfoResponse3 == null) ? null : rankInfoResponse3.getName();
            if ((j & 268435456) != 0) {
                strValueOf = String.valueOf(rankInfoResponse3 != null ? rankInfoResponse3.getQuantity() : 0L);
            } else {
                strValueOf = null;
            }
            pic = ((j & 4194304) == 0 || rankInfoResponse3 == null) ? null : rankInfoResponse3.getPic();
        } else {
            str3 = name;
            pic = null;
            name2 = null;
            strValueOf = null;
        }
        long j12 = j & 28;
        if (j12 != 0) {
            if (!z4) {
                str3 = "";
            }
            str4 = pic;
            str5 = str3;
        } else {
            str4 = pic;
            str5 = null;
        }
        String strValueOf5 = (j & 33554432) != 0 ? String.valueOf(rank) : null;
        if ((j & 4296278016L) != 0) {
            if (observableList != null) {
                str6 = str;
                rankInfoResponse2 = (RankInfoResponse) observableList.get(1);
            } else {
                str6 = str;
                rankInfoResponse2 = null;
            }
            if ((j & PlaybackStateCompat.ACTION_SET_REPEAT_MODE) != 0) {
                strValueOf2 = String.valueOf(rankInfoResponse2 != null ? rankInfoResponse2.getQuantity() : 0L);
            } else {
                strValueOf2 = null;
            }
            name3 = ((j & 1048576) == 0 || rankInfoResponse2 == null) ? null : rankInfoResponse2.getName();
            pic2 = ((j & 4294967296L) == 0 || rankInfoResponse2 == null) ? null : rankInfoResponse2.getPic();
        } else {
            str6 = str;
            pic2 = null;
            strValueOf2 = null;
            name3 = null;
        }
        if ((j & 1090523136) != 0) {
            if (observableList != null) {
                str7 = pic2;
                rankInfoResponse = (RankInfoResponse) observableList.get(0);
            } else {
                str7 = pic2;
                rankInfoResponse = null;
            }
            name4 = ((j & PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) == 0 || rankInfoResponse == null) ? null : rankInfoResponse.getName();
            pic3 = ((j & ConvertUtils.GB) == 0 || rankInfoResponse == null) ? null : rankInfoResponse.getPic();
            if ((j & 16777216) != 0) {
                strValueOf3 = String.valueOf(rankInfoResponse != null ? rankInfoResponse.getQuantity() : 0L);
            } else {
                strValueOf3 = null;
            }
        } else {
            str7 = pic2;
            name4 = null;
            strValueOf3 = null;
            pic3 = null;
        }
        long j13 = j & 26;
        if (j13 != 0) {
            if (!z) {
                name2 = "";
            }
            if (!z2) {
                name4 = "";
            }
            if (!z3) {
                strValueOf2 = "";
            }
            if (!z3) {
                name3 = "";
            }
            if (!z) {
                str4 = "";
            }
            if (!z2) {
                strValueOf3 = "";
            }
            if (!z) {
                strValueOf = "";
            }
            if (!z2) {
                pic3 = "";
            }
            str15 = z3 ? str7 : "";
            str11 = name2;
            str12 = strValueOf;
            str14 = str4;
            str13 = pic3;
            i5 = i2;
            str8 = str5;
            str10 = strValueOf2;
            str9 = name3;
            j2 = 0;
        } else {
            i5 = i2;
            str8 = str5;
            str9 = null;
            str10 = null;
            str11 = null;
            name4 = null;
            str12 = null;
            strValueOf3 = null;
            j2 = 0;
            str13 = null;
            str14 = null;
            str15 = null;
        }
        if (j12 != j2) {
            if (z5) {
                strValueOf5 = "-";
            }
            str16 = strValueOf5;
        } else {
            str16 = null;
        }
        if (j13 != j2) {
            replyCommand5 = replyCommand3;
            this.f8894f.setVisibility(i);
            ImageViewBindingAdapters.loadImage(this.f8894f, 0, str13, R.mipmap.ic_head_default, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
            this.i.setVisibility(i4);
            ImageViewBindingAdapters.loadImage(this.i, 0, str15, R.mipmap.ic_head_default, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
            this.l.setVisibility(i3);
            ImageViewBindingAdapters.loadImage(this.l, 0, str14, R.mipmap.ic_head_default, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
            androidx.databinding.a.e.a(this.p, strValueOf3);
            androidx.databinding.a.e.a(this.q, name4);
            androidx.databinding.a.e.a(this.r, str10);
            androidx.databinding.a.e.a(this.s, str9);
            androidx.databinding.a.e.a(this.t, str12);
            androidx.databinding.a.e.a(this.u, str11);
        } else {
            replyCommand5 = replyCommand3;
        }
        if ((j & 24) != 0) {
            ViewBindingAdapters.clickCommand(this.f8894f, replyCommand, false, 0);
            ViewBindingAdapters.clickCommand(this.i, replyCommand4, false, 0);
            ViewBindingAdapters.clickCommand(this.l, replyCommand2, false, 0);
            PageRecyclerViewBindingAdapters.setPageRecyclerView(this.A, cVar, nVar, null, false, false, false, 0, 0, false, null);
            ViewBindingAdapters.clickCommand(this.C, replyCommand5, false, 0);
        }
        if ((j & 16) != 0) {
            this.n.setType("gDiamond");
        }
        if (j12 != 0) {
            this.o.setVisibility(i5);
            androidx.databinding.a.e.a(this.B, str16);
            ImageViewBindingAdapters.loadImage(this.D, 0, str2, R.mipmap.ic_head_default, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
            androidx.databinding.a.e.a(this.E, str8);
            androidx.databinding.a.e.a(this.F, str6);
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
            return a((ObservableList<RankInfoResponse>) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return a((ObservableField<RankInfoResponse>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(androidx.lifecycle.g gVar) {
        super.setLifecycleOwner(gVar);
        this.n.setLifecycleOwner(gVar);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (272 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.W.c.o) obj);
        return true;
    }

    private C0760wa(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (Guideline) objArr[26], (Guideline) objArr[27], (Guideline) objArr[28], (ImageView) objArr[21], (ImageView) objArr[18], (ImageView) objArr[1], (ImageView) objArr[22], (ImageView) objArr[19], (ImageView) objArr[2], (ImageView) objArr[23], (ImageView) objArr[20], (ImageView) objArr[3], (ImageView) objArr[24], (Di) objArr[17], (LinearLayout) objArr[11], (TextView) objArr[5], (TextView) objArr[4], (TextView) objArr[7], (TextView) objArr[6], (TextView) objArr[9], (TextView) objArr[8], (View) objArr[25]);
        this.G = -1L;
        this.f8894f.setTag(null);
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

    private boolean a(ObservableList<RankInfoResponse> observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.G |= 2;
        }
        return true;
    }

    private boolean a(ObservableField<RankInfoResponse> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.G |= 4;
        }
        return true;
    }
}
