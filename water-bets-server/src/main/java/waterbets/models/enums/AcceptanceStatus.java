package waterbets.models.enums;

import java.util.stream.Stream;

public enum AcceptanceStatus {

    ACCEPTED,
    DECLINED,
    NOT_ACKNOWLEDGED;


    public static AcceptanceStatus findOrNull(String acceptanceStatus) {
        return Stream.of(AcceptanceStatus.values())
                .filter(x -> x.name().equals(acceptanceStatus))
                .findFirst()
                .orElse(null);
    }

}