package com.example.registration_system.repositories;
import com.example.registration_system.appUser.AppUser;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository {
    Optional<AppUser> findByEmail(String email);
}
