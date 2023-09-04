package com.jsp.fifo.dto;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Entity
@Data
@Component
public class Fifo 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] fil;

}
