package com.squareup.picasso;

import android.net.NetworkInfo;
import com.squareup.picasso.P;
import com.squareup.picasso.Picasso;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PicassoExecutorService.java */
/* JADX INFO: loaded from: classes5.dex */
class A extends ThreadPoolExecutor {

    /* JADX INFO: compiled from: PicassoExecutorService.java */
    private static final class a extends FutureTask<RunnableC2754i> implements Comparable<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final RunnableC2754i f19208a;

        public a(RunnableC2754i runnableC2754i) {
            super(runnableC2754i, null);
            this.f19208a = runnableC2754i;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            Picasso.Priority priorityJ = this.f19208a.j();
            Picasso.Priority priorityJ2 = aVar.f19208a.j();
            return priorityJ == priorityJ2 ? this.f19208a.f19292e - aVar.f19208a.f19292e : priorityJ2.ordinal() - priorityJ.ordinal();
        }
    }

    A() {
        super(3, 3, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new P.e());
    }

    void a(NetworkInfo networkInfo) {
        if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
            a(3);
            return;
        }
        int type = networkInfo.getType();
        if (type != 0) {
            if (type == 1 || type == 6 || type == 9) {
                a(4);
                return;
            } else {
                a(3);
                return;
            }
        }
        int subtype = networkInfo.getSubtype();
        switch (subtype) {
            case 1:
            case 2:
                a(1);
                return;
            case 3:
            case 4:
            case 5:
            case 6:
                break;
            default:
                switch (subtype) {
                    case 12:
                        break;
                    case 13:
                    case 14:
                    case 15:
                        a(3);
                        break;
                    default:
                        a(3);
                        break;
                }
                return;
        }
        a(2);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        a aVar = new a((RunnableC2754i) runnable);
        execute(aVar);
        return aVar;
    }

    private void a(int i) {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }
}
