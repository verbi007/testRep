package org.jumbo.product;

import lombok.Data;

@Data
public class Price {
    private Object id_priv;
    private Object priv_type;
    private Integer price_type;
    private Integer priv_used;
    private Boolean priv_private;
    private Integer price;
    private Integer discount_price;
    private Integer discount_percent;
    private Property properties;
}
