package org.example;

public class RationalCalcul {
    private String[] affirmations;
    private boolean[] valeursVerite;

    public RationalCalcul(String[] affirmations, boolean[] valeursVerite) {
        this.affirmations = affirmations;
        this.valeursVerite = valeursVerite;
    }

    public boolean evaluerAffirmation(String affirmation) {
        affirmation = affirmation.replace("Donc", "=>")
                .replace(" et ", " && ")
                .replace(" ou ", " || ")
                .replace("Non ", "! ");

        String[] termes = affirmation.split(" ");
        boolean valeurVerite = evaluerAffirmationSimple(termes[0] + " " + termes[1] + " " + termes[2]);

        for (int i = 3; i < termes.length; i += 2) {
            String conjonction = termes[i];
            String affirmationSimple;

            if (conjonction.equals("!")) {
                affirmationSimple = termes[i + 1] + " " + termes[i + 2] + " " + termes[i + 3];
                valeurVerite = !evaluerAffirmationSimple(affirmationSimple);
                i += 2;
            } else {
                try {
                    affirmationSimple = termes[i + 1] + " " + termes[i + 2] + " " + termes[i + 3];
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Affirmation mal formée après la conjonction: " + affirmation);
                    return false;
                }

                switch (conjonction) {
                    case "&&":
                        valeurVerite = valeurVerite && evaluerAffirmationSimple(affirmationSimple);
                        break;
                    case "||":
                        valeurVerite = valeurVerite || evaluerAffirmationSimple(affirmationSimple);
                        break;
                    case "=>":
                        valeurVerite = !valeurVerite || evaluerAffirmationSimple(affirmationSimple);
                        break;
                    default:
                        System.out.println("Conjonction inconnue: " + conjonction);
                        return false;
                }
                i += 2;
            }
        }

        return valeurVerite;
    }

    private boolean evaluerAffirmationSimple(String affirmationSimple) {
        for (int i = 0; i < affirmations.length; i++) {
            if (affirmationSimple.equals(affirmations[i])) {
                return valeursVerite[i];
            }
        }
        // Gérer les affirmations inconnues
        System.out.println("Affirmation inconnue: " + affirmationSimple + " - j'ignore sa valeur de vérité.");
        return false;
    }
}
