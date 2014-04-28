package com.haiso.hr.dao;

import com.haiso.hr.entity.person.SocialRelationship;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ff on 4/28/14.
 */
public interface PersonSocialRelationshipDao extends CrudRepository<SocialRelationship, Integer> {
}
