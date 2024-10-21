package fr.mightycode.cpoo.server.repository;

import fr.mightycode.cpoo.server.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
  UserInfo findByLogin(String login);
}

