package zlc.season.rxdownload4.download.storage;

import android.content.SharedPreferences;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.util.List;
import kotlin.e;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.k;
import kotlin.reflect.g;
import kotlin.text.o;
import zlc.season.claritypotion.ClarityPotion;

/* JADX INFO: compiled from: SimpleStorage.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final /* synthetic */ g[] f23927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final e f23928d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f23929e;

    static {
        PropertyReference1Impl propertyReference1Impl = new PropertyReference1Impl(k.a(b.class), "sp", "getSp()Landroid/content/SharedPreferences;");
        k.a(propertyReference1Impl);
        f23927c = new g[]{propertyReference1Impl};
        f23929e = new b();
        f23928d = kotlin.g.a(new kotlin.jvm.a.a<SharedPreferences>() { // from class: zlc.season.rxdownload4.download.storage.SimpleStorage$sp$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.a.a
            public final SharedPreferences invoke() {
                return ClarityPotion.f23647d.a().getSharedPreferences("rxdownload_simple_storage", 0);
            }
        });
    }

    private b() {
    }

    private final SharedPreferences a() {
        e eVar = f23928d;
        g gVar = f23927c[0];
        return (SharedPreferences) eVar.getValue();
    }

    private final void d(zlc.season.rxdownload4.a.a.a aVar) {
        a().edit().remove(String.valueOf(aVar.hashCode())).apply();
    }

    private final void e(zlc.season.rxdownload4.a.a.a aVar) {
        String string = a().getString(String.valueOf(aVar.hashCode()), "");
        if (string == null || string.length() == 0) {
            return;
        }
        List listA = o.a((CharSequence) string, new String[]{UMCustomLogInfoBuilder.LINE_SEP}, false, 0, 6, (Object) null);
        if (listA.size() == 3) {
            aVar.c((String) listA.get(0));
            aVar.a((String) listA.get(1));
            aVar.b((String) listA.get(2));
        }
    }

    private final void f(zlc.season.rxdownload4.a.a.a aVar) {
        String strValueOf = String.valueOf(aVar.hashCode());
        String str = aVar.c() + UMCustomLogInfoBuilder.LINE_SEP + aVar.a() + UMCustomLogInfoBuilder.LINE_SEP + aVar.b() + UMCustomLogInfoBuilder.LINE_SEP + aVar.d();
        SharedPreferences.Editor editorEdit = a().edit();
        editorEdit.putString(strValueOf, str);
        editorEdit.apply();
    }

    @Override // zlc.season.rxdownload4.download.storage.a, zlc.season.rxdownload4.download.storage.c
    public synchronized void a(zlc.season.rxdownload4.a.a.a aVar) {
        i.b(aVar, "task");
        super.a(aVar);
        d(aVar);
    }

    @Override // zlc.season.rxdownload4.download.storage.a, zlc.season.rxdownload4.download.storage.c
    public synchronized void b(zlc.season.rxdownload4.a.a.a aVar) {
        i.b(aVar, "task");
        super.b(aVar);
        f(aVar);
    }

    @Override // zlc.season.rxdownload4.download.storage.a, zlc.season.rxdownload4.download.storage.c
    public synchronized void c(zlc.season.rxdownload4.a.a.a aVar) {
        i.b(aVar, "task");
        super.c(aVar);
        if (aVar.e()) {
            e(aVar);
            super.b(aVar);
        }
    }
}
