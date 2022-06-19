package waterbets;

import org.springframework.boot.builder.SpringApplicationBuilder;

public class WaterBetsServer extends WaterBetsApplication {

    public static void main(String[] args) {
        new WaterBetsServer().configure(new SpringApplicationBuilder())
                .initializers()
                .profiles("local", "protected")
                .run(args);
    }

}