package freemarker.core;

import freemarker.template.TemplateException;
import java.io.PrintStream;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes5.dex */
public class StopException extends TemplateException {
    StopException(Environment environment) {
        super(environment);
    }

    @Override // freemarker.template.TemplateException, java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        synchronized (printWriter) {
            String message = getMessage();
            printWriter.print("Encountered stop instruction");
            if (message == null || message.equals("")) {
                printWriter.println();
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("\nCause given: ");
                stringBuffer.append(message);
                printWriter.println(stringBuffer.toString());
            }
            super.printStackTrace(printWriter);
        }
    }

    StopException(Environment environment, String str) {
        super(str, environment);
    }

    @Override // freemarker.template.TemplateException, java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        synchronized (printStream) {
            String message = getMessage();
            printStream.print("Encountered stop instruction");
            if (message != null && !message.equals("")) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("\nCause given: ");
                stringBuffer.append(message);
                printStream.println(stringBuffer.toString());
            } else {
                printStream.println();
            }
            super.printStackTrace(printStream);
        }
    }
}
