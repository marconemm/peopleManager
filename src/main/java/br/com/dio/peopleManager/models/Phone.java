package br.com.dio.peopleManager.models;

import javax.persistence.*;

@Entity
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

    public Phone() {
        id = 0;
        number = null;
        type = null;
    }

    public String getNumber() {
        return number;
    }

    public int getId() {
        return id;
    }

    public PhoneType getType() {
        return type;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }
}
