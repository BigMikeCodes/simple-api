package uk.co.michaelfarrant.simpleapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.michaelfarrant.simpleapi.responses.BeerResponse;

@RestController
public class BeerController {

    @GetMapping("/favourite/beer")
    public BeerResponse getFavouriteBeer(){
        return new BeerResponse("free");
    }

    @GetMapping("/least-favourite/beer")
    public BeerResponse getLeastFavouriteBeer(){
        return new BeerResponse("lite");
    }

}
