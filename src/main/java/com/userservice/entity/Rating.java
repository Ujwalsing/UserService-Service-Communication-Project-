package com.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
	private String ratingId;
	private String userIdString;
	private String hotelIdString;
	private int rating;
	private String feedBack;
	
}
