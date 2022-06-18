package waterbets.models.enums;

import java.util.stream.Stream;

public enum BetStatus {

    OPEN,
    CLOSED,
    GROUP_REVIEW,
    RESCINDED,
    ADMIN_VETOED;

    public static BetStatus findOrNull(String betStatus) {
        return Stream.of(BetStatus.values())
                .filter(x -> x.name().equals(betStatus))
                .findFirst()
                .orElse(null);
    }

}