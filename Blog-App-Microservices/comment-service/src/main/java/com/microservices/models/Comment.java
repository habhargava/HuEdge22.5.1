package com.microservices.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@Data
@NoArgsConstructor
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String comment;
	private Timestamp time;
	private Long postId;
}
