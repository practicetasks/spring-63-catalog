package kz.runtime.stat_service.spring63catalog.model;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    long id;
    String name;
    double price;
    Category category;
}
