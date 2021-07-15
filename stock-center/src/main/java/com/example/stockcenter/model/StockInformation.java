package com.example.stockcenter.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name ="stock_information")
public class StockInformation extends AuditModel{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name= "product_id")
    private String productId;

    @Column
    @Size(min = 1, max = 100)
    private String name;

    @Column
    @NotNull
    private String version;

    @Column
    @NotNull
    private Integer amount;

//    @Column(name = "dis_count")
//    @NotNull
//    private Double disCount;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
