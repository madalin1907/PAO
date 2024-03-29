package main.java.laborator4.asociere;

import java.util.Arrays;
public class TestAsociere {
    public static void main(String[] args) {

        Profesor profesorPrincipalMate = new Profesor(1, "Popescu");
        Profesor profesorSecundarMate = new Profesor(2, "Ionescu");
        Profesor profesorInfo = new Profesor(3, "Anghel");
        Profesor profesorMateSiInfo = new Profesor(4, "Petrescu");
        Profesor profesorInfoSiMate = new Profesor(5, "Andrei");

        Profesor[] profesoriDepartamentMate = new Profesor[]{profesorPrincipalMate, profesorSecundarMate, profesorMateSiInfo, profesorInfoSiMate};
        Profesor[] profesoriDepartamentInfo = new Profesor[]{profesorInfo, profesorInfoSiMate, profesorMateSiInfo};

        Departament departamentMate = new Departament("matematica", profesoriDepartamentMate);
        Departament departamentInfo = new Departament("informatica", profesoriDepartamentInfo);

        Departament[] departamenteUnibuc = new Departament[]{departamentMate, departamentInfo};
        System.out.println("Departamente UniBuc: " + Arrays.toString(departamenteUnibuc));

        Universitate unibuc = new Universitate("UNIBUC", departamenteUnibuc);

        System.out.println("\n\n" + unibuc);

        // daca din exterior se pierde referinta catre un obiect asociat prin compozitie
        departamenteUnibuc[1] = null;
        System.out.println("\n\nStergere referinta departament info din tabloul de departamente: " + Arrays.toString(departamenteUnibuc));
        System.out.println("\nUniversitatea nu pierde referinta catre departament info:\n" + unibuc);

        // daca din exterior se pierde referinta catre un obiect asociat prin agregare
        profesoriDepartamentMate[2] = null;
        System.out.println("\n\nStergere referinta profesor din tabloul de profesori mate: " + Arrays.toString(profesoriDepartamentMate));
        System.out.println("\nSe pierde referinta in cazul asocierii prin agregare: " + departamentMate);
    }
}
