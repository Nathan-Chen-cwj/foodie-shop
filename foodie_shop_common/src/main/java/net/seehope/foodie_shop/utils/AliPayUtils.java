package net.seehope.foodie_shop.utils;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2020/9/4 22:53
 */
public class AliPayUtils {
    private static String appId=null;
    private static String serverUrl=null;
    private static String privateKey=null;
    private static String publicKey=null;
    private static String aliPublicKey=null;
    private static String format=null;
    private static String charset=null;
    private static String signType=null;
    private static String returnUrl=null;
    private static AlipayClient ALIPAY_CLIENT_PAGE=null;
    private static AlipayClient ALIPAY_CLIENT_QUERY=null;
    //读取配置文件的配置项信息
    static {
        ResourceBundle alipay_config = ResourceBundle.getBundle("alipay");
        appId = alipay_config.getString("appId");
        serverUrl = alipay_config.getString("serverUrl");
        privateKey = alipay_config.getString("privateKey");
        publicKey = alipay_config.getString("publicKey");
        aliPublicKey = alipay_config.getString("aliPublicKey");
        format = alipay_config.getString("format");
        charset = alipay_config.getString("charset");
        signType = alipay_config.getString("signType");
        returnUrl = alipay_config.getString("returnUrl");
        /**下单操作*/
        ALIPAY_CLIENT_PAGE = new DefaultAlipayClient(serverUrl, appId, privateKey, format, charset, aliPublicKey, signType);
        /**查询操作*/
        ALIPAY_CLIENT_QUERY = new DefaultAlipayClient(serverUrl, appId, privateKey, format, charset, aliPublicKey, signType);
    }

    /**
     *
     * @param out_trade_no 订单号
     * @param subject 订单标题
     * @param total_amount 支付数额
     * @return
     * @throws AlipayApiException
     * @throws JsonProcessingException
     */
    public static String generateAliPayTradePagePayRequestForm(String out_trade_no,String subject,double total_amount) throws AlipayApiException, JsonProcessingException {
        //创建API对应的request
        AlipayTradePagePayRequest aliPayRequest = new AlipayTradePagePayRequest();
        aliPayRequest.setReturnUrl(returnUrl);
        BizContent bizContent = new BizContent(out_trade_no,total_amount,subject);
        String s = new ObjectMapper().writeValueAsString(bizContent);
        aliPayRequest.setBizContent(s);
        //调用SDK生成表单
        return ALIPAY_CLIENT_PAGE.pageExecute(aliPayRequest).getBody();
    }

    public static boolean generateAliPayTradeQueryRequest(String orderId) throws AlipayApiException {
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        request.setBizContent("{"+
                "\"out_trade_no\":\""+orderId+"\""+
                " }");
        AlipayTradeQueryResponse response = ALIPAY_CLIENT_QUERY.execute(request);
        if (response.isSuccess()){
            String tradeStatus = response.getTradeStatus();
            if (TradeStatus.TRADE_SUCCESS.name().equals(tradeStatus)){
                return true;
            }
            System.out.println(tradeStatus);
        }
        return false;
    }

    /**
     * 支付宝检签检测
     * @param requestParams 支付宝响应参数集合
     * @return
     */
    public static boolean check(Map<String, String[]> requestParams){
        try {
            return AlipaySignature.rsaCheckV2(convert(requestParams),aliPublicKey,charset,signType);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Map<String, String[]> 转换为 Map<String, String>
     * @param requestParams 需要转换的Map
     * @return 转换后的Map
     */
    public static Map<String, String> convert(Map<String, String[]> requestParams){
        HashMap<String, String> result = new HashMap<>();
        if (requestParams != null && requestParams.size() > 0){
            Set<Map.Entry<String, String[]>> entrySet = requestParams.entrySet();
            for (Map.Entry<String, String[]> entry : entrySet) {
                //这里的结课名不同，报错请看！||
                if (!entry.getKey().equals("mtx_md")){
                    result.put(entry.getKey(),entry.getValue()[0]);
                }
            }
        }
        return result;
    }

    public static enum TradeStatus{
        WAIT_BUYER_PAY,TRADE_CLOSE,TRADE_SUCCESS,TRADE_FINISHED
    }

    public static class BizContent{
        //商户交易订单号
        private String out_trade_no;
        //销售产品码，与支付宝签约的产品码名称。
        //注：目前仅支持FAST_INSTANT_TRADE_PAY
        private String product_code="FAST_INSTANT_TRADE_PAY";
        //订单的总金额
        private double total_amount;
        //订单标题 必选
        private String subject;
        //	订单描述 可选
        private String body;

        public String getOut_trade_no() {
            return out_trade_no;
        }

        public void setOut_trade_no(String out_trade_no) {
            this.out_trade_no = out_trade_no;
        }

        public String getProduct_code() {
            return product_code;
        }

        public void setProduct_code(String product_code) {
            this.product_code = product_code;
        }

        public double getTotal_amount() {
            return total_amount;
        }

        public void setTotal_amount(double total_amount) {
            this.total_amount = total_amount;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        private  BizContent(String out_trade_no, double total_amount, String subject) {
            this.out_trade_no = out_trade_no;
            this.total_amount = total_amount;
            this.subject = subject;
        }

    }
}
