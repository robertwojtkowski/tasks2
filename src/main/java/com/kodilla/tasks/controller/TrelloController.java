package com.kodilla.tasks.controller;


import com.kodilla.tasks.domain.CreatedTrelloCard;
import com.kodilla.tasks.domain.TrelloBoardDto;
import com.kodilla.tasks.domain.TrelloCardDto;
import com.kodilla.tasks.trello.client.TrelloClient;
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
    private TrelloClient trelloClient;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public void getTrelloBoards() {

        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

        trelloBoards.stream().filter(trelloBoardDto -> trelloBoardDto.getName().equals("Kodilla")).forEach(trelloBoardDto -> {

            System.out.println(trelloBoardDto.getId() + " - " + trelloBoardDto.getId());
            System.out.println("This board contains lists:");
            trelloBoardDto.getLists().forEach(trelloList ->
                    System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed()));

        });

    }


    @RequestMapping(method = RequestMethod.POST, value = "/createTrelloCard")
    public CreatedTrelloCard createTrelloCard(@RequestBody TrelloCardDto trelloCard) {
        return trelloClient.createNewCard(trelloCard);
    }
}
