package com.kodilla.tasks.controller;


import com.kodilla.tasks.domain.CreatedTrelloCardDto;
import com.kodilla.tasks.domain.TrelloBoardDto;
import com.kodilla.tasks.domain.TrelloCardDto;
import com.kodilla.tasks.service.TrelloService;
import com.kodilla.tasks.trello.facade.TrelloFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloFacade trelloFacade;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {
        return trelloFacade.fetchTrelloBoards();
    }


    @RequestMapping(method = RequestMethod.POST, value = "/createTrelloCard")
    public CreatedTrelloCardDto createTrelloCard(@RequestBody TrelloCardDto trelloCard) {
        return trelloFacade.createdTrelloCard(trelloCard);
    }
}
