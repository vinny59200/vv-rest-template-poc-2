package com.vv.pocRestTemplate.controller;

import com.vv.pocRestTemplate.Model.Story;
import com.vv.pocRestTemplate.client.StoryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping( "/api/stories" )
public class StoryController {

    @Autowired
    private StoryClient storyClient;

    @PostMapping
    public Story postOneStory() {
        return storyClient.saveNewStory( Story.builder()
                                              .userId( 1L )
                                              .id( 1111L )
                                              .title( "Paris" )
                                              .body( "Moving to Paris would be In-Seine." )
                                              .build() );
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<String> getStoryById( @PathVariable( value = "id" ) Long storyId ) {
        return storyClient.getStory( storyId );
    }
}