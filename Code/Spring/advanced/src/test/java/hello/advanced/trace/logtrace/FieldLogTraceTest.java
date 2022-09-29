package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import org.junit.jupiter.api.Test;

public class FieldLogTraceTest {
    FieldLogTrace trace = new FieldLogTrace();
    @Test
    void begin_end() {
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.end(status2);
        trace.end(status1);
    }
    @Test
    void begin_exception() {

        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.exception(status2,new IllegalStateException());
        trace.exception(status1,new IllegalStateException());
    }
}
