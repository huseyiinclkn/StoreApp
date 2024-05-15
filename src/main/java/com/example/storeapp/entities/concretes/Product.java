        package com.example.storeapp.entities.concretes;

        import jakarta.persistence.*;
        import lombok.*;
        import org.springframework.beans.factory.annotation.Autowired;

        @Entity
        @Table(name="products")
        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public class Product {

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name="product_id")
            private int id;


            @Column(name="product_name")
            private String productName;

            @Column(name="unit_price")
            private double unitPrice;

            @Column(name="units_in_stock")
            private short unitsInStock;

            @Column(name="quantity_per_unit")
            private String quantityPerUnit;

           @ManyToOne()
           @JoinColumn(name = "category_id")
           private Category category;
       }
