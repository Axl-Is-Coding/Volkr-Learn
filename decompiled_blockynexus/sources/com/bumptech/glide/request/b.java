package com.bumptech.glide.request;

import com.bumptech.glide.request.RequestCoordinator;

/* JADX INFO: compiled from: ErrorRequestCoordinator.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements RequestCoordinator, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f4789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RequestCoordinator f4790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile d f4791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile d f4792d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RequestCoordinator.RequestState f4793e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private RequestCoordinator.RequestState f4794f;

    public b(Object obj, RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f4793e = requestState;
        this.f4794f = requestState;
        this.f4789a = obj;
        this.f4790b = requestCoordinator;
    }

    private boolean d() {
        RequestCoordinator requestCoordinator = this.f4790b;
        return requestCoordinator == null || requestCoordinator.b(this);
    }

    private boolean e() {
        RequestCoordinator requestCoordinator = this.f4790b;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    private boolean g(d dVar) {
        return dVar.equals(this.f4791c) || (this.f4793e == RequestCoordinator.RequestState.FAILED && dVar.equals(this.f4792d));
    }

    public void a(d dVar, d dVar2) {
        this.f4791c = dVar;
        this.f4792d = dVar2;
    }

    @Override // com.bumptech.glide.request.d
    public boolean b() {
        boolean z;
        synchronized (this.f4789a) {
            z = this.f4793e == RequestCoordinator.RequestState.CLEARED && this.f4794f == RequestCoordinator.RequestState.CLEARED;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.d
    public void begin() {
        synchronized (this.f4789a) {
            if (this.f4793e != RequestCoordinator.RequestState.RUNNING) {
                this.f4793e = RequestCoordinator.RequestState.RUNNING;
                this.f4791c.begin();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean c(d dVar) {
        boolean z;
        synchronized (this.f4789a) {
            z = e() && g(dVar);
        }
        return z;
    }

    @Override // com.bumptech.glide.request.d
    public void clear() {
        synchronized (this.f4789a) {
            this.f4793e = RequestCoordinator.RequestState.CLEARED;
            this.f4791c.clear();
            if (this.f4794f != RequestCoordinator.RequestState.CLEARED) {
                this.f4794f = RequestCoordinator.RequestState.CLEARED;
                this.f4792d.clear();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean f(d dVar) {
        boolean z;
        synchronized (this.f4789a) {
            z = c() && g(dVar);
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        RequestCoordinator root;
        synchronized (this.f4789a) {
            root = this.f4790b != null ? this.f4790b.getRoot() : this;
        }
        return root;
    }

    @Override // com.bumptech.glide.request.d
    public boolean isComplete() {
        boolean z;
        synchronized (this.f4789a) {
            z = this.f4793e == RequestCoordinator.RequestState.SUCCESS || this.f4794f == RequestCoordinator.RequestState.SUCCESS;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.d
    public boolean isRunning() {
        boolean z;
        synchronized (this.f4789a) {
            z = this.f4793e == RequestCoordinator.RequestState.RUNNING || this.f4794f == RequestCoordinator.RequestState.RUNNING;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.d
    public void pause() {
        synchronized (this.f4789a) {
            if (this.f4793e == RequestCoordinator.RequestState.RUNNING) {
                this.f4793e = RequestCoordinator.RequestState.PAUSED;
                this.f4791c.pause();
            }
            if (this.f4794f == RequestCoordinator.RequestState.RUNNING) {
                this.f4794f = RequestCoordinator.RequestState.PAUSED;
                this.f4792d.pause();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void d(d dVar) {
        synchronized (this.f4789a) {
            if (dVar.equals(this.f4792d)) {
                this.f4794f = RequestCoordinator.RequestState.FAILED;
                if (this.f4790b != null) {
                    this.f4790b.d(this);
                }
            } else {
                this.f4793e = RequestCoordinator.RequestState.FAILED;
                if (this.f4794f != RequestCoordinator.RequestState.RUNNING) {
                    this.f4794f = RequestCoordinator.RequestState.RUNNING;
                    this.f4792d.begin();
                }
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void e(d dVar) {
        synchronized (this.f4789a) {
            if (dVar.equals(this.f4791c)) {
                this.f4793e = RequestCoordinator.RequestState.SUCCESS;
            } else if (dVar.equals(this.f4792d)) {
                this.f4794f = RequestCoordinator.RequestState.SUCCESS;
            }
            if (this.f4790b != null) {
                this.f4790b.e(this);
            }
        }
    }

    @Override // com.bumptech.glide.request.d
    public boolean a(d dVar) {
        if (!(dVar instanceof b)) {
            return false;
        }
        b bVar = (b) dVar;
        return this.f4791c.a(bVar.f4791c) && this.f4792d.a(bVar.f4792d);
    }

    private boolean c() {
        RequestCoordinator requestCoordinator = this.f4790b;
        return requestCoordinator == null || requestCoordinator.f(this);
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean b(d dVar) {
        boolean z;
        synchronized (this.f4789a) {
            z = d() && g(dVar);
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.d
    public boolean a() {
        boolean z;
        synchronized (this.f4789a) {
            z = this.f4791c.a() || this.f4792d.a();
        }
        return z;
    }
}
