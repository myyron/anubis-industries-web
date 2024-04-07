package com.anubisindustries.web.dto;

import java.util.Set;

/**
 *
 * @author altrax
 */
public class ProductDto {

    private String alias;
    private String name;
    private Set<VariationDto> variation;

    public Set<VariationDto> getVariation() {
        return variation;
    }

    public void setVariation(Set<VariationDto> variation) {
        this.variation = variation;
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
