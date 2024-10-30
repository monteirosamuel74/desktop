package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Utils {
    public Date stringToDate(String data) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.parse(data);
    }

    public String dateToString(Date data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(data);
    }

    public Boolean strongPassword(String senha) {
        return senha.length() >= 8 && senha.matches(".*[0-9].*") && senha.matches(".*[a-z].*") && senha.matches(".*[A-Z].*");
    }
}
