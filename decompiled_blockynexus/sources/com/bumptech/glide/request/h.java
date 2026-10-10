package com.bumptech.glide.request;

import com.bumptech.glide.request.RequestCoordinator;

/* JADX INFO: compiled from: ThumbnailRequestCoordinator.java */
/* JADX INFO: loaded from: classes.dex */
public class h implements RequestCoordinator, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RequestCoordinator f4795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f4796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile d f4797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile d f4798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RequestCoordinator.RequestState f4799e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private RequestCoordinator.RequestState f4800f;
    private boolean g;

    public h(Object obj, RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f4799e = requestState;
        this.f4800f = requestState;
        this.f4796b = obj;
        this.f4795a = requestCoordinator;
    }

    private boolean d() {
        RequestCoordinator requestCoordinator = this.f4795a;
        return requestCoordinator == null || requestCoordinator.b(this);
    }

    private boolean e() {
        RequestCoordinator requestCoordinator = this.f4795a;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    public void a(d dVar, d dVar2) {
        this.f4797c = dVar;
        this.f4798d = dVar2;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean b(d dVar) {
        boolean z;
        synchronized (this.f4796b) {
            z = d() && dVar.equals(this.f4797c) && !a();
        }
        return z;
    }

    @Override // com.bumptech.glide.request.d
    public void begin() {
        synchronized (this.f4796b) {
            this.g = true;
            try {
                if (this.f4799e != RequestCoordinator.RequestState.SUCCESS && this.f4800f != RequestCoordinator.RequestState.RUNNING) {
                    this.f4800f = RequestCoordinator.RequestState.RUNNING;
                    this.f4798d.begin();
                }
                if (this.g && this.f4799e != RequestCoordinator.RequestState.RUNNING) {
                    this.f4799e = RequestCoordinator.RequestState.RUNNING;
                    this.f4797c.begin();
                }
            } finally {
                this.g = false;
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean c(d dVar) {
        boolean z;
        synchronized (this.f4796b) {
            z = e() && (dVar.equals(this.f4797c) || this.f4799e != RequestCoordinator.RequestState.SUCCESS);
        }
        return z;
    }

    @Override // com.bumptech.glide.request.d
    public void clear() {
        synchronized (this.f4796b) {
            this.g = false;
            this.f4799e = RequestCoordinator.RequestState.CLEARED;
            this.f4800f = RequestCoordinator.RequestState.CLEARED;
            this.f4798d.clear();
            this.f4797c.clear();
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean f(d dVar) {
        boolean z;
        synchronized (this.f4796b) {
            z = c() && dVar.equals(this.f4797c) && this.f4799e != RequestCoordinator.RequestState.PAUSED;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        RequestCoordinator root;
        synchronized (this.f4796b) {
            root = this.f4795a != null ? this.f4795a.getRoot() : this;
        }
        return root;
    }

    @Override // com.bumptech.glide.request.d
    public boolean isComplete() {
        boolean z;
        synchronized (this.f4796b) {
            z = this.f4799e == RequestCoordinator.RequestState.SUCCESS;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.d
    public boolean isRunning() {
        boolean z;
        synchronized (this.f4796b) {
            z = this.f4799e == RequestCoordinator.RequestState.RUNNING;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.d
    public void pause() {
        synchronized (this.f4796b) {
            if (!this.f4800f.isComplete()) {
                this.f4800f = RequestCoordinator.RequestState.PAUSED;
                this.f4798d.pause();
            }
            if (!this.f4799e.isComplete()) {
                this.f4799e = RequestCoordinator.RequestState.PAUSED;
                this.f4797c.pause();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void d(d dVar) {
        synchronized (this.f4796b) {
            if (!dVar.equals(this.f4797c)) {
                this.f4800f = RequestCoordinator.RequestState.FAILED;
                return;
            }
            this.f4799e = RequestCoordinator.RequestState.FAILED;
            if (this.f4795a != null) {
                this.f4795a.d(this);
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void e(d dVar) {
        synchronized (this.f4796b) {
            if (dVar.equals(this.f4798d)) {
                this.f4800f = RequestCoordinator.RequestState.SUCCESS;
                return;
            }
            this.f4799e = RequestCoordinator.RequestState.SUCCESS;
            if (this.f4795a != null) {
                this.f4795a.e(this);
            }
            if (!this.f4800f.isComplete()) {
                this.f4798d.clear();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.d
    public boolean a() {
        boolean z;
        synchronized (this.f4796b) {
            z = this.f4798d.a() || this.f4797c.a();
        }
        return z;
    }

    private boolean c() {
        RequestCoordinator requestCoordinator = this.f4795a;
        return requestCoordinator == null || requestCoordinator.f(this);
    }

    @Override // com.bumptech.glide.request.d
    public boolean b() {
        boolean z;
        synchronized (this.f4796b) {
            z = this.f4799e == RequestCoordinator.RequestState.CLEARED;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.d
    public boolean a(d dVar) {
        if (!(dVar instanceof h)) {
            return false;
        }
        h hVar = (h) dVar;
        if (this.f4797c == null) {
            if (hVar.f4797c != null) {
                return false;
            }
        } else if (!this.f4797c.a(hVar.f4797c)) {
            return false;
        }
        if (this.f4798d == null) {
            if (hVar.f4798d != null) {
                return false;
            }
        } else if (!this.f4798d.a(hVar.f4798d)) {
            return false;
        }
        return true;
    }
}
