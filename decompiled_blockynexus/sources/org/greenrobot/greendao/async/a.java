package org.greenrobot.greendao.async;

import org.greenrobot.greendao.async.AsyncOperation;

/* JADX INFO: compiled from: AsyncOperationExecutor.java */
/* JADX INFO: loaded from: classes5.dex */
/* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f23556a = new int[AsyncOperation.OperationType.values().length];

    static {
        try {
            f23556a[AsyncOperation.OperationType.Delete.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f23556a[AsyncOperation.OperationType.DeleteInTxIterable.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f23556a[AsyncOperation.OperationType.DeleteInTxArray.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f23556a[AsyncOperation.OperationType.Insert.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f23556a[AsyncOperation.OperationType.InsertInTxIterable.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f23556a[AsyncOperation.OperationType.InsertInTxArray.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f23556a[AsyncOperation.OperationType.InsertOrReplace.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f23556a[AsyncOperation.OperationType.InsertOrReplaceInTxIterable.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f23556a[AsyncOperation.OperationType.InsertOrReplaceInTxArray.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f23556a[AsyncOperation.OperationType.Update.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f23556a[AsyncOperation.OperationType.UpdateInTxIterable.ordinal()] = 11;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f23556a[AsyncOperation.OperationType.UpdateInTxArray.ordinal()] = 12;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            f23556a[AsyncOperation.OperationType.TransactionRunnable.ordinal()] = 13;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            f23556a[AsyncOperation.OperationType.TransactionCallable.ordinal()] = 14;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            f23556a[AsyncOperation.OperationType.QueryList.ordinal()] = 15;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            f23556a[AsyncOperation.OperationType.QueryUnique.ordinal()] = 16;
        } catch (NoSuchFieldError unused16) {
        }
        try {
            f23556a[AsyncOperation.OperationType.DeleteByKey.ordinal()] = 17;
        } catch (NoSuchFieldError unused17) {
        }
        try {
            f23556a[AsyncOperation.OperationType.DeleteAll.ordinal()] = 18;
        } catch (NoSuchFieldError unused18) {
        }
        try {
            f23556a[AsyncOperation.OperationType.Load.ordinal()] = 19;
        } catch (NoSuchFieldError unused19) {
        }
        try {
            f23556a[AsyncOperation.OperationType.LoadAll.ordinal()] = 20;
        } catch (NoSuchFieldError unused20) {
        }
        try {
            f23556a[AsyncOperation.OperationType.Count.ordinal()] = 21;
        } catch (NoSuchFieldError unused21) {
        }
        try {
            f23556a[AsyncOperation.OperationType.Refresh.ordinal()] = 22;
        } catch (NoSuchFieldError unused22) {
        }
    }
}
