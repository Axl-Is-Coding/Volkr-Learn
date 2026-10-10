package com.bumptech.glide.request;

/* JADX INFO: loaded from: classes.dex */
public interface RequestCoordinator {

    public enum RequestState {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);

        private final boolean isComplete;

        RequestState(boolean z) {
            this.isComplete = z;
        }

        boolean isComplete() {
            return this.isComplete;
        }
    }

    boolean a();

    boolean b(d dVar);

    boolean c(d dVar);

    void d(d dVar);

    void e(d dVar);

    boolean f(d dVar);

    RequestCoordinator getRoot();
}
