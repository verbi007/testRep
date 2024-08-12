package org.jumbo.product;

import lombok.Data;

@Data
public class ShoppingCart {
    private Object group_price;
    private Object title_prefix;
    private Object tov_separator;
    private String color;
    private String price_text_color;
    private Boolean show_both;
    private Object text;
    private String desc_text_color;
    private Object icon;
}
