package com.dsecet.core.persist;

import com.dsecet.core.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with Test
 * User : yt
 * Date : 2014/11/11.
 */
public interface UserRepository extends JpaRepository<User, Long>{
}
