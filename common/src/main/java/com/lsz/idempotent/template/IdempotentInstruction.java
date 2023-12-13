package com.lsz.idempotent.template;

/**
 * @ClassName BaseOperateInstruction
 * @Description TODO
 * @Author tingkai
 * @Date 2023/12/13 10:54
 * @Version 1.0
 **/
public class IdempotentInstruction {

    private String instructionId;

    private String requestId;

    private String siteId;

    private Long requestTime;

    private Long finishTime;

    private String requestContent;

    private String resultContent;

    public String getInstructionId() {
        return instructionId;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getSiteId() {
        return siteId;
    }

    public Long getRequestTime() {
        return requestTime;
    }

    public Long getFinishTime() {
        return finishTime;
    }

    public String getRequestContent() {
        return requestContent;
    }

    public String getResultContent() {
        return resultContent;
    }
}
