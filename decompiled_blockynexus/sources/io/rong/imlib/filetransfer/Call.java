package io.rong.imlib.filetransfer;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes5.dex */
public class Call {
    private final CallDispatcher dispatcher;
    private final Request request;

    class AsyncCall implements Runnable {
        protected Future future;

        AsyncCall() {
        }

        public void cancel(CancelCallback cancelCallback) {
            Future future = this.future;
            if (future != null && !future.isDone()) {
                this.future.cancel(true);
                this.future = null;
            }
            if (cancelCallback != null) {
                cancelCallback.onCanceled(Call.this.request.tag);
            }
            if (Call.this.request.requestCallBack == null || !Call.this.dispatcher.inReadyCalls(Call.this.request.tag)) {
                return;
            }
            Call.this.request.requestCallBack.onCanceled(Call.this.request.tag);
        }

        public void pause(PauseCallback pauseCallback) {
            Call.this.request.info.setStop(true);
            pauseCallback.onPaused(Call.this.request.tag);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Call.this.request.isMessage) {
                Call.this.request.sendRequest();
            } else {
                Call.this.request.sendRequestForNoneMessage();
            }
            Call.this.dispatcher.finish(this);
        }

        public Object tag() {
            return Call.this.request.tag;
        }
    }

    private Call(CallDispatcher callDispatcher, Request request) {
        this.request = request;
        this.dispatcher = callDispatcher;
    }

    public static Call create(CallDispatcher callDispatcher, Request request) {
        return new Call(callDispatcher, request);
    }

    public void enqueue() {
        this.dispatcher.enqueue(new AsyncCall());
    }
}
