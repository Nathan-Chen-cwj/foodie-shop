package net.seehope.foodie_shop.mapper;

import net.seehope.foodie_shop.enums.OrdersStatusEnum;
import net.seehope.foodie_shop.pojo.Orders;
import net.seehope.foodie_shop.vo.OrdersVo;

import java.util.List;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
public interface OrdersMapper extends tk.mybatis.mapper.common.Mapper<Orders> {
    /**
     * 根据用户手机号码查询订单
     * @param mobile
     * @return
     */
    public List<OrdersVo> queryOrdersByUserMobile(String mobile);

    /**
     * 根据收货人手机号码查询订单
     * @param mobile
     * @return
     */
    public List<OrdersVo> queryOrderByReceiverMobile(String mobile);

    /**
     * 支付完成后修改订单状态表中的订单状态
     * @param out_trade_no
     * @param tradeTime
     * @param orderStatus
     * @return
     */
    public int successPay(String out_trade_no, String tradeTime, int orderStatus);

    /**
     * 向订单状态表插入数据
     * @param orderId
     * @param orderStatus
     * @param createTime
     * @return
     */
    public int insertOrdersStatusTable(String orderId,int orderStatus,String createTime);
}




