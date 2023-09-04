package com.jsp.fifo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.fifo.dto.Fifo;

public interface FifoRepo extends JpaRepository<Fifo, Integer>
{

//	List<Fifo> findByName(String name);

}
