package com.zp.service;

import com.zp.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * PaymentService
 *
 * @author zhengpanone
 * @since 2021-10-29
 */
public interface PaymentService {
    /**
     * 保存
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * 根据ID查询
     * @param id payment ID
     * @return
     */
    Payment getPaymentById(@Param("id")Long id);
}
