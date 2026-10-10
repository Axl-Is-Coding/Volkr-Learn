package zlc.season.rxdownload4.notification;

import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Intent;
import androidx.core.app.l;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import zlc.season.claritypotion.ClarityPotion;
import zlc.season.rxdownload4.R;
import zlc.season.rxdownload4.download.request.RequestImpl;
import zlc.season.rxdownload4.manager.C2952a;
import zlc.season.rxdownload4.manager.C2956e;
import zlc.season.rxdownload4.manager.C2957f;
import zlc.season.rxdownload4.manager.H;
import zlc.season.rxdownload4.manager.m;

/* JADX INFO: compiled from: NotificationActionService.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationActionService extends IntentService {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f23984d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23981a = ClarityPotion.f23647d.a().getPackageName() + ".rxdownload.action.START";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f23982b = ClarityPotion.f23647d.a().getPackageName() + ".rxdownload.action.STOP";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f23983c = ClarityPotion.f23647d.a().getPackageName() + ".rxdownload.action.CANCEL";

    /* JADX INFO: compiled from: NotificationActionService.kt */
    public static final class a {
        private a() {
        }

        public final String a() {
            return NotificationActionService.f23983c;
        }

        public final String b() {
            return NotificationActionService.f23981a;
        }

        public final String c() {
            return NotificationActionService.f23982b;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final l.a a(zlc.season.rxdownload4.a.a.a aVar) {
            i.b(aVar, "task");
            l.a aVarA = new l.a.C0008a(R.drawable.ic_cancel, ClarityPotion.f23647d.a().getString(R.string.action_cancel), a(a(), aVar)).a();
            i.a((Object) aVarA, "NotificationCompat.Actio…sk)\n            ).build()");
            return aVarA;
        }

        public final l.a b(zlc.season.rxdownload4.a.a.a aVar) {
            i.b(aVar, "task");
            l.a aVarA = new l.a.C0008a(R.drawable.ic_start, ClarityPotion.f23647d.a().getString(R.string.action_start), a(b(), aVar)).a();
            i.a((Object) aVarA, "NotificationCompat.Actio…sk)\n            ).build()");
            return aVarA;
        }

        public final l.a c(zlc.season.rxdownload4.a.a.a aVar) {
            i.b(aVar, "task");
            l.a aVarA = new l.a.C0008a(R.drawable.ic_pause, ClarityPotion.f23647d.a().getString(R.string.action_stop), a(c(), aVar)).a();
            i.a((Object) aVarA, "NotificationCompat.Actio…sk)\n            ).build()");
            return aVarA;
        }

        private final PendingIntent a(String str, zlc.season.rxdownload4.a.a.a aVar) {
            Intent intent = new Intent(ClarityPotion.f23647d.a(), (Class<?>) NotificationActionService.class);
            intent.setAction(str);
            intent.putExtra("task_url", aVar.d());
            PendingIntent service = PendingIntent.getService(ClarityPotion.f23647d.a(), aVar.hashCode(), intent, 134217728);
            i.a((Object) service, "PendingIntent.getService…ent, FLAG_UPDATE_CURRENT)");
            return service;
        }
    }

    public NotificationActionService() {
        super("NotificationActionService");
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("task_url");
            if (stringExtra == null) {
                stringExtra = "";
            }
            String str = stringExtra;
            if (!(str.length() > 0)) {
                throw new IllegalStateException("Invalid url!");
            }
            H hA = m.a(str, (Map<String, String>) ((1791 & 1) != 0 ? zlc.season.rxdownload4.a.b.b() : null), (1791 & 2) != 0 ? 5 : 0, (1791 & 4) != 0 ? 4194304L : 0L, (1791 & 8) != 0 ? zlc.season.rxdownload4.download.downloader.a.f23871a : null, (1791 & 16) != 0 ? zlc.season.rxdownload4.a.b.a.f23867a : null, (1791 & 32) != 0 ? zlc.season.rxdownload4.download.storage.b.f23929e : null, (1791 & 64) != 0 ? RequestImpl.f23923b : null, (1791 & 128) != 0 ? zlc.season.rxdownload4.a.c.b.f23870c : null, (1791 & 256) != 0 ? C2956e.f23957a : new b(), (1791 & 512) != 0 ? C2957f.f23958a : null, (1791 & 1024) != 0 ? C2952a.C0280a.a(C2952a.f23953b, 0, 1, null) : null);
            String action = intent.getAction();
            if (i.a((Object) action, (Object) f23981a)) {
                m.b(hA);
            } else if (i.a((Object) action, (Object) f23982b)) {
                m.c(hA);
            } else if (i.a((Object) action, (Object) f23983c)) {
                m.a(hA);
            }
        }
    }
}
