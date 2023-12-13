package com.lsz.idempotent;

import com.lsz.idempotent.template.CommonIdempotentTemplate;
import com.lsz.idempotent.template.IdempotentContext;
import com.lsz.idempotent.template.IdempotentExecuteCallback;
import com.lsz.idempotent.template.IdempotentTemplate;

/**
 * @ClassName Demo
 * @Description TODO
 * @Author tingkai
 * @Date 2023/12/13 19:42
 * @Version 1.0
 **/
public class Demo {



    public static void main(String[] args) {
        IdempotentTemplate idempotentTemplate = new CommonIdempotentTemplate();
        String request = (String) idempotentTemplate.execute("request", new IdempotentExecuteCallback<String, String>() {

            @Override
            public IdempotentContext generateIdempotentContext(String s) {
                return new IdempotentContext.Builder().idempotentKey("test").build();
            }

            @Override
            public String execute(String request) {
                return "result";
            }
        });
        System.out.println("request = " + request);

        Long request1 = (Long) idempotentTemplate.execute(2L, new IdempotentExecuteCallback<Long, Long>() {

            @Override
            public IdempotentContext generateIdempotentContext(Long s) {
                return new IdempotentContext.Builder().idempotentKey("test").build();
            }

            @Override
            public Long execute(Long request) {
                return 2L;
            }
        });
        System.out.println("request1 = " + request1);
    }
}
