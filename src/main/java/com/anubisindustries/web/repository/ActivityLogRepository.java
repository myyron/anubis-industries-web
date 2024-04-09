package com.anubisindustries.web.repository;

import com.anubisindustries.web.model.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author altrax
 */
@Repository
public interface ActivityLogRepository extends JpaRepository<ActivityLog, Integer> {
}
