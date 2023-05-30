public class EquatesMovies {
    public static void main(String[] args) {
        Movies m1 = new Movies("RRR", "RAJAMOULI", 2022);

        Movies m2 = new Movies("RRR", "Ganesh", 2025);

        Movies m3 = new Movies("RRR", "MANEESH", 2022);

        Movies m4 = new Movies("RRR", "Raja Mouli", 2039);

        Movies m5 = new Movies("RRR", "RAJ", 2056);

        if (m1.equals(m2)) {
            System.out.println("both movies are  having same name" );
        }
            else {
            System.out.println("both are different movies");
        }
//        if (!m1.equals("RRR")) {
//            System.out.println("Check with String");
//        }
        if(m1.equals(m3)){
            System.out.println("both are same ");
        }

    }
}
