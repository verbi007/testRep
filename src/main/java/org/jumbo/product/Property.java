package org.jumbo.product;

import lombok.Data;

@Data
public class Property {

    private String price_name;
    private String color;
    private Boolean show_both;
    private String text;
    private Integer type;
    private String price_text_color;
    private String desc_text_color;
    private IconToAction icon_to_action;
    private Icon icon;
    private ShoppingCart shopping_cart;
    private Object additional_block;
    private Object bottomsheet;
    private Object nameplate;
    private Object id_priv;
    private Object priv_type;
    private Integer price_type;
    private Integer priv_used;
    private Boolean priv_private;
    private String property_id;
    private String property_name;
    private String property_value;
    private String property_expand;
    private String display_front;
    private String color_property_value;
}
