package com.zp.service.impl;

import com.zp.dao.PaymentDao;
import com.zp.entities.Payment;
import com.zp.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * PayServiceImpl
 *
 * @author zhengpanone
 * @since 2021-10-29
 */
@Service
public class PayServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
