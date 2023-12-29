package com.lsz.idempotent;


/**
  *@ClassName TestApplication
  *@Description TODO
  *@Author tingkai
  *@Date 2023/12/17 13:40
  *@Version 1.0
  **/
public interface TestApplication {


    boolean execute(TestCommand command);

}
