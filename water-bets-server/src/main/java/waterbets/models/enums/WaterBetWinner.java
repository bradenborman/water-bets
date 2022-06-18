package waterbets.models.enums;

import java.util.stream.Stream;

public enum WaterBetWinner {

    OFFERER,
    RECIPIENT;

    public static WaterBetWinner findOrNull(String waterBetWinner) {
        return Stream.of(WaterBetWinner.values())
                .filter(x -> x.name().equals(waterBetWinner))
                .findFirst()
                .orElse(null);
    }

}