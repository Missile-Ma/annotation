package com.missile.dao;

import org.springframework.stereotype.Repository;

/**
 * @author Missile
 * @Date 2021-02-02-20:15
 */
@Repository
public class BookDao {

    private String label="1";

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "[" +
                "label='" + label + '\'' +
                ']';
    }
}
