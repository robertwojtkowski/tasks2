package com.kodilla.tasks.service;

import com.kodilla.tasks.config.AdminConfig;
import com.kodilla.tasks.domain.*;
import com.kodilla.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrelloService {

    private static final String SUBJECT = "Tasks: New Trello card";

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private TrelloClient trelloClient;

    @Autowired
    private SimpleEmailService emailService;

    public List<TrelloBoardDto> fetchTrelloBoards(){
        return trelloClient.getTrelloBoards();
    }

    public CreatedTrelloCardDto createTrelloCard(final TrelloCardDto trelloCardDto){
        CreatedTrelloCardDto newCard = trelloClient.createNewCard(trelloCardDto);

        emailService.send(new Mail("", SUBJECT, "New card" + trelloCardDto.getName() +
                " has been created on your Trello account"));

        return newCard;
    }

}
