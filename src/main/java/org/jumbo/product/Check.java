package org.jumbo.product;

import lombok.Data;

@Data
public class Check {
    private Integer cash_id;
    private Integer check_number;
    private String check_uid;
    private Integer manufacturer_id;
    private String date_check;
    private Integer can_leave_rating;
}
