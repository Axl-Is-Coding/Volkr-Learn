package com.disabngo.blockynexus.view.activity.overviewrank;

import android.content.Context;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.greendao.entity.TopRankInfo;
import rx.functions.Action0;

/* JADX INFO: compiled from: OverViewRankItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends ListItemViewModel<TopRankInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReplyCommand f11044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11045b;

    public f(Context context, String str, TopRankInfo topRankInfo) {
        super(context, topRankInfo);
        this.f11044a = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.overviewrank.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f11039a.f();
            }
        });
        this.f11045b = "overall".equals(str) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void f() {
        /*
            r6 = this;
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            int r1 = r6.f11045b
            java.lang.String r2 = "rank_period_type"
            r0.putInt(r2, r1)
            T r1 = r6.item
            com.sandboxol.greendao.entity.TopRankInfo r1 = (com.sandboxol.greendao.entity.TopRankInfo) r1
            java.lang.String r1 = r1.getType()
            int r2 = r1.hashCode()
            r3 = -1854421267(0xffffffff9177c6ed, float:-1.9546163E-28)
            r4 = 2
            r5 = 1
            if (r2 == r3) goto L3e
            r3 = -1422950650(0xffffffffab2f7f06, float:-6.234877E-13)
            if (r2 == r3) goto L34
            r3 = 3056214(0x2ea256, float:4.282668E-39)
            if (r2 == r3) goto L2a
            goto L48
        L2a:
            java.lang.String r2 = "clan"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L48
            r1 = 2
            goto L49
        L34:
            java.lang.String r2 = "active"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L48
            r1 = 1
            goto L49
        L3e:
            java.lang.String r2 = "gDiamond"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L48
            r1 = 0
            goto L49
        L48:
            r1 = -1
        L49:
            if (r1 == 0) goto L86
            if (r1 == r5) goto L6b
            if (r1 == r4) goto L50
            goto La0
        L50:
            android.content.Context r1 = r6.context
            java.lang.Class<com.disabngo.blockynexus.e.b.W.b.h> r2 = com.disabngo.blockynexus.e.b.W.b.h.class
            T r3 = r6.item
            com.sandboxol.greendao.entity.TopRankInfo r3 = (com.sandboxol.greendao.entity.TopRankInfo) r3
            java.lang.String r3 = r3.getType()
            java.lang.String r3 = com.disabngo.blockynexus.d.G.b(r3)
            com.sandboxol.center.utils.TemplateUtils.startTemplate(r1, r2, r3, r0)
            android.content.Context r0 = r6.context
            java.lang.String r1 = "rank_clan_click"
            com.sandboxol.common.interfaces.ReportDataAdapter.onEvent(r0, r1)
            goto La0
        L6b:
            android.content.Context r1 = r6.context
            java.lang.Class<com.disabngo.blockynexus.e.b.W.a.h> r2 = com.disabngo.blockynexus.e.b.W.a.h.class
            T r3 = r6.item
            com.sandboxol.greendao.entity.TopRankInfo r3 = (com.sandboxol.greendao.entity.TopRankInfo) r3
            java.lang.String r3 = r3.getType()
            java.lang.String r3 = com.disabngo.blockynexus.d.G.b(r3)
            com.sandboxol.center.utils.TemplateUtils.startTemplate(r1, r2, r3, r0)
            android.content.Context r0 = r6.context
            java.lang.String r1 = "rank_active_click"
            com.sandboxol.common.interfaces.ReportDataAdapter.onEvent(r0, r1)
            goto La0
        L86:
            android.content.Context r1 = r6.context
            java.lang.Class<com.disabngo.blockynexus.e.b.W.c.h> r2 = com.disabngo.blockynexus.e.b.W.c.h.class
            T r3 = r6.item
            com.sandboxol.greendao.entity.TopRankInfo r3 = (com.sandboxol.greendao.entity.TopRankInfo) r3
            java.lang.String r3 = r3.getType()
            java.lang.String r3 = com.disabngo.blockynexus.d.G.b(r3)
            com.sandboxol.center.utils.TemplateUtils.startTemplate(r1, r2, r3, r0)
            android.content.Context r0 = r6.context
            java.lang.String r1 = "rank_rich_click"
            com.sandboxol.common.interfaces.ReportDataAdapter.onEvent(r0, r1)
        La0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.view.activity.overviewrank.f.f():void");
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public TopRankInfo getItem() {
        return (TopRankInfo) super.getItem();
    }
}
