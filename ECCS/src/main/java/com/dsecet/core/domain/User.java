package com.dsecet.core.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with Test
 * User : yt
 * Date : 2014/11/11.
 */
@Entity
@Table
@Data
public class User implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "u_id")
    private long id;
    @Column(name = "u_name")
    private String name;
}
