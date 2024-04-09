package com.anubisindustries.web.service;

import com.anubisindustries.web.model.ActivityLog;
import com.anubisindustries.web.model.ETableName;
import com.anubisindustries.web.model.ETransactionType;
import com.anubisindustries.web.model.Product;
import com.anubisindustries.web.repository.ActivityLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author altrax
 */
@Service
public class ActivityLogServiceImpl implements IActivityLogService {

    @Autowired
    private ActivityLogRepository activityLogRepository;

    @Override
    public Integer save(Object object, ETransactionType transactionType) {
        ETableName tableName = null;
        Integer recordId = 0;
        if (object instanceof Product) {
            tableName = ETableName.PRODUCT;
            recordId = ((Product) object).getId();
        }

        ActivityLog activityLog = new ActivityLog();
        activityLog.setRecordId(recordId);
        activityLog.setTableName(tableName);
        activityLog.setTransactionType(transactionType);
        activityLog.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        return activityLogRepository.save(activityLog).getId();
    }
}
