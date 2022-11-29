package heh.be.projet_tri.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class Car {

    private final String marque;
    private final String model;
    private final Integer annee;
}