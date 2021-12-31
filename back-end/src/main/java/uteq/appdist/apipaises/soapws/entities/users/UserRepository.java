package uteq.appdist.apipaises.soapws.entities.users;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uteq.appdist.apipaises.soapws.shared.DBResponse;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    

    @Query(value = "select*from tbperson where email_person=:email", nativeQuery = true)
    public List<User> getUserByEmail(String email);

    @Query(value = "select*from tbperson where phone_person=:phone", nativeQuery = true)
    public List<User> getUserByPhone(String phone);

    @Query(value = "select*from tbusers where user_name=:userName", nativeQuery = true)
    public List<User> getUserByUserName(String userName);

    // Insert Province
    @Query(value = "select * from fninsertpersona(:fnm,:snm,:ema,:phn,:usn,:pss)", nativeQuery = true)
    public DBResponse saveUser(
            @Param("fnm") String firtsName,
            @Param("snm") String secondName,
            @Param("ema") String email,
            @Param("phn") String phone,
            @Param("usn") String userName,
            @Param("pss") String password);


    


}
