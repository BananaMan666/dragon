package com.dragon.banana.common.exception;

import com.dragon.banana.common.response.BizResponse;
import com.dragon.banana.common.response.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/**
 * @author liulongxiang
 * @Date 2023/9/8 16:51
 *
 * @Description 全局异常控制
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    public static final String PROJECT_NAME = "banana:{}";

    /**
     * 自定义异常处理
     *
     * @param ex
     * @param request
     * @return
     */
    @ResponseBody
    @ExceptionHandler(BizException.class)
    public Object handlerBizResponse(BizException ex, WebRequest request){
        log.warn(PROJECT_NAME, ex.getMessage());

        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("success", false);
        modelMap.addAttribute("code", ResultCode.getCode(ex.getMessage()));
        modelMap.addAttribute("message", ex.getMessage());

        return modelMap;
    }

    /**
     * 处理其他异常
     *
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object handlerXhrException(Exception ex, WebRequest request) {
        // 使用log4j时， ex.printStackTrace()不会输出到日志文件中
        log.error(PROJECT_NAME, ex);
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("success", false);
        modelMap.addAttribute("code", ResultCode.SYSTEM_INNER_BUSY.code());
        modelMap.addAttribute("message", ResultCode.SYSTEM_INNER_BUSY.message());
        return modelMap;
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public BizResponse handler(MethodArgumentNotValidException e) {
        log.error("实体校验异常：----------------{}", e);
        BindingResult bindingResult = e.getBindingResult();
        ObjectError objectError = bindingResult.getAllErrors().stream().findFirst().get();

        return BizResponse.fail(objectError.getDefaultMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = IllegalArgumentException.class)
    public BizResponse handler(IllegalArgumentException e) {
        log.error("Assert异常：----------------{}", e);
        return BizResponse.fail(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public BizResponse handler(RuntimeException e) {
        log.error("运行时异常：----------------{}", e);
        return BizResponse.fail(e.getMessage());
    }

}
