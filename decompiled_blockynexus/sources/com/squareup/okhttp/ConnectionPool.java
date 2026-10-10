package com.squareup.okhttp;

import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public final class ConnectionPool {
    private static final long DEFAULT_KEEP_ALIVE_DURATION_MS = 300000;
    private static final ConnectionPool systemDefault;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;
    private final LinkedList<Connection> connections = new LinkedList<>();
    private Executor executor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
    private final Runnable connectionsCleanupRunnable = new Runnable() { // from class: com.squareup.okhttp.ConnectionPool.1
        @Override // java.lang.Runnable
        public void run() {
            ConnectionPool.this.runCleanupUntilPoolIsEmpty();
        }
    };

    static {
        String property = System.getProperty("http.keepAlive");
        String property2 = System.getProperty("http.keepAliveDuration");
        String property3 = System.getProperty("http.maxConnections");
        long j = property2 != null ? Long.parseLong(property2) : DEFAULT_KEEP_ALIVE_DURATION_MS;
        if (property != null && !Boolean.parseBoolean(property)) {
            systemDefault = new ConnectionPool(0, j);
        } else if (property3 != null) {
            systemDefault = new ConnectionPool(Integer.parseInt(property3), j);
        } else {
            systemDefault = new ConnectionPool(5, j);
        }
    }

    public ConnectionPool(int i, long j) {
        this.maxIdleConnections = i;
        this.keepAliveDurationNs = j * 1000 * 1000;
    }

    private void addConnection(Connection connection) {
        boolean zIsEmpty = this.connections.isEmpty();
        this.connections.addFirst(connection);
        if (zIsEmpty) {
            this.executor.execute(this.connectionsCleanupRunnable);
        } else {
            notifyAll();
        }
    }

    public static ConnectionPool getDefault() {
        return systemDefault;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runCleanupUntilPoolIsEmpty() {
        while (performCleanup()) {
        }
    }

    public void evictAll() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.connections);
            this.connections.clear();
            notifyAll();
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Util.closeQuietly(((Connection) arrayList.get(i)).getSocket());
        }
    }

    public synchronized Connection get(Address address) {
        Connection connection;
        connection = null;
        ListIterator<Connection> listIterator = this.connections.listIterator(this.connections.size());
        while (listIterator.hasPrevious()) {
            Connection connectionPrevious = listIterator.previous();
            if (connectionPrevious.getRoute().getAddress().equals(address) && connectionPrevious.isAlive() && System.nanoTime() - connectionPrevious.getIdleStartTimeNs() < this.keepAliveDurationNs) {
                listIterator.remove();
                if (!connectionPrevious.isFramed()) {
                    try {
                        Platform.get().tagSocket(connectionPrevious.getSocket());
                    } catch (SocketException e2) {
                        Util.closeQuietly(connectionPrevious.getSocket());
                        Platform.get().logW("Unable to tagSocket(): " + e2);
                    }
                }
                connection = connectionPrevious;
                break;
            }
        }
        if (connection != null && connection.isFramed()) {
            this.connections.addFirst(connection);
        }
        return connection;
    }

    public synchronized int getConnectionCount() {
        return this.connections.size();
    }

    synchronized List<Connection> getConnections() {
        return new ArrayList(this.connections);
    }

    public synchronized int getHttpConnectionCount() {
        return this.connections.size() - getMultiplexedConnectionCount();
    }

    public synchronized int getMultiplexedConnectionCount() {
        int i;
        i = 0;
        Iterator<Connection> it = this.connections.iterator();
        while (it.hasNext()) {
            if (it.next().isFramed()) {
                i++;
            }
        }
        return i;
    }

    @Deprecated
    public synchronized int getSpdyConnectionCount() {
        return getMultiplexedConnectionCount();
    }

    boolean performCleanup() {
        synchronized (this) {
            if (this.connections.isEmpty()) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            long jNanoTime = System.nanoTime();
            long j = this.keepAliveDurationNs;
            ListIterator<Connection> listIterator = this.connections.listIterator(this.connections.size());
            long jMin = j;
            int i = 0;
            while (listIterator.hasPrevious()) {
                Connection connectionPrevious = listIterator.previous();
                long idleStartTimeNs = (connectionPrevious.getIdleStartTimeNs() + this.keepAliveDurationNs) - jNanoTime;
                if (idleStartTimeNs <= 0 || !connectionPrevious.isAlive()) {
                    listIterator.remove();
                    arrayList.add(connectionPrevious);
                } else if (connectionPrevious.isIdle()) {
                    i++;
                    jMin = Math.min(jMin, idleStartTimeNs);
                }
            }
            ListIterator<Connection> listIterator2 = this.connections.listIterator(this.connections.size());
            while (listIterator2.hasPrevious() && i > this.maxIdleConnections) {
                Connection connectionPrevious2 = listIterator2.previous();
                if (connectionPrevious2.isIdle()) {
                    arrayList.add(connectionPrevious2);
                    listIterator2.remove();
                    i--;
                }
            }
            if (arrayList.isEmpty()) {
                try {
                    long j2 = jMin / 1000000;
                    Long.signum(j2);
                    wait(j2, (int) (jMin - (1000000 * j2)));
                    return true;
                } catch (InterruptedException unused) {
                }
            }
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                Util.closeQuietly(((Connection) arrayList.get(i2)).getSocket());
            }
            return true;
        }
    }

    void recycle(Connection connection) {
        if (!connection.isFramed() && connection.clearOwner()) {
            if (!connection.isAlive()) {
                Util.closeQuietly(connection.getSocket());
                return;
            }
            try {
                Platform.get().untagSocket(connection.getSocket());
                synchronized (this) {
                    addConnection(connection);
                    connection.incrementRecycleCount();
                    connection.resetIdleStartTime();
                }
            } catch (SocketException e2) {
                Platform.get().logW("Unable to untagSocket(): " + e2);
                Util.closeQuietly(connection.getSocket());
            }
        }
    }

    void replaceCleanupExecutorForTests(Executor executor) {
        this.executor = executor;
    }

    void share(Connection connection) {
        if (!connection.isFramed()) {
            throw new IllegalArgumentException();
        }
        if (connection.isAlive()) {
            synchronized (this) {
                addConnection(connection);
            }
        }
    }
}
