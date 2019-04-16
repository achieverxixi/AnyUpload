package cc.zenking.cloud.anyupload.core.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by chengjunchao on 2018/3/1 17:08.
 * 控制器基础类
 */
public class BaseController {
    @Autowired
    private HttpServletRequest request;
}
