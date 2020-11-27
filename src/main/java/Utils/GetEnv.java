package Utils;
import javassist.NotFoundException;
import org.hibernate.internal.build.AllowPrintStacktrace;

import java.util.Optional;

public class GetEnv {

    @AllowPrintStacktrace
    public static String getEnvLogin() {
        String mvclogin = "There is no Login hire";
        try {
            mvclogin = Optional.ofNullable(System.getenv("MVCLOGIN"))
                    .orElseThrow(() -> new NotFoundException("mvclogin is not set in the environment"));
            return mvclogin;
        } catch (NotFoundException nE) {
            nE.printStackTrace();
        }
        return mvclogin;
    }

    @AllowPrintStacktrace
    public static String getEnvPass() {
        String mvcpass = "There is no Password hire";
        try {
            mvcpass = Optional.ofNullable(System.getenv("MVCPASS"))
                    .orElseThrow(() -> new NotFoundException("mvcpassword is not set in the environment"));
            return mvcpass;
        } catch (NotFoundException nE) {
            nE.printStackTrace();
        }
        return mvcpass;
    }
}
