package com.github.nekox41.quartz.util;

import org.quartz.JobExecutionContext;
import com.github.nekox41.quartz.domain.SysJob;

/**
 * 定时任务处理（允许并发执行）
 * 
 * @author longyun
 *
 */
public class QuartzJobExecution extends AbstractQuartzJob
{
    @Override
    protected void doExecute(JobExecutionContext context, SysJob sysJob) throws Exception
    {
        JobInvokeUtil.invokeMethod(sysJob);
    }
}
