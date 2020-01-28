package com.kodilla.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TrelloList {
    private String id;
    private String name;
    private boolean closed;

}
