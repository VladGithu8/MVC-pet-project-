package Utils;
import javassist.NotFoundException;
import java.util.Optional;

public class GetEnv {

    public static String getEnvLogin() throws NotFoundException {
        String mvclogin;
        return mvclogin = Optional.ofNullable(System.getenv("MVCLOGIN"))
                .orElseThrow(() -> new NotFoundException("mvclogin is not set in the environment"));
    }

    public static String getEnvPass() throws NotFoundException {
        String mvcpass;
        return mvcpass = Optional.ofNullable(System.getenv("MVCPASS"))
                .orElseThrow(() -> new NotFoundException("mvcpass is not set in the environment"));

    }



}
