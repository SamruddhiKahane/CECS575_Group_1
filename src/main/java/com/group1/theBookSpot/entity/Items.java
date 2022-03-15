package com.group1.theBookSpot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="items")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Items  extends BaseEntity implements Serializable {

    @Column(unique = true)
    private String bookId;

    @Column(name = "isbn",unique = true)
    private String isbn;


    @Column(name = "item_year")
    private Date year;


    @Column(name = "category")
    private String category;


    @Column(name = "author")
    private String author;


    @Column(name = "title")
    private String title;


    @Column(name = "publisher")
    private String publisher;

}
