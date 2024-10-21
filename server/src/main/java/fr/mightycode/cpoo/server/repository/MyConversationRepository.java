package fr.mightycode.cpoo.server.repository;

import fr.mightycode.cpoo.server.entity.MyConversation;
import fr.mightycode.cpoo.server.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyConversationRepository extends JpaRepository<MyConversation, Long> {
  @Query("SELECT c FROM MyConversation c WHERE c.userInfo = :userInfo ORDER BY c.lastMessageDate DESC")
  List<MyConversation> findByUserInfoOrderByLastMsgDateDesc(@Param("userInfo") UserInfo userInfo);

  List<MyConversation> findByUserInfo(UserInfo userInfo);
}
