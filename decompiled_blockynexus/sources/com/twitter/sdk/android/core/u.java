package com.twitter.sdk.android.core;

import android.content.Context;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: TwitterConfig.java */
/* JADX INFO: loaded from: classes5.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f20269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final i f20270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final q f20271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final ExecutorService f20272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Boolean f20273e;

    /* JADX INFO: compiled from: TwitterConfig.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f20274a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private i f20275b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private q f20276c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ExecutorService f20277d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Boolean f20278e;

        public a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.f20274a = context.getApplicationContext();
        }

        public a a(i iVar) {
            if (iVar == null) {
                throw new IllegalArgumentException("Logger must not be null.");
            }
            this.f20275b = iVar;
            return this;
        }

        public a a(q qVar) {
            if (qVar != null) {
                this.f20276c = qVar;
                return this;
            }
            throw new IllegalArgumentException("TwitterAuthConfig must not be null.");
        }

        public a a(boolean z) {
            this.f20278e = Boolean.valueOf(z);
            return this;
        }

        public u a() {
            return new u(this.f20274a, this.f20275b, this.f20276c, this.f20277d, this.f20278e);
        }
    }

    private u(Context context, i iVar, q qVar, ExecutorService executorService, Boolean bool) {
        this.f20269a = context;
        this.f20270b = iVar;
        this.f20271c = qVar;
        this.f20272d = executorService;
        this.f20273e = bool;
    }
}
