package com.haiso.hr.dao;

import com.haiso.hr.entity.employee.RewardsPunishment;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ff on 4/28/14.
 */
public interface EmployeeRewardsPunishmentDao extends CrudRepository<RewardsPunishment, Integer> {
}
