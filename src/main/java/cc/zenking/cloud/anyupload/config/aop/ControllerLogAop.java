package cc.zenking.cloud.anyupload.config.aop;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cc.zenking.cloud.anyupload.core.constant.ErrorCode;
import cc.zenking.cloud.anyupload.core.response.JsonResponse;
import cc.zenking.cloud.anyupload.util.JsonParserUtil;

/**
 * 日志切面
 */
@Aspect
@Component
public class ControllerLogAop {

    private static final Logger logger = LoggerFactory.getLogger(ControllerLogAop.class);

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    @Pointcut("execution(public * cc.zenking.cloud.anyupload.web.controller.*Controller.*(..))")
    public void logPoint() {
    }

    // 响应日志
    // 记录执行时间，单位：毫秒
    @Around("logPoint()")
    public Object executeTime(ProceedingJoinPoint joinPoint) {

        StringBuilder log = new StringBuilder("url:" + request.getRequestURI());

        long start = System.currentTimeMillis();
        Object o = null;
        boolean isResponse = false;
        try {
            o = joinPoint.proceed();
        } catch (Throwable ex) {
            ex.printStackTrace();
            logger.error("AOP 程序内错误", ex);
            isResponse = true;
        }
        long end = System.currentTimeMillis();
        log.append(" execute info 接口信息: , execute time len :" + (end - start) + "ms");
        if (o != null) {
            log.append(", response data:" + JsonParserUtil.DEFAULT.toJson(o));
        }
        logger.info(log.toString());
        if (isResponse) {
            response.setContentType("application/json;charset=UTF-8");
            try {
                response.setStatus(200);
                response.getWriter().write(JsonParserUtil.DEFAULT.toJson(JsonResponse.fail(ErrorCode.ERROR_CODE_1001).getBody()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return o;
    }
}
