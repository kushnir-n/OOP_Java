public class MyView {

    public static String[][] MatrixCoordination;

    public static void drawBattlefield() {
        for (int i = 0; i < MatrixCoordination.length; i++) {
            for (int j = 0; j < MatrixCoordination[i].length; j++) {
                System.out.print(MatrixCoordination[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void fillEmptyBattlefield() {
        for (int i = 0; i < MatrixCoordination.length; i++) {
            for (int j = 0; j < MatrixCoordination[i].length; j++) {
                if (MatrixCoordination[i][j] == null || MatrixCoordination[i][j].trim().isEmpty()) {
                    MatrixCoordination[i][j] = Color.MAGENTA_BOLD + "*" + Color.RESET;
                }
            }
        }
    }
}
