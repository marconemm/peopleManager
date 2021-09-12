package br.com.dio.peopleManager.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Phone {
   public enum PhoneType {
       HOME("Home"),
       MOBILE("Mobile"),
       COMMERCIAL("Commercial");

       final private String description;

       PhoneType(String description) {
           this.description = description;
       }
   }

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @Column(length = 18, nullable = false)
   private String number;

   @Enumerated(EnumType.STRING)
   @Column(nullable = false)
   private PhoneType type;
}
