package zlc.season.rxdownload3.core;

import io.reactivex.b.o;
import io.reactivex.e;
import io.reactivex.f.b;
import io.reactivex.i;
import io.reactivex.internal.operators.maybe.MaybeToPublisher;
import io.reactivex.j;
import io.reactivex.l;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Semaphore;
import zlc.season.rxdownload3.extension.Extension;
import zlc.season.rxdownload3.helper.UtilsKt;

/* JADX INFO: compiled from: LocalMissionBox.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class LocalMissionBox implements MissionBox {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f23675a = DownloadConfig.r.j();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Semaphore f23676b = new Semaphore(this.f23675a, true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<RealMission> f23677c = new LinkedHashSet();

    public i<Object> c() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.f23677c.iterator();
        while (it.hasNext()) {
            arrayList.add(((RealMission) it.next()).i());
        }
        i<Object> iVarC = e.b(arrayList).b(MaybeToPublisher.INSTANCE).c();
        kotlin.jvm.internal.i.a((Object) iVarC, "Flowable.fromIterable(ar…           .lastElement()");
        return iVarC;
    }

    public i<Boolean> d(final Mission mission) {
        kotlin.jvm.internal.i.b(mission, "mission");
        i<Boolean> iVarA = i.a((l) new l<T>() { // from class: zlc.season.rxdownload3.core.LocalMissionBox$isExists$1
            @Override // io.reactivex.l
            public final void a(j<Boolean> jVar) {
                T next;
                kotlin.jvm.internal.i.b(jVar, "it");
                Iterator<T> it = this.f23684a.f23677c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = (T) null;
                        break;
                    } else {
                        next = it.next();
                        if (kotlin.jvm.internal.i.a(((RealMission) next).b(), mission)) {
                            break;
                        }
                    }
                }
                if (next != null) {
                    jVar.onSuccess(true);
                    return;
                }
                RealMission realMission = new RealMission(mission, this.f23684a.f23676b, false, false, 4, null);
                if (DownloadConfig.r.f()) {
                    jVar.onSuccess(Boolean.valueOf(DownloadConfig.r.d().a(realMission)));
                } else {
                    jVar.onSuccess(false);
                }
            }
        });
        kotlin.jvm.internal.i.a((Object) iVarA, "Maybe.create<Boolean> {\n…}\n            }\n        }");
        return iVarA;
    }

    public i<Object> e(Mission mission) {
        Object next;
        kotlin.jvm.internal.i.b(mission, "mission");
        Iterator<T> it = this.f23677c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (kotlin.jvm.internal.i.a(((RealMission) next).b(), mission)) {
                break;
            }
        }
        RealMission realMission = (RealMission) next;
        if (realMission != null) {
            return realMission.i();
        }
        i<Object> iVarA = i.a((Throwable) new RuntimeException("Mission not create"));
        kotlin.jvm.internal.i.a((Object) iVarA, "Maybe.error(RuntimeExcep…on(\"Mission not create\"))");
        return iVarA;
    }

    public i<Object> f(final Mission mission) {
        kotlin.jvm.internal.i.b(mission, "newMission");
        i<Object> iVarA = i.a((l) new l<T>() { // from class: zlc.season.rxdownload3.core.LocalMissionBox$update$1
            @Override // io.reactivex.l
            public final void a(j<Object> jVar) {
                kotlin.jvm.internal.i.b(jVar, "it");
                RealMission realMission = new RealMission(mission, this.f23686a.f23676b, false, false, 4, null);
                if (DownloadConfig.r.f() && DownloadConfig.r.d().a(realMission)) {
                    DownloadConfig.r.d().d(realMission);
                }
                jVar.onSuccess(UtilsKt.a());
            }
        });
        kotlin.jvm.internal.i.a((Object) iVarA, "Maybe.create<Any> {\n    ….onSuccess(ANY)\n        }");
        return iVarA;
    }

    @Override // zlc.season.rxdownload3.core.MissionBox
    public i<Object> a(Mission mission) {
        Object next;
        kotlin.jvm.internal.i.b(mission, "mission");
        Iterator<T> it = this.f23677c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (kotlin.jvm.internal.i.a(((RealMission) next).b(), mission)) {
                break;
            }
        }
        RealMission realMission = (RealMission) next;
        if (realMission != null) {
            return realMission.h();
        }
        i<Object> iVarA = i.a((Throwable) new RuntimeException("Mission not create"));
        kotlin.jvm.internal.i.a((Object) iVarA, "Maybe.error(RuntimeExcep…on(\"Mission not create\"))");
        return iVarA;
    }

    @Override // zlc.season.rxdownload3.core.MissionBox
    public e<Status> b(Mission mission, boolean z) {
        Object next;
        kotlin.jvm.internal.i.b(mission, "mission");
        Iterator<T> it = this.f23677c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (kotlin.jvm.internal.i.a(((RealMission) next).b(), mission)) {
                break;
            }
        }
        RealMission realMission = (RealMission) next;
        if (realMission != null) {
            return realMission.d();
        }
        RealMission realMission2 = new RealMission(mission, this.f23676b, z, false, 8, null);
        this.f23677c.add(realMission2);
        return realMission2.d();
    }

    @Override // zlc.season.rxdownload3.core.MissionBox
    public i<Object> a(Mission mission, boolean z) {
        Object next;
        kotlin.jvm.internal.i.b(mission, "mission");
        Iterator<T> it = this.f23677c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (kotlin.jvm.internal.i.a(((RealMission) next).b(), mission)) {
                break;
            }
        }
        RealMission realMission = (RealMission) next;
        if (realMission != null) {
            return realMission.a(z);
        }
        i<Object> iVarA = i.a((Throwable) new RuntimeException("Mission not create"));
        kotlin.jvm.internal.i.a((Object) iVarA, "Maybe.error(RuntimeExcep…on(\"Mission not create\"))");
        return iVarA;
    }

    public i<Object> b() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.f23677c.iterator();
        while (it.hasNext()) {
            arrayList.add(((RealMission) it.next()).h());
        }
        i<Object> iVarC = e.b(arrayList).a((o) MaybeToPublisher.INSTANCE, true).c();
        kotlin.jvm.internal.i.a((Object) iVarC, "Flowable.fromIterable(ar…           .lastElement()");
        return iVarC;
    }

    public i<Object> a(final List<? extends Mission> list, final boolean z) {
        kotlin.jvm.internal.i.b(list, "missions");
        i<Object> iVarA = i.a((l) new l<T>() { // from class: zlc.season.rxdownload3.core.LocalMissionBox$createAll$1
            @Override // io.reactivex.l
            public final void a(j<Object> jVar) {
                T next;
                kotlin.jvm.internal.i.b(jVar, "it");
                for (Mission mission : list) {
                    Iterator<T> it = this.f23681a.f23677c.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            next = it.next();
                            if (kotlin.jvm.internal.i.a(((RealMission) next).b(), mission)) {
                                break;
                            }
                        } else {
                            next = (T) null;
                            break;
                        }
                    }
                    if (next == null) {
                        this.f23681a.f23677c.add(new RealMission(mission, this.f23681a.f23676b, z, false, 8, null));
                    }
                }
                jVar.onSuccess(UtilsKt.a());
            }
        }).a(b.c());
        kotlin.jvm.internal.i.a((Object) iVarA, "Maybe.create<Any> {\n    ….subscribeOn(newThread())");
        return iVarA;
    }

    public i<File> c(Mission mission) {
        Object next;
        kotlin.jvm.internal.i.b(mission, "mission");
        Iterator<T> it = this.f23677c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (kotlin.jvm.internal.i.a(((RealMission) next).b(), mission)) {
                break;
            }
        }
        RealMission realMission = (RealMission) next;
        if (realMission != null) {
            return realMission.a();
        }
        i<File> iVarA = i.a((Throwable) new RuntimeException("Mission not create"));
        kotlin.jvm.internal.i.a((Object) iVarA, "Maybe.error(RuntimeExcep…on(\"Mission not create\"))");
        return iVarA;
    }

    @Override // zlc.season.rxdownload3.core.MissionBox
    public i<Object> a(boolean z) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.f23677c.iterator();
        while (it.hasNext()) {
            arrayList.add(((RealMission) it.next()).a(z));
        }
        i<Object> iVarC = e.b(arrayList).b(MaybeToPublisher.INSTANCE).c();
        kotlin.jvm.internal.i.a((Object) iVarC, "Flowable.fromIterable(ar…           .lastElement()");
        return iVarC;
    }

    public i<Object> b(Mission mission) {
        Object next;
        kotlin.jvm.internal.i.b(mission, "mission");
        Iterator<T> it = this.f23677c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (kotlin.jvm.internal.i.a(((RealMission) next).b(), mission)) {
                break;
            }
        }
        final RealMission realMission = (RealMission) next;
        if (realMission != null) {
            i<Object> iVarA = i.a((l) new l<T>() { // from class: zlc.season.rxdownload3.core.LocalMissionBox$clear$1
                @Override // io.reactivex.l
                public final void a(j<Object> jVar) {
                    kotlin.jvm.internal.i.b(jVar, "it");
                    realMission.g();
                    this.f23678a.f23677c.remove(realMission);
                    jVar.onSuccess(UtilsKt.a());
                }
            });
            kotlin.jvm.internal.i.a((Object) iVarA, "Maybe.create<Any> {\n    ….onSuccess(ANY)\n        }");
            return iVarA;
        }
        i<Object> iVarA2 = i.a((Throwable) new RuntimeException("Mission not create"));
        kotlin.jvm.internal.i.a((Object) iVarA2, "Maybe.error(RuntimeExcep…on(\"Mission not create\"))");
        return iVarA2;
    }

    public i<Object> a(Mission mission, Class<? extends Extension> cls) {
        Object next;
        kotlin.jvm.internal.i.b(mission, "mission");
        kotlin.jvm.internal.i.b(cls, "type");
        Iterator<T> it = this.f23677c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (kotlin.jvm.internal.i.a(((RealMission) next).b(), mission)) {
                break;
            }
        }
        RealMission realMission = (RealMission) next;
        if (realMission != null) {
            return realMission.a(cls).a();
        }
        i<Object> iVarA = i.a((Throwable) new RuntimeException("Mission not create"));
        kotlin.jvm.internal.i.a((Object) iVarA, "Maybe.error(RuntimeExcep…on(\"Mission not create\"))");
        return iVarA;
    }

    public i<Object> a() {
        i<Object> iVarA = i.a((l) new l<T>() { // from class: zlc.season.rxdownload3.core.LocalMissionBox$clearAll$1
            @Override // io.reactivex.l
            public final void a(j<Object> jVar) {
                kotlin.jvm.internal.i.b(jVar, "it");
                Iterator<T> it = this.f23680a.f23677c.iterator();
                while (it.hasNext()) {
                    ((RealMission) it.next()).g();
                }
                this.f23680a.f23677c.clear();
            }
        });
        kotlin.jvm.internal.i.a((Object) iVarA, "Maybe.create<Any> {\n    …    SET.clear()\n        }");
        return iVarA;
    }
}
