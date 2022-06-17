package waterbets;

import org.springframework.boot.builder.SpringApplicationBuilder;

public class Server extends WaterBetsApplication {

    public static void main(String[] args) {
        new Server().configure(new SpringApplicationBuilder())
                .initializers()
                .profiles("local")
                .run(args);
    }

}