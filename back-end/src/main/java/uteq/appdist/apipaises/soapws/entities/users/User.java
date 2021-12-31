package uteq.appdist.apipaises.soapws.entities.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbusers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    
    @Id
    @SequenceGenerator(name = "usuarios_usuarioID_seq", sequenceName = "usuarios_usuarioID_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarios_usuarioID_seq")

    @Column(name = "userid")
    int userid;

    // String firstName;

    // String secondName;

    // String email;

    // String phone;

    @Column(name = "user_name")
    String userName;

    @Column(name = "user_password")
    String password;


    @Column(name = "usertypeid")
    int userTypeId;

    @Column(name = "personid")
    int personId;
}
