package com.iba.Game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class HistoryResponseGlobal {
    List<HistoryResponse> responseList;
    int globalScore;

}
