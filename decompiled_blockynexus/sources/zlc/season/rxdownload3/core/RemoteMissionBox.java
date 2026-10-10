package zlc.season.rxdownload3.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.facebook.internal.AnalyticsEvents;
import io.reactivex.BackpressureStrategy;
import io.reactivex.e;
import io.reactivex.f;
import io.reactivex.g;
import io.reactivex.j;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.i;
import kotlin.l;
import zlc.season.rxdownload3.core.DownloadService;
import zlc.season.rxdownload3.core.RemoteMissionBox;

/* JADX INFO: compiled from: RemoteMissionBox.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class RemoteMissionBox implements MissionBox {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f23765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DownloadService.DownloadBinder f23766b;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: RemoteMissionBox.kt */
    static final class ErrorCallbackImpl implements DownloadService.ErrorCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final j<? extends Object> f23767a;

        public ErrorCallbackImpl(j<? extends Object> jVar) {
            i.b(jVar, "emitter");
            this.f23767a = jVar;
        }

        @Override // zlc.season.rxdownload3.core.DownloadService.ErrorCallback
        public void a(Throwable th) {
            i.b(th, "throwable");
            this.f23767a.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: RemoteMissionBox.kt */
    static final class SuccessCallbackImpl implements DownloadService.SuccessCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final j<Object> f23768a;

        public SuccessCallbackImpl(j<Object> jVar) {
            i.b(jVar, "emitter");
            this.f23768a = jVar;
        }

        @Override // zlc.season.rxdownload3.core.DownloadService.SuccessCallback
        public void apply(Object obj) {
            i.b(obj, "any");
            this.f23768a.onSuccess(obj);
        }
    }

    public RemoteMissionBox() {
        Context contextB = DownloadConfig.r.b();
        if (contextB != null) {
            this.f23765a = contextB;
        } else {
            i.a();
            throw null;
        }
    }

    @Override // zlc.season.rxdownload3.core.MissionBox
    public e<Status> b(final Mission mission, final boolean z) {
        i.b(mission, "mission");
        e<Status> eVarB = e.a(new g<T>() { // from class: zlc.season.rxdownload3.core.RemoteMissionBox$create$1
            @Override // io.reactivex.g
            public final void a(final f<Status> fVar) {
                i.b(fVar, "emitter");
                this.f23772a.a((b<? super DownloadService.DownloadBinder, l>) new b<DownloadService.DownloadBinder, l>() { // from class: zlc.season.rxdownload3.core.RemoteMissionBox$create$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.a.b
                    public /* bridge */ /* synthetic */ l invoke(DownloadService.DownloadBinder downloadBinder) {
                        invoke2(downloadBinder);
                        return l.f22855a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DownloadService.DownloadBinder downloadBinder) {
                        i.b(downloadBinder, "it");
                        RemoteMissionBox$create$1 remoteMissionBox$create$1 = RemoteMissionBox$create$1.this;
                        downloadBinder.a(mission, z, new DownloadService.StatusCallback() { // from class: zlc.season.rxdownload3.core.RemoteMissionBox.create.1.1.1
                            @Override // zlc.season.rxdownload3.core.DownloadService.StatusCallback
                            public void a(Status status) {
                                i.b(status, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
                                fVar.onNext(status);
                            }
                        });
                    }
                });
            }
        }, BackpressureStrategy.LATEST).b(io.reactivex.f.b.c());
        i.a((Object) eVarB, "Flowable.create<Status>(….subscribeOn(newThread())");
        return eVarB;
    }

    @Override // zlc.season.rxdownload3.core.MissionBox
    public io.reactivex.i<Object> a(final Mission mission) {
        i.b(mission, "mission");
        io.reactivex.i<Object> iVarA = io.reactivex.i.a((io.reactivex.l) new io.reactivex.l<T>() { // from class: zlc.season.rxdownload3.core.RemoteMissionBox$start$1
            @Override // io.reactivex.l
            public final void a(final j<Object> jVar) {
                i.b(jVar, "emitter");
                this.f23793a.a((b<? super DownloadService.DownloadBinder, l>) new b<DownloadService.DownloadBinder, l>() { // from class: zlc.season.rxdownload3.core.RemoteMissionBox$start$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.a.b
                    public /* bridge */ /* synthetic */ l invoke(DownloadService.DownloadBinder downloadBinder) {
                        invoke2(downloadBinder);
                        return l.f22855a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DownloadService.DownloadBinder downloadBinder) {
                        i.b(downloadBinder, "it");
                        Mission mission2 = mission;
                        j jVar2 = jVar;
                        i.a((Object) jVar2, "emitter");
                        RemoteMissionBox.SuccessCallbackImpl successCallbackImpl = new RemoteMissionBox.SuccessCallbackImpl(jVar2);
                        j jVar3 = jVar;
                        i.a((Object) jVar3, "emitter");
                        downloadBinder.b(mission2, successCallbackImpl, new RemoteMissionBox.ErrorCallbackImpl(jVar3));
                    }
                });
            }
        }).a(io.reactivex.f.b.c());
        i.a((Object) iVarA, "Maybe.create<Any> { emit….subscribeOn(newThread())");
        return iVarA;
    }

    @Override // zlc.season.rxdownload3.core.MissionBox
    public io.reactivex.i<Object> a(final Mission mission, final boolean z) {
        i.b(mission, "mission");
        io.reactivex.i<Object> iVarA = io.reactivex.i.a((io.reactivex.l) new io.reactivex.l<T>() { // from class: zlc.season.rxdownload3.core.RemoteMissionBox$delete$1
            @Override // io.reactivex.l
            public final void a(final j<Object> jVar) {
                i.b(jVar, "emitter");
                this.f23779a.a((b<? super DownloadService.DownloadBinder, l>) new b<DownloadService.DownloadBinder, l>() { // from class: zlc.season.rxdownload3.core.RemoteMissionBox$delete$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.a.b
                    public /* bridge */ /* synthetic */ l invoke(DownloadService.DownloadBinder downloadBinder) {
                        invoke2(downloadBinder);
                        return l.f22855a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DownloadService.DownloadBinder downloadBinder) {
                        i.b(downloadBinder, "it");
                        RemoteMissionBox$delete$1 remoteMissionBox$delete$1 = RemoteMissionBox$delete$1.this;
                        Mission mission2 = mission;
                        boolean z2 = z;
                        j jVar2 = jVar;
                        i.a((Object) jVar2, "emitter");
                        RemoteMissionBox.SuccessCallbackImpl successCallbackImpl = new RemoteMissionBox.SuccessCallbackImpl(jVar2);
                        j jVar3 = jVar;
                        i.a((Object) jVar3, "emitter");
                        downloadBinder.a(mission2, z2, successCallbackImpl, new RemoteMissionBox.ErrorCallbackImpl(jVar3));
                    }
                });
            }
        }).a(io.reactivex.f.b.c());
        i.a((Object) iVarA, "Maybe.create<Any> { emit….subscribeOn(newThread())");
        return iVarA;
    }

    @Override // zlc.season.rxdownload3.core.MissionBox
    public io.reactivex.i<Object> a(final boolean z) {
        io.reactivex.i<Object> iVarA = io.reactivex.i.a((io.reactivex.l) new io.reactivex.l<T>() { // from class: zlc.season.rxdownload3.core.RemoteMissionBox$deleteAll$1
            @Override // io.reactivex.l
            public final void a(final j<Object> jVar) {
                i.b(jVar, "emitter");
                this.f23782a.a((b<? super DownloadService.DownloadBinder, l>) new b<DownloadService.DownloadBinder, l>() { // from class: zlc.season.rxdownload3.core.RemoteMissionBox$deleteAll$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.a.b
                    public /* bridge */ /* synthetic */ l invoke(DownloadService.DownloadBinder downloadBinder) {
                        invoke2(downloadBinder);
                        return l.f22855a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DownloadService.DownloadBinder downloadBinder) {
                        i.b(downloadBinder, "it");
                        boolean z2 = z;
                        j jVar2 = jVar;
                        i.a((Object) jVar2, "emitter");
                        RemoteMissionBox.SuccessCallbackImpl successCallbackImpl = new RemoteMissionBox.SuccessCallbackImpl(jVar2);
                        j jVar3 = jVar;
                        i.a((Object) jVar3, "emitter");
                        downloadBinder.a(z2, successCallbackImpl, new RemoteMissionBox.ErrorCallbackImpl(jVar3));
                    }
                });
            }
        }).a(io.reactivex.f.b.c());
        i.a((Object) iVarA, "Maybe.create<Any> { emit….subscribeOn(newThread())");
        return iVarA;
    }

    public final DownloadService.DownloadBinder a() {
        return this.f23766b;
    }

    public final void a(DownloadService.DownloadBinder downloadBinder) {
        this.f23766b = downloadBinder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final b<? super DownloadService.DownloadBinder, l> bVar) {
        DownloadService.DownloadBinder downloadBinder = this.f23766b;
        if (downloadBinder == null) {
            Intent intent = new Intent(this.f23765a, (Class<?>) DownloadService.class);
            this.f23765a.startService(intent);
            this.f23765a.bindService(intent, new ServiceConnection() { // from class: zlc.season.rxdownload3.core.RemoteMissionBox$startBindServiceAndDo$1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    i.b(componentName, "name");
                    i.b(iBinder, "binder");
                    this.f23796a.a((DownloadService.DownloadBinder) iBinder);
                    b bVar2 = bVar;
                    DownloadService.DownloadBinder downloadBinderA = this.f23796a.a();
                    if (downloadBinderA != null) {
                        bVar2.invoke(downloadBinderA);
                    } else {
                        i.a();
                        throw null;
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    i.b(componentName, "name");
                    this.f23796a.a((DownloadService.DownloadBinder) null);
                }
            }, 1);
        } else if (downloadBinder != null) {
            bVar.invoke(downloadBinder);
        } else {
            i.a();
            throw null;
        }
    }
}
