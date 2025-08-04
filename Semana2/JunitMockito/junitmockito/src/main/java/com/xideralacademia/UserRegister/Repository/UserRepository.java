package com.xideralacademia.UserRegister.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.xideralacademia.UserRegister.Model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository <UserEntity,Long>{
    
}
