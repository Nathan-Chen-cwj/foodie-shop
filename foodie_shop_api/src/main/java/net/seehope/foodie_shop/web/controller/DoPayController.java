package net.seehope.foodie_shop.web.controller;

import com.alipay.api.AlipayApiException;
import net.seehope.foodie_shop.common.JsonResult;
import net.seehope.foodie_shop.service.OrdersService;
import net.seehope.foodie_shop.utils.AliPayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/3/27 21:51
 */
@RestController
@RequestMapping("/payment")
public class DoPayController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private HttpServletRequest request;

//    paymentServerUrl + "/payment/goAlipay?OrderId=" + orderId+ "&amount=" + totalAmount)
    @PostMapping("/goAlipay")
    public JsonResult goAlipay(@RequestBody String orderId,String amount){
        System.out.println("go into goToPayOrder  "+"orderId  "+orderId+ "amount"+amount);
        String form = null;
        try{
            form = AliPayUtils.generateAliPayTradePagePayRequestForm(orderId.toString(), "沙箱支付学习", Double.parseDouble(amount));
            return JsonResult.isOk(form);
        }catch (Exception e){
            throw new RuntimeException("系统异常,支付失败！");
        }
    }

    /**
     * 检验支付是否成功
     */
    @GetMapping("/callback")
    public JsonResult callback() throws AlipayApiException {
        boolean check = AliPayUtils.check(request.getParameterMap());
        if (check){
            String out_trade_no = request.getParameter("out_trade_no");
            boolean b = AliPayUtils.generateAliPayTradeQueryRequest(out_trade_no);
            if (b){
                //修改数据库中订单状态信息
                ordersService.successPay(out_trade_no);
                return JsonResult.isOk("支付成功！");
            }else {
                return JsonResult.err("系统繁忙，支付失败！");
            }
        }else {
            return JsonResult.err("非法请求！");
        }

    }
}
