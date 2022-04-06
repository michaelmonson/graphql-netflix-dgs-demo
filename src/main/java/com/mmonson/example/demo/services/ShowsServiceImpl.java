package com.mmonson.example.demo.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
//import com.mmonson.example.demo.DemoApplication.Show;
//import com.mmonson.example.demo.generated.types.Show;

@Service
public class ShowsServiceImpl implements ShowsService {

    @Override
    public List<Show> shows() {
        return Arrays.asList(
            Show.newBuilder().id(1).title("Stranger Things").releaseYear(2016).build(),
            Show.newBuilder().id(2).title("Ozark").releaseYear(2017).build()            
        );
    }

    
}
