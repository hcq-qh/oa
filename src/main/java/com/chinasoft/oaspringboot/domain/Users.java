package com.chinasoft.oaspringboot.domain;

import java.io.Serializable;

public class Users implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.id
     *
     * @mbggenerated Tue Sep 17 16:37:16 CST 2019
     */
    private static final long serialVersionUID = -5244288298702801619L;
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.name
     *
     * @mbggenerated Tue Sep 17 16:37:16 CST 2019
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.id
     *
     * @return the value of users.id
     *
     * @mbggenerated Tue Sep 17 16:37:16 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.id
     *
     * @param id the value for users.id
     *
     * @mbggenerated Tue Sep 17 16:37:16 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.name
     *
     * @return the value of users.name
     *
     * @mbggenerated Tue Sep 17 16:37:16 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.name
     *
     * @param name the value for users.name
     *
     * @mbggenerated Tue Sep 17 16:37:16 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}