package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldLogTrace implements LogTrace{
    private static final String START_PREFIX = "-->";
    private static final String COMPLETE_PREFIX = "<--";
    private static final String EX_PREFIX="<X-";

    private TraceId traceIdHolder; //traceId 동기화, 동시성 이슈 발생

    @Override
    public TraceStatus begin(String message) {
        syncTraceId();
        TraceId traceId = traceIdHolder;
        Long startTimeMs = System.currentTimeMillis();
        //로그출력
        log.info("[{}] {}{}",traceId.getId(),addSpace(START_PREFIX,traceId.getLevel()),message);
        return new TraceStatus(traceId, startTimeMs, message);
    }

    @Override
    public void end(TraceStatus status) {
        complete(status,null);
    }

    @Override
    public void exception(TraceStatus status, Exception e) {
        complete(status,e);
    }
    private void complete(TraceStatus status,Exception e){
        Long stopTimeMs = System.currentTimeMillis();
        long resultTimeMs = stopTimeMs-status.getStartTimeMs();
        TraceId traceId = status.getTraceId();
        if(e==null){
            log.info("[{}] {}{} time={}ms",
                    traceId.getId(),
                    addSpace(COMPLETE_PREFIX, traceId.getLevel()),
                    status.getMessage(),
                    resultTimeMs);
        }else{
            log.info("[{}] {}{} time={}ms ex={}",
                    traceId.getId(),
                    addSpace(EX_PREFIX, traceId.getLevel()),
                    status.getMessage(),
                    resultTimeMs,
                    e.toString());
        }
        releaseTraceId();
    }
    // 직전에 생성된 traceId가 없으면, 새로 만들고, 있으면, 아이디는 유지하고, 레벨만 올린다.
    private void syncTraceId(){
        if(traceIdHolder==null){
            traceIdHolder=new TraceId();
        }else {
            traceIdHolder=traceIdHolder.createNextId();
        }
    }
    // 레벨이 계속있으면, 아이디는 유지하고, 레벨은 하나씩 줄인다. 레벨이 끝에 닿으면, traceId를 파기한다.
    private void releaseTraceId() {
        if(traceIdHolder.isFirstLevel()){
            traceIdHolder=null; // destroy
        }else {
            traceIdHolder=traceIdHolder.createPreviousId();
        }
    }

    private static String addSpace(String prefix, int level){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<level;i++){
            sb.append((i==level - 1)?"|"+prefix:"|   ");
        }
        return sb.toString();
    }
}
