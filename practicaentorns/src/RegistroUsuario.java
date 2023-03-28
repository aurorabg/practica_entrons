import java.util.Random;

public class RegistroUsuario {
    private static final String[] nombresExistentes = { "Juan_123", "Maria_456", "Pedro-789", "Sofia_123", "Luisa-456",
            "Pablo_789", "Ana_123", "Carlos-456", "Lucia_789", "Marta_123" };
    private String nombre;
    private String email;
    private String password;
    private String codigo;

    public RegistroUsuario(String nombre, String email, String password, String codigo) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.codigo = codigo;
    }

    public static void main(String[] args) {
        RegistroUsuario registro = new RegistroUsuario("Carles_345", "carlescanals345@gmail.com", "Prova_99",
                "abcd1234");
        validarCampos(registro);
    }

    private static void validarCampos(RegistroUsuario registro) {
        if (!validarNombre(registro.nombre)) {
            System.out.println("El nombre de usuario no cumple con las restricciones.");
            return;
        }
        if (!validarEmail(registro.email)) {
            System.out.println("El correo electrónico no cumple con las restricciones.");
            return;
        }
        if (!validarPassword(registro.password)) {
            System.out.println("La contraseña no cumple con las restricciones.");
            return;
        }
        if (!validarCodigo(registro.codigo)) {
            System.out.println("El código de seguridad no coincide.");
            return;
        }
        System.out.println("El registro se ha realizado con éxito: " + registro.nombre + " " + registro.email + " "
                + registro.password + " " + registro.codigo);
    }

    private static boolean validarNombre(String nombre) {
        if (nombre.length() > 16) {
            return false;
        }
        if (!Character.isUpperCase(nombre.charAt(0))) {
            return false;
        }
        if (!nombre.matches("^[A-Za-z][a-z]*[-_][0-9]{3}$")) {
            return false;
        }
        for (String nombreExistente : nombresExistentes) {
            if (nombre.equalsIgnoreCase(nombreExistente)) {
                return false;
            }
        }
        return true;
    }

    private static boolean validarEmail(String email) {
        if (!email.contains("@")) {
            return false;
        }
        if (!email.matches("^.*@(paucasesnovescifp|yahoo|gmail|hotmail)\\.(com|es|cat)$")) {
            return false;
        }
        return true;
    }

    private static boolean validarPassword(String password) {
        if (password.length() != 8) {
            return false;
        }
        if (!Character.isUpperCase(password.charAt(0))) {
            return false;
        }
        if (!password.matches("^[A-Za-z0-9]*[@\\-_#][0-9]{2}$")) {
            return false;
        }
        return true;
    }

    private static boolean validarCodigo(String codigo) {
        String codigoAutogenerado = generarCodigoSeguridad();
        System.out.println("Código autogenerado: " + codigoAutogenerado);
        return codigo.equals(codigoAutogenerado);
    }

    private static String generarCodigoSeguridad() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String numeros = "1234567890";
        String simbolos = "@-_#";
        String caracteres = letras + numeros + simbolos;
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(index));
        }
        return sb.toString();
    }
}