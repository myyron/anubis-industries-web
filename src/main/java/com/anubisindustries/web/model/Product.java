package com.anubisindustries.web.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author altrax
 */
@Entity
@Table(name = "product",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = "alias")
        })
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 20)
    private String alias;

    @NotBlank
    @Size(max = 120)
    private String name;

    @OneToMany(mappedBy = "product")
    private Set<Variation> variation = new HashSet<>();

    public Set<Variation> getVariation() {
        return variation;
    }

    public void setVariation(Set<Variation> variation) {
        this.variation = variation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
