package com.example.jeezoo.zoo.application.query;

import com.example.jeezoo.kernel.cqs.Query;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RetrieveZooById implements Query {

    public Long id;
}
