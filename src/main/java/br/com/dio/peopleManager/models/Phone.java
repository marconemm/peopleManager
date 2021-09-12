package br.com.dio.peopleManager.models;

import br.com.dio.peopleManager.enums.PhoneTypes;
import lombok.AllArgsConstructor;
import lombok.Builder;
//import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
//@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Phone {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @Column(length = 18, nullable = false)
   private String number;

   @Enumerated(EnumType.STRING)
   @Column(nullable = false)
   private PhoneTypes type;

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getNumber() {
      return number;
   }

   public void setNumber(String number) {
      this.number = number;
   }

   public PhoneTypes getType() {
      return type;
   }

   public void setType(PhoneTypes type) {
      this.type = type;
   }
}
