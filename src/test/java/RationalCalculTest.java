import org.example.RationalCalcul;

public class RationalCalculTest {
    public static void main(String[] args) {
        String[] affirmations = {"Lou est beau", "Lou est pauvre", "Lou est généreux"};
        boolean[] valeursVerite = {true, false, true};

        RationalCalcul rc = new RationalCalcul(affirmations, valeursVerite);

        String affirmation1 = "Lou est pauvre et Lou est généreux";
        System.out.println(affirmation1 + " : " + rc.evaluerAffirmation(affirmation1));

        String affirmation2 = "Lou est beau. Donc Lou est pauvre";
        System.out.println(affirmation2 + " : " + rc.evaluerAffirmation(affirmation2));

        String affirmation3 = "Lou est pauvre. Donc Lou est généreux";
        System.out.println(affirmation3 + " : " + rc.evaluerAffirmation(affirmation3));

        String affirmation4 = "Lou est beau ou Lou est généreux. Donc Lou est pauvre";
        System.out.println(affirmation4 + " : " + rc.evaluerAffirmation(affirmation4));

        String affirmation5 = "Lou est beau ou Lou est généreux. Donc Lou est pauvre. Et Lou est pauvre ou Lou est généreux";
        System.out.println(affirmation5 + " : " + rc.evaluerAffirmation(affirmation5));

        String affirmation6 = "Non Lou est pauvre";
        System.out.println(affirmation6 + " : " + rc.evaluerAffirmation(affirmation6));

        String affirmation7 = "Lou est beau et Lou est généreux";
        System.out.println(affirmation7 + " : " + rc.evaluerAffirmation(affirmation7));

        String affirmation8 = "Lou est beau et Lou est pauvre";
        System.out.println(affirmation8 + " : " + rc.evaluerAffirmation(affirmation8));

        String affirmation9 = "Lou est pauvre ou Lou est pauvre";
        System.out.println(affirmation9 + " : " + rc.evaluerAffirmation(affirmation9));

        String affirmation10 = "Lou est pauvre. Donc Lou est pauvre";
        System.out.println(affirmation10 + " : " + rc.evaluerAffirmation(affirmation10));

        String affirmation11 = "Non Lou est pauvre. Donc Lou est beau";
        System.out.println(affirmation11 + " : " + rc.evaluerAffirmation(affirmation11));
    }
}
