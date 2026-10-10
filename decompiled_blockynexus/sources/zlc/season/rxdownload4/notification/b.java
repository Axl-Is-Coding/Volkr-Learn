package zlc.season.rxdownload4.notification;

import android.app.Notification;
import androidx.core.app.l;
import com.facebook.internal.AnalyticsEvents;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Triple;
import kotlin.collections.m;
import kotlin.e;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.k;
import kotlin.reflect.g;
import zlc.season.claritypotion.ClarityPotion;
import zlc.season.rxdownload4.R;
import zlc.season.rxdownload4.download.utils.c;
import zlc.season.rxdownload4.manager.C2953b;
import zlc.season.rxdownload4.manager.C2954c;
import zlc.season.rxdownload4.manager.C2955d;
import zlc.season.rxdownload4.manager.C2958g;
import zlc.season.rxdownload4.manager.C2959h;
import zlc.season.rxdownload4.manager.InterfaceC2960i;
import zlc.season.rxdownload4.manager.o;
import zlc.season.rxdownload4.manager.p;
import zlc.season.rxdownload4.notification.b;

/* JADX INFO: compiled from: SimpleNotificationCreator.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements InterfaceC2960i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ g[] f23987a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zlc.season.rxdownload4.a.a.a f23991e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f23988b = "RxDownload";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f23989c = "RxDownload";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f23990d = "RxDownload";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e f23992f = kotlin.g.a(new kotlin.jvm.a.a<a>() { // from class: zlc.season.rxdownload4.notification.SimpleNotificationCreator$builderHelper$2
        {
            super(0);
        }

        @Override // kotlin.jvm.a.a
        public final b.a invoke() {
            return new b.a(this.this$0.f23988b, b.b(this.this$0));
        }
    });

    /* JADX INFO: compiled from: SimpleNotificationCreator.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ g[] f23993a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<p, l.e> f23994b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final e f23995c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final e f23996d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final e f23997e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final e f23998f;
        private final e g;
        private final e h;
        private final e i;
        private final e j;
        private final e k;
        private final e l;
        private final String m;
        private final zlc.season.rxdownload4.a.a.a n;

        static {
            PropertyReference1Impl propertyReference1Impl = new PropertyReference1Impl(k.a(a.class), "pendingContent", "getPendingContent()Ljava/lang/String;");
            k.a(propertyReference1Impl);
            PropertyReference1Impl propertyReference1Impl2 = new PropertyReference1Impl(k.a(a.class), "startedContent", "getStartedContent()Ljava/lang/String;");
            k.a(propertyReference1Impl2);
            PropertyReference1Impl propertyReference1Impl3 = new PropertyReference1Impl(k.a(a.class), "pausedContent", "getPausedContent()Ljava/lang/String;");
            k.a(propertyReference1Impl3);
            PropertyReference1Impl propertyReference1Impl4 = new PropertyReference1Impl(k.a(a.class), "failedContent", "getFailedContent()Ljava/lang/String;");
            k.a(propertyReference1Impl4);
            PropertyReference1Impl propertyReference1Impl5 = new PropertyReference1Impl(k.a(a.class), "completedContent", "getCompletedContent()Ljava/lang/String;");
            k.a(propertyReference1Impl5);
            PropertyReference1Impl propertyReference1Impl6 = new PropertyReference1Impl(k.a(a.class), "pendingActions", "getPendingActions()Ljava/util/List;");
            k.a(propertyReference1Impl6);
            PropertyReference1Impl propertyReference1Impl7 = new PropertyReference1Impl(k.a(a.class), "startedActions", "getStartedActions()Ljava/util/List;");
            k.a(propertyReference1Impl7);
            PropertyReference1Impl propertyReference1Impl8 = new PropertyReference1Impl(k.a(a.class), "downloadingActions", "getDownloadingActions()Ljava/util/List;");
            k.a(propertyReference1Impl8);
            PropertyReference1Impl propertyReference1Impl9 = new PropertyReference1Impl(k.a(a.class), "pausedActions", "getPausedActions()Ljava/util/List;");
            k.a(propertyReference1Impl9);
            PropertyReference1Impl propertyReference1Impl10 = new PropertyReference1Impl(k.a(a.class), "failedActions", "getFailedActions()Ljava/util/List;");
            k.a(propertyReference1Impl10);
            f23993a = new g[]{propertyReference1Impl, propertyReference1Impl2, propertyReference1Impl3, propertyReference1Impl4, propertyReference1Impl5, propertyReference1Impl6, propertyReference1Impl7, propertyReference1Impl8, propertyReference1Impl9, propertyReference1Impl10};
        }

        public a(String str, zlc.season.rxdownload4.a.a.a aVar) {
            i.b(str, "channelId");
            i.b(aVar, "task");
            this.m = str;
            this.n = aVar;
            this.f23994b = new LinkedHashMap();
            this.f23995c = kotlin.g.a(new kotlin.jvm.a.a<String>() { // from class: zlc.season.rxdownload4.notification.SimpleNotificationCreator$BuilderHelper$pendingContent$2
                @Override // kotlin.jvm.a.a
                public final String invoke() {
                    return ClarityPotion.f23647d.a().getString(R.string.notification_pending_text);
                }
            });
            this.f23996d = kotlin.g.a(new kotlin.jvm.a.a<String>() { // from class: zlc.season.rxdownload4.notification.SimpleNotificationCreator$BuilderHelper$startedContent$2
                @Override // kotlin.jvm.a.a
                public final String invoke() {
                    return ClarityPotion.f23647d.a().getString(R.string.notification_started_text);
                }
            });
            this.f23997e = kotlin.g.a(new kotlin.jvm.a.a<String>() { // from class: zlc.season.rxdownload4.notification.SimpleNotificationCreator$BuilderHelper$pausedContent$2
                @Override // kotlin.jvm.a.a
                public final String invoke() {
                    return ClarityPotion.f23647d.a().getString(R.string.notification_paused_text);
                }
            });
            this.f23998f = kotlin.g.a(new kotlin.jvm.a.a<String>() { // from class: zlc.season.rxdownload4.notification.SimpleNotificationCreator$BuilderHelper$failedContent$2
                @Override // kotlin.jvm.a.a
                public final String invoke() {
                    return ClarityPotion.f23647d.a().getString(R.string.notification_failed_text);
                }
            });
            this.g = kotlin.g.a(new kotlin.jvm.a.a<String>() { // from class: zlc.season.rxdownload4.notification.SimpleNotificationCreator$BuilderHelper$completedContent$2
                @Override // kotlin.jvm.a.a
                public final String invoke() {
                    return ClarityPotion.f23647d.a().getString(R.string.notification_completed_text);
                }
            });
            this.h = kotlin.g.a(new kotlin.jvm.a.a<List<? extends l.a>>() { // from class: zlc.season.rxdownload4.notification.SimpleNotificationCreator$BuilderHelper$pendingActions$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.a.a
                public final List<? extends l.a> invoke() {
                    return m.b(NotificationActionService.f23984d.c(this.this$0.n), NotificationActionService.f23984d.a(this.this$0.n));
                }
            });
            this.i = kotlin.g.a(new kotlin.jvm.a.a<List<? extends l.a>>() { // from class: zlc.season.rxdownload4.notification.SimpleNotificationCreator$BuilderHelper$startedActions$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.a.a
                public final List<? extends l.a> invoke() {
                    return m.b(NotificationActionService.f23984d.c(this.this$0.n), NotificationActionService.f23984d.a(this.this$0.n));
                }
            });
            this.j = kotlin.g.a(new kotlin.jvm.a.a<List<? extends l.a>>() { // from class: zlc.season.rxdownload4.notification.SimpleNotificationCreator$BuilderHelper$downloadingActions$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.a.a
                public final List<? extends l.a> invoke() {
                    return m.b(NotificationActionService.f23984d.c(this.this$0.n), NotificationActionService.f23984d.a(this.this$0.n));
                }
            });
            this.k = kotlin.g.a(new kotlin.jvm.a.a<List<? extends l.a>>() { // from class: zlc.season.rxdownload4.notification.SimpleNotificationCreator$BuilderHelper$pausedActions$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.a.a
                public final List<? extends l.a> invoke() {
                    return m.b(NotificationActionService.f23984d.b(this.this$0.n), NotificationActionService.f23984d.a(this.this$0.n));
                }
            });
            this.l = kotlin.g.a(new kotlin.jvm.a.a<List<? extends l.a>>() { // from class: zlc.season.rxdownload4.notification.SimpleNotificationCreator$BuilderHelper$failedActions$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.a.a
                public final List<? extends l.a> invoke() {
                    return m.b(NotificationActionService.f23984d.b(this.this$0.n), NotificationActionService.f23984d.a(this.this$0.n));
                }
            });
        }

        private final String a() {
            e eVar = this.g;
            g gVar = f23993a[4];
            return (String) eVar.getValue();
        }

        private final l.e b(p pVar) {
            Triple triple;
            l.e eVar = this.f23994b.get(pVar);
            if (eVar != null) {
                return eVar;
            }
            if (pVar instanceof C2959h) {
                triple = new Triple("", m.a(), 0);
            } else if (pVar instanceof zlc.season.rxdownload4.manager.l) {
                triple = new Triple(h(), g(), Integer.valueOf(R.drawable.ic_download));
            } else if (pVar instanceof o) {
                triple = new Triple(j(), i(), Integer.valueOf(R.drawable.ic_download));
            } else if (pVar instanceof C2955d) {
                triple = new Triple("", b(), Integer.valueOf(R.drawable.ic_download));
            } else if (pVar instanceof zlc.season.rxdownload4.manager.k) {
                triple = new Triple(f(), e(), Integer.valueOf(R.drawable.ic_pause));
            } else if (pVar instanceof C2958g) {
                triple = new Triple(d(), c(), Integer.valueOf(R.drawable.ic_pause));
            } else if (pVar instanceof C2953b) {
                triple = new Triple(a(), m.a(), Integer.valueOf(R.drawable.ic_completed));
            } else {
                if (!(pVar instanceof C2954c)) {
                    throw new NoWhenBranchMatchedException();
                }
                triple = new Triple("", m.a(), 0);
            }
            String str = (String) triple.component1();
            List list = (List) triple.component2();
            int iIntValue = ((Number) triple.component3()).intValue();
            String str2 = this.m;
            String strC = this.n.c();
            i.a((Object) str, "content");
            l.e eVarA = zlc.season.rxdownload4.notification.a.a(str2, strC, str, iIntValue, (48 & 16) != 0 ? null : null, (48 & 32) != 0 ? null : null, (48 & 64) != 0 ? m.a() : list);
            this.f23994b.put(pVar, eVarA);
            return eVarA;
        }

        private final List<l.a> b() {
            e eVar = this.j;
            g gVar = f23993a[7];
            return (List) eVar.getValue();
        }

        private final List<l.a> c() {
            e eVar = this.l;
            g gVar = f23993a[9];
            return (List) eVar.getValue();
        }

        private final String d() {
            e eVar = this.f23998f;
            g gVar = f23993a[3];
            return (String) eVar.getValue();
        }

        private final List<l.a> e() {
            e eVar = this.k;
            g gVar = f23993a[8];
            return (List) eVar.getValue();
        }

        private final String f() {
            e eVar = this.f23997e;
            g gVar = f23993a[2];
            return (String) eVar.getValue();
        }

        private final List<l.a> g() {
            e eVar = this.h;
            g gVar = f23993a[5];
            return (List) eVar.getValue();
        }

        private final String h() {
            e eVar = this.f23995c;
            g gVar = f23993a[0];
            return (String) eVar.getValue();
        }

        private final List<l.a> i() {
            e eVar = this.i;
            g gVar = f23993a[6];
            return (List) eVar.getValue();
        }

        private final String j() {
            e eVar = this.f23996d;
            g gVar = f23993a[1];
            return (String) eVar.getValue();
        }

        public final l.e a(p pVar) {
            i.b(pVar, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
            l.e eVarB = b(pVar);
            if (pVar instanceof C2955d) {
                eVarB.a((int) pVar.a().c(), (int) pVar.a().a(), pVar.a().d());
            } else if ((pVar instanceof C2959h) || (pVar instanceof C2954c)) {
                return null;
            }
            return eVarB;
        }
    }

    static {
        PropertyReference1Impl propertyReference1Impl = new PropertyReference1Impl(k.a(b.class), "builderHelper", "getBuilderHelper()Lzlc/season/rxdownload4/notification/SimpleNotificationCreator$BuilderHelper;");
        k.a(propertyReference1Impl);
        f23987a = new g[]{propertyReference1Impl};
    }

    private final a a() {
        e eVar = this.f23992f;
        g gVar = f23987a[0];
        return (a) eVar.getValue();
    }

    public static final /* synthetic */ zlc.season.rxdownload4.a.a.a b(b bVar) {
        zlc.season.rxdownload4.a.a.a aVar = bVar.f23991e;
        if (aVar != null) {
            return aVar;
        }
        i.c("task");
        throw null;
    }

    @Override // zlc.season.rxdownload4.manager.InterfaceC2960i
    public void a(zlc.season.rxdownload4.a.a.a aVar) {
        i.b(aVar, "task");
        this.f23991e = aVar;
        if (!zlc.season.rxdownload4.notification.a.a()) {
            c.a("Notification not enable", null, 1, null);
        }
        zlc.season.rxdownload4.notification.a.a(this.f23988b, this.f23989c, this.f23990d);
    }

    @Override // zlc.season.rxdownload4.manager.InterfaceC2960i
    public Notification a(zlc.season.rxdownload4.a.a.a aVar, p pVar) {
        i.b(aVar, "task");
        i.b(pVar, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
        l.e eVarA = a().a(pVar);
        if (eVarA != null) {
            return eVarA.a();
        }
        return null;
    }
}
