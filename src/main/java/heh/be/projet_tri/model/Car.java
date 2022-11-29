package heh.be.projet_tri.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Car {

    @Getter
    private final String marque;

    @Getter
    private final String model;

    @Getter
    private final Integer annee;
}