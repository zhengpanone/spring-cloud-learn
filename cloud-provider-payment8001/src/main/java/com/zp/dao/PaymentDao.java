package com.zp.dao;

import com.zp.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * PayDao
 *
 * @author zhengpanone
 * @since 2021-10-22
 */
@Mapper
public interface PaymentDao{
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
