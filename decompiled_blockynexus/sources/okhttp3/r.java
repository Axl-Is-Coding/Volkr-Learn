package okhttp3;

import okhttp3.EventListener;

/* JADX INFO: compiled from: EventListener.java */
/* JADX INFO: loaded from: classes5.dex */
class r implements EventListener.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ EventListener f23453a;

    r(EventListener eventListener) {
        this.f23453a = eventListener;
    }

    @Override // okhttp3.EventListener.Factory
    public EventListener create(Call call) {
        return this.f23453a;
    }
}
