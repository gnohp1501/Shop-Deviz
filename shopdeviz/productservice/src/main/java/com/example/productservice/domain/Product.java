package com.example.productservice.domain;

import com.netflix.discovery.provider.Serializer;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Serializer
@Document(collection = "product")
public class Product {
    private String name;
    private String author;
}
