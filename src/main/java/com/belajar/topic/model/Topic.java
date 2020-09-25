package com.belajar.topic.model;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name="TOPIC")
@ApiModel
@NamedQuery(name = "Topic.findAll", query = "SELECT t FROM Topic t")
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(
                name = "findByYearProcedure",
                procedureName = "FIND_TOPIC_BY_YEAR",
                resultClasses = {Topic.class},
                parameters = {
                        @StoredProcedureParameter(
                                name = "p_year",
                                type = Integer.class,
                                mode = ParameterMode.IN
                        )})})
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false, scale = 0)
    private Integer id_topic;

    @NotNull
    @Column(name = "NAME")
    @ApiModelProperty(notes = "Name of the topic")
    private String name_topic;

    @Column(name = "DESCRIPTION")
    @ApiModelProperty(notes = "Topic's description")
    private String description_topic;

    @Column(name = "YEAR")
    @ApiModelProperty(notes = "Year of the topic discovered")
    private Integer year;


    public Topic(){

    }

    public Topic(String name_topic, String description_topic, Integer year){
        this.name_topic=name_topic;
        this.description_topic=description_topic;
        this.year=year;
    }

    public Integer getId() {
        return id_topic;
    }
    public void setId(Integer id_topic) {
        this.id_topic = id_topic;
    }

    public String getName() {
        return name_topic;
    }
    public void setName(String name_topic) {
        this.name_topic = name_topic;
    }

    public String getDescription() {
        return description_topic;
    }
    public void setDescription(String description_topic) {
        this.description_topic = description_topic;
    }

    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }


}
