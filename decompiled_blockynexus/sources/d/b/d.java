package d.b;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: _JULLoggerFactory.java */
/* JADX INFO: loaded from: classes5.dex */
public class d implements c {

    /* JADX INFO: compiled from: _JULLoggerFactory.java */
    private static class a extends b {
        private final Logger i;

        a(Logger logger) {
            this.i = logger;
        }

        @Override // d.b.b
        public void a(String str, Throwable th) {
            this.i.log(Level.SEVERE, str, th);
        }

        @Override // d.b.b
        public void b(String str) {
            this.i.log(Level.FINE, str);
        }

        @Override // d.b.b
        public void c(String str) {
            this.i.log(Level.SEVERE, str);
        }

        @Override // d.b.b
        public void e(String str) {
            this.i.log(Level.INFO, str);
        }

        @Override // d.b.b
        public void f(String str) {
            this.i.log(Level.WARNING, str);
        }

        @Override // d.b.b
        public boolean a() {
            return this.i.isLoggable(Level.FINE);
        }

        @Override // d.b.b
        public void b(String str, Throwable th) {
            this.i.log(Level.INFO, str, th);
        }

        @Override // d.b.b
        public void c(String str, Throwable th) {
            this.i.log(Level.WARNING, str, th);
        }

        @Override // d.b.b
        public boolean b() {
            return this.i.isLoggable(Level.INFO);
        }

        @Override // d.b.b
        public boolean c() {
            return this.i.isLoggable(Level.WARNING);
        }
    }

    @Override // d.b.c
    public b a(String str) {
        return new a(Logger.getLogger(str));
    }
}
