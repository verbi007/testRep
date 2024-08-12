package org.jumbo.product;

import lombok.Data;

@Data
public class Dynamic {
    private String style;
    private String title;
    private String subtitle;
    private String image;
    private String link;
    private Object properties;
    private Object content;
}
