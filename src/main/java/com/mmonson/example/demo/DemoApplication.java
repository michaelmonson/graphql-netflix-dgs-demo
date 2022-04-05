package com.mmonson.example.demo;

import java.util.List;
import java.util.stream.Collectors;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@DgsComponent
	public class ShowsDatafetcher {
	
		private final List<Show> shows = List.of(
				new Show("Stranger Things", 2016),
				new Show("Ozark", 2017),
				new Show("The Crown", 2016),
				new Show("Dead to Me", 2019),
				new Show("Orange is the New Black", 2013)
		);
	
		@DgsQuery
		public List<Show> shows(@InputArgument String titleFilter) {
			if(titleFilter == null) {
				return shows;
			}
	
			return shows.stream().filter(s -> s.getTitle().contains(titleFilter)).collect(Collectors.toList());
		}
	}
	
	public class Show {
		private final String title;
		private final Integer releaseYear;
	
		public Show(String title, Integer releaseYear) {
			this.title = title;
			this.releaseYear = releaseYear;
		}
	
		public String getTitle() {
			return title;
		}
	
		public Integer getReleaseYear() {
			return releaseYear;
		}
	}


}
