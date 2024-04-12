package com.anubisindustries.web.service;

import com.anubisindustries.web.model.ETransactionType;

/**
 *
 * @author altrax
 */
public interface IActivityLogService {

    Integer save(Object object, ETransactionType transactionType);
}
