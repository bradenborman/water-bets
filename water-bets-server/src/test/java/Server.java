import org.springframework.boot.builder.SpringApplicationBuilder;
import waterbets.WaterBetsApplication;

public class Server extends WaterBetsApplication {

    public static void main(String[] args) {
        new Server().configure(new SpringApplicationBuilder())
                .initializers()
                .profiles("local", "protected")
                .run(args);
    }

}