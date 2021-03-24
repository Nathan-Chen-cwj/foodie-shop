package net.seehope.foodie_shop.advice;


import net.seehope.foodie_shop.common.JsonResult;
import net.seehope.foodie_shop.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * 不加 @ControllerAdvice 默认所有错误转发到 basicErrorController中
 *
 * 控制器统一异常处理中心，所有异常转发到该控制器中处理
 *
 * 一般情况下，异常往controller抛，由controllerAdvice接受异常并进行处理
 * 在写代码的时候，错误情况，就不要返回错误代码，或者return 取而代之
 * 使用自定义异常，并且在异常处理类中自己处理
 *
 *
 * 以后写代码的时候，逻辑一般都是，先排除所有异常情况(抛出异常)，如果没有抛异常，那么方法逻辑成功
 *
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/2 20:25
 *
 * 异常处理器，用于工程出现异常时进行前端控制显示、打印异常日志等
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    /**
     * 所有的Exception都归该方法处理
     * 注解 @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
     * 表示程序发生500错误，意思就是一切异常，
     * 当然要是命中自定义的异常，就先去自定义的异常
     *
     * 注解 @ExceptionHandler(value = Exception.class) 捕获程序运行抛出的、上抛的异常，
     * 注解 @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
     * 带有@ResponseStatus注解的异常类会被ResponseStatusExceptionResolver 解析。
     * 可以实现自定义的一些异常,同时在页面上进行显示。
     * @param e 异常
     * @return JsonResult包含异常信息
     */
    @ResponseBody
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
    public JsonResult handleExceptionRequest(Exception e) {
        return JsonResult.err(e.getLocalizedMessage());
    }

    /**
     * 所有的ArithmeticException都归该方法处理
     *  程序发生ArithmeticException异常
     * @param e 异常
     * @return JsonResult包含异常信息
     */
    @ResponseBody
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = ArithmeticException.class)
    public JsonResult handleArithmeticExceptionRequest(ArithmeticException e) {
        return JsonResult.err("算数异常:" + e.getLocalizedMessage());
    }

    /**
     * 处理设置默认地址错误异常
     * @param e 异常
     * @return JsonResult包含异常信息
     */
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = SetReceivingAddressNotToDefaultException.class)
    public JsonResult handlerSetReceivingAddressNotToDefault(SetReceivingAddressNotToDefaultException e){
        return JsonResult.err(e.getLocalizedMessage());
    }

    /**
     * 处理创建订单异常
     * @param e 异常
     * @return JsonResult包含异常信息
     */
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = CreateOrderItemsException.class)
    public JsonResult handlerCreateOrderItemsException(CreateOrderItemsException e){
        return JsonResult.err(e.getLocalizedMessage());
    }

    /**
     * 处理删除收货地址异常
     * @param e 异常
     * @return JsonResult包含异常信息
     */
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = DeleteReceivingAddressException.class)
    public JsonResult handlerDeleteReceivingAddressException(DeleteReceivingAddressException e){
        return JsonResult.err(e.getLocalizedMessage());
    }

    /**
     * 处理添加收货地址异常
     * @param e 异常
     * @return JsonResult包含异常信息
     */
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = AddReceivingAddressException.class)
    public JsonResult handlerAddReceivingAddressException(AddReceivingAddressException e){
        return JsonResult.err(e.getLocalizedMessage());
    }

    /**
     * 处理更新收货地址异常
     * @param e 异常
     * @return JsonResult包含异常信息
     */
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = UpdateReceivingAddressException.class)
    public JsonResult handlerUpdateReceivingAddressException(UpdateReceivingAddressException e){
        return JsonResult.err(e.getLocalizedMessage());
    }

    /**
     * 处理登陆异常
     * @param e
     * @return
     */
    @ResponseBody

    @ExceptionHandler(LoginException.class)
    public JsonResult handlerLoginException(LoginException e){
        return JsonResult.err(e.getLocalizedMessage());
    }

    /**
     * 处理注册异常
     * @param e
     * @return
     */
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = RegisterException.class)
    public JsonResult handlerRegisterException(LoginException e){
        return JsonResult.err(e.getLocalizedMessage());
    }

}

