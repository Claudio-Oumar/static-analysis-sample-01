package ec.edu.epn;

public class Pub {
    public static final String ONE_BEER = "hansa";
    public static final String ONE_CIDER = "grans";
    public static final String A_PROPER_CIDER = "strongbow";
    public static final String GT = "gt";
    public static final String BACARDI_SPECIAL = "bacardi_special";

    public int computeCost(String drink, boolean student, int amount) {

        if (amount > 2 && (GT.equals(drink) || BACARDI_SPECIAL.equals(drink))) {
            throw new IllegalArgumentException("Too many drinks, max 2.");
        }
        int price;

        if (ONE_BEER.equals(drink)) {
            price = 74;
        }
        else if (ONE_CIDER.equals(drink)) {
            price = 103;
        }
        else if (A_PROPER_CIDER.equals(drink)) {
            price = 110;
        }

        else if (GT.equals(drink)) {
            price = GIN_UNIT_PRICE + TONIC_WATER_UNIT_PRICE + GREEN_STUFF_UNIT_PRICE;
        }
        else if (BACARDI_SPECIAL.equals(drink)) {
            price = GIN_UNIT_PRICE / 2 + RUM_UNIT_PRICE + GRENADINE_UNIT_PRICE + LIME_JUICE_UNIT_PRICE;
        }
        else {
            throw new IllegalArgumentException("No such drink exists");
        }
        if (student && (ONE_CIDER.equals(drink) || ONE_BEER.equals(drink) || A_PROPER_CIDER.equals(drink))) {
            price = price - price / 10;
        }
        return price*amount;
    }

    //one unit of rum
    private static final int RUM_UNIT_PRICE = 65;
    private static final int GRENADINE_UNIT_PRICE = 10;
    private static final int LIME_JUICE_UNIT_PRICE = 10;
    private static final int GREEN_STUFF_UNIT_PRICE = 10;
    private static final int TONIC_WATER_UNIT_PRICE = 20;
    private static final int GIN_UNIT_PRICE = 85;

}
