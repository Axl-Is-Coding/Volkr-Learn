package io.rong.imlib.filetransfer;

import io.rong.imlib.filetransfer.Call;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class CallDispatcher {
    private static final int MAX_RUNNING_TASK = 4;
    private ExecutorService executorService;
    private final Deque<Call.AsyncCall> readyCalls = new ArrayDeque();
    private final Deque<Call.AsyncCall> runningCalls = new ArrayDeque();

    private void promoteCalls() {
        if (this.runningCalls.size() >= 4 || this.readyCalls.isEmpty()) {
            return;
        }
        Iterator<Call.AsyncCall> it = this.readyCalls.iterator();
        while (it.hasNext()) {
            Call.AsyncCall next = it.next();
            this.runningCalls.add(next);
            next.future = getExecutorService().submit(next);
            it.remove();
            if (this.runningCalls.size() >= 4) {
                return;
            }
        }
    }

    private ThreadFactory threadFactory() {
        return new ThreadFactory() { // from class: io.rong.imlib.filetransfer.CallDispatcher.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "HttpEngine Dispatcher");
                thread.setDaemon(false);
                return thread;
            }
        };
    }

    public synchronized void cancel(Object obj, CancelCallback cancelCallback) {
        for (Call.AsyncCall asyncCall : this.readyCalls) {
            if (asyncCall.tag().equals(obj)) {
                asyncCall.cancel(cancelCallback);
                this.readyCalls.remove(asyncCall);
                return;
            }
        }
        for (Call.AsyncCall asyncCall2 : this.runningCalls) {
            if (asyncCall2.tag().equals(obj)) {
                asyncCall2.cancel(cancelCallback);
                return;
            }
        }
        cancelCallback.onError(-3);
    }

    public synchronized void cancelAll() {
        for (Call.AsyncCall asyncCall : this.readyCalls) {
            this.readyCalls.remove(asyncCall);
            asyncCall.cancel(null);
        }
        this.readyCalls.clear();
        Iterator<Call.AsyncCall> it = this.runningCalls.iterator();
        while (it.hasNext()) {
            it.next().cancel(null);
        }
        this.runningCalls.clear();
    }

    public synchronized void enqueue(Call.AsyncCall asyncCall) {
        if (this.runningCalls.size() < 4) {
            asyncCall.future = getExecutorService().submit(asyncCall);
            this.runningCalls.add(asyncCall);
        } else {
            this.readyCalls.add(asyncCall);
        }
    }

    public synchronized void finish(Call.AsyncCall asyncCall) {
        if (!this.runningCalls.remove(asyncCall)) {
            throw new RuntimeException("Not in running list.");
        }
        promoteCalls();
    }

    public synchronized ExecutorService getExecutorService() {
        if (this.executorService == null) {
            this.executorService = new ThreadPoolExecutor(4, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory());
        }
        return this.executorService;
    }

    public boolean inReadyCalls(Object obj) {
        Iterator<Call.AsyncCall> it = this.readyCalls.iterator();
        while (it.hasNext()) {
            if (it.next().tag().equals(obj)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void pause(Object obj, PauseCallback pauseCallback) {
        for (Call.AsyncCall asyncCall : this.runningCalls) {
            if (asyncCall.tag().equals(obj)) {
                asyncCall.pause(pauseCallback);
                return;
            }
        }
        pauseCallback.onError(-3);
    }
}
